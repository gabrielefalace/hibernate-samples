package com.samples.hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class UserHistory implements Serializable {

    @Column(name = "entry_time")
    private Date entryTime;

    private String entry;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserHistory that = (UserHistory) o;

        if (entryTime != null ? !entryTime.equals(that.entryTime) : that.entryTime != null) return false;
        return entry != null ? entry.equals(that.entry) : that.entry == null;

    }

    @Override
    public int hashCode() {
        int result = entryTime != null ? entryTime.hashCode() : 0;
        result = 31 * result + (entry != null ? entry.hashCode() : 0);
        return result;
    }
}
