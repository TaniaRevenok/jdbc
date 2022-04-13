package model.dao;

public class DevopProjectRelationDao {

    private Integer developerId;
    private Integer projectId;

    public DevopProjectRelationDao(Integer developerId, Integer projectId) {
        this.developerId = developerId;
        this.projectId = projectId;
    }
    public DevopProjectRelationDao(){}

    public Integer getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Integer developerId) {
        this.developerId = developerId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }




}
