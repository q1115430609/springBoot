package com.example.springboot.controller;

import com.example.springboot.service.FileStoreService;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("fileStorage/")
public class FileUploadStorage {
    @Autowired
    public FileStoreService fileStoreService;

    @RequestMapping(value="uploadFile", method = RequestMethod.POST)
    public Map<String,String> uploadFile(@RequestParam(value = "userId") String userId, @RequestParam(value = "fileList") MultipartFile[] files,HttpServletRequest request){
        Map<String,String> resultMap = new HashMap<>();
        if (files.length > 0){
            for(int i=0;i<files.length;i++){
                String path =  request.getServletContext().getRealPath("/");
                String fileName=files[i].getOriginalFilename();
                boolean fileFlag = saveFile(files[i],userId,fileName,path);
                if(fileFlag){
                    fileStoreService.addFile(userId,fileName,path);
                }else{
                    resultMap.put("result","第" + (i + 1) + "个文件上传失败,请重新上传");
                    return resultMap;
                }
            }
        }
        resultMap.put("result","文件上传成功");
        return resultMap;
    }

    private boolean saveFile(MultipartFile file,String userId,String fileName,String path) {
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                String filePath = path.replaceAll("/","\\") + userId + "\\" + fileName;
                System.out.println(filePath);
                File saveDir = new File(filePath);
                if (!saveDir.getParentFile().exists())
                    saveDir.getParentFile().mkdirs();
                // 转存文件
                file.transferTo(saveDir);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    @RequestMapping(value="queryFileList", method = RequestMethod.POST)
    public List<Map<String,Object>> queryFileList(@RequestBody Map<String,Object> params){
        String userId = params.get("userId").toString();
        List<Map<String,Object>> resultList = fileStoreService.getFileListService(userId);
        return resultList;
    }

    @RequestMapping(value="downloadFile",method = RequestMethod.GET)
    public void downloadFile(String id, HttpServletResponse response) {
        List<Map<String,Object>> resultList = fileStoreService.getFileByIdService(id);
        String path = resultList.get(0).get("path").toString();
        String fileName = resultList.get(0).get("fileName").toString();
        //获取服务器文件
        File file = new File(path);

        response.setContentType("application/application/vnd.ms-excel");
        response.setHeader("Content-disposition",
                "attachment;filename=" + fileName);
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            InputStream ins = new FileInputStream(file);
            byte[] b = new byte[1024];
            int len;
            while((len = ins.read(b)) > 0){
                os.write(b,0,len);
            }
            os.flush();
            os.close();
            ins.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
