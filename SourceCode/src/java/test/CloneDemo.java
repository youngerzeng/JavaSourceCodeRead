/**
 * Author: youngerzeng
 * Date: 2019/10/3 15:05
 * Description: 深克隆和浅克隆
 */
package test;

import test.pojo.Student;
import test.pojo.Teacher;

import java.io.IOException;

/**
 * 深克隆和浅克隆
 * 浅克隆：创建一个新对象，新对象的属性和原来对象完全相同，对于非基本类型属性，仍指向原有属性所指向的对象的内存地址(克隆地址)。
 *    即：克隆的非基本类型属性发生变化会使两个对象相互影响
 * 深克隆：创建一个新对象，属性中引用的其他对象也会被克隆，不再指向原有对象地址（克隆值）。
 *    即：克隆的非基本类型属性发生变化不会使两个对象相互影响
 */
public class CloneDemo {
    public static void main(String []args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Teacher teacher1 = new Teacher("张三",20);
        Student student1 = new Student();
        student1.setTeacher(teacher1);
        Student student_clone = (Student) student1.clone();
        Student student_clone2 = (Student) student1.deepClone();
        System.out.println(student_clone);
        System.out.println(student_clone2);
        teacher1.setName("李四");
        System.out.println(student_clone); //方式1 不变化
        System.out.println(student_clone2);//方式2 不变化
    }
}
