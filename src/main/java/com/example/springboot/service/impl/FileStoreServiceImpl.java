package com.example.springboot.service.impl;

import com.example.springboot.mapper.FileStoreMapper;
import com.example.springboot.service.FileStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.springboot.util.Common.getUuid;

@Service
public class FileStoreServiceImpl implements FileStoreService {

    @Autowired
    public FileStoreMapper fileStoreMapper;

    public void addFile(String userId,String fileName,String path){
        String id= getUuid();
        Date nowTime = new Date();
        Map<String,Object> params = new HashMap<>();
        String realPath = path.replaceAll("/","\\") + userId + "\\" + fileName;
        params.put("id",id);
        params.put("userId",userId);
        params.put("fileName",fileName);
        params.put("path",realPath);
        params.put("createTime",nowTime);
        params.put("updateTime",nowTime);
        fileStoreMapper.addFileServiceImpl(params);
    }

    public List<Map<String,Object>> getFileListService(String userId){
        List<Map<String,Object>> list =fileStoreMapper.getFileListServiceImpl(userId);
        return list;
    }

    public List<Map<String,Object>> getFileByIdService(String id){
        List<Map<String,Object>> list =fileStoreMapper.getFileByIdServiceImpl(id);
        return list;
    }

}
