package com.zhongbei.graduation_project.service;

import com.zhongbei.graduation_project.entity.Test;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TestService {
    public void saveTest(String testContent);

    public List<Test> getTests(int num);

    public void saveScore(String name, int score, int userId);
}
