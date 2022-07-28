package org.example.view;

import org.example.model.Emp;

public class EmpView {
    public void printEmp(Emp emp) {
        StringBuilder resultToPrint = new StringBuilder();
        resultToPrint.append("ID: " + emp.getEmpno() + "\n");
        resultToPrint.append("Last name: " + emp.getEname() + "\n");
        resultToPrint.append("Work: " + emp.getJob() + "\n");
        resultToPrint.append("Manager ID: " + emp.getMgr() + "\n");
        resultToPrint.append("Hire date: " + emp.getHiredata() + "\n");
        resultToPrint.append("Salary: " + emp.getSal() + "\n");
        resultToPrint.append("Commisions: " + emp.getComm() + "\n");
        resultToPrint.append("Department: " + emp.getDname() + "\n");
        resultToPrint.append("City: " + emp.getLoc() + "\n");
        resultToPrint.append("ETS index - " + emp.getEts() + "\n");

        System.out.println(resultToPrint.toString());
    }
}
