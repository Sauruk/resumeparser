package com.rparser.acceptor;

public class SyncInfoAcceptor implements Acceptor {

    private String tableName;

    public SyncInfoAcceptor(String tableName) {
        this.tableName = tableName;
    }

    public String getId() {
        return tableName;
    }
}
