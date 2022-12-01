package org.common.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.common.common.model.ApplicationUser;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<ApplicationUser, Long>
{
    public List<ApplicationUser> findAllByUsername(String username);
    public ApplicationUser findByEmail(String email);
    ApplicationUser findByUsername(String username);
}