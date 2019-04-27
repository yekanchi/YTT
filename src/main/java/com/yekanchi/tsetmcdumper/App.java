package com.yekanchi.tsetmcdumper;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.yekanchi.Utility.Tools;

import org.jsoup.Jsoup;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import DAL.sqllite.dataaccess.PricesRepository;

public class App {

    private static final Pattern intraTradeDataPattern = Pattern.compile("(IntraTradeData=[^;]*);$");

    public static void main(String[] args) {
        PricesRepository.insert("name", 12.1);
        Document doc;
        try {
            
            doc = Jsoup.connect("http://cdn.tsetmc.com/Loader.aspx?ParTree=15131P&i=9211775239375291&d=20190101")
                    .header("Accept-Encoding", "gzip, deflate")
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0) Gecko/20100101 Firefox/23.0")
                    .maxBodySize(0).timeout(600000).get();

            // get title of the page
            String title = doc.title();
            System.out.println("Title: " + title);

            Tools.Log("HHH");
            // ArrayList<String> downServers = new ArrayList<>();
            Elements scriptTags = doc.getElementsByTag("script");
            for (Element tag : scriptTags) {
                for (DataNode node : tag.dataNodes()) {
                    if (node.toString().contains("IntraTradeData")) {
                        Matcher matchedData = intraTradeDataPattern.matcher(node.getWholeData());
                        if (matchedData.find()) {
                            // ...then you can use group() methods.
                            System.out.println(matchedData.group(0));
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    

}
