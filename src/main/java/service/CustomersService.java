package service;

import dataLayer.Repository;
import model.converter.CustomerConverter;
import model.dao.CustomersDao;
import model.dto.CustomerDto;

public class CustomersService {
    private final CustomerConverter converter;
    private final Repository<CustomersDao> repository;

    public CustomersService(CustomerConverter converter, Repository<CustomersDao> repository) {
        this.converter = converter;
        this.repository = repository;
    }

    public CustomerDto findById(Integer id){
        return converter.convert(repository.findById(id));
    }

    public void create(CustomerDto dto){
        repository.create(converter.convert(dto));
    }

    public void delete(CustomerDto dto){
        repository.delete(converter.convert(dto));
    }

    public int update(CustomerDto dto){
        return repository.update(converter.convert(dto));
    }
}

