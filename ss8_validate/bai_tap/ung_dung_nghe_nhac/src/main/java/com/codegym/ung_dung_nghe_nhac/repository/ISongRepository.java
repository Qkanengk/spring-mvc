package com.codegym.ung_dung_nghe_nhac.repository;

import com.codegym.ung_dung_nghe_nhac.entity.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song,Integer> {
    Page<Song> findAll(Pageable pageable);
}
