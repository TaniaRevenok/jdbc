package model.dto;

import java.util.Date;

public class ProjectFormatDto {

    private Date date;
    private String name;
    private Integer count;

    public ProjectFormatDto(Date date, String name, Integer count) {
        this.date = date;
        this.name = name;
        this.count = count;
    }
    public ProjectFormatDto() {}


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }



}
