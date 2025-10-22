package student_management_system.v3.entity;

import student_management_system.v3.Interface.Person;

public class Lecturer implements Person {
    private int lecturerNumber = 0;
    private String id; //定义工号
    private String name; //定义名字
    private int age; //定义年龄
    private String sex; //定义性别
    private String course; //定义教学课程

    public Lecturer(){
    }

    public Lecturer(String id, String name, int age, String sex, String course){
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.course = course;
    }


    public int getLecturerNumber() {
        return lecturerNumber;
    }

    public void setLecturerNumber(int lecturerNumber) {
        this.lecturerNumber = lecturerNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String showInfo(){
        return "讲师信息：工号："+id+"，姓名："+name+"，年龄："+age+"，性别:"+sex+"，专业课程："+course;
    };
}
