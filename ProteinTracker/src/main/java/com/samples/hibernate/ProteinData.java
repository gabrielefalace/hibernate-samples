package com.samples.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "Protein_Data")
public class ProteinData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "protein_id")
    private int id;

    @OneToOne(optional = false)
    @PrimaryKeyJoinColumn(name = "user_fk")
    private User user;

    @Column(name = "total")
    private int total;

    @Column(name = "goal")
    private int goal;

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
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
