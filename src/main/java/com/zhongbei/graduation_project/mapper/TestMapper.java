package com.zhongbei.graduation_project.mapper;

import com.zhongbei.graduation_project.entity.Test;
import com.zhongbei.graduation_project.entity.TestHistory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {
    public void saveTest(Test test);

    public List<Test> getTests(int num);

    public void saveScore(TestHistory testHistory);
}
