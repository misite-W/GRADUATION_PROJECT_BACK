package com.zhongbei.graduation_project.service.Impl;

import com.zhongbei.graduation_project.entity.Knowledge;
import com.zhongbei.graduation_project.mapper.KnowledgeMapper;
import com.zhongbei.graduation_project.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class KnowledgeServiceImpl  implements KnowledgeService {


    @Autowired
    private KnowledgeMapper knowledgeMapper;
    @Override
    public String saveKnowledge(Knowledge knowledge) {
        Date date = new Date();
        knowledge.setUpdateTime(date);
        knowledgeMapper.saveKnowledge(knowledge);
        return "添加成功！";
    }

    @Override
    public List<Knowledge> getKnowledge() {
        return knowledgeMapper.getKnowledge();
    }

    @Override
    public void deleteKnowledge(int id) {
        knowledgeMapper.deleteKnowledge(id);
    }

}
