package student_management_system.v3.entity;

public class ClassTeacher {
    private String teacherName; //定义老师的名字
    private int age; //定义老师的年龄
    private String sex; //定义老师的性别

    public ClassTeacher(String teacherName,int age,String sex) {
        this.teacherName = teacherName;
        this.age = age;
        this.sex = sex;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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

    public String showInfo() {
        return "班主任名字："+teacherName+"-年龄-"+age+"-性别-"+sex;
    }
}