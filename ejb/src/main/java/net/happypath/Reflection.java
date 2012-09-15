package net.happypath;

import javax.ejb.Local;

@Local
public interface Reflection
{
    boolean isAssignableFrom(String typename, Object instance)
        throws ClassNotFoundException;
}
