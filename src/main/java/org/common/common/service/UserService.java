package org.common.common.service;

import org.common.common.model.Role;
import org.common.common.model.User;

import java.util.List;

public interface UserService
{
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers(); //TODO Implement Pagination
}
