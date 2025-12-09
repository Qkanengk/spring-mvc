package com.codegym.ung_dung_muon_sach.repository;

import com.codegym.ung_dung_muon_sach.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentRepository extends JpaRepository<Ticket, Integer> {
     Ticket findByLoanCode(String loanCode);

     Page<Ticket> findAllByStatus(Pageable pageable, boolean status);
}
