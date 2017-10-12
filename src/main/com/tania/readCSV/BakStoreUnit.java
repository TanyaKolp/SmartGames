package com.tania.readCSV;

import java.util.Date;

/**
 * Created by tanya on 11.09.17.
 */
public class BakStoreUnit {
    protected Long id;
    protected Date created;
    protected Date updated;
    protected Long creatorId;
    protected Long changerId;
    protected ActiveType active = ActiveType.ENABLED;
    private String name;
    private String numberCode;
    private String rusName1;
    private String rusName2;
    private String engName1;
    private String engName2;
    private MyGroup group;
    private Long unit_type_id;

    public MyGroup getGroup() {
        return group;
    }

    public void setGroup(MyGroup group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberCode() {
        return numberCode;
    }

    public void setNumberCode(String numberCode) {
        this.numberCode = numberCode;
    }

    public String getRusName1() {
        return rusName1;
    }

    public void setRusName1(String rusName1) {
        this.rusName1 = rusName1;
    }

    public String getRusName2() {
        return rusName2;
    }

    public void setRusName2(String rusName2) {
        this.rusName2 = rusName2;
    }

    public String getEngName1() {
        return engName1;
    }

    public void setEngName1(String engName1) {
        this.engName1 = engName1;
    }

    public String getEngName2() {
        return engName2;
    }

    public void setEngName2(String engName2) {
        this.engName2 = engName2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Long getChangerId() {
        return changerId;
    }

    public void setChangerId(Long changerId) {
        this.changerId = changerId;
    }

    public ActiveType getActive() {
        return active;
    }

    public void setActive(ActiveType active) {
        this.active = active;
    }

    public Long getUnit_type_id() {
        return unit_type_id;
    }

    public void setUnit_type_id(Long unit_type_id) {
        this.unit_type_id = unit_type_id;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %s %n", this.numberCode, this.engName1, this.group, this.rusName1);
    }
}
