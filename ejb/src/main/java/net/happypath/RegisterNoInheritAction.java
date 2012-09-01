package net.happypath;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.log.Log;

@Stateless
@Name("registerNoInherit")
public class RegisterNoInheritAction implements RegisterNoInherit
{
    @In
    private UserNoInherit userNoInherit;

    @PersistenceContext
    private EntityManager em;

    @Logger
    private Log log;

    public String register()
    {
        List<String> existing = (List<String>)em.createQuery(
                "select username from UserNoInherit where username=#{userNoInherit.username}"
            )
            .getResultList();

        if (existing.size()==0)
        {
            em.persist(userNoInherit);
            log.info("Registered new user #{userNoInherit.username}");
            return "/registeredNoInherit.xhtml";
        }
        else
        {
            FacesMessages.instance().add("User #{userNoInherit.username} already exists");
            return null;
        }
    }
}

