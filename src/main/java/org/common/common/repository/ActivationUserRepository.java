package org.common.common.repository;

import org.common.common.model.UserActivation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ActivationUserRepository extends JpaRepository<UserActivation, UUID> {
    public UserActivation findByUuid(UUID uuid);
    public UserActivation findByUserId(Long id);
    public List<UserActivation> findAll();
}
