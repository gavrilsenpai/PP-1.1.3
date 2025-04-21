package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoHibernateImpl();

    @Override
    public void createUsersTable() {
        userDao.createUsersTable();
        System.out.println("Table created" + "\n");
    }

    @Override
    public void dropUsersTable() {
        userDao.dropUsersTable();
        System.out.println("Table dropped" + "\n");
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        userDao.saveUser(name, lastName, age);
        System.out.println("User " + name + " has been saved" + "\n");
    }

    @Override
    public void removeUserById(long id) {
        userDao.removeUserById(id);
        System.out.println("Table removed" + "\n");
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userDao.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("Table loaded" + "\n");
        return users;
    }

    @Override
    public void cleanUsersTable() {
        userDao.cleanUsersTable();
        System.out.println("Table cleaned" + "\n");
    }
}
