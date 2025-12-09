package com.codegym.ung_dung_muon_sach.dto;

import com.codegym.ung_dung_muon_sach.entity.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {
    private Integer bookId;
}
