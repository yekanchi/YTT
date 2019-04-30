package com.yekanchi.tsetmcdumper;

import com.yekanchi.tsetmcdumper.parser.ParseManager;

public class App {
    public static void main(String[] args) {
        var stockSymbols = ParseManager.GetStockSymbolsTsetmc();
    }
}
