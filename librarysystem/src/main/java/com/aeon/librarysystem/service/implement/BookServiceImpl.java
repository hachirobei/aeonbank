package com.aeon.librarysystem.service.implement;

import com.aeon.librarysystem.constant.ApiConstants;
import com.aeon.librarysystem.dto.BookDTO;
import com.aeon.librarysystem.entity.Book;
import com.aeon.librarysystem.exception.BookAlreadyBorrowedException;
import com.aeon.librarysystem.exception.BookNotBorrowedException;
import com.aeon.librarysystem.exception.BookNotFoundException;
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

        Book book = new Book();
        book.setIsbn(bookDTO.getIsbn());
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setBorrowed(false);

        Book savedBook = bookRepository.save(book);

        return new BookDTO(savedBook.getId(), savedBook.getIsbn(), savedBook.getTitle(), savedBook.getAuthor(), savedBook.isBorrowed());
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(book -> new BookDTO(book.getId(), book.getIsbn(), book.getTitle(), book.getAuthor(), book.isBorrowed()))
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
                .map(savedBook -> new BookDTO(savedBook.getId(), savedBook.getIsbn(), savedBook.getTitle(), savedBook.getAuthor(), savedBook.isBorrowed()))
                .orElseThrow(BookNotFoundException::new);
    }

    @Transactional
    @Override
    public BookDTO returnBook(Long bookId) {
        return bookRepository.findById(bookId)
                .map(book -> {
                    if (!book.isBorrowed()) {

                        throw new BookNotBorrowedException("Book with ID " + bookId + " was not borrowed. Error Code: " + ApiConstants.BOOK_NOT_BORROWED_CODE);
                    }
                    book.setBorrowed(false);
                    return bookRepository.save(book);
                })
                .map(savedBook -> new BookDTO(savedBook.getId(), savedBook.getIsbn(), savedBook.getTitle(), savedBook.getAuthor(), savedBook.isBorrowed()))
                .orElseThrow(BookNotFoundException::new);
    }
}
