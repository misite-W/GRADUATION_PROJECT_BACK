package com.zhongbei.graduation_project.entity;

import java.util.ArrayList;
import java.util.List;

public class Test {
    int testId;
    String testContent;
    List<Choice> choice ;

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getTestContent() {
        return testContent;
    }

    public void setTestContent(String testContent) {
        this.testContent = testContent;
    }

    public List<Choice> getChoice() {
        return choice;
    }

    public void setChoice(List<Choice> choice) {
        this.choice = choice;
    }
}
