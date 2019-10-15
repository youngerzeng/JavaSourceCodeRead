/**
 * Author: Teacher
 * Date: 2019/10/3 15:14
 * Description: 老师类
 */
package test.pojo;

import java.io.Serializable;

public class Teacher implements Cloneable,Serializable {
    private  String name;
    private Integer age;

    public Teacher(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Teacher() {
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

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
