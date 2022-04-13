package service;

import dataLayer.Repository;
import model.converter.SkillsConverter;
import model.dao.SkillsDao;
import model.dto.SkillsDto;

public class SkillsService {
    private final SkillsConverter converter;
    private final Repository<SkillsDao> repository;

    public SkillsService(SkillsConverter converter, Repository<SkillsDao> repository) {
        this.converter = converter;
        this.repository = repository;
    }

    public SkillsDto findById(Integer id){
        return converter.convert(repository.findById(id));
    }

    public void create(SkillsDto dto){
        repository.create(converter.convert(dto));
    }

    public void delete(SkillsDto dto){
        repository.delete(converter.convert(dto));
    }

    public void update(SkillsDto dto){
        repository.update(converter.convert(dto));
    }
}


