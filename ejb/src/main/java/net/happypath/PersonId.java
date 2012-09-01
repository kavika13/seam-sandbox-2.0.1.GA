package net.happypath;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Version;

import org.jboss.seam.annotations.Name;

@Entity
@Name("personid")
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonId implements Serializable
{
    private Long id;
    private long version;

    public PersonId()
    {
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }

    @Version
    public long getVersion() {
        return version;
    }
    public void setVersion(long version) {
        this.version = version;
    }
}

