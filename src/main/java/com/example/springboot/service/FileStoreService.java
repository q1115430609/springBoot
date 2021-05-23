package com.example.springboot.service;

import java.util.List;
import java.util.Map;

public interface FileStoreService {
    void addFile(String userId,String fileName,String path);
    List<Map<String,Object>> getFileListService(String userId);
}
