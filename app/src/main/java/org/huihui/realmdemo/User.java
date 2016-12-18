package org.huihui.realmdemo;

import io.realm.RealmObject;

/**
 * User: huihui
 * Date: 2016-12-18 {HOUR}:27
 */
public class User extends RealmObject {
//    @PrimaryKey
//    private int id;
    private String name;
    private int age;

    public String getName() {
        return name;
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
}