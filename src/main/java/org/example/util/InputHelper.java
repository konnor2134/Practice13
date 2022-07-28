package org.example.util;

import org.example.dao.EmpDAO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class InputHelper {
    private static Scanner in = new Scanner(System.in);

    public static Integer InputNum() {
        boolean wasError = false;
        int inValue = 0;
        String tempInt;

        do {
            wasError = false;
            tempInt = in.nextLine();

            if (tempInt == null) {
                wasError = true;

            }

            try {
                inValue = Integer.parseInt(tempInt);
            } catch (NumberFormatException e) {
                wasError = true;
            }

            if (inValue < 0) {
                wasError = true;
            }

            if (wasError) {
                System.out.print("Value is not correct. Try again: ");
            }

        } while (wasError);

        return inValue;
    }

    public static String InputString() {
        boolean wasError = false;
        String line;

        do {
            wasError = false;
            line = in.nextLine();

            if (line == null) {
                wasError = true;
            }

            if (wasError) {
                System.out.print("Value is not correct. Try again: ");
            }
        } while (wasError);

        return line;
    }

    public static Date InputDate() {
        Date returnTime = null;
        boolean wasError = false;

        String tempDataTime;

        do {
            wasError = false;
            tempDataTime = in.nextLine();

            if (tempDataTime == null) {
                wasError = true;
            }

            returnTime = Date.valueOf(tempDataTime);

            if (wasError) {
                System.out.print("Value is not correct. Try again: ");
            }

        } while (wasError);

        return returnTime;
    }

    public static Integer InputNumInRange(int from, int to) {
        boolean wasError = false;
        Integer inValue = 0;
        String tempInt;

        do {
            wasError = false;
            tempInt = in.nextLine();

            if (tempInt == null) {
                wasError = true;
            }

            try {
                inValue = Integer.parseInt(tempInt);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                wasError = true;
            }

            if (inValue < from || inValue > to) {
                wasError = true;
            }

            if (wasError) {
                System.out.print("Value is not correct. Try again: ");
            }

        } while (wasError);

        return inValue;
    }

    public static Integer InputNumfromPool(ArrayList<Integer> temp) {
        boolean wasError = false;
        Integer inValue = 0;
        String tempInt;

        do {
            wasError = false;
            tempInt = in.nextLine();

            if (tempInt == null) {
                wasError = true;
            }

            try {
                inValue = Integer.parseInt(tempInt);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                wasError = true;
            }
            wasError = true;
            for (Integer i : temp) {
                if (inValue.equals(i)) {
                    wasError = false;
                }
            }

            if (wasError) {
                System.out.print("Value is not correct. Try again: ");
            }

        } while (wasError);

        return inValue;
    }
}
