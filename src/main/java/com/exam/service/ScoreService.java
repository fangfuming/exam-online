package com.exam.service;

import com.exam.dao.ScoreMapper;
import com.exam.entity.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fang
 * @date 2019/2/13 0013 - 下午 2:48
 */
@Service
public class ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;

    public void addScore(Score score) {
        scoreMapper.addScore(score);
    }

    public int deleteScore(String username) {
        int i = scoreMapper.deleteScore(username);
        return  i;
    }

    public List<Score> getScoreList() {
        List<Score> scoreList = scoreMapper.getScoreList();
        return scoreList;
    }

    public Score getScoreByName(String username) {
        Score score = scoreMapper.getScore(username);
        return score;
    }

    public int[] analyseScore() {
        int count = scoreMapper.getCount();
        int countA = scoreMapper.getCountA();
        int countB = scoreMapper.getCountB();
        int countC = scoreMapper.getCountC();
        int countD = scoreMapper.getCountD();
        int[] arr = {count,countA,countB,countC,countD};
        return  arr;

    }


}
