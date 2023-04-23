package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Coin;

public class CoinController {
    public List<Coin> createCoinList(int cant1, int cant2, int cant3) {
        List<Coin> monedas = new ArrayList<Coin>();
        monedas.add(new Coin(0.50, cant1));
        monedas.add(new Coin(0.20, cant2));
        monedas.add(new Coin(0.05, cant3));
        return monedas;
    }
}
