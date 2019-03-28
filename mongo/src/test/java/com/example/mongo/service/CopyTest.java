package com.example.mongo.service;

import org.junit.Assert;
import org.junit.Test;


public class CopyTest {
    @Test
    public void copyTest() {
        Son son = new Son();
        try {
            Son son1 = (Son) son.clone();
            son1.setWhat("new what");
            Assert.assertEquals(son1.equals(son),false);
            son1.parent.name="lufy gai";
            Assert.assertEquals(son1.parent.name.equals(son.parent.name),true);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void copyTest1() {
        Pru son = new Pru();
        try {
            Pru son1 = (Pru) son.clone();
            son1.name="lufy modify";
            Assert.assertEquals(son1.name.equals(son.name),false);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
    class Pru implements Cloneable{
        public Pru(){
            this.name="lufy";
            this.age="15";
        }
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        private String age;
        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    class Parent {
        private String name;
        private String msg;

        public Parent() {
            this.name = "default parent";
            this.msg = "fck";
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

    class Son implements Cloneable{
        public Son() {
            this.parent = new Parent();
            this.what="what";
        }

        public Parent getParent() {
            return parent;
        }

        public void setParent(Parent parent) {
            this.parent = parent;
        }

        public String getWhat() {
            return what;
        }

        public void setWhat(String what) {
            this.what = what;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
        private Parent parent;
        private String what;
    }
}
