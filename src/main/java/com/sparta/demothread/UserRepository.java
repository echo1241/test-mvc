package com.sparta.demothread;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, String> {

    @Query("SELECT u FROM User u")
    List<User> findByAll();
}
