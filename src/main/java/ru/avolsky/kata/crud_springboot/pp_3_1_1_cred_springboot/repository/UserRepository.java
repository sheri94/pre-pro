package ru.avolsky.kata.crud_springboot.pp_3_1_1_cred_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.avolsky.kata.crud_springboot.pp_3_1_1_cred_springboot.model.User;


public interface UserRepository extends JpaRepository<User,Integer> {

}
