package com.aeon.librarysystem.service.implement;

import com.aeon.librarysystem.constant.ApiConstants;
import com.aeon.librarysystem.dto.BookDTO;
import com.aeon.librarysystem.entity.Book;
import com.aeon.librarysystem.exception.*;
import com.aeon.librarysystem.repository.BookRepository;
import com.aeon.librarysystem.service.BookService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public BookDTO registerBook(BookDTO bookDTO) {
        bookRepository.findByIsbn(bookDTO.getIsbn()).ifPresent(existingBook -> {
            if (!existingBook.getTitle().equals(bookDTO.getTitle()) ||
                    !existingBook.getAuthor().equals(bookDTO.getAuthor())) {
                throw new InvalidBookDetailsException(String.format(
                        "ISBN %s exists with a different title/author. Expected Title: %s, Author: %s",
                        bookDTO.getIsbn(), existingBook.getTitle(), existingBook.getAuthor()));
            }
            throw new BookAlreadyExistsException(String.format(
                    "Book with ISBN %s already exists with title: %s and author: %s.",
                    bookDTO.getIsbn(), bookDTO.getTitle(), bookDTO.getAuthor()));
        });

        Book book = new Book(null, bookDTO.getIsbn(), bookDTO.getTitle(), bookDTO.getAuthor(), false);
        Book savedBook = bookRepository.save(book);

        return mapToDTO(savedBook);
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Transactional
    @Override
    public BookDTO borrowBook(Long bookId) {
        return bookRepository.findById(bookId)
                .map(book -> {
                    if (book.isBorrowed()) {
                        throw new BookAlreadyBorrowedException();
                    }
                    book.setBorrowed(true);
                    return bookRepository.save(book);
                })
                .map(this::mapToDTO)
                .orElseThrow(BookNotFoundException::new);
    }

    @Transactional
    @Override
    public BookDTO returnBook(Long bookId) {
        return bookRepository.findById(bookId)
                .map(book -> {
                    if (!book.isBorrowed()) {
                        throw new BookNotBorrowedException(String.format(
                                "Book with ID %s was not borrowed.", bookId));
                    }
                    book.setBorrowed(false);
                    return bookRepository.save(book);
                })
                .map(this::mapToDTO)
                .orElseThrow(BookNotFoundException::new);
    }

    private BookDTO mapToDTO(Book book) {
        return new BookDTO(
                book.getId(),
                book.getIsbn(),
                book.getTitle(),
                book.getAuthor(),
                book.isBorrowed());
    }
}
