package com.exam.service;

import com.exam.dao.QuestionMapper;
import com.exam.entity.Question;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.*;

/**
 * @author fang
 * @date 2019/1/19 0019 - 下午 12:38
 */
@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    public int addQuestion(Question question) {
        int i = questionMapper.addQuestion(question);
        return i;
    }

    public List<Question> getQuestionList() {
        List<Question> list = questionMapper.getList();
        return list;
    }

    public Question getQuestionById(String questionId) {
        Question question = questionMapper.getOne(questionId);
        return question;
    }

    public int delQuestion(String questionId) {
        int i = questionMapper.delQuestion(questionId);
        return i;
    }

    public int delAllQuestion(String questionIds) {
        String[] stringArr = questionIds.split(",");
        int[] arr = new int[stringArr.length];
        for (int j = 0; j < stringArr.length; j++) {
            arr[j] = Integer.parseInt(stringArr[j]);
        }
        int i = questionMapper.delAllQuestion(arr);
        return i;
    }


    public int updQuestion(Question question, String questionId) {
        Map map = new HashMap();
        map.put("question", question);
        map.put("questionId", questionId);
        int i = questionMapper.updQuestion(map);
        return i;
    }

    //获取抽取的试题编号
    public int[] getQuestionIds() {
        List questionIds = questionMapper.getQuestionIds();
        List list = new ArrayList();
        while (list.size() < 20) {
            Object o = questionIds.get((int) (Math.random() * questionIds.size()));
            if (!list.contains(o)) {
                list.add(o);
            }
        }
        String[] str = new String[list.size()];
        String[] str1 = (String[]) list.toArray(str);
        int[] arr = new int[str1.length];
        for(int i=0;i<str1.length;i++){
            arr[i] = Integer.parseInt(str1[i]);
        }
        return arr;
    }

        //根据随机编号获取试题列表
        public List<Question> getRandQuestions(int[] arr) {
            List<Question> randQuestions = questionMapper.getRandQuestions(arr);
            return randQuestions;
        }
}
