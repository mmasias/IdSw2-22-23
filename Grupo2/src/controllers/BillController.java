package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Bill;

public class BillController {
    public List<Bill> createBillList(int quantity1, int quantity2, int quantity3, int quantity4, int quantity5) {
        List<Bill> bills = new ArrayList<Bill>();
        bills.add(new Bill(20, quantity1));
        bills.add(new Bill(10, quantity2));
        bills.add(new Bill(5, quantity3));
        bills.add(new Bill(2, quantity4));
        bills.add(new Bill(1, quantity5));
        return bills;
    }
}
