package com.app1.smallApp1.repositories;

import com.app1.smallApp1.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByEmail(String email);
}


