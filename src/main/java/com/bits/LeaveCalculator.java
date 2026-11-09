package com.bits;

public class LeaveCalculator {
    public int getLeaveBalance(String empId) {
        if (empId == null) {
                return 0;
        }
        return 10;
    }

    public int getLeaveEncashment(String empId) {
        if (empId == null) {
                return 0;
        }
        return 10 * 1000;
    }
}

