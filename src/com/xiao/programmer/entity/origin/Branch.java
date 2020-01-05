package com.xiao.programmer.entity.origin;

public class Branch {
    private String branchid;

    private String name;

    private Integer selected;

    private Integer limited;

    public String getBranchid() {
        return branchid;
    }

    public void setBranchid(String branchid) {
        this.branchid = branchid == null ? null : branchid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSelected() {
        return selected;
    }

    public void setSelected(Integer selected) {
        this.selected = selected;
    }

    public Integer getLimited() {
        return limited;
    }

    public void setLimited(Integer limited) {
        this.limited = limited;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branchid='" + branchid + '\'' +
                ", name='" + name + '\'' +
                ", selected=" + selected +
                ", limited=" + limited +
                '}';
    }
}