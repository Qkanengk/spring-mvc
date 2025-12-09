package com.codegym.ung_dung_muon_sach.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String loanCode;
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Ticket(String loanCode, boolean status, Book book) {
        this.loanCode = loanCode;
        this.status = status;
        this.book = book;
    }
}
