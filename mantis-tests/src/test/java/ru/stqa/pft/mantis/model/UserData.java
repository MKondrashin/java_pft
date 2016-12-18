package ru.stqa.pft.mantis.model;

import com.mysql.cj.api.mysqla.result.ColumnDefinition;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by UserData on 18.12.2016.
 */
@Entity
@javax.persistence.Table(name="mantis_user_table")
public class UserData {
    @Id
    @Column(columnDefinition = "INT(10)", name="id")
    long id;

    @Column(name="username")
    String username;

    @Column(name="realname")
    String realname;

    @Column(name="email")
    String email;

    @Column(name="password")
    String password;

    @Column(columnDefinition = "tinyint(4)",name="enabled")
    int enabled;


    @Column(columnDefinition="tinyint(4)", name="protected")
    int _protected;


    @Column(columnDefinition="smallint(6)", name="access_level")
    int access_level;

    @Column(columnDefinition = "INT(11)",name="login_count")
    int login_count;

    @Column(columnDefinition="smallint(6)",name="lost_password_request_count")
    int lost_password_request_count;

    @Column(columnDefinition="smallint(6)",name="failed_login_count")
    int failed_login_count;

    @Column(name="cookie_string")
    String cookie_string;

    @Column(columnDefinition = "INT(10)",name="last_visit")
    long last_visit;


    @Column(columnDefinition = "INT(10)",name="date_created")
    long date_created;

    public UserData withId(long id) {
        this.id = id;
        return this;
    }

    public UserData withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserData withRealname(String realname) {
        this.realname = realname;
        return this;
    }

    public UserData withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserData withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserData withEnabled(int enabled) {
        this.enabled = enabled;
        return this;
    }

    public UserData with_protected(int _protected) {
        this._protected = _protected;
        return this;
    }

    public UserData withAccess_level(int access_level) {
        this.access_level = access_level;
        return this;
    }

    public UserData withLogin_count(int login_count) {
        this.login_count = login_count;
        return this;
    }

    public UserData withLost_password_request_count(int lost_password_request_count) {
        this.lost_password_request_count = lost_password_request_count;
        return this;
    }

    public UserData withFailed_login_count(int failed_login_count) {
        this.failed_login_count = failed_login_count;
        return this;
    }

    public UserData withCookie_string(String cookie_string) {
        this.cookie_string = cookie_string;
        return this;
    }

    public UserData withLast_visit(long last_visit) {
        this.last_visit = last_visit;
        return this;
    }

    public UserData withDate_created(long date_created) {
        this.date_created = date_created;
        return this;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public int get_protected() {
        return _protected;
    }

    public void set_protected(int _protected) {
        this._protected = _protected;
    }

    public int getAccess_level() {
        return access_level;
    }

    public void setAccess_level(int access_level) {
        this.access_level = access_level;
    }

    public int getLogin_count() {
        return login_count;
    }

    public void setLogin_count(int login_count) {
        this.login_count = login_count;
    }

    public int getLost_password_request_count() {
        return lost_password_request_count;
    }

    public void setLost_password_request_count(int lost_password_request_count) {
        this.lost_password_request_count = lost_password_request_count;
    }

    public int getFailed_login_count() {
        return failed_login_count;
    }

    public void setFailed_login_count(int failed_login_count) {
        this.failed_login_count = failed_login_count;
    }

    public String getCookie_string() {
        return cookie_string;
    }

    public void setCookie_string(String cookie_string) {
        this.cookie_string = cookie_string;
    }

    public long getLast_visit() {
        return last_visit;
    }

    public void setLast_visit(long last_visit) {
        this.last_visit = last_visit;
    }

    public long getDate_created() {
        return date_created;
    }

    public void setDate_created(long date_created) {
        this.date_created = date_created;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", realname='" + realname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", _protected=" + _protected +
                ", access_level=" + access_level +
                ", login_count=" + login_count +
                ", lost_password_request_count=" + lost_password_request_count +
                ", failed_login_count=" + failed_login_count +
                ", cookie_string='" + cookie_string + '\'' +
                ", last_visit=" + last_visit +
                ", date_created=" + date_created +
                '}';
    }


}
