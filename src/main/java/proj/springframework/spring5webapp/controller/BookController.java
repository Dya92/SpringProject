package proj.springframework.spring5webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import proj.springframework.spring5webapp.repositories.BookRepository;

@Controller
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    //pass the implementation of model interface at runtime
    public String getBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        //return a view called "books"
        return "books";
    }
}
