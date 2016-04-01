package com.samples.hibernate;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @Column(name = "name")
    private String username;

    @ElementCollection
    @CollectionTable(name = "User_History", joinColumns = @JoinColumn(name = "id"))
    private Set<UserHistory> history = new HashSet<UserHistory>();

    // 1) not embedded anymore
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    ProteinData proteinData;

    // 2) constructor using setter
    public User(){
       setProteinData(new ProteinData());
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

    // 3) setter setting up the reciprocal reference
    public void setProteinData(ProteinData proteinData) {
        this.proteinData = proteinData;
        proteinData.setUser(this);
    }

    public Set<UserHistory> getHistory() {
        return history;
    }

    public void setHistory(Set<UserHistory> history) {
        this.history = history;
    }
}
