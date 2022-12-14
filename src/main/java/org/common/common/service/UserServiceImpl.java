package org.common.common.service;

//import lombok.extern.slf4j.Slf4j;
import org.common.common.model.Role;
import org.common.common.model.ApplicationUser;
import org.common.common.model.UserActivation;
import org.common.common.repository.ActivationUserRepository;
import org.common.common.repository.RoleRepository;
import org.common.common.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
//@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService
{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final ActivationUserRepository actRepo;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, ActivationUserRepository actRepo)
    {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.actRepo = actRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        ApplicationUser user = userRepository.findByUsername(username);
        if(user == null)
        {
            throw new UsernameNotFoundException("User not found in database");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayDeque<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public ApplicationUser saveUser(ApplicationUser user)
    {
        //log.info("Saving new user {} to the database", user.getName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public UserActivation saveActivationUser(UserActivation user){
        return actRepo.save(user);
    }
    public UserActivation getUserActivationByUuid(UUID uuid) {return actRepo.findByUuid(uuid);}
    public UserActivation getUserActivationByUserId(Long id) {return actRepo.findByUserId(id);}
    public void deleteUserActivation(UserActivation user) {
        actRepo.delete(user);
    }

    @Override
    public Role saveRole(Role role)
    {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName)
    {
        ApplicationUser user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    public void confirm(UUID id){
        Collection<Role> roles = null;
        roles.add(new Role(1l, "User", Role.Type.USER));
        ApplicationUser user = getUserById(getUserActivationByUuid(id).getUserId());
        user.setRoles(roles);
        userRepository.save(user);
        deleteUserActivation(getUserActivationByUuid(id));
    }

    @Override
    public ApplicationUser getUser(String username)
    {
        //log.info("Fetching user {}", username);
        return userRepository.findByUsername(username);
    }

    public ApplicationUser getUserById(Long id) {return userRepository.findById(id).get();}

    @Override
    public List<ApplicationUser> getUsers()
    {
        //log.info("Fetching all users");
        return userRepository.findAll();
    }
}
