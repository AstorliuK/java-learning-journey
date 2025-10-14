package student_management_system.v2;

public class Clazz {
    private String major; //定义班级的专业
    private String grade; //定义班级的年级
    private Student[] students = null; //定义一个只包含Student对象的数组为空值
    private int studentIndex = 0; //定义一个添加的是第几个学生的索引

    //定义一个初始化班级信息的构造方法,包括专业、年级和学生信息
    public Clazz(String major, String grade) {
        this.major = major;
        this.grade = grade;
        students = new Student[50]; //50长度对应50个学生
        students[0] = new Student("001","小明",23,"男");
        students[1] = new Student("002","小红",23,"女");
        students[2] = new Student("003","小张",23,"男");
        students[3] = new Student("004","小李",23,"女");
        students[4] = new Student("005","小刘",23,"男");
        studentIndex = 5;
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

    //统计当前学生的人数
    private int countStudents() {
        int count = 0;
        int i = 0;
        while (i < students.length && students[i] != null) {
            count++;
            i++;
        }
        return count;

        /*也可以用for循环来实现
         * int count = 0;
         * for(int i = 0; i<students.length;i++){
         *     if(student[i] != null){
         *      count++
         *     }
         * }
         * return count;
         *
         * for循环更加的实用和简便。
         * 我一开始用的while循环忘了考虑数据溢出了，没有限制i，后面用短路与补救。
         * 而for循环则可以从一开始就考虑到。
         */
    }

    //判断学生是否满了，一个班级里最多存在50个学生。
    public boolean isFull() {
        return studentIndex >= 50;
        /* 一开始用的三元判断，大于等于50人判定满了返回true，否则返回false。
         * 也考虑用普通的if else循环，不过都没必要，直接写就可以返回布尔式的结果的。
         */
    }

    //添加学生的方法，首先运用了已经创建的isStudentExist方法，确定学生有无创建
    public void addStudent(Student student) {
        if (isStudentExist(student.getId())) {
            System.out.println("添加的学号已经存在！");
        } else {
            students[studentIndex] = student;
            studentIndex++;
        }
    }

    //删除学生的方法,通过学号删除
    public void deleteStudent(String deleteId) {
        if (isStudentExist(deleteId)) {
            for (int i = 0; i < studentIndex; i++) {
                if (students[i].getId().equals(deleteId)) {
                    for (int j = i; j < studentIndex; j++) {
                        students[j] = students[j + 1];
                    }
                    students[studentIndex] = null;
                    studentIndex--;
                }
            }
        } else {
            System.out.println("你所输入的学号不存在！");
        }
    }

    //修改学生的方法
    public void updateStudent(Student student) {
        if (isStudentExist(student.getId())) {
            for (int i = 0; i < studentIndex; i++) {
                if (students[i].getId().equals(student.getId())) {
                    students[i] = student;
                }
            }
        } else {
            System.out.println("你所输入的学号不存在！");
        }
    }

    //判断学生是否存在的方法,通过学号来进行判断，用equals方法
    public boolean isStudentExist(String studentId) {
        boolean result = false;
        for (int i = 0; i < studentIndex; i++) {
            if (students[i].getId().equals(studentId)) {
                result = true;
                break;
            }
        }
        return result;
        /* 要注意在循环体中，不能够直接的进行return，否则会报错。
         * 要先定义一个boolean类型的变量，并赋一个默认的值。
         * 在循环体达成任务后，再在循环体中把这个变量重新赋值。
         * 最后在循环体外return。
         */
    }

    //根据学号查找学生
//    public String selectStudentById(String selectStudentId) {
//        String selectStudentId = "nothing";
//        for (int i = 0; i < studentIndex; i++) {
//            if (students[i].getId().equals(selectStudentId)) {
//                selectStudentId = students[i].getId();
//                break;
//            }
//        }
//        if (selectStudentId.equals("nothing")){
//            return"你所输入的学号不存在！";
//        }
//    }
    //根据学号查找学生
    public Student selectStudentById(Student student) {
        Student result = null;
        for (int i = 0; i < studentIndex; i++) {
            if (students[i].getId().equals(student.getId())) {
                result = students[i];
                break;
            }
        }
        return result;
        System.out.println("你所输入的学号不存在！");
    }




    //打印班级所有学生的信息
    public void printClazzInfo() {
        System.out.println("班级信息如下：");
        System.out.println("**********************");
        System.out.println(showInfo());
        Menu.classTeacher.showInfo();
        for (int i = 0; i < studentIndex; i++) {
            System.out.println(students[i].showInfo());
        }
        System.out.println("**********************");
    }

    //打印班级信息
    public String showInfo(){
        return grade+"-"+major+"专业"+"-学生人数："+countStudents();
    }


}

