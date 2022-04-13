package service;

import dataLayer.Repository;
import model.converter.ProjectsConverter;
import model.dao.ProjectsDao;
import model.dto.ProjectsDto;

public class ProjectsService {

    private final ProjectsConverter converter;
    private final Repository<ProjectsDao> repository;

    public ProjectsService(ProjectsConverter converter, Repository<ProjectsDao> repository) {
        this.converter = converter;
        this.repository = repository;
    }

    public ProjectsDto findById(Integer id){
        return converter.convert(repository.findById(id));
    }

    public void create(ProjectsDto dto){
        repository.create(converter.convert(dto));
    }

    public void delete(ProjectsDto dto){
        repository.delete(converter.convert(dto));
    }

    public void update(ProjectsDto dto){
        repository.update(converter.convert(dto));
    }
}

