package student_management_system.v3.manger;

import student_management_system.v2.Menu;
import student_management_system.v3.Interface.Person;
import student_management_system.v3.entity.Lecturer;
import student_management_system.v3.entity.Student;

public class Clazz {
    private String major; //定义班级的专业
    private String grade; //定义班级的年级
    private Student[] students = null; //定义一个只包含Student对象的数组为空值
    private Lecturer[] lecturers = null; //定义一个只包含Lecturer对象的数组为空值
    private int studentIndex = 0; //定义一个添加的是第几个学生的索引
    private int lecturerIndex = 0; //定义一个添加的是第几个讲师的索引
    //定义一个初始化班级信息的构造方法,包括专业、年级和学生信息
    public Clazz(String major, String grade) {
        this.major = major;
        this.grade = grade;
        students = new Student[50]; //50长度对应50个学生
        students[0] = new Student("S001", "小明", 23, "男");
        students[0].setStudentNumber(0); //设定一下初始化的学生对象的系统编号
        students[1] = new Student("S002", "红红", 23, "女");
        students[1].setStudentNumber(1);
        students[2] = new Student("S003", "小刚", 23, "男");
        students[2].setStudentNumber(2);
        students[3] = new Student("S004", "小张", 23, "男");
        students[3].setStudentNumber(3);
        students[4] = new Student("S005", "李李", 23, "女");
        students[4].setStudentNumber(4);
        studentIndex = 5;
        /*可以这样写的
         * for (int i = 0; i < students.length; i++) {
         *     students[i].setStudentNumber(i);
         * 全自动赋予学生系统编号
         */
        lecturers = new Lecturer[10];
        lecturers[0] = new Lecturer("Z001","王大锤",44,"男","计算机组成原理");
        lecturers[1] = new Lecturer("Z002","韩梅梅",31,"女","数据结构");
        lecturers[2] = new Lecturer("Z003","李雷",45,"男","数据库使用");
        lecturers[3] = new Lecturer("Z004","小帅",42,"男","计算机编程基础");
        lecturers[4] = new Lecturer("Z005","王尼玛",38,"男","Java程序设计");
        lecturerIndex = 5;

    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Lecturer[] getLecturers() {
        return lecturers;
    }

    public void setLecturers(Lecturer[] lecturers) {
        this.lecturers = lecturers;
    }

    //统计当前班级内教师和讲师的人数
    private int countMembers(Object[] objects) {
        //这里向上转型要用Object[]，因为这属于是操作数组，有两个类型。用一个的情况是直接操作类成员数组，Student xx，Lecturer xx
        int count = 0;
        if(objects instanceof Student[]){
            for (int i = 0; i < studentIndex; i++) {
                count ++;
            }
        }
        if(objects instanceof Lecturer[]){
            for (int j = 0; j < lecturerIndex; j++) {
                count ++;
            }
        }
        return count;
    }

    //判断学生是否满了，一个班级里最多存在50个学生。
    private boolean isStudentsFull() {
        return studentIndex >= 50;
        /* 一开始用的三元判断，大于等于50人判定满了返回true，否则返回false。
         * 也考虑用普通的if else循环，不过都没必要，直接写就可以返回布尔式的结果的。
         */
    }
    //判断讲师是否满了，一个班级最多只能存在10个讲师。
    private boolean isLecturersFull() {
        return lecturerIndex >= 10;
    }
    //一开始也想看着直接isMemberFull但发现不可以，因为两个是否满了要分开计算，不然会出现聚合不当

    //将添加学生的方法改为添加成员的方法，根据学号工号判定是学生或讲师
    public void addMembers(Person person) {
        //很简单的逻辑，先做两个判断，传入的person是否属于Student或Lecturer，再做接下来的
        //如果满了就满了，再如果学工号已经存在，就已经存在，最后就如实添加
        if (person instanceof Student) {
            if (isStudentsFull()) {
                System.out.println("学生已满，无法添加学生！");
            }
            else if (isMembersExist(((Student) person).getId())){
                System.out.println("添加的学号已经存在！");
            }
            else {
                ((Student) person).setStudentNumber(studentIndex);//放在Index自增之前，把Index设为系统编号
                students[studentIndex]=((Student) person);
                studentIndex++;
            }
        }
        else if (person instanceof Lecturer) {
            if (isLecturersFull()) {
                System.out.println("讲师已满，无法添加讲师！");
            }
            else if (isMembersExist(((Lecturer) person).getId())){
                System.out.println("添加的工号已经存在！");
            }
            else {
                lecturers[lecturerIndex]=((Lecturer)person);
                lecturerIndex++;
            }
        }
    }

    //删除学生的方法,改为删除成员，通过学号工号鉴定
    public void deleteMembers(String deleteId) {
        if (deleteId.contains("S")) {
            for (int i = 0; i < studentIndex; i++) {
                if (students[i].getId().equals(deleteId)) {
                    for (int j = i; j < studentIndex - 1; j++) {
                        //检查时更改的bug，要-1，防止下面的数组越界
                        students[j] = students[j + 1];
                        //放在删除完数组对象、后面的对象前移之后，下标是等于系统编号的，等于就行
                        students[j].setStudentNumber(j);
                    }
                }
            }
            students[studentIndex - 1] = null;
            //studentIndex是比数组下标+1的，所以要-1，因为其他数都前移了，所以把数组最后一位设为null
            studentIndex--;
            //再将Index其本身自减1，两者更换一下位置也可以，上面的就不用-1了，因为先自减1了
        }
        if (deleteId.contains("Z")) {
            for (int i = 0; i < lecturerIndex; i++) {
                if (lecturers[i].getId().equals(deleteId)) {
                    for (int j = i; j < lecturerIndex - 1; j++) {
                        lecturers[j] = lecturers[j + 1];
                    }
                }
            }
            lecturers[lecturerIndex - 1] = null;
            lecturerIndex--;
        }
    }
    //修改学生的方法，改为修改成员，通过学号和工号判断
    public void updateMembers(Person person){
        //逻辑是先判断Person的实现类是哪个，再判断是否存在，再进行遍历，直到学号一致，更换
        if(person instanceof Student){
            if (isMembersExist(((Student)person).getId())){
                for (int i = 0; i < studentIndex; i++) {
                    if(students[i].getId().equals(((Student) person).getId())){
                        students[i] = ((Student)person);
                        students[i].setStudentNumber(i);//因为下标与系统编号一致，所以直接设置就好，不然默认0
                    }
                }
            }
        }
        else if (person instanceof Lecturer){
            if(isMembersExist(((Lecturer) person).getId())){
                for (int i = 0; i < lecturerIndex; i++) {
                    if(lecturers[i].getId().equals(((Lecturer) person).getId())){
                        lecturers[i] = ((Lecturer) person);
                    }
                }
            }
        }
        else {
            System.out.println("你所输入的学号不存在！");
        }
    }

    //将判断学生是否存在的方法，改为判断成员是否存在，同时判断学生和讲师，通过学号和工号，也可单独判断以更准确
    public boolean isMembersExist(String id) {
        boolean result = false;
        if(id.contains("S")) {
            for (int i = 0; i < studentIndex; i++) {
                if (students[i].getId().equals(id)) {
                    result = true;
                    break;
                }
            }
        }
        if (id.contains("Z")){
            for (int j = 0; j < lecturerIndex; j++) {
                if (lecturers[j].getId().equals(id)) {
                    result = true;
                    break;
                }
            }
        }

        return result;
        /* 要注意在循环体中，不能够直接的进行return，否则会报错。
         * 要先定义一个boolean类型的变量，并赋一个默认的值。
         * 在循环体达成任务后，再在循环体中把这个变量重新赋值。
         * 最后在循环体外return。
         */
    }

    //根据学号查找学生的方法，改为同时查找讲师和学生
    public Person selectMembersById(String id) {
        //先在循环外设置一个null的返回值，通过学工号里的字母判断是遍历Student还是Lecturer，把result赋值成其，循环外返回
        Person result = null;
        if (id.contains("S")) {
            for (int i = 0; i < studentIndex; i++) {
                if (students[i].getId().equals(id)) {
                    result = students[i];
                    break;
                }
            }
        }
        if (id.contains("Z")) {
            for (int j = 0; j < lecturerIndex; j++) {
                if (lecturers[j].getId().equals(id)) {
                    result = lecturers[j];
                    break;
                }
            }
        }
        if (result == null) {
            System.out.println("你所输入的学（工）号不存在！");
        }
        return result;
    }

    //打印学生的信息
    public void printStudents(){
        System.out.println("***学生信息***");
        for (int i = 0; i < studentIndex; i++) {
            System.out.println(students[i].showInfo());
        }
    }
    //打印讲师的信息
    public void printLecturers() {
        System.out.println("***讲师信息***");
        for (int j = 0; j < lecturerIndex; j++) {
            System.out.println(lecturers[j].showInfo());
        }
    }


    //打印班级完整信息
    public void printClazzInfo() {
        System.out.println("班级信息如下："); //头部1
        System.out.println("**********************"); //头部2
        System.out.println(showInfo()); //班级基础信息
        System.out.println(Menu.classTeacher.showInfo()); //班主任
        printStudents();
        printLecturers();
        System.out.println("**********************");
    }

    //打印基础班级信息
    public String showInfo() {
        return grade + "-" + major + "专业" + "-学生人数：" + countMembers(students)+"，专业教师人数："+countMembers(lecturers);
    }
}

