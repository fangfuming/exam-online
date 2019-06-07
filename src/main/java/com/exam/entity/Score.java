package com.exam.entity;

/**
 * @author fang
 * @date 2019/2/4 0004 - 上午 12:22
 */
public class Score {
    private String username;
    private String score;
    private String grade;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Score(String username, String score, String grade) {
        this.username = username;
        this.score = score;
        this.grade = grade;
    }

    public Score() {
    }
}
