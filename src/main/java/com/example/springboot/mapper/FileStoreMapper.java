package com.example.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface FileStoreMapper {
    void addFileServiceImpl(Map<String,Object> params);
    List<Map<String,Object>> getFileListServiceImpl(@Param("userId") String userId);
    List<Map<String,Object>> getFileByIdServiceImpl(@Param("id") String id);
}
