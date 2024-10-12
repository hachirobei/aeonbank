package com.aeon.librarysystem.initializer;

import com.aeon.librarysystem.entity.Book;
import com.aeon.librarysystem.entity.Borrower;
import com.aeon.librarysystem.repository.BookRepository;
import com.aeon.librarysystem.repository.BorrowerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BorrowerRepository borrowerRepository;
    private final BookRepository bookRepository;

    public DataInitializer(BorrowerRepository borrowerRepository, BookRepository bookRepository) {
        this.borrowerRepository = borrowerRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args){
        // Insert Borrowers
        borrowerRepository.save(new Borrower(null, "John Doe", "john.doe@example.com"));
        borrowerRepository.save(new Borrower(null, "Jane Smith", "jane.smith@example.com"));
        borrowerRepository.save(new Borrower(null, "Alice Johnson", "alice.johnson@example.com"));
        borrowerRepository.save(new Borrower(null, "Bob Brown", "bob.brown@example.com"));
        borrowerRepository.save(new Borrower(null, "Charlie Davis", "charlie.davis@example.com"));

        // Insert Books
        bookRepository.save(new Book(null, "978-3-16-148410-0", "Spring Boot in Action", "Craig Walls", false));
        bookRepository.save(new Book(null, "978-0-12-374514-9", "Effective Java", "Joshua Bloch", false));
        bookRepository.save(new Book(null, "978-1-59327-599-0", "Clean Code", "Robert C. Martin", false));
        bookRepository.save(new Book(null, "978-1-118-37016-6", "Head First Design Patterns", "Eric Freeman", false));
        bookRepository.save(new Book(null, "978-0-321-35668-0", "Refactoring", "Martin Fowler", false));
    }
}