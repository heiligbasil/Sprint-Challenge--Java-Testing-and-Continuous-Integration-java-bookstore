package com.lambdaschool.javabookstore.repositories;

import com.lambdaschool.javabookstore.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
