package com.turakulov;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HtmlTextParserTest {

    private boolean areEqual(Map<String, Long> first, Map<String, Long> second) {
        if (first.size() != second.size()) {
            return false;
        }

        return first.entrySet().stream()
                .allMatch(e -> e.getValue().equals(second.get(e.getKey())));
    }

    @Test
    void parse() {
        HtmlTextParser htmlTextParser = new HtmlTextParser();
        String text = "Привет мир! Миру мир.";
        Map<String,Long> expected=new HashMap<>();
        expected.put("привет", 1L);
        expected.put("мир", 2L);
        expected.put("миру", 1L);

        Map<String, Long> actual = htmlTextParser.parse(text);

        assertTrue(areEqual(expected,actual));
    }
}