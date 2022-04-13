package model.dao;

public class CustomerProjectRelationDao {

    private Integer customerId;
    private Integer projectId;

    public CustomerProjectRelationDao() {

    }

    public CustomerProjectRelationDao(Integer customerId, Integer projectId) {
        this.customerId = customerId;
        this.projectId = projectId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }



}
