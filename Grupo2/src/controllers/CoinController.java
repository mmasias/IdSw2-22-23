package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Coin;

public class CoinController {
    public List<Coin> createCoinList(int quantity1, int quantity2, int quantity3) {
        List<Coin> coins = new ArrayList<Coin>();
        coins.add(new Coin(0.50, quantity1));
        coins.add(new Coin(0.20, quantity2));
        coins.add(new Coin(0.05, quantity3));
        return coins;
    }
}
