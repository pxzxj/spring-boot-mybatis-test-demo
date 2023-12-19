package io.github.pxzxj.mapper;

import io.github.pxzxj.entity.User;

public interface UserMapper {

    Integer saveUser(User user);

    User findUserByUsername(String username);

    Integer countUser();

}
