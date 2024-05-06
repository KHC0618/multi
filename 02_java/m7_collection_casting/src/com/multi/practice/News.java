package com.multi.practice;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;

public class News {

    public static void main(String[] args) {
        Workbook workbook = new HSSFWorkbook();
        int rowNo = 0;

        Sheet sheet1 = workbook.createSheet("네이버 경제뉴스");

        Document doc = null;
        try {
            doc = Jsoup.connect("https://news.naver.com/section/100").get();
            Elements list = doc.select(".sa_text_strong");

            System.out.println(list.size());

            for (int i = 0; i < list.size(); i++) {
                Row row = sheet1.createRow(rowNo++);
                Element tag = list.get(i);
                row.createCell(0).setCellValue(i + 1);
                row.createCell(1).setCellValue(tag.text());
                System.out.println(i + ":" + tag.text());
            }
            FileOutputStream fileOut = new FileOutputStream("news.xlsx");
            workbook.write(fileOut);
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
