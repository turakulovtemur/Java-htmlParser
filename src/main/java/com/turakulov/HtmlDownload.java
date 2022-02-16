package com.turakulov;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class HtmlDownload {

    /***
     * Записать текст в файл
     * @param text входной текст
     * @param filePath путь до файла
     */
    public void writeToFile(String text, String filePath){

        try(FileWriter writer=new FileWriter(filePath))
        {
            File file = new File(filePath);

            writer.write(text);
        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    /***
     * Скачать страницу по ссылке
     * @param route ссылка
     * @return
     */
    public String downloadHtml(String route){
        Document doc = null;

        try {
            doc = Jsoup.connect(route).maxBodySize(Integer.MAX_VALUE).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return doc.clone().outerHtml();
    }

}
