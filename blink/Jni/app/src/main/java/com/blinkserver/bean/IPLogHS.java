package com.blinkserver.bean;

import java.sql.Timestamp;

/**
 * Created by abu on 2016/9/7 15:17.
 */
public class IPLogHS {
    private int iplog_id;
    private String ip;
    private long sms_time;
    private Timestamp sms_date;

    public IPLogHS(){}

    public IPLogHS(int iplog_id, String ip, long sms_time, Timestamp sms_date){
        this.iplog_id = iplog_id;
        this.ip = ip;
        this.sms_time = sms_time;
        this.sms_date = sms_date;
    }

    @Override
    public String toString() {
        return "IPLogHS{" +
                "iplog_id=" + iplog_id +
                ", ip='" + ip + '\'' +
                ", sms_time=" + sms_time +
                ", sms_date=" + sms_date +
                '}';
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getIplog_id() {
        return iplog_id;
    }

    public void setIplog_id(int iplog_id) {
        this.iplog_id = iplog_id;
    }

    public long getSms_time() {
        return sms_time;
    }

    public void setSms_time(long sms_time) {
        this.sms_time = sms_time;
    }

    public Timestamp getSms_date() {
        return sms_date;
    }

    public void setSms_date(Timestamp sms_date) {
        this.sms_date = sms_date;
    }
}
