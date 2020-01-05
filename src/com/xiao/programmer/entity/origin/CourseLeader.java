package com.xiao.programmer.entity.origin;

public class CourseLeader {
    private String cid;

    private String name;

    private String gender;

    private String tid;

    private String courseid;

    private String email;

    private String introduce;
    //附上课程信息
    private Course course;
    //附上老师信息
    private Teacher teacher;
    //附上学生信息
    private Branch branch;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
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

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid == null ? null : courseid.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "CourseLeader{" +
                "cid='" + cid + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", tid='" + tid + '\'' +
                ", courseid='" + courseid + '\'' +
                ", email='" + email + '\'' +
                ", introduce='" + introduce + '\'' +
                ", course=" + course +
                ", teacher=" + teacher +
                ", branch=" + branch +
                '}';
    }
}