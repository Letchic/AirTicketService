package com.letchic.model;


import javax.persistence.*;

@Entity
@Table(name = "chatmessage")
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long messageid;

    private long useridfrom;
    private long useridto;
    private String message;
    private String date;
/*

    public long getMessageid() {
        return messageid;
    }

    public void setMessageid(long messageid) {
        this.messageid = messageid;
    }

    public long getUseridfrom() {
        return useridfrom;
    }

    public void setUseridfrom(long useridfrom) {
        this.useridfrom = useridfrom;
    }

    public long getUseridto() {
        return useridto;
    }

    public void setUseridto(long useridto) {
        this.useridto = useridto;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "messageid=" + messageid +
                ", useridfrom=" + useridfrom +
                ", useridto=" + useridto +
                ", message='" + message + '\'' +
                ", date='" + date + '\'' +
                '}';
    }*/
}


