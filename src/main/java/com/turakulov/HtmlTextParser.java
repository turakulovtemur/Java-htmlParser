package com.turakulov;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.summarizingDouble;

public class HtmlTextParser{

    /***
     * Подсчет повторяющихся слов
     * @param inputList список слов
     * @return
     */
    private Map<String, Long> countDuplicates(List<String> inputList) {
        return inputList.stream().collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum)); //Проверяем кол-во уникальных слов
       // return inputList.stream().collect(Collectors.toMap(counting()));
    }

    /***
     * Выделить только слова из html
     * @param body тело html
     * @return
     */
    public List<String> wordSeparator(String body){
        List<String> words = new ArrayList<>();
        for (String s : body.split("[, .':?;!\n\r\t]")) { //Разделяем слова
            if(!s.equals("")){
                words.add(s.replaceAll("[^a-zA-Zа-яёА-ЯЁ]", "").toLowerCase());
            }
        }
        return words;
    }

    /***
     * Парсит страницу
     * @param body тело html
     * @return
     */
    public Map<String, Long> parse(String body){
        List<String> wo_def= wordSeparator(body);
        Map<String, Long> frequency = countDuplicates(wo_def);
        return frequency;
    }
}
