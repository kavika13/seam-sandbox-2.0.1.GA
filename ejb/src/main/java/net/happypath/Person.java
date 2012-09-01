package net.happypath;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.validator.NotNull;

@Entity
@PrimaryKeyJoinColumn(name = "person_Id")
public abstract class Person extends PersonId implements Serializable
{
    private String name;

    public Person()
    {
    }

    public Person(String name)
    {
        this.name = name;
    }

    @NotNull
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
}

