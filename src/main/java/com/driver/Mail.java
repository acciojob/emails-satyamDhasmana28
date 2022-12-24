package com.driver;

import java.util.Date;

public class Mail {

    public Date date;
    public String senderId;
    public String message;

    public Mail(Date date, String senderId, String message) {
        this.date = date;
        this.senderId = senderId;
        this.message = message;
    }


}
