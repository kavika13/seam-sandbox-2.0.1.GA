package net.happypath;

import javax.ejb.Stateless;

import org.jboss.seam.annotations.Name;

@Name("reflection")
@Stateless
public class ReflectionImplementation implements Reflection
{
    @Override
    public boolean isAssignableFrom(String typename, Object instance)
        throws ClassNotFoundException
    {
        return instance != null
            && Class.forName(typename)
                .isAssignableFrom(instance.getClass());
    }
}
