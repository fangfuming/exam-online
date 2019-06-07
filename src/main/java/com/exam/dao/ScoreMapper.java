package com.exam.dao;

import com.exam.entity.Score;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author fang
 * @date 2019/2/13 0013 - 下午 2:47
 */
@Mapper
public interface ScoreMapper {
    void addScore(Score score);
    List<Score> getScoreList();
    Score getScore(String username);
    int deleteScore(String username);
    int getCount();
    int getCountA();
    int getCountB();
    int getCountC();
    int getCountD();

}
