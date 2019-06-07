package com.exam.controller;

import com.exam.entity.Question;
import com.exam.service.QuestionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author fang
 * @date 2019/1/19 0019 - 下午 12:30
 */
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @ResponseBody
    @PostMapping(value = "/admin/addQuestion")
    private int addQuestion2(Question question){
        int i = questionService.addQuestion(question);
        return i;
    }

    @GetMapping(value = "/admin/getQuestionList")
    private String getQuestionList(@RequestParam(value="pn",defaultValue="1") Integer pn,Map map){

        PageHelper.startPage(pn,4);
        List<Question> questionList = questionService.getQuestionList();
        PageInfo page = new PageInfo(questionList,5);
        map.put("pageInfo",page);
        return "question/questionList";
    }

    @ResponseBody
    @GetMapping(value = "/admin/getQuestion")
    private Question getQuestion(String questionId){
        Question question = questionService.getQuestionById(questionId);
        return question;
    }

    @ResponseBody
    @DeleteMapping(value = "/admin/delQuestion/{questionId}")
    private int delQuestion(@PathVariable("questionId") String pn){
        int i = questionService.delQuestion(pn);
        return i;
    }

    @ResponseBody
    @DeleteMapping(value = "/admin/delAllQuestion")
    private int delAllQuestion( String questionIds){
        int i = questionService.delAllQuestion(questionIds);
        return i;
    }

    @ResponseBody
    @PutMapping(value = "/admin/updQuestion/{questionId}")
    private int updQuestion(@PathVariable("questionId") String questionId,Question question){
        int i = questionService.updQuestion(question,questionId);
        return i;
    }

    /**
     * 获取试题列表
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/user/getQuestions")
    private PageInfo getQuestions(@RequestParam(value="pn",defaultValue="1") Integer pn, String string, Map map, HttpSession session){
        //根据随机编号获取试题
        PageHelper.startPage(pn,1);
        int[] arr =(int[]) session.getAttribute("arr");
        List<Question> randQuestions = questionService.getRandQuestions(arr);
        PageInfo page = new PageInfo(randQuestions,5);
        map.put("pageInfo",page);
        return page;
    }

}
