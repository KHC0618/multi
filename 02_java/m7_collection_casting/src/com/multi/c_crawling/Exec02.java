package com.multi.c_crawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Exec02 {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://finance.naver.com/item/main.naver?code=005930").get();
            //전일가
            Elements list = doc.select("td.first").select(".blind");    // 메소드 체이닝. .메소드.메소드.메소드 ...
            System.out.println(list);
            Element tag = list.get(0);
            System.out.println("전일가: " + tag.text());
            Element tag1 = list.get(1);
            System.out.println("시가: " + tag1.text());

            Elements list1 = doc.select("div.today").select(".blind");
            System.out.println(list1);
            Element tag2 = list1.get(0);
            System.out.println("현재가: " + tag2.text());
            Element tag3 = list1.get(1);
            System.out.println("변동 가격: " + tag3.text());
            Element tag4 = list1.get(2);
            System.out.println("변동 퍼센트: " + tag4.text());

//            for (int i = 0; i < list.size(); i++) {
//                Element tag = list.get(i);  // Element 는 tag를 나타냄. 단품. Elements랑은 다름.
//                System.out.println(tag.text());
//            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
