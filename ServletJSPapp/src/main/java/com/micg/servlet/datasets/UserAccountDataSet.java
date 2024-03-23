package com.micg.servlet.datasets;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class UserAccountDataSet implements Serializable {
    //Моделька пользователя, специально подготовленная для работы hibernate
    @Serial
    private static final long serialVersionUID = -8706689714326132798L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "login", unique = true, updatable = false)
    private String login;
    @Column(name = "password", updatable = false)
    private String password;
    @Column(name = "email", updatable = false)
    private String email;

    public UserAccountDataSet() {
    }

    public UserAccountDataSet(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public String login() {
        return login;
    }

    public String password() {
        return password;
    }

    public String email() {
        return email;
    }
}
