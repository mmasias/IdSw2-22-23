
import java.util.ArrayList;
import java.util.List;

import controllers.BillController;
import controllers.CoinController;
import controllers.ProductController;

import models.Bill;
import models.Machine;
import models.Coin;
import models.Product;

import views.MachineView;
import views.ProductView;
import views.PurchaseView;

class Main {
    public static void main(String[] args) {
        BillController billController = new BillController();
        CoinController coinController = new CoinController();
        ProductController productController = new ProductController();

        ProductView productsView = new ProductView();
        MachineView machineView = new MachineView();
        PurchaseView purchaseView = new PurchaseView();

        List<Bill> billsMachine01 = billController.createBillList(3,1,2,5,10);
        List<Coin> coinsMachine01 = coinController.createCoinList(10, 20, 10);

        List<Bill> billsMachine02 = billController.createBillList(3, 2, 3, 7, 15);
        List<Coin> coinsMachine02 = coinController.createCoinList(25, 30, 20);

        List<Bill> billsMachine03 = billController.createBillList(3, 1, 3, 5, 12);
        List<Coin> coinsMachine03 = coinController.createCoinList(30, 10, 15);

        List<Product> products = productController.createProductList();

        List<Machine> machines = new ArrayList<Machine>();
        machines.add(new Machine("Maquina 1", billsMachine01, coinsMachine01, products));
        machines.add(new Machine("Maquina 2", billsMachine02, coinsMachine02, products));
        machines.add(new Machine("Maquina 3", billsMachine03, coinsMachine03, products));

        machineView.printMachineName(machines);
        productsView.printProducts(machines);
        purchaseView.purchaseMenu(machines);
    }

}
