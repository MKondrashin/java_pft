package ru.stqa.pft.mantis.model;

/**
 * Created by User on 18.12.2016.
 */
public class User {
    long id;
    String username;
    String realname;
    String email;
    String password;
    int enabled;
    int _protected
    int access_level;
    int login_count;
    int lost_password_request_count;
    int failed_login_count;
    String cookie_string;
    long last_visit;
    long date_created;
}
