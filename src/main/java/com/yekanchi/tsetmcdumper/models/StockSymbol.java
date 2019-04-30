package com.yekanchi.tsetmcdumper.models;

public final class StockSymbol {
    
    public StockSymbol() {
    };

    public StockSymbol(String Code, String PersianSymbol, String EnglishSymbol, String PersianName, String EnglishName,
            String Board, String GroupCode, String PersianGroupName) {
        this.Code = Code;
        this.PersianSymbol = PersianSymbol;
        this.EnglishSymbol = EnglishSymbol;
        this.PersianName = PersianName;
        this.EnglishName = EnglishName;
        this.Board = Board;
        this.GroupCode = GroupCode;
        this.PersianGroupName = PersianGroupName;
    };

    public String Code;

    public String PersianSymbol;
    public String EnglishSymbol;
    public String PersianName;
    public String EnglishName;
    public String Board;

    public String GroupCode;
    public String PersianGroupName;

}