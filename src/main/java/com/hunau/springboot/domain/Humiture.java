package com.hunau.springboot.domain;

/**
 * @author cx
 * @Time 2020/6/28 15:11
 * @Description 温湿度检测 实体
 */
public class Humiture {

    /**数据编号*/
    private int id;
    /**温度*/
    private String temp;
    /**湿度*/
    private String humidity;
    /**ip地址*/
    private String ip;
    /**采集时间*/
    private String time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
