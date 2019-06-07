package com.exam.controller;

import com.exam.entity.Score;
import com.exam.service.ScoreService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author fang
 * @date 2019/2/13 0013 - 下午 2:48
 */
@Controller
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping(value = "/user/submit")
    public String complete(String score, HttpSession session){

        //将成绩存放在session，并存入数据库中
        session.setAttribute("score",score);
        String username = (String)session.getAttribute("loginUser");
        String grade = "";
        if(Integer.parseInt(score)<60){
            grade = "D" ;
        }else if(60<=Integer.parseInt(score) && Integer.parseInt(score) <80 ){
            grade = "C" ;
        }else if(80<=Integer.parseInt(score) && Integer.parseInt(score) <90 ){
            grade = "B" ;
        }else {
            grade = "A" ;
        }
        scoreService.addScore(new Score(username,score,grade));

        return "redirect:/user/complete";

    }

    //显示所有成绩
    @GetMapping(value = "/admin/getScoreList")
    public String getScoreList(@RequestParam(value="pn",defaultValue="1") Integer pn, Map map){
        PageHelper.startPage(pn,5);
        List<Score> scoreList = scoreService.getScoreList();
        int[] arr = scoreService.analyseScore();
        PageInfo page = new PageInfo(scoreList,5);
        map.put("pageInfo",page);
        map.put("arr",arr);
        return "admin/scoreList";
    }

    //根据用户名查询成绩
    @ResponseBody
    @GetMapping(value = "/admin/getScoreByName")
    public Score getScoreByName(String username){
        Score score = scoreService.getScoreByName(username);
        System.out.println(score);
        return score;
    }


    //删除某条数据
    @ResponseBody
    @DeleteMapping(value = "/admin/delScore")
    public int delScore(String username){

        int i = scoreService.deleteScore(username);

        return i;
    }

}
