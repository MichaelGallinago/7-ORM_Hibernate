package com.micg.servlet.service;

import com.micg.servlet.dao.UsersDAO;
import com.micg.servlet.datasets.UserAccountDataSet;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static com.micg.servlet.service.AppLifecycleListener.sessionFactory;

public class AccountService {

    public static void addNewUser(UserAccountDataSet account) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        UsersDAO.addUser(session, account);
        transaction.commit();
        session.close();
    }

    public static UserAccountDataSet getUserByLogin(String login) {
        Session session = sessionFactory.openSession();
        UserAccountDataSet result =  UsersDAO.getUserByLogin(session, login);
        session.close();

        return result;
    }
}
