package org.example.controller;

import org.example.dao.EmpDAO;
import org.example.model.Emp;
import org.example.util.InputHelper;
import org.example.view.PrintView;

import java.sql.Date;

public class AddController {
    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    private Date hiredata;
    private Integer sal;
    private Integer comm;
    private Integer deptno;

    public Integer process(EmpDAO empDAO) {
        System.out.print("Enter the employee's individual number: ");
        empno = InputHelper.InputNum();

        System.out.print("Enter the employee's last name: ");
        ename = InputHelper.InputString();

        System.out.print("Enter the job of the employee: ");
        job = InputHelper.InputString();

        PrintView.printEmpno(empDAO);
        System.out.print("Enter the employee's manager: ");
        mgr = InputHelper.InputNumfromPool(empDAO.selectEMPNO());

        System.out.print("Enter the employee's hiring date (YYYY-MM-DD): ");
        hiredata = InputHelper.InputDate();

        System.out.print("Enter the employee's salary: ");
        sal = InputHelper.InputNum();

        System.out.print("Enter employee commissions: ");
        comm = InputHelper.InputNum();

        PrintView.printDepno(empDAO);
        System.out.print("Enter the employee's department number - ");
        deptno = InputHelper.InputNumfromPool(empDAO.selectDEPNO());

        empDAO.insertEMP(new Emp(empno, ename, job, mgr, hiredata, sal, comm, deptno, "dname", "loc", 0));
        return 0;
    }
}
