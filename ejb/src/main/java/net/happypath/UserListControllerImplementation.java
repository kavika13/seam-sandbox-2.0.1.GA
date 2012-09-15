package net.happypath;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

@Name("userListController")
@Stateless
public class UserListControllerImplementation implements UserListController
{
    @In
    EntityManager entityManager;

    @Override
    public List<User> getUsers()
    {
        return (List<User>)entityManager
            .createQuery("from User")
            .getResultList();
    }

    @Override
    public String getRowClasses(User user)
    {
        List<RowProperty<User>> rowProperties = new ArrayList<RowProperty<User>>();
        rowProperties.add(new GenderRowProperty());

        List<String> result = new ArrayList<String>();

        for(RowProperty<User> rowProperty : rowProperties)
        {
            result.addAll(rowProperty.getRowClasses(user));
        }

        return stringJoin(result, " ");
    }

    @Override
    public List<Column<User>> getColumns()
    {
        List<Column<User>> result = new ArrayList<Column<User>>();

        result.add(
            new StringColumn<User>("usernameColumnHeader")
            {
                public String getValue(User row) { return row.getUsername(); }
            });
        result.add(
            new StringColumn<User>("usernameColumnHeader")
            {
                public String getValue(User row) { return row.getName(); }
            });
        result.add(
            new GenderColumn<User>("genderColumnHeader")
            {
                public User.Gender getValue(User row) { return row.getGender(); }
            });

        return result;
    }

    private static String stringJoin(Collection<?> items, String delimiter)
    {
        StringBuilder builder = new StringBuilder();
        Iterator iter = items.iterator();

        while (iter.hasNext())
        {
            builder.append(iter.next());

            if(!iter.hasNext())
            {
                builder.append(delimiter);
            }
        }

        return builder.toString();
    }
}
