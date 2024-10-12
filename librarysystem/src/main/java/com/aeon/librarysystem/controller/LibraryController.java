package com.aeon.librarysystem.controller;

import com.aeon.librarysystem.constant.ApiConstants;
import com.aeon.librarysystem.dto.BookDTO;
import com.aeon.librarysystem.dto.BorrowerDTO;
import com.aeon.librarysystem.dto.response.ApiResponse;
import com.aeon.librarysystem.service.BookService;
import com.aeon.librarysystem.service.BorrowerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library")
@RequiredArgsConstructor
@Tag(name = "Library API", description = "API for managing books and borrowers in a library system")
public class LibraryController {

    private final BookService bookService;
    private final BorrowerService borrowerService;

    @Operation(summary = "Register a new borrower", description = "Registers a new borrower to the library system.")
    @PostMapping("/borrowers")
    public ApiResponse<BorrowerDTO> registerBorrower(
            @Parameter(description = "Borrower details to register", required = true)
            @Valid @RequestBody BorrowerDTO borrowerDTO) {
        BorrowerDTO registeredBorrower = borrowerService.registerBorrower(borrowerDTO);
        return ApiResponse.success(ApiConstants.CREATED_CODE, registeredBorrower);
    }

    @Operation(summary = "Register a new book", description = "Registers a new book to the library system.")
    @PostMapping("/books")
    public ApiResponse<BookDTO> registerBook(
            @Parameter(description = "Book details to register", required = true)
            @Valid @RequestBody BookDTO bookDTO) {
        BookDTO registeredBook = bookService.registerBook(bookDTO);
        return ApiResponse.success(ApiConstants.CREATED_CODE, registeredBook);
    }

    @Operation(summary = "Get all books", description = "Retrieves a list of all books available in the library system.")
    @GetMapping("/books")
    public ApiResponse<List<BookDTO>> getAllBooks() {
        List<BookDTO> books = bookService.getAllBooks();
        return ApiResponse.success(ApiConstants.SUCCESS_CODE, books);
    }

    @Operation(summary = "Borrow a book", description = "Allows a borrower to borrow a book by its ID.")
    @PostMapping("/borrow/{bookId}")
    public ApiResponse<BookDTO> borrowBook(
            @Parameter(description = "ID of the book to borrow", required = true)
            @PathVariable Long bookId) {
        BookDTO borrowedBook = bookService.borrowBook(bookId);
        return ApiResponse.success(ApiConstants.SUCCESS_CODE, borrowedBook);
    }

    @Operation(summary = "Return a book", description = "Allows a borrower to return a borrowed book by its ID.")
    @PostMapping("/return/{bookId}")
    public ApiResponse<BookDTO> returnBook(
            @Parameter(description = "ID of the book to return", required = true)
            @PathVariable Long bookId) {
        BookDTO returnedBook = bookService.returnBook(bookId);
        return ApiResponse.success(ApiConstants.SUCCESS_CODE, returnedBook);
    }
}
