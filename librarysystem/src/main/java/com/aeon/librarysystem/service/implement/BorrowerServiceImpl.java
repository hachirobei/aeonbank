package com.aeon.librarysystem.service.implement;

import com.aeon.librarysystem.dto.BorrowerDTO;
import com.aeon.librarysystem.entity.Borrower;
import com.aeon.librarysystem.repository.BorrowerRepository;
import com.aeon.librarysystem.service.BorrowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BorrowerServiceImpl implements BorrowerService {

    private final BorrowerRepository borrowerRepository;

    @Override
    public BorrowerDTO registerBorrower(BorrowerDTO borrowerDTO) {

        Borrower borrower = new Borrower();
        borrower.setName(borrowerDTO.getName());
        borrower.setEmail(borrowerDTO.getEmail());

        Borrower savedBorrower = borrowerRepository.save(borrower);

        return new BorrowerDTO(savedBorrower.getId(), savedBorrower.getName(), savedBorrower.getEmail());
    }
}
