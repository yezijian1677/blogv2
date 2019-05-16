package cur.pro.entity;

import java.util.Date;

public class Token {
    private Integer uid;

    private String token;

    private Date expiredTime;

    private String ip;

    private String device;

    private Date ctime;

    private Byte stat;

    public Token(Integer uid, String token, Date expiredTime, String ip, String device, Date ctime, Byte stat) {
        this.uid = uid;
        this.token = token;
        this.expiredTime = expiredTime;
        this.ip = ip;
        this.device = device;
        this.ctime = ctime;
        this.stat = stat;
    }

    public Token() {
        super();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Date getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device == null ? null : device.trim();
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Byte getStat() {
        return stat;
    }

    public void setStat(Byte stat) {
        this.stat = stat;
    }
}