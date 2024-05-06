package com.multi.c_crawling;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Exec01 {
    public static void main(String[] args) {
        // 크롤링 순서
        // 1. 사이트 연결
        // 2. 해당 페이지 다운로드(html)
        // 3. 원하는 위치의 정보를 추출해냄

        Connection con = Jsoup.connect("https://www.naver.com/");
        System.out.println("1. 사이트 연결 성공!!");

        try {
            Document doc = con.get();
            System.out.println("2. 해당 페이지 다운로드 성공!!"); //index.html
            System.out.println("-----------------------");
//            System.out.println(doc);
            System.out.println("3. 원하는 위치의 정보를 추출 성공!!");
            Elements list = doc.select("a");    // ArrayList 타입이라 index 가능
            System.out.println(list.size());
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
                Element tag = list.get(i);  // Element 는 tag를 나타냄. 단품.
                System.out.println(tag.text());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Document doc1 = Jsoup.connect("https://news.naver.com/").get();
            System.out.println("2. 해당 페이지 다운로드 성공!!"); //index.html
            System.out.println("-----------------------");
//            System.out.println(doc);
            System.out.println("3. 원하는 위치의 정보를 추출 성공!!");
            Elements list = doc1.select("a");    // ArrayList 타입이라 index 가능
            System.out.println(list.size());
            for (int i = 0; i < list.size(); i++) {
//                System.out.println(list.get(i));
                Element tag = list.get(i);  // Element 는 tag를 나타냄. 단품. Elements랑은 다름.
                System.out.println(tag.text());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
