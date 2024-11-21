package com.book.demo.Controller;

package com.book.demo;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    // In-memory list to store books 
    List<Book> booksList = new ArrayList<>();

    public List<Book> getAllBooks() {
        return booksList;
    }

    public String addBook(long id, String title, String author) {
        booksList.add(new Book(id, title, author));
        return "Book Added Successfully: " + title;
    }

    public String deleteBook(int id) {
        for (Book book : booksList) {
            if (book.getId() == id) {
                booksList.remove(book);
                return "The updated list is: " + booksList;
            }
        }
        return "Book not found with ID: " + id;
    }

    public String updateBook(int id, Book updatedBook) {
        for (Book book : booksList) {
            if (book.getId() == id) {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                return "Updated Book: " + book;
            }
        }
        return "Book not found with ID: " + id;
    }
}
