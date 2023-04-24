package controllers;

import java.util.ArrayList;
import java.util.List;
import models.CoinModel;

public class CoinController {
    public List<CoinModel> createCoinList(int quantity1, int quantity2, int quantity3) {
        List<CoinModel> coins = new ArrayList<CoinModel>();
        coins.add(new CoinModel(0.50, quantity1));
        coins.add(new CoinModel(0.20, quantity2));
        coins.add(new CoinModel(0.05, quantity3));
        return coins;
    }
}
