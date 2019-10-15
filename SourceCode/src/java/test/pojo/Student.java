/**
 * Author: Student
 * Date: 2019/10/3 15:13
 * Description: 学生类
 */
package test.pojo;

import java.io.*;

public class Student implements Cloneable,Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private Integer age;
    private Teacher teacher;

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name, Integer age, Teacher teacher) {
        this.name = name;
        this.age = age;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     * 深克隆方式1：对每一个非基本类型进行克隆
     * 思路：1. 实现Cloneable接口
     *       2. 重写clone方法，抛出CloneNotSupportedException异常
     *       3. 对每一个非基本类型属性进行克隆
     *       4. 对每个非基本类型属性所应用的类进行如上操作。
     * 对象简单时可选择该种方式
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        //return super.clone();
        //1. 深克隆：对每一个非基本类型进行克隆
        Student student = (Student)super.clone();
        student.setTeacher((Teacher) student.getTeacher().clone());
        return student;
    }

    /**
     * 深克隆方式2：利用serializable深复制，将对象写入IO流，再写出
     * 思路：1. 每一个类都要继承Serializable接口
     *       2. 自定义克隆方法，将对象写入对象IO流，再读出IO流
     * 对象复杂时可选择该方式
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Object deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        //写对象到流
        oos.writeObject(this);
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        //读对象到流
        return ois.readObject();

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", teacher=" + teacher +
                '}';
    }
}
