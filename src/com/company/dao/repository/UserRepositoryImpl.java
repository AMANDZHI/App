package com.company.dao.repository;

import com.company.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private List<User> list = new ArrayList<>();

    {
        list.add(new User(1, "admin", "admin", "admin", true));
    }

    @Override
    public void save(User object) {
        list.add(object);
    }

    @Override
    public User findById(Integer id) {
        try {
            return list.get(id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public User update(User object) {
        list.get(object.getId()).setName(object.getName());
        list.get(object.getId()).setLogin(object.getLogin());
        list.get(object.getId()).setPassword(object.getPassword());
        return list.get(object.getId());
    }

    @Override
    public boolean removeById(Integer id) {
        return list.remove(id);
    }

    @Override
    public List<User> getList() {
        return list;
    }

    @Override
    public User findByLogin(String login) {
        for (User u: list) {
            if (u.getLogin().equals(login)) {
                return u;
            }
        }
        return null;
    }
}