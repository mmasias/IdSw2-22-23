package models;

import java.util.List;

public class BillModel extends MoneyAbstract {
    public BillModel(double value, int quantity) {
        super(value, quantity);
    }
    public int compareValue(BillModel billToCompare){
        return Double.compare(this.value, billToCompare.value);
    }

    @Override
    public void received(PurchaseModel purchaseModel) {
        purchaseModel.depositMoney((List<BillModel>) this);
    }

    public void increaseQuantity(int quantity) {
        this.quantity += quantity;
    }
}
