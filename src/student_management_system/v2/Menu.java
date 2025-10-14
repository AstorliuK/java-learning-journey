package student_management_system.v2;

import com.sun.source.tree.NewArrayTree;

import java.util.Scanner;


    //内部调用

public class Menu {
    //班主任是班级唯一的，50个学生共用1个班主任，所以可以设置成static
    public static ClassTeacher classTeacher = new ClassTeacher("张老师",33,"男");

    //创建班级对象,假设管理的班级也是唯一固定的
    public static Clazz clazz = new Clazz("软件工程","2025级");

    //学生的总人数,暂时可能没啥用
    public int studentNumber = 0;

    //创建输入流
    public Scanner sc = new Scanner(System.in);

    //创建一个Menu的构造方法
    public Menu(){

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

    //创造用于菜单的数组
    String[] useMenu = new String[]{"1.显示学生信息", "2.添加学生信息", "3.删除学生信息"
            , "4.修改学生信息", "5.根据学号查询", "6.退出系统"};

    //创造菜单
    private void printMenu() {
        for (String i : useMenu) {  //遍历菜单数组
            System.out.println(i);
        }
        System.out.println("==================");
        System.out.println("请输入序号使用功能：");
        }

    //初始化的方法，进行程序的初始化
    private void initSystem(){
        printHeader();
        printMenu();
    }


    //执行菜单的方法
    public void startSystem(){
        initSystem(); //这里调用初始化的方法
        int num = 0;
        while (num != 6) {
            num = sc.nextInt();
            switch (num) {
            case 1:
                clazz.printClazzInfo();
                break;
            case 2:
                System.out.println("请输入学生的学号：");
                String id = sc.next();
                System.out.println("请输入学生的姓名：");
                String name = sc.next();
                System.out.println("请输入学生的年龄：");
                int age = sc.nextInt();
                System.out.println("请输入学生的性别：");
                String sex = sc.next();
                Student student = new Student(id,name,age,sex);
                break;
            case 3:
                System.out.println("请输入需要删除的学生学号：");
                String deleteId = sc.next();
                clazz.deleteStudent(deleteId);
                break;
            case 4:
                System.out.println("请输入学生的学号：");
                String updateId = sc.next();
                System.out.println("请输入学生的姓名：");
                String updateName = sc.next();
                System.out.println("请输入学生的年龄：");
                int updateAge = sc.nextInt();
                System.out.println("请输入学生的性别：");
                String updateSex = sc.next();
                Student updateStudent = new Student(updateId,updateName,updateAge,updateSex);
                clazz.updateStudent(updateStudent);
                break;
            case 5:
                System.out.println("请输入学生的学号：");
                String selectStudentById = sc.next();
                clazz.selectStudentBsyId(selectStudentById);
                break;
            case 6:
                System.out.println("选择功能：退出系统");
                System.out.println("=======================");
                System.out.println("系统退出成功，欢迎下次使用！");
                System.out.println("=======================");
                sc.close(); //关掉Scanner输入流
                break;
            default:
                System.out.println("输入无效，请重新输入1-6之间的数字");
                break;
            }
        }
    }
    //创造一个统一启动方法
    public void tini() {
        printHeader();
        printMenu();
    }
}
