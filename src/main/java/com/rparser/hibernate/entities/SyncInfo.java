package com.rparser.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * This stupid table exist just in case of having another table
 */
@Entity
@Table(name = "SYNCINFO")
public class SyncInfo {

    private String tableName;
    private Date LastSyncDate;

    public SyncInfo(){
    }

    public SyncInfo(String tableName, Date syncDate) {
        this.tableName = tableName;
        this.LastSyncDate = syncDate;
    }

    @Id
    @Column(name = "TABLENAME")
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Column(name = "SYNC_TIME")
    public Date getLastSyncDate() {
        return LastSyncDate;
    }

    public void setLastSyncDate(Date lastSyncDate) {
        LastSyncDate = lastSyncDate;
    }
}
