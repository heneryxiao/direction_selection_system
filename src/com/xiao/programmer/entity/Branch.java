package com.xiao.programmer.entity;

public class Branch {
    private String branchid;

    private String name;

    private String courseid;

    private Integer selected;

    private Integer limited;

    //带上课程信息
    private Course course;

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

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid == null ? null : courseid.trim();
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branchid='" + branchid + '\'' +
                ", name='" + name + '\'' +
                ", courseid='" + courseid + '\'' +
                ", selected=" + selected +
                ", limited=" + limited +
                ", course=" + course +
                '}';
    }
}