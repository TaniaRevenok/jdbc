package model.dao;

public class DevopSkillsRelationDao {

    private Integer developerId;
    private Integer skillId;

    public DevopSkillsRelationDao(Integer developerId, Integer skillId) {
        this.developerId = developerId;
        this.skillId = skillId;
    }

    public DevopSkillsRelationDao() {}


    public Integer getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Integer developerId) {
        this.developerId = developerId;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

}
