package com.example.springboot.controller;

import com.example.springboot.entity.User;
import com.example.springboot.service.LoginService;
import com.example.springboot.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("question/")
public class QuestionController {
    @Autowired
    public QuestionService questionService;

    @RequestMapping(value = "getQuestionList",method = RequestMethod.POST)
    public List<Map<String,Object>> getQuestionList(){
        List<Map<String,Object>> list = questionService.getQuestionList();

        return list;
    }

    @RequestMapping(value = "addQuestion",method = RequestMethod.POST)
    public Map<String,Object> addQuestion(@RequestBody HashMap<String,Object> map){
        Map<String,Object> map1 = questionService.addQuestion(map);
        return map1;
    }

    @RequestMapping(value = "deleteQuestion",method = RequestMethod.POST)
    public Map<String,Object> deleteQuestion(@RequestBody HashMap<String,Object> map){
        Map<String,Object> resultMap = new HashMap<>();
        String questionId = map.get("questionId").toString();
        try{
            questionService.deleteQuestion(questionId);
            resultMap.put("data","删除成功！");
        }catch (Exception e){
            resultMap.put("data","删除失败！");
        }
        return resultMap;
    }

    @RequestMapping(value = "editQuestion",method = RequestMethod.POST)
    public Map<String,Object> editQuestion(@RequestBody HashMap<String,Object> map){
        Map<String,Object> map1 = questionService.addQuestion(map);
        return map1;
    }
}
