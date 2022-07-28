package org.example.controller;

import org.example.dao.EmpDAO;
import org.example.dao.OracleDAOFactory;
import org.example.util.InputHelper;
import org.example.view.MenuView;

public class MainController {
    MenuView menuView = new MenuView();
    AddController addController = new AddController();
    DeleteController deleteController = new DeleteController();
    ShowEmpController showEmpController = new ShowEmpController();
    EmpDAO empDAO = OracleDAOFactory.getEmpDAO();
    Integer state;

   public void process() {
        while (true) {
            menuView.printMainMenu();
            state = InputHelper.InputNumInRange(1, 4);
            switch (state) {
                case 1:
                    addController.process(empDAO);
                    break;
                case 2:
                    deleteController.process(empDAO);
                    break;
                case 3:
                    showEmpController.process(empDAO);
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }
}
