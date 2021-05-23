package com.example.springboot.service.impl;

import com.example.springboot.mapper.FileStoreMapper;
import com.example.springboot.service.FileStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.example.springboot.util.Common.getUuid;

@Service
public class FileStoreServiceImpl implements FileStoreService {

    @Autowired
    public FileStoreMapper fileStoreMapper;

    public void addFile(String userId,String fileName,String path){
        String id= getUuid();
        fileStoreMapper.addFileServiceImpl(id, userId,fileName,path);
    }

    public List<Map<String,Object>> getFileListService(String userId){
        List<Map<String,Object>> list =fileStoreMapper.getFileListServiceImpl(userId);
        return list;
    }
}
