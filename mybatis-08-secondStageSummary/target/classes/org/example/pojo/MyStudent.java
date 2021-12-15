package org.example.pojo;

public class MyStudent {
    int myId;
    String myName;
    String myEmail;
    int myAge;

    public int getMyId() {
        return myId;
    }

    public void setMyId(int myId) {
        this.myId = myId;
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public String getMyEmail() {
        return myEmail;
    }

    public void setMyEmail(String myEmail) {
        this.myEmail = myEmail;
    }

    public int getMyAge() {
        return myAge;
    }

    public void setMyAge(int myAge) {
        this.myAge = myAge;
    }

    @Override
    public String toString() {
        return "MyStudent{" +
                "myId=" + myId +
                ", myName='" + myName + '\'' +
                ", myEmail='" + myEmail + '\'' +
                ", myAge=" + myAge +
                '}';
    }
}
