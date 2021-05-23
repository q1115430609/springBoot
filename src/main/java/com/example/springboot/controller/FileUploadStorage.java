package com.example.springboot.controller;

import com.example.springboot.service.FileStoreService;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
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
    public String uploadFile(@RequestParam(value = "userId") String userId, @RequestParam(value = "fileList") MultipartFile[] files,HttpServletRequest request){
        if (files.length > 0){
            for(int i=0;i<files.length;i++){
                String path =  request.getSession().getServletContext().getRealPath("");
                String fileName=files[i].getOriginalFilename();
                boolean fileFlag = saveFile(files[i],userId,fileName,path);
                if(fileFlag){
                    fileStoreService.addFile(userId,fileName,path);
                }else{
                    return "第" + (i + 1) + "个文件上传失败,请重新上传";
                }
            }
        }
        return "文件上传成功";
    }

    private boolean saveFile(MultipartFile file,String userId,String fileName,String path) {
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                String filePath = path.replaceAll("/","\\\\") + "\\"+ userId + "\\" + fileName;
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

    @RequestMapping(value="getFileList", method = RequestMethod.POST)
    public List<Map<String,Object>> getFileList(@RequestBody Map<String,Object> params){
        String userId = params.get("userId").toString();
        fileStoreService.getFileListService(userId);
        return new ArrayList<>();
    }

}
