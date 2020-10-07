package com.javaadvanced.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String username;
}
