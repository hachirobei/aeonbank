package com.aeon.librarysystem.service;

import com.aeon.librarysystem.dto.BookDTO;
import jakarta.transaction.Transactional;

import java.util.List;

public interface BookService {
    BookDTO registerBook(BookDTO bookDTO);

    List<BookDTO> getAllBooks();

    @Transactional
    BookDTO borrowBook(Long bookId);

    @Transactional
    BookDTO returnBook(Long bookId);
}
