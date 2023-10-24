package com.example.inter.req;


public class SysUserLoginReq {

    private String email;

    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SysUserLoginReq{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
