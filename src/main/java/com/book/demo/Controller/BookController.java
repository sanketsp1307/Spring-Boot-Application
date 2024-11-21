package com.book.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/books")
public class BookController {

    List<Book> booksList = new ArrayList<>();

    @GetMapping("showBooks")
    public String getAllBooks() {
        return "Books Available: " + booksList;
    }

    @PostMapping("addBook")
    public String addBook(@RequestParam("id") Long id, @RequestParam("title") String title, @RequestParam("author") String author) {
        booksList.add(new Book(id, title, author));
        return "Book Added Successfully: " + title;
    }

    @DeleteMapping("deleteBook")
    public String deleteBook(@RequestParam("id") int id) {
        for (Book book : booksList) {
            if (book.getId() == id) {
                booksList.remove(book);
                return "The updated list is: " + booksList;
            }
        }
        return "Book not found with ID: " + id;
    }

    @PutMapping("updateBook/{id}")
    public String updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
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
