package com.micg.servlet.dao;

import com.micg.servlet.datasets.UserAccountDataSet;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UsersDAO {
    //объект отвечающий за получение информации из БД
    public static void addUser(Session session, UserAccountDataSet user) {
        session.save(user);
    }

    public static UserAccountDataSet getUserByLogin(Session session, String login) {
        Criteria criteria = session.createCriteria(UserAccountDataSet.class);
        return (UserAccountDataSet) criteria.add(Restrictions.eq("login", login)).uniqueResult();
    }
}
