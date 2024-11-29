package com.zd.example.common.model;

//对象需要实现序列化接口，为后续网络传输序列化提供支持
import java.io.Serializable;

//实体类 User：
public class User implements Serializable {
    private String name;

    public String getName(){
        return name;
    }

    public  void setName(String name){
        this.name=name;
    }
}
