package com.samples.hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
public class User implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @Column(name = "name")
    private String username;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    private List<UserHistory> history = new ArrayList<UserHistory>();

    @Embedded
    ProteinData proteinData = new ProteinData();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ProteinData getProteinData() {
        return proteinData;
    }

    public void setProteinData(ProteinData proteinData) {
        this.proteinData = proteinData;
    }

    public List<UserHistory> getHistory() {
        return history;
    }

    public void setHistory(List<UserHistory> history) {
        this.history = history;
    }

    public void addHistory(UserHistory userHistory){
        // first set the reference for the other object
        // userHistory.setUser(this);
        // then actually add to the list
        history.add(userHistory);
    }
}
