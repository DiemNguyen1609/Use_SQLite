package com.example.use_sqlite.Model;

public class Student {
    private int ID;
    private String Name;
    private String Address;
    private String Phone_Number;
    private String Email;


    public Student(String name, String address, String number, String email) {
        Name = name;
        Address = address;
        Phone_Number = number;
        Email = email;
    }
    public Student(){}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        Phone_Number = phone_Number;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
