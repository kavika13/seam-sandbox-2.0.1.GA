package net.happypath;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.ScopeType;

@Entity
@Name("userNoInherit")
@Scope(ScopeType.CONVERSATION)
public class UserNoInherit implements Serializable
{
    private Long id;
    private PersonId personId = new PersonId();
    private String username;
    private String name;
    private String password;

    public UserNoInherit()
    {
    }

    public UserNoInherit(String username, String name, String password)
    {
        this.username = username;
        this.name = name;
        this.password = password;
    }

    @Id
    @GeneratedValue(generator = "personid-primarykey")
    @GenericGenerator(
        name="personid-primarykey",
        strategy="foreign",
        parameters = @Parameter(name="property", value="personId")
    )
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public PersonId getPersonId()
    {
        return this.personId;
    }
    public void setPersonId(PersonId personId)
    {
        this.personId = personId;
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
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
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

