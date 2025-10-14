package student_management_system.v2;

public class Student {
    private int studentNumber =0; //定义学生编号，初始为0
    private String id; //定义学号
    private String name; //定义学生姓名
    private int age; //定义年龄
    private String sex; //定义性别
    private Clazz clazz; //引用创建的Clazz对象，定义班级
    private ClassTeacher  classTeacher; //引用创建的ClassTeacher对象，定义班级老师

    //定义一个空参的Student构造方法。
    public Student(){
    }

    //定义一个初始化学生的学号、名字、年龄、性别的构造方法。
    public Student(String id,String name,int age,String sex){
    }

    //定义关于学生编号、学号、名字、年龄、性别、班级和班级老师的getter和setter方法。
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

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public ClassTeacher getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(ClassTeacher classTeacher) {
        this.classTeacher = classTeacher;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    //建立返回上述学生信息的方法
    public String showInfo(){
        return "学生信息：系统编号"+studentNumber+"学号："+id+"姓名："+name+"年龄："+age+"性别:"+sex;
    }
}
