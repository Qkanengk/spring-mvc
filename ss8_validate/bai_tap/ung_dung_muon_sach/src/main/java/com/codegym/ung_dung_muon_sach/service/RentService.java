package com.codegym.ung_dung_muon_sach.service;

import com.codegym.ung_dung_muon_sach.entity.Book;
import com.codegym.ung_dung_muon_sach.entity.Ticket;
import com.codegym.ung_dung_muon_sach.exception.OutOfStockException;
import com.codegym.ung_dung_muon_sach.repository.IBookRepository;
import com.codegym.ung_dung_muon_sach.repository.IRentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RentService implements IRentService {
    private final IRentRepository rentRepository;
    private final IBookRepository bookRepository;



    public RentService(IRentRepository rentRepository, IBookRepository bookRepository) {
        this.rentRepository = rentRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public boolean rent(Integer bookId) throws Exception {
        Book book = bookRepository.findById(bookId).orElse(null);
        if (book != null && book.getStock() <= 0) {
           throw new OutOfStockException("Out of stock");
        }
        book.setStock(book.getStock() - 1);
        bookRepository.save(book);
        Ticket ticket = new Ticket();
        ticket.setLoanCode(generateCode());
        ticket.setBook(book);
        ticket.setStatus(false);
        rentRepository.save(ticket);
        return true;
    }

    @Override
    public boolean returnBook(String loanCode) {
        Ticket ticket = rentRepository.findByLoanCode(loanCode);
        if (ticket!= null){
            Book book = bookRepository.findById(ticket.getBook().getId()).orElse(null);
            book.setStock(book.getStock() + 1);
            bookRepository.save(book);
            ticket.setStatus(true);
            rentRepository.save(ticket);
            return true;
        }
        return false;
    }

    @Override
    public void add(Ticket ticket) {
        rentRepository.save(ticket);
    }

    @Override
    public Page<Ticket> findAll(Pageable pageable, boolean status) {
        return rentRepository.findAllByStatus(pageable, status);
    }

    @Override
    public String generateCode() {
        return String.format("%05d", new java.util.Random().nextInt(100000));
    }
}
