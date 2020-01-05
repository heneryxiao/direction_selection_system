package com.xiao.programmer.entity.origin;

public class Course {
    private String courseid;

    private String name;

    private String branchid;

    private Branch branch;

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid == null ? null : courseid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBranchid() {
        return branchid;
    }

    public void setBranchid(String branchid) {
        this.branchid = branchid == null ? null : branchid.trim();
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseid='" + courseid + '\'' +
                ", name='" + name + '\'' +
                ", branchid='" + branchid + '\'' +
                ", branch=" + branch +
                '}';
    }
}