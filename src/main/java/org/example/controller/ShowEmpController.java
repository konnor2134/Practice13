package org.example.controller;

import org.example.dao.EmpDAO;
import org.example.model.Emp;
import org.example.util.InputHelper;
import org.example.view.EmpView;
import org.example.view.PrintView;

public class ShowEmpController {
    EmpView view = new EmpView();
    Emp tempEmp;

    public Integer process(EmpDAO empDAO) {
        PrintView.printEmpno(empDAO);
        System.out.print("Enter the user ID: ");
        Integer tempEmpno = InputHelper.InputNumfromPool(empDAO.selectEMPNO());

        tempEmp = empDAO.selectEMP(tempEmpno);
        view.printEmp(tempEmp);

        return 0;
    }
}
