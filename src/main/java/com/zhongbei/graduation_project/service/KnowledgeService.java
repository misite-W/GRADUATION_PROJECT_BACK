package com.zhongbei.graduation_project.service;

import com.zhongbei.graduation_project.entity.Knowledge;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KnowledgeService {
    public String saveKnowledge(Knowledge knowledge);

    public List<Knowledge> getKnowledge();

    public void deleteKnowledge(int id);
}
