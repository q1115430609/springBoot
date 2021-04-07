package com.example.springboot.service.impl;

import com.example.springboot.entity.Answer;
import com.example.springboot.mapper.AnswerMapper;
import com.example.springboot.mapper.QuestionMapper;
import com.example.springboot.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.springboot.util.Common.getUuid;

@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    public QuestionMapper questionmapper;
    @Autowired
    public AnswerMapper answerMapper;

    public List<Map<String,Object>> getQuestionList(){
        List<Map<String,Object>> list = questionmapper.getQuestionList();
        for(int i=0;i<list.size();i++){
            List<Map<String,Object>> answerList = answerMapper.getAnswerList(list.get(i).get("questionId").toString());
            for(int j=0;j<answerList.size();j++){
                if(list.get(i).get("questionCorrectAnswer").toString().equals(answerList.get(j).get("answerId").toString())){
                    list.get(i).put("questionCorrectAnswer",j+1);
                }
                answerList.get(j).put("rank",j+1);
            }
            list.get(i).put("returnAnswer","");
            list.get(i).put("rightOrMis","");
            list.get(i).put("answerList",answerList);
        }
        return list;
    }
    public Map<String,Object> addQuestion(Map<String,Object> map){

        int questionNo = questionmapper.getQuestionMaxNo();
        String questionId= getUuid();
        // 生成选项
        List<Map<String,Object>> list = new ArrayList<>();
        List<Map<String,Object>> answerList= (List<Map<String,Object>>) map.get("answerList");
        for(int i =0;i<answerList.size();i++){
            String answerId= getUuid();
            Map<String,Object> map1 = new HashMap<>();
            map1.put("answerId",answerId);
            map1.put("rank",i+1);
            if(map.get("questionCorrectAnswer").equals(String.valueOf(i+1))){
                map.put("questionCorrectAnswer",answerId);
            }
            map1.put("questionId",questionId);
            map1.put("answerContent",answerList.get(i).get("answerContent"));
            list.add(map1);
        }
        answerMapper.addAnswer(list);
        //生成问题
        map.put("questionNo",++questionNo);
        map.put("questionId",questionId);
        questionmapper.addQuestion(map);
        return new HashMap<>();
    }

}
