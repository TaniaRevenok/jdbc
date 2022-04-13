package model.converter;

import model.dao.ProjectFormatDao;
import model.dto.ProjectFormatDto;

public class ProjectFormatConverter {
    public ProjectFormatDto convert(ProjectFormatDao projectFormatDao) {
        ProjectFormatDto projectFormatDto = new ProjectFormatDto();
        projectFormatDto.setDate(projectFormatDao.getDate());
        projectFormatDto.setName(projectFormatDao.getName());
        projectFormatDto.setCount(projectFormatDao.getCount());
        return projectFormatDto;
    }
    public ProjectFormatDao convert(ProjectFormatDto projectFormatDto) {
        ProjectFormatDao projectFormatDao = new ProjectFormatDao();
        projectFormatDao.setDate(projectFormatDto.getDate());
        projectFormatDao.setName(projectFormatDto.getName());
        projectFormatDao.setCount(projectFormatDto.getCount());
        return projectFormatDao;
    }
}
