package com.codegym.ung_dung_muon_sach.service;

import com.codegym.ung_dung_muon_sach.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IRentService {
    boolean rent(Integer bookId);

    boolean returnBook(String loanCode);

    void add(Ticket ticket);
    Page<Ticket> findAll(Pageable pageable, boolean status);
     String generateCode();
}
