package service;

import dataLayer.Repository;
import model.converter.DevelopersConverter;
import model.dao.DevelopersDao;
import model.dto.DevelopersDto;

public class DevelopersService {
    private final DevelopersConverter converter;
    private final Repository<DevelopersDao> repository;

    public DevelopersService(DevelopersConverter converter, Repository<DevelopersDao> repository) {
        this.converter = converter;
        this.repository = repository;
    }

    public DevelopersDto findById(Integer id){
        return converter.convert(repository.findById(id));
    }

    public void create(DevelopersDto dto){
        repository.create(converter.convert(dto));
    }

    public void delete(DevelopersDto dto){
        repository.delete(converter.convert(dto));
    }

    public int update(DevelopersDto dto){
        return repository.update(converter.convert(dto));
    }
}