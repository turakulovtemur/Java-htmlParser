package com.turakulov;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class
ConsoleWriter implements IResultWriter{
    @Override
    public void write(Map<String, Long> result) {
        result.forEach((k,v)-> System.out.println(k+" = "+v));
    }
}
