package org.common.common.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "users")
public class ApplicationUser
{
    @Id @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    private String username;
    private String password;
    /*@NotEmpty
    @Column(name = "email", unique = true)*/
    private String email;

    public Collection<Role> getRoles()
    {
        return roles;
    }

    public void setRoles(Collection<Role> roles)
    {
        this.roles = roles;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

    public ApplicationUser(Long id, /*String name,*/ String username, String password, String email, Collection<Role> roles)
    {
        this.id = id;
        //this.name = name;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.email = email;
    }

    public ApplicationUser()
    {
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }


}