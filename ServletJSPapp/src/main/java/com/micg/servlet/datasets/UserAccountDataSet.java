package com.micg.servlet.datasets;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class UserAccountDataSet implements Serializable {
    //Моделька пользователя, специально подготовленная для работы hibernate
    private static final long serialVersionUID = -8706689714326132798L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "login", unique = true, updatable = false)
    private String login;
    @Column(name = "password", updatable = false)
    private String pass;
    @Column(name = "email", updatable = false)
    private String email;

    //Important to Hibernate!
    @SuppressWarnings("UnusedDeclaration")
    public UserAccountDataSet() {
    }
    public UserAccountDataSet(String login, String pass, String email) {
        this.login = login;
        this.pass = pass;
        this.email = email;
    }

    public String login() {
        return login;
    }

    public String password() {
        return pass;
    }

    public String email() {
        return email;
    }
}
