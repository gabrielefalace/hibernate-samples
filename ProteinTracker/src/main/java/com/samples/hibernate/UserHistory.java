package com.samples.hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "User_History")
public class UserHistory implements Serializable {

    @Id
    @Column(name = "user_history_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "entry_time")
    private Date entryTime;

    @Column(name = "entry")
    private String entry;


    @ManyToOne
    @JoinColumn(name = "user_fk", nullable = false)
    private User user;

    public UserHistory(){}

    public UserHistory(Date entryTime, String entry) {
        super();
        this.entry = entry;
        this.entryTime = entryTime;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
