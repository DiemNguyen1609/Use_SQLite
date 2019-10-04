package com.example.use_sqlite.Model;

public class Student {
    private int ID;
    private String Name;
    private String Address;
    private String Number;
    private String Email;

    public Student(int ID, String name, String address, String number, String email) {
        this.ID = ID;
        Name = name;
        Address = address;
        Number = number;
        Email = email;
    }

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

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
