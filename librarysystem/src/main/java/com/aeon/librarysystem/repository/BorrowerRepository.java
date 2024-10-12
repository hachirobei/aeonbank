package com.aeon.librarysystem.repository;

import com.aeon.librarysystem.entity.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Long> {

    boolean existsByEmail(String email);

}