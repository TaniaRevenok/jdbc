package model.converter;

import model.dao.DevelopersDao;
import model.dto.DevelopersDto;

public class DevelopersConverter {
    public DevelopersDao convert(DevelopersDto developersDto){
        DevelopersDao developersDao = new DevelopersDao();
        developersDao.setDeveloperId(developersDto.getDeveloperId());
        developersDao.setDeveloperName(developersDto.getDeveloperName());
        developersDao.setDeveloperAge(developersDto.getDeveloperAge());
        developersDao.setDeveloperSex(developersDto.getDeveloperSex());
        developersDao.setSalary(developersDto.getSalary());
        return developersDao;
    }

    public DevelopersDto convert(DevelopersDao developersDao){
        DevelopersDto developersDto = new DevelopersDto();
        developersDto.setDeveloperId(developersDao.getDeveloperId());
        developersDto.setDeveloperName(developersDao.getDeveloperName());
        developersDto.setDeveloperAge(developersDao.getDeveloperAge());
        developersDto.setDeveloperSex(developersDao.getDeveloperSex());
        developersDto.setSalary(developersDao.getSalary());
        return  developersDto;
    }
}
