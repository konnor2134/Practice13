package org.example.dao;

import org.example.util.ConnectionParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

public class OracleDAOFactory extends DBFactory {
    private static ConnectionParser parser;

    static {
        try {
            parser = new ConnectionParser("Data/dataSourse.xml");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String, String> connect;

    public static EmpDAO getEmpDAO() {
        return new OracleEmpDao();
    }

    public static Connection createConnection() {
        Connection connection = null;
        connect = parser.setConnection();
        try {
            Class.forName(connect.get("driver"));
            connection = DriverManager.getConnection(connect.get("url"), connect.get("user"), connect.get("password"));

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
