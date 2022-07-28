package org.example.view;

import org.example.dao.EmpDAO;

import java.util.ArrayList;

public class PrintView {
    public static void printEmpno(EmpDAO empDAO){
        ArrayList<Integer> getList = empDAO.selectEMPNO();
        System.out.println("Employee's ID:");
        for (Integer temp: getList){
            System.out.print("|");
            System.out.print(temp);
        }
        System.out.print("|\n");
    }
    public static void printDepno(EmpDAO empDAO){
        ArrayList<Integer> getList = empDAO.selectDEPNO();
        System.out.println("Department identifiers:");
        for (Integer temp: getList){
            System.out.print("|");
            System.out.print(temp);
        }
        System.out.print("|\n");
    }
}
