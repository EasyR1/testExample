package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        GoogleHomePageExtractor extractor = new GoogleHomePageExtractor();
        String checkedUri = "https://www.google.ru/";
        try {
            boolean isGoogleHomePage = extractor.googleResultContainsOraclePage(checkedUri);
            System.out.println(isGoogleHomePage
                    ? "Эта страница с заголовком Google"
                    : "Эта страница не GOOGLE");
        } catch (IOException | InterruptedException e) {
            System.err.printf("Не удалось проверить страницу c uri: %s из-за: %s%n", checkedUri, e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}