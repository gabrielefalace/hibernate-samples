package com.samples.hibernate;


import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @Column(name = "name")
    private String username;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "User_History", joinColumns = @JoinColumn(name = "id"))
    @MapKeyColumn(name = "ENTRY_IDENTIFIER")
    private Map<String, UserHistory> history = new HashMap<String, UserHistory>();

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

    public Map<String, UserHistory> getHistory() {
        return history;
    }

    public void setHistory(Map<String, UserHistory> history) {
        this.history = history;
    }
}
