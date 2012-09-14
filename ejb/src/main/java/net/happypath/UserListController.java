package net.happypath;

import java.util.List;

import javax.ejb.Local;

@Local
public interface UserListController
{
    List<User> getUsers();
    String getRowClasses(User user);
    List<Column<User>> getColumns();
}
