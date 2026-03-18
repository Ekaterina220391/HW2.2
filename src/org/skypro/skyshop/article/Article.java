package org.skypro.skyshop.article;

import org.skypro.skyshop.Searchable;

public class Article implements Searchable {
    private final String title;
    private final String text;

    public Article(String title, String text) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Название статьи не может быть пустым");
        }
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Текст статьи не может быть пустым");
        }
        this.title = title;
        this.text = text;
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return title;
    }

    @Override
    public String toString() {
        return title + "\n" + text;
    }
}
