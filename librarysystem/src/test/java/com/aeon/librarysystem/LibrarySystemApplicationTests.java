package com.aeon.librarysystem;

import com.aeon.librarysystem.constant.ApiConstants;
import com.aeon.librarysystem.controller.LibraryController;
import com.aeon.librarysystem.dto.BookDTO;
import com.aeon.librarysystem.dto.BorrowerDTO;
import com.aeon.librarysystem.dto.response.ApiResponse;
import com.aeon.librarysystem.service.BookService;
import com.aeon.librarysystem.service.BorrowerService;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class LibrarySystemApplicationTests {

    @Mock
    private BookService bookService;

    @Mock
    private BorrowerService borrowerService;

    @InjectMocks
    private LibraryController libraryController;

    private Faker faker;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        faker = new Faker();
    }

    private BorrowerDTO generateRandomBorrowerDTO() {
        return new BorrowerDTO(
                faker.number().randomNumber(),
                faker.name().fullName(),
                faker.internet().emailAddress()
        );
    }

    private BookDTO generateRandomBookDTO() {
        return new BookDTO(
                faker.number().randomNumber(),
                faker.code().isbn10(),
                faker.book().title(),
                faker.book().author(),
                false
        );
    }

    @Test
    void testRegisterBorrower() {
        BorrowerDTO borrowerDTO = generateRandomBorrowerDTO();
        when(borrowerService.registerBorrower(any(BorrowerDTO.class))).thenReturn(borrowerDTO);

        ApiResponse<BorrowerDTO> response = libraryController.registerBorrower(borrowerDTO);

        assertEquals(ApiConstants.CREATED_CODE, response.getCode());
    }

    @Test
    void testRegisterBook() {
        BookDTO bookDTO = generateRandomBookDTO();
        when(bookService.registerBook(any(BookDTO.class))).thenReturn(bookDTO);

        ApiResponse<BookDTO> response = libraryController.registerBook(bookDTO);

        assertEquals(ApiConstants.CREATED_CODE, response.getCode());
    }

    @Test
    void testGetAllBooks() {
        when(bookService.getAllBooks()).thenReturn(List.of(generateRandomBookDTO(), generateRandomBookDTO()));

        ApiResponse<?> response = libraryController.getAllBooks();

        assertEquals(ApiConstants.SUCCESS_CODE, response.getCode());
    }

    @Test
    void testBorrowBook() {
        Long bookId = faker.number().randomNumber();
        when(bookService.borrowBook(bookId)).thenReturn(generateRandomBookDTO());

        ApiResponse<?> response = libraryController.borrowBook(bookId);

        assertEquals(ApiConstants.SUCCESS_CODE, response.getCode());
    }

    @Test
    void testReturnBook() {
        Long bookId = faker.number().randomNumber();
        when(bookService.returnBook(bookId)).thenReturn(generateRandomBookDTO());

        ApiResponse<?> response = libraryController.returnBook(bookId);

        assertEquals(ApiConstants.SUCCESS_CODE, response.getCode());
    }
}
