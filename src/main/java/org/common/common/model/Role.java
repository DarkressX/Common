package org.common.common.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Role
{
    public enum Type {
        USER, ADMIN, DEACTIVATED
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Role(Long id, String name, Type type)
    {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    private Type type;

    public Role()
    {
    }
}
