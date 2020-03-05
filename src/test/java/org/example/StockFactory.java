package org.example;

public class StockFactory {

    // Need to add date + time

    private String symbol;
    private String lastPrice;
    private String changeDollars;
    private String changePercent;
    private String volume;
    private String averageVolume;
    private String marketCap;
    private String scrapeDate;


    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getChangeDollars() {
        return changeDollars;
    }

    public void setChangeDollars(String changeDollars) {
        this.changeDollars = changeDollars;
    }

    public String getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(String changePercent) {
        this.changePercent = changePercent;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getAverageVolume() {
        return averageVolume;
    }

    public void setAverageVolume(String averageVolume) {
        this.averageVolume = averageVolume;
    }

    public String getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(String marketCap) {
        this.marketCap = marketCap;
    }
    public String getScrapeDate() {
        return scrapeDate;
    }

    public void setScrapeDate(String scrapeDate) {
        this.scrapeDate = scrapeDate;
    }
    public void stockReport() {
        System.out.println("Symbol: " + this.symbol);
        System.out.println("Last Price: " + this.lastPrice);
        System.out.println("Dollar Change: " + this.changeDollars);
        System.out.println("Percent Change: " + this.changePercent);
        System.out.println("Volume: " + this.volume);
        System.out.println("Avg Volume: " + this.averageVolume);
        System.out.println("Market Cap: " + this.marketCap);
        System.out.println("Date: " + this.scrapeDate);
        System.out.println("----------------");
    }
}

