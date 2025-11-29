package com.example.library.controller;

import com.example.library.model.*;
import com.example.library.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class LibraryController {

    private final BookRepository bookRepo;
    private final AuthorRepository authorRepo;
    private final GenreRepository genreRepo;
    private final ReaderRepository readerRepo;
    private final BorrowingRepository borrowingRepo;

    public LibraryController(BookRepository bookRepo,
                             AuthorRepository authorRepo,
                             GenreRepository genreRepo,
                             ReaderRepository readerRepo,
                             BorrowingRepository borrowingRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
        this.genreRepo = genreRepo;
        this.readerRepo = readerRepo;
        this.borrowingRepo = borrowingRepo;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    // BOOKS
    @GetMapping("/books")
    public String books(Model model) {
        model.addAttribute("books", bookRepo.findAll());
        return "books";
    }

    @GetMapping("/book/add")
    public String addBookForm(Model model) {
        model.addAttribute("authors", authorRepo.findAll());
        model.addAttribute("genres", genreRepo.findAll());
        return "add-book";
    }

    @PostMapping("/book/add")
    public String addBook(@RequestParam String title,
                          @RequestParam Integer yearPublished,
                          @RequestParam Integer pages,
                          @RequestParam Long authorId,
                          @RequestParam Long genreId) {
        Author a = authorRepo.findById(authorId).orElseThrow();
        Genre g = genreRepo.findById(genreId).orElseThrow();
        Book b = new Book(title, yearPublished, pages, a, g);
        bookRepo.save(b);
        return "redirect:/books";
    }

    // AUTHORS
    @GetMapping("/authors")
    public String authors(Model model) {
        model.addAttribute("authors", authorRepo.findAll());
        return "authors";
    }

    @GetMapping("/author/add")
    public String addAuthorForm() {
        return "add-author";
    }

    @PostMapping("/author/add")
    public String addAuthor(@RequestParam String name, @RequestParam String country) {
        authorRepo.save(new Author(name, country));
        return "redirect:/authors";
    }

    // GENRES
    @GetMapping("/genres")
    public String genres(Model model) {
        model.addAttribute("genres", genreRepo.findAll());
        return "genres";
    }

    @GetMapping("/genre/add")
    public String addGenreForm() {
        return "add-genre";
    }

    @PostMapping("/genre/add")
    public String addGenre(@RequestParam String name) {
        genreRepo.save(new Genre(name));
        return "redirect:/genres";
    }

    // READERS
    @GetMapping("/readers")
    public String readers(Model model) {
        model.addAttribute("readers", readerRepo.findAll());
        return "readers";
    }

    @GetMapping("/reader/add")
    public String addReaderForm() {
        return "add-reader";
    }

    @PostMapping("/reader/add")
    public String addReader(@RequestParam String fullName, @RequestParam String phone) {
        readerRepo.save(new Reader(fullName, phone));
        return "redirect:/readers";
    }

    // BORROW
    @GetMapping("/borrow")
    public String borrowForm(Model model) {
        model.addAttribute("readers", readerRepo.findAll());
        model.addAttribute("books", bookRepo.findAll());
        return "borrow";
    }

    @PostMapping("/borrow")
    public String borrow(@RequestParam Long readerId, @RequestParam Long bookId) {
        Reader r = readerRepo.findById(readerId).orElseThrow();
        Book b = bookRepo.findById(bookId).orElseThrow();
        borrowingRepo.save(new Borrowing(r, b, LocalDate.now()));
        return "redirect:/borrowings";
    }

    @GetMapping("/borrowings")
    public String borrowings(Model model) {
        model.addAttribute("borrowings", borrowingRepo.findAll());
        return "borrowings";
    }
}
