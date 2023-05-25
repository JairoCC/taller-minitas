package com.keycode.TallerMinitas.models;
import jakarta.persistence.*;

@Entity
@Table(name = "demining")
public class DeminingType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "demining_id")
    private Integer deminingId;

    @Column(name = "region")
    private String region;
    @Column(name = "demining_name")
    private String deminingName;

    @Column(name = "user")
    private String user;

    public DeminingType(Integer deminingId, String region, String deminingName, String user) {
        this.deminingId = deminingId;
        this.region = region;
        this.deminingName = deminingName;
        this.user = user;
    }

    public DeminingType() {
    }

    public Integer getDeminingId() {
        return deminingId;
    }

    public void setDeminingId(Integer deminingId) {
        this.deminingId = deminingId;
    }

    public String getDeminingName() {
        return deminingName;
    }

    public void setDeminingName(String deminingName) {
        this.deminingName = deminingName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
