package com.samples.hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Goal_Alert")
public class GoalAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_id")
    private int id;

    @Column(name = "message")
    private String message;

    @ManyToMany(mappedBy = "goalAlerts")
    private List<User> users = new ArrayList<User>();

    public GoalAlert(){}


    public GoalAlert(String message){
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
