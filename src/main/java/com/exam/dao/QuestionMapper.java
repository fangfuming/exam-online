package com.exam.dao;

import com.exam.entity.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author fang
 * @date 2019/1/19 0019 - 下午 12:33
 */
@Mapper
public interface QuestionMapper {

    int addQuestion(Question question);

    List<Question> getList();

    int delQuestion(String questionId);

    Question getOne(String questionId);

    int updQuestion(Map map);

    int delAllQuestion (int[] questionIds);

    List<Question> getRandQuestions (int[] questionIds);

    List getQuestionIds();

}
