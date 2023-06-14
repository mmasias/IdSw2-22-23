package controllers;

import java.util.ArrayList;
import java.util.List;

import models.BillModel;
import models.MachineModel;
import models.CoinModel;
import models.ProductModel;
import models.PurchaseModel;
import views.PurchaseView;
import utils.Line;

public class InitializerController {

    public void machines() {
        final Line line = new Line(27);
        final PurchaseModel purchaseModel = new PurchaseModel();

        final BillController billController = new BillController();
        final CoinController coinController = new CoinController();
        final ProductController productController = new ProductController();
        final PurchaseController purchaseController = new PurchaseController(purchaseModel, line);
        final MachineController machineController = new MachineController(purchaseController, line);
        final MaintenanceController maintenanceController = new controllers.MaintenanceController();

        final PurchaseView purchaseView = new PurchaseView(machineController, maintenanceController,line);
        final List<MachineModel> machines = generateMachines(billController, coinController, productController);

        purchaseView.purchaseMenu(machines);
    }

    public static List<MachineModel> generateMachines(BillController billController, CoinController coinController, ProductController productController) {
        final List<BillModel> billsMachine01 = billController.createBillList(3,1,2,5,10);
        final List<CoinModel> coinsMachine01 = coinController.createCoinList(10, 20, 10);

        final List<BillModel> billsMachine02 = billController.createBillList(3, 2, 3, 7, 15);
        final List<CoinModel> coinsMachine02 = coinController.createCoinList(25, 30, 20);

        final List<BillModel> billsMachine03 = billController.createBillList(3, 1, 3, 5, 12);
        final List<CoinModel> coinsMachine03 = coinController.createCoinList(30, 10, 15);

        final List<ProductModel> products = productController.createProductList();

        final List<MachineModel> machines = new ArrayList<MachineModel>();

        
        machines.add(new MachineModel("Maquina 1", billsMachine01, coinsMachine01, products));
        machines.add(new MachineModel("Maquina 2", billsMachine02, coinsMachine02, products));
        machines.add(new MachineModel("Maquina 3", billsMachine03, coinsMachine03, products));

        return machines;
    }

}
