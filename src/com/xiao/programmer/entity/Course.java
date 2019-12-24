package com.xiao.programmer.entity;

public class Course {
    private String courseid;

    private String name;

    private String introduce;

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

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseid='" + courseid + '\'' +
                ", name='" + name + '\'' +
                ", introduce='" + introduce + '\'' +
                '}';
    }
}