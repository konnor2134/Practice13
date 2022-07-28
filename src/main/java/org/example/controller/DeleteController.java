package org.example.controller;

import org.example.dao.EmpDAO;
import org.example.util.InputHelper;
import org.example.view.PrintView;

public class DeleteController {
    public Integer process(EmpDAO empDAO) {
        PrintView.printEmpno(empDAO);
        System.out.print("Enter the user ID: ");
        Integer tempEmpno = InputHelper.InputNumfromPool(empDAO.selectEMPNO());

        empDAO.removeEMP(tempEmpno);

        return 0;

    }
}
