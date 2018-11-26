package com.xueliangli.domain.common;

import java.util.Objects;

public class Student {
    private String name;
    private int age;
    private char sex;
    private String phoneNum;

    public Student(String name) {
        this.name = name;
        System.out.println("姓名"+name);
    }

    //注意这里是私有修饰
    private Student(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("姓名"+name+"年龄"+age);
    }

    public Student(String name, int age, char sex, String phoneNum) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.phoneNum = phoneNum;
    }

    public Student(String name, int age, String phoneNum) {
        this.name = name;
        this.age = age;
        this.phoneNum = phoneNum;
        System.out.println("姓名"+name+"年龄"+age+"手机号"+phoneNum);
    }

    public String getName() {
        return name;
    }

    public Student() {
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

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }

    public static void main(String[] args) {
        System.out.println("main 方法执行了... ...");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                sex == student.sex &&
                Objects.equals(name, student.name) &&
                Objects.equals(phoneNum, student.phoneNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex, phoneNum);
    }
}
