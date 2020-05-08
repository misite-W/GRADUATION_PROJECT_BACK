package com.zhongbei.graduation_project.service.Impl;

import com.zhongbei.graduation_project.entity.Choice;
import com.zhongbei.graduation_project.entity.Test;
import com.zhongbei.graduation_project.entity.TestHistory;
import com.zhongbei.graduation_project.mapper.TestMapper;
import com.zhongbei.graduation_project.service.TestService;
import org.apache.ibatis.io.ResolverUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private  TestMapper testMapper;
    @Override
    public void saveTest(String testContent) {
        Test test = new Test();
        test.setTestContent(testContent);
        testMapper.saveTest(test);
    }

    @Override
    public List<Test> getTests(int num) {
        List<Choice> choice = new ArrayList<>();

        Choice choice1 = new Choice();
        Choice choice2 = new Choice();
        Choice choice3 = new Choice();
        Choice choice4 = new Choice();
        choice1.setContent("非常严重");
        choice2.setContent("比较严重");
        choice3.setContent("一般");
        choice4.setContent("没有");
        choice1.setScore(0);
        choice2.setScore((100/num)/5);
        choice3.setScore((100/num)*3/5);
        choice4.setScore(num);

        choice.add(choice1);
        choice.add(choice2);
        choice.add(choice3);
        choice.add(choice4);
        List<Test> tests = testMapper.getTests(num);
        for (Test test :tests){
           test.setChoice(choice);
        }
        return tests;
    }

    @Override
    public void saveScore(String name, int score, int userId) {
        TestHistory testHistory = new TestHistory();
        Calendar c = Calendar.getInstance();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-hh E a HH:mm:ss");
        String testTime = simpleDateFormat.format(date);
        testHistory.setName(name);
        testHistory.setScore(score);
        testHistory.setUserId(userId);
        testHistory.setTestTime(testTime);
        testMapper.saveScore(testHistory);
    }
}
