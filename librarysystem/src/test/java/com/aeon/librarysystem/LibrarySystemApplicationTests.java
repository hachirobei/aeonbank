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

import java.util.ArrayList;
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
                faker.number().numberBetween(1L, 1000L),
                faker.name().fullName(),
                faker.internet().emailAddress()
        );
    }

    private BookDTO generateRandomBookDTO() {
        return new BookDTO(
                faker.number().numberBetween(1L, 1000L),
                faker.code().isbn10(),
                faker.book().title(),
                faker.book().author(),
                faker.bool().bool()
        );
    }

    @Test
    void testRegisterBorrower() {
        // Arrange
        BorrowerDTO borrowerDTO = generateRandomBorrowerDTO();
        when(borrowerService.registerBorrower(any(BorrowerDTO.class))).thenReturn(borrowerDTO);

        // Act
        ApiResponse<BorrowerDTO> response = libraryController.registerBorrower(borrowerDTO);

        // Assert
        assertEquals(ApiConstants.CREATED_CODE, response.getCode());
        assertEquals(borrowerDTO, response.getData());
        verify(borrowerService, times(1)).registerBorrower(any(BorrowerDTO.class));
    }

    @Test
    void testRegisterBook() {
        // Arrange
        BookDTO bookDTO = generateRandomBookDTO();
        when(bookService.registerBook(any(BookDTO.class))).thenReturn(bookDTO);

        // Act
        ApiResponse<BookDTO> response = libraryController.registerBook(bookDTO);

        // Assert
        assertEquals(ApiConstants.CREATED_CODE, response.getCode());
        assertEquals(bookDTO, response.getData());
        verify(bookService, times(1)).registerBook(any(BookDTO.class));
    }

    @Test
    void testGetAllBooks() {
        // Arrange
        List<BookDTO> bookList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            bookList.add(generateRandomBookDTO());
        }
        when(bookService.getAllBooks()).thenReturn(bookList);

        // Act
        ApiResponse<List<BookDTO>> response = libraryController.getAllBooks();

        // Assert
        assertEquals(ApiConstants.SUCCESS_CODE, response.getCode());
        assertEquals(bookList, response.getData());
        verify(bookService, times(1)).getAllBooks();
    }

    @Test
    void testBorrowBook() {
        // Arrange
        Long bookId = faker.number().numberBetween(1L, 1000L);
        BookDTO borrowedBook = generateRandomBookDTO();
        when(bookService.borrowBook(bookId)).thenReturn(borrowedBook);

        // Act
        ApiResponse<BookDTO> response = libraryController.borrowBook(bookId);

        // Assert
        assertEquals(ApiConstants.SUCCESS_CODE, response.getCode());
        assertEquals(borrowedBook, response.getData());
        verify(bookService, times(1)).borrowBook(bookId);
    }

    @Test
    void testReturnBook() {
        // Arrange
        Long bookId = faker.number().numberBetween(1L, 1000L);
        BookDTO returnedBook = generateRandomBookDTO();
        when(bookService.returnBook(bookId)).thenReturn(returnedBook);

        // Act
        ApiResponse<BookDTO> response = libraryController.returnBook(bookId);

        // Assert
        assertEquals(ApiConstants.SUCCESS_CODE, response.getCode());
        assertEquals(returnedBook, response.getData());
        verify(bookService, times(1)).returnBook(bookId);
    }
}
