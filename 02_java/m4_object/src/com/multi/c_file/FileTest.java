package com.multi.c_file;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileTest {
    public static void main(String[] args) {
        File f = new File("text.txt");
        boolean result = f.exists();
        System.out.println(result);
        System.out.println(f.isDirectory());
        System.out.println(f.isFile());
        System.out.println(f.getParent());
        System.out.println(f.getAbsolutePath());
        try {
            f.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File folder = new File("parent"); //folder == directory == package
        folder.mkdir();
        System.out.println(folder.isDirectory());
        String[] list = folder.list();
        System.out.println(Arrays.toString(list));
    }
}
