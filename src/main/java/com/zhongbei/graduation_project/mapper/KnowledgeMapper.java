package com.zhongbei.graduation_project.mapper;

import com.zhongbei.graduation_project.entity.Knowledge;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface KnowledgeMapper {
    public void saveKnowledge(Knowledge knowledge);

    public List<Knowledge> getKnowledge();

    public void deleteKnowledge(int id);
}
