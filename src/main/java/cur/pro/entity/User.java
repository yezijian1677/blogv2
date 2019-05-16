package cur.pro.entity;

import java.util.Date;

public class User {
    private Integer userId;

    private String userName;

    private String password;

    private String nickname;

    private String email;

    private Date ctime;

    private Date utime;

    private Byte stat;

    public User(Integer userId, String userName, String password, String nickname, String email, Date ctime, Date utime, Byte stat) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.ctime = ctime;
        this.utime = utime;
        this.stat = stat;
    }

    public User() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }

    public Byte getStat() {
        return stat;
    }

    public void setStat(Byte stat) {
        this.stat = stat;
    }
}