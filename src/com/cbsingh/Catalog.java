package com.cbsingh;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Catalog implements Search{

    private HashMap<String, List<Book>> bookTitles;
    private HashMap<String, List<Book>> bookAuthors;
    private HashMap<String, List<Book>> bookSubjects;
    private HashMap<String, List<Book>> bookPublicationDates;

    @Override
    public List<Book> searchByTitle(String query) {
        return bookTitles.get(query);
    }

    @Override
    public List<Book> searchByAuthor(String query) {
        return bookAuthors.get(query);
    }

    @Override
    public List<Book> searchBySubject(String query) {
        return bookSubjects.get(query);
    }

    @Override
    public List<Book> searchByPublicationDate(Date publishDate) {
        String dateStr = publishDate.toString();
        return bookPublicationDates.get(dateStr);
    }

}
