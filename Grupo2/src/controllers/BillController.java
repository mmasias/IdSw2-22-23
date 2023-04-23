package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Bill;

public class BillController {
    public List<Bill> createBillList(int cant1, int cant2, int cant3, int cant4, int cant5) {
        List<Bill> billetes = new ArrayList<Bill>();
        billetes.add(new Bill(20, cant1));
        billetes.add(new Bill(10, cant2));
        billetes.add(new Bill(5, cant3));
        billetes.add(new Bill(2, cant4));
        billetes.add(new Bill(1, cant5));
        return billetes;
    }
}
