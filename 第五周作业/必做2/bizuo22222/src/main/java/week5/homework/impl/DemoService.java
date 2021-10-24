package week5.homework.impl;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class DemoService {

    private String name;

    private Student student100;

    private Student student123;

    private School school;

    private Klass class1;

    public DemoService(){}
    public DemoService(Student student100,Student student123,School school,Klass class1){
        this.student100 = student100;
        this.student123 = student123;
        this.school = school;
        this.class1 = class1;
    }


    public void demoRun(){
        student123.print();
        student100.print();
        school.ding();
        class1.dong();
        System.out.println("TESt++++++++++++++++++++++++++" +name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent100() {
        return student100;
    }

    public void setStudent100(Student student100) {
        this.student100 = student100;
    }

    public Student getStudent123() {
        return student123;
    }

    public void setStudent123(Student student123) {
        this.student123 = student123;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Klass getClass1() {
        return class1;
    }

    public void setClass1(Klass class1) {
        this.class1 = class1;
    }
}
