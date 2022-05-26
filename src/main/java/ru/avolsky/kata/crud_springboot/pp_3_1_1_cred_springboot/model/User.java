package ru.avolsky.kata.crud_springboot.pp_3_1_1_cred_springboot.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String surname;

    private int age;
}
