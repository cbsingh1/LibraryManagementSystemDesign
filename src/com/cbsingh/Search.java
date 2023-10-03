package com.cbsingh;

import java.util.Date;
import java.util.List;

public interface Search {
    List<Book> searchByTitle(String query);
    List<Book> searchByAuthor(String query);
    List<Book> searchBySubject(String query);
    List<Book> searchByPublicationDate(Date publishDate);
}
