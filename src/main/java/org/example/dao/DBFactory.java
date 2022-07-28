package org.example.dao;

public abstract class DBFactory {

    public static DBFactory getDAOFactory (DBType dbType) {
        switch (dbType) {
            case ORACLE:
                return new OracleDAOFactory();
            case MYSQL:
                return null;
            default:
                return null;
        }
    }
}