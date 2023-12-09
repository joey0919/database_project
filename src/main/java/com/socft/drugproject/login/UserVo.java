package com.socft.drugproject.login;

import lombok.Data;

@Data
public class UserVo {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String address;
    private String phone;
    private String website;
    private String company;
    private String userType;
}