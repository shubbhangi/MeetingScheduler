package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.app.model.User;

public interface UserRepository extends JpaRepository<User, Integer> ,JpaSpecificationExecutor<User> {

}
