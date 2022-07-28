package org.example.dao;

import org.example.model.Emp;

import java.sql.*;
import java.util.ArrayList;

public class OracleEmpDao implements EmpDAO {
    @Override
    public void insertEMP(Emp insertEmp) {
        try (Connection connection = OracleDAOFactory.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO EMP (empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES ( ?, ?, ?, ?, ?, ?,?,?)");) {
            preparedStatement.setInt(1, insertEmp.getEmpno());
            preparedStatement.setString(2, insertEmp.getEname());
            preparedStatement.setString(3, insertEmp.getJob());
            preparedStatement.setInt(4, insertEmp.getMgr());
            preparedStatement.setDate(5, insertEmp.getHiredata());
            preparedStatement.setInt(6, insertEmp.getSal());
            preparedStatement.setInt(7, insertEmp.getComm());
            preparedStatement.setInt(8, insertEmp.getDeptno());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Emp selectEMP(Integer empno) {
        Emp tempEmp = null;
        try (Connection connection = OracleDAOFactory.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT EMPNO,ENAME,JOB ,MGR,HIREDATE,SAL,COMM,DNAME,LOC," +
                     "(SELECT GRADE FROM salgrade WHERE SAL BETWEEN MINSAL AND HISAL) AS ets FROM EMP NATURAL JOIN DEPT WHERE EMPNO = ?");) {
            preparedStatement.setInt(1, empno);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                tempEmp = parseEmp(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tempEmp;
    }

    @Override
    public void removeEMP(Integer empno) {
        try (Connection connection = OracleDAOFactory.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM EMP WHERE empno = ?");) {
            preparedStatement.setInt(1, empno);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Integer> selectEMPNO() {
        ArrayList<Integer> empnoArrayListList = new ArrayList<>();
        try (Connection connection = OracleDAOFactory.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT empno FROM emp ");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                empnoArrayListList.add(parseKey(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empnoArrayListList;
    }

    @Override
    public ArrayList<Integer> selectDEPNO() {
        ArrayList<Integer> depnoArrayListList = new ArrayList<>();
        try (Connection connection = OracleDAOFactory.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT deptno FROM dept ");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                depnoArrayListList.add(parseKey(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return depnoArrayListList;
    }

    private static Integer parseKey(ResultSet resultSet) {
        Integer tempKey = 0;
        try {
            tempKey = resultSet.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tempKey;
    }

    private static Emp parseEmp(ResultSet resultSet) {
        Emp temp = null;
        try {
            Integer empno = resultSet.getInt(1);
            String ename = resultSet.getString(2);
            String job = resultSet.getString(3);
            Integer mgr = resultSet.getInt(4);
            Date hiredata = resultSet.getDate(5);
            Integer sal = resultSet.getInt(6);
            Integer comm = resultSet.getInt(7);
            String dname = resultSet.getString(8);
            String loc = resultSet.getString(9);
            Integer ets = resultSet.getInt(10);
            temp = new Emp(empno, ename, job, mgr, hiredata, sal, comm, 0, dname, loc, ets);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }
}
