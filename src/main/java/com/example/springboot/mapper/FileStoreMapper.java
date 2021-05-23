package com.example.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface FileStoreMapper {
    void addFileServiceImpl(@Param("id") String id, @Param("userId") String userId,@Param("fileName") String fileName, @Param("path")String path);
    List<Map<String,Object>> getFileListServiceImpl(@Param("id") String id);
}
