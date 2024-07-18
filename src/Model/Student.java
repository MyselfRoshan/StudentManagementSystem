package Model;

import Enums.Faculty;
import Enums.Gender;

public class Student {
    private String username;
    private String password;

    private String name;
    private String address;
    private long phoneNumber;
    private Gender gender;
    private Faculty faculty;

    public Student(String username, String password, String name, String address, long phoneNumber, Gender gender,
            Faculty faculty) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.faculty = faculty;
    }

    public Student(String username, String name, String address, long phoneNumber, Gender gender,
            Faculty faculty) {
        this.username = username;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.faculty = faculty;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public Gender getGender() {
        return gender;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }
}