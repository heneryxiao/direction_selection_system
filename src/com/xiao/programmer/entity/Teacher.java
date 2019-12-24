package com.xiao.programmer.entity;

public class Teacher {
    private String tid;

    private String name;

    private String gender;

    private String introduce;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid='" + tid + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", introduce='" + introduce + '\'' +
                '}';
    }
}