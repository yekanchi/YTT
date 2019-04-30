package com.yekanchi.tsetmcdumper.parser;

import java.io.IOException;
import java.util.ArrayList;

import com.yekanchi.Utility.Tools;
import com.yekanchi.tsetmcdumper.models.StockSymbol;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class ParseManager {
    public static ArrayList<StockSymbol> GetStockSymbolsTsetmc() {
        var stockSymbols = new ArrayList<StockSymbol>();

        try {
            var tsetmcDoc = Jsoup.connect("http://www.tsetmc.com/Loader.aspx?ParTree=111C1417")
                    .header("Accept-Encoding", "gzip, deflate").ignoreHttpErrors(true).validateTLSCertificates(false)
                    .maxBodySize(0).timeout(600000).get();

            var stockSymbolsTable = tsetmcDoc.select("#tblToGrid").first();

            for (Element tr : stockSymbolsTable.select("tr")) {
                var newStockSymbol = new StockSymbol(tr.select("td").get(0).html(), // Code
                        tr.select("td").get(6).select("a").html(), // PersianSymbol
                        tr.select("td").get(4).html(), // EnglishSymbol
                        tr.select("td").get(7).select("a").html(), // PersianName
                        tr.select("td").get(5).html(), // EnglishName
                        tr.select("td").get(3).html(), // Board
                        tr.select("td").get(1).html(), // GroupCode
                        tr.select("td").get(2).html());// PersianGroupName

                Tools.Log(newStockSymbol.Code + "\t" + newStockSymbol.PersianName);

                stockSymbols.add(newStockSymbol);
            }
            System.out.println(stockSymbols.size());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return stockSymbols;
    }
}
