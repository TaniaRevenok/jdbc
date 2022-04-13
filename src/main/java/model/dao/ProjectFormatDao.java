package model.dao;

import java.util.Date;
import java.util.List;

public class ProjectFormatDao {

 private Date date;
 private String name;
 private Integer count;

 public ProjectFormatDao(Date date,String name,Integer count) {
     this.date = date;
     this.name = name;
     this.count = count;
 }
    public ProjectFormatDao(){}

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
    public static void printInfo(List<ProjectFormatDao> list) {

        for(ProjectFormatDao psf : list){
            System.out.println("Project name: " + psf.getName());
            System.out.println("Date of start: " + psf.getDate());
            System.out.println("Count of developers: " + psf.getCount());
            System.out.println("---------");
        }
    }
    @Override
    public String toString() {
     return "Date " + date +
             ", Projects name: '" + name + '\'' +
             ", Count of developers: " + count;
    }
}

