package com.example.springboot.controller;

import org.apache.logging.log4j.util.PropertiesUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("fileStorage/")
public class FileUploadStorage {

    @RequestMapping(value="uploadFile", method = RequestMethod.POST)
    public String uploadFile(@RequestParam(value = "userId") String userId, @RequestParam(value = "fileList") MultipartFile[] files,HttpServletRequest request){
        if (files.length > 0){
            for(int i=0;i<files.length;i++){
                String path =  request.getSession().getServletContext().getRealPath("");
                saveFile(files[i],path,userId);
            }
        }
        return "";
    }

    private boolean saveFile(MultipartFile file,String path,String userId) {
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                String filename=file.getOriginalFilename();
                String filePath = path.replaceAll("/","\\\\") + "\\"+ userId + "\\" + file.getOriginalFilename();
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

}
