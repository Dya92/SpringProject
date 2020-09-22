package proj.springframework.spring5webapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import proj.springframework.spring5webapp.model.Author;
import proj.springframework.spring5webapp.model.Book;
import proj.springframework.spring5webapp.model.Publisher;
import proj.springframework.spring5webapp.repositories.AuthorRepository;
import proj.springframework.spring5webapp.repositories.BookRepository;
import proj.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;

//    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
//        this.authorRepository = authorRepository;
//        this.bookRepository = bookRepository;
//        this.publisherRepository = publisherRepository;
//    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher harper = new Publisher();
        harper.setName("Harper Collins");
        Book ddd = new Book("Domain Driven Design", "1234", harper);
        eric.getBooks();
        ddd.getAuthors().add(eric);

        publisherRepository.save(harper);
        authorRepository.save(eric);
        bookRepository.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher worx = new Publisher();
        worx.setName("Worx");
        Book noEJB = new Book("J2EE Development without EJB", "23444", worx);
        rod.getBooks().add(noEJB);

        publisherRepository.save(worx);
        bookRepository.save(noEJB);
        authorRepository.save(rod);

    }

}
