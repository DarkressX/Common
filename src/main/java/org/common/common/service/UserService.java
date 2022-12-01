package org.common.common.service;

import org.common.common.model.Role;
import org.common.common.model.ApplicationUser;

import java.util.List;

public interface UserService
{
    ApplicationUser saveUser(ApplicationUser user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    ApplicationUser getUser(String username);
    List<ApplicationUser> getUsers(); //TODO Implement Pagination
}
