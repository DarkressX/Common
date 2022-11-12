package org.common.common.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Role
{
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

    public Role(Long id, String name)
    {
        this.id = id;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;

    public Role()
    {
    }
}
