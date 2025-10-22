package student_management_system.v3;

/* 关于学生管理系统v3项目实训的心得：
 * 学会进行一些业务逻辑的分类，使用了进阶的功能，继承与多态，来创建学生管理系统。
 * 与v2版本相比，v3版本主要增加了对接口和实现的使用，创建一个Person接口，用Student和Lecturer两个类来实现。
 * 没有对v2版本进行太多改进，只是在上面拓展了教师管理，也运用了二维数组。
 * 对与高内聚还没有贯彻，可以改进，有很多重复性高的代码或者看起来比较杂乱的代码。
 *
 * entity包：表示实体，现实中可以被抽象成类的一些。
 * entity.Student类：描述学生信息。
 * entity.Lecturer类：描述讲师信息。
 * Interface包：顾名思义，存放接口。
 * Interface.Person接口：抽象学生管理系统内的人，让它们更方便的进行编写，运用向上转型。
 * manger包：表示管理，在学生管理系统中的管理部分。
 * manger.Clazz类：描述班级信息，包含班级内的学生、讲师数组，并定义了管理两者Members信息的方法（如添加、删除、修改、查询等）。
 * manger.Menu类：提供用户界面，作为程序与用户的交互入口，协调各个类完成功能。
 * Main类：程序入口，启动菜单系统。
 *
 * 有一些知识点是：
 * 1.修bug太难了，在运行菜单时一直出错，发现是忘了在一级菜单关于二级菜单的case底部，没写break。
 * 2.System.exit(0); 在退出程序是可以使用的代码，System里的退出代码，意为停止所有执行中的代码
 * 3.instanceof，这个很重要，用来确认父子类。
 * （父）instanceof（子），用来确丁你不知道一个父类是啥，看看是不是这个子类
 * （子）instanceof（父），用来确定这个子类属不属于这个父类，你不知道子类是啥
 * 4.关于String的话
 * （调用）.equals（被调用），确认被调用的对象，是不是和调用的对象完全相等？每个字母或者汉字、数字都要相等。
 * （调用）.contains（被调用），确认被调用的对象里，被不被调用的对象包含，比如说确认一个字母，是不是被调用的对象包含。
 */

import student_management_system.v3.manger.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.startSystem();

    }
}
