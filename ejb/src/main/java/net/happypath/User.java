package net.happypath;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.ScopeType;

@Entity
@Name("user")
@Scope(ScopeType.CONVERSATION)
@PrimaryKeyJoinColumn(name = "person_Id")
public class User extends Person
{
    private String username;
    private String password;

    public User()
    {
    }

    public User(String username, String name, String password)
    {
        super(name);
        this.password = password;
        this.username = username;
    }

    @NotNull
    @Length(min=5, max=15)
    public String getUsername()
    {
        return username;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }

    @NotNull
    @Length(min=5, max=15)
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
}

