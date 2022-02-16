package com.turakulov;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.*;
import java.io.IOException;
import java.util.*;

public class Application {
    public static void main(String[] args) throws IOException {
        String path="./src/main/resources/PageForParsing.html";
        HtmlDownload downloader = new HtmlDownload();
        HtmlTextParser parser = new HtmlTextParser();
        ConsoleWriter consoleWriter = new ConsoleWriter();
        String html = downloader.downloadHtml("https://betacode.net/10399/jsoup-java-html-parser");
        downloader.writeToFile(html,path);
        consoleWriter.write(parser.parse(html));
    }

}
