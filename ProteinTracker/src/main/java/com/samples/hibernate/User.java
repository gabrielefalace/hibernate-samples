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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String username;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserHistory> history = new ArrayList<UserHistory>();

    @OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "protein_id", nullable = false)
    ProteinData proteinData = new ProteinData();


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "User_GoalAlert",
            joinColumns = @JoinColumn(name = "user_fk"),
            inverseJoinColumns = @JoinColumn(name = "goal_alert_fk"))
    private List<GoalAlert> goalAlert;


    public List<GoalAlert> getGoalAlert() {
        return goalAlert;
    }

    public void setGoalAlert(List<GoalAlert> goalAlert) {
        this.goalAlert = goalAlert;
    }


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
        userHistory.setUser(this);
        // then actually add to the list
        history.add(userHistory);
    }
}
