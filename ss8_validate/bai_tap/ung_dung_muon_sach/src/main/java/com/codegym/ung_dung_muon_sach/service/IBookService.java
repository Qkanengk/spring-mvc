package com.codegym.ung_dung_muon_sach.service;

import com.codegym.ung_dung_muon_sach.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService {
    Page<Book>findAll(Pageable pageable);
    Book findById(Integer id);
}
