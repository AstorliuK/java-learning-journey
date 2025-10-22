package student_management_system.v3.manger;

import student_management_system.v3.Interface.Person;
import student_management_system.v3.entity.ClassTeacher;
import student_management_system.v3.entity.Lecturer;
import student_management_system.v3.entity.Student;

import java.util.Scanner;


    //内部调用

public class Menu {
    //班主任是班级唯一的，50个学生共用1个班主任，所以可以设置成static
    public static ClassTeacher classTeacher = new ClassTeacher("张老师", 33, "男");

    //创建班级对象,假设管理的班级也是唯一固定的
    public static Clazz clazz = new Clazz("软件工程", "2025级");

    //学生的总人数,暂时可能没啥用
    public int studentNumber = 0;

    //创建输入流
    public Scanner sc = new Scanner(System.in);

    //创建一个Menu的构造方法
    public Menu() {

        /* 可以Clazz的构造方法中的创建学生信息移到这里
         * 符合单一职责原则，让代码更加简易可读、易于维护
         */
    }


    //创建菜单头部
    private void printHeader() {
        System.out.println("==================");
        System.out.println("欢迎使用班级管理系统！");
        System.out.println("==================");
    }

    //创造用于菜单的数组，v3中因为变成了有两级的菜单，所以用二维数组
    String[][] useMenu = new String[][]{{"1.班级信息", "2.学生管理", "3.教师管理", "4.退出系统"},
            {"1.显示学生信息", "2.添加学生信息", "3.删除学生信息", "4.修改学生信息", "5.根据学号查询", "6.返回上级菜单", "7.退出系统"},
            {"1.显示讲师信息", "2.添加讲师信息", "3.删除讲师信息", "4.修改讲师信息", "5.根据工号查询", "6.返回上级菜单", "7.退出系统"}};
    //第1行是00，01，02，03，第二行是10,11,12,13……第三行是20,21,22,23……

    //创建一级菜单
    private void printTopMenu() {
        printHeader();//把菜单头部信息移到这里
        for (String i : useMenu[0]) {
            //遍历菜单数组，这里因为是要遍历一级菜单，而一级菜单属于是二维数组的0行，所以用0来表遍历
            System.out.println(i);
        }
        System.out.println("==================");
        System.out.println("请输入序号使用功能：");
    }

    //创建二级菜单学生
    private void printStudentMenu() {
        printHeader();
        for (String i : useMenu[1]) {
            //遍历二维数组第1行，第1行是学生菜单的信息
            System.out.println(i);
        }
        System.out.println("==================");
        System.out.println("请输入序号使用功能：");

    }

    //创建二级菜单讲师
    private void printLecturerMenu() {
        printHeader();
        for (String i : useMenu[2]) {
            //遍历二维数组第2行，第2行是讲师菜单的信息
            System.out.println(i);
        }
        System.out.println("==================");
        System.out.println("请输入序号使用功能：");

    }

    //初始化的方法，进行程序的初始化，这里进行显示第一级菜单
    private void initSystem() {
        printTopMenu();
    }


    //执行菜单的方法
    public void startSystem() {
        //将v2中的while循环换成了至少会循环一次的do while循环
        int num =0;
        loop1:do {
            initSystem();
            num = sc.nextInt();
            switch (num) {
                case 1:
                    clazz.printClazzInfo();
                    break;
                case 2:
                    int num1 = 0;
                    loop2:do {
                        printStudentMenu();
                        num1 = sc.nextInt();
                        switch (num1) {
                            case 1:
                                System.out.flush();
                                clazz.printStudents();
                                break;
                            case 2:
                                System.out.flush();
                                System.out.println("请输入学生的学号：");
                                String id = sc.next();
                                System.out.println("请输入学生的姓名：");
                                String name = sc.next();
                                System.out.println("请输入学生的年龄：");
                                int age = sc.nextInt();
                                System.out.println("请输入学生的性别：");
                                String sex = sc.next();
                                Student student = new Student(id, name, age, sex);
                                clazz.addMembers(student);
                                clazz.printStudents();
                                break;
                            case 3:
                                System.out.flush();
                                System.out.println("请输入需要删除的学生学号：");
                                String deleteId = sc.next();
                                clazz.deleteMembers(deleteId);
                                clazz.printStudents();
                                break;
                            case 4:
                                System.out.flush();
                                System.out.println("请输入学生的学号：");
                                String updateId = sc.next();
                                System.out.println("请输入学生的姓名：");
                                String updateName = sc.next();
                                System.out.println("请输入学生的年龄：");
                                int updateAge = sc.nextInt();
                                System.out.println("请输入学生的性别：");
                                String updateSex = sc.next();
                                Student updateStudent = new Student(updateId, updateName, updateAge, updateSex);
                                clazz.updateMembers(updateStudent);
                                clazz.printStudents();
                                break;
                            case 5:
                                System.out.flush();
                                System.out.println("请输入学生的学号：");
                                String selectId = sc.next();
                                Person select = clazz.selectMembersById(selectId);
                                /* 一开始还做错了，查询方法是传入String，传出Person啊。
                                 * 建立一个Person类型的select，指向创建的查找对象的方法，括号里写上面写的id。
                                 * 查到了select就等于那个对象，差不多select就等于null。
                                 */
                                if (select != null) {
                                    System.out.println("查询成功！你所查询的学生信息如下：");
                                    System.out.println(((Student) select).showInfo());
                                }
                                break;
                            case 6:
                                break loop2;
                            case 7:
                                System.out.flush();
                                System.out.println("选择功能：退出系统");
                                System.out.println("=======================");
                                System.out.println("系统退出成功，欢迎下次使用！");
                                System.out.println("=======================");
                                exitSystem();
                            default:
                                System.out.flush();
                                System.out.println("输入无效，请重新输入1-6之间的数字");
                                break;
                        }
                    } while (num1 != 7);
                    break;
                case 3:
                    int num2 = 0;
                    loop3: do {
                        printLecturerMenu();
                        num2 = sc.nextInt();
                        switch (num2) {
                            case 1:
                                System.out.flush();
                                clazz.printLecturers();
                                break;
                            case 2:
                                System.out.flush();
                                System.out.println("请输入讲师的工号：");
                                String id = sc.next();
                                System.out.println("请输入讲师的姓名：");
                                String name = sc.next();
                                System.out.println("请输入讲师的年龄：");
                                int age = sc.nextInt();
                                System.out.println("请输入讲师的性别：");
                                String sex = sc.next();
                                System.out.println("请输入讲师的任教课程：");
                                String course = sc.next();
                                Lecturer lecturer = new Lecturer(id,name,age,sex,course);
                                clazz.addMembers(lecturer);
                                clazz.printLecturers();
                                break;
                            case 3:
                                System.out.flush();
                                System.out.println("请输入需要删除的学生学号：");
                                String deleteId = sc.next();
                                clazz.deleteMembers(deleteId);
                                clazz.printLecturers();
                                break;
                            case 4:
                                System.out.flush();
                                System.out.println("请输入讲师的工号：");
                                String updateId = sc.next();
                                System.out.println("请输入讲师的姓名：");
                                String updateName = sc.next();
                                System.out.println("请输入讲师的年龄：");
                                int updateAge = sc.nextInt();
                                System.out.println("请输入讲师的性别：");
                                String updateSex = sc.next();
                                System.out.println("请输入讲师的任教课程：");
                                String updateCourse = sc.next();
                                Lecturer updateLecturer = new Lecturer(updateId, updateName, updateAge, updateSex,updateCourse);
                                clazz.updateMembers(updateLecturer);
                                clazz.printLecturers();
                                break;
                            case 5:
                                System.out.flush();
                                System.out.println("请输入讲师的工号：");
                                String selectId = sc.next();
                                Person select = clazz.selectMembersById(selectId);
                                if (select != null) {
                                    System.out.println("查询成功！你所查询的讲师信息如下：");
                                    System.out.println(((Lecturer) select).showInfo());
                                }
                                break;
                            case 6:
                                break loop3;
                            case 7:
                                System.out.flush();
                                System.out.println("选择功能：退出系统");
                                System.out.println("=======================");
                                System.out.println("系统退出成功，欢迎下次使用！");
                                System.out.println("=======================");
                                exitSystem();
                            default:
                                System.out.flush();
                                System.out.println("输入无效，请重新输入1-6之间的数字");
                                break;
                        }
                    } while (num2 != 7);
                    break;
                case 4:
                    System.out.flush();
                    System.out.println("选择功能：退出系统");
                    System.out.println("=======================");
                    System.out.println("系统退出成功，欢迎下次使用！");
                    System.out.println("=======================");
                    exitSystem();
            }
        }while (num != 4) ;
    }

    //关闭程序的方法
    public void exitSystem(){
        sc.close(); //关掉Scanner输入流
        System.exit(0); //关闭一切运行的代码
    }
}