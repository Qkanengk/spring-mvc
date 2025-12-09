package com.codegym.ung_dung_nghe_nhac.service;

import com.codegym.ung_dung_nghe_nhac.entity.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISongService {
    Page<Song> findAll(Pageable pageable);

    void save(Song song);

    Song findById(Integer id);

    void remove(Integer id);

    void update(Integer id, Song song);
}
