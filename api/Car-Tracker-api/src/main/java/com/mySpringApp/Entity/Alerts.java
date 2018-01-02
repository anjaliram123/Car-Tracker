package com.mySpringApp.Entity;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name="alerts",schema="egen_car")
public class Alerts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    /*nested exception is javax.persistence.
    PersistenceException: org.hibernate.exception.SQLGrammarException: could not execute statement
    The above error is possible if we use GenerationType.INDENTITY
     */
    private String vin;
    private String timestamp;
    private String alertReason;
    private String alertType;


    public long getId() {
        return id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getAlertReason() {
        return alertReason;
    }

    public void setAlertReason(String alertReason) {
        this.alertReason = alertReason;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    @Override
    public String toString() {
        return "Alerts{" +
                "id='" + id + '\'' +
                ", vin='" + vin + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", alertReason='" + alertReason + '\'' +
                ", alertType='" + alertType + '\'' +
                '}';
    }
}


