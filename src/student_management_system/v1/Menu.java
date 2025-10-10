package student_management_system.v1;

import java.util.Scanner;

public class Menu {
    //创造头部
    public void menuHeader() {
        System.out.println("==================");
        System.out.println("欢迎使用班级管理系统！");
        System.out.println("==================");
    }

    //创造用于菜单的数组
    String[] useMenu = new String[]{"1.显示学生信息", "2.添加学生信息", "3.删除学生信息"
            , "4.修改学生信息", "5.根据学号查询", "6.退出系统"};

    //创造菜单
    public void menuUser() {
        //遍历菜单数组
        for (String i : useMenu) {
            System.out.println(i);
        }
        //创造Scanner输入流
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入序号使用功能：");
        //创造菜单的循环
        int num = 0;
        while (num != 6) {
            num = scanner.nextInt();
            switch (num) {
                case 1:
                    System.out.println("选择功能：显示学生信息");
                    break;
                case 2:
                    System.out.println("选择功能：添加学生信息");
                    break;
                case 3:
                    System.out.println("选择功能：删除学生信息");
                    break;
                case 4:
                    System.out.println("选择功能：修改学生信息");
                    break;
                case 5:
                    System.out.println("选择功能：根据学号查询");
                    break;
                case 6:
                    System.out.println("选择功能：退出系统");
                    System.out.println("=======================");
                    System.out.println("系统退出成功，欢迎下次使用！");
                    System.out.println("=======================");
                    scanner.close(); //关掉Scanner输入流
                    break;
            }

        }
    }
    //创造一个统一启动方法
    public void tini() {
        menuHeader();
        menuUser();
    }
}
