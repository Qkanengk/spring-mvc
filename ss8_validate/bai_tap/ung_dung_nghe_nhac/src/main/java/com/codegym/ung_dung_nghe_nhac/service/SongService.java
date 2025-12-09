package com.codegym.ung_dung_nghe_nhac.service;

import com.codegym.ung_dung_nghe_nhac.entity.Song;
import com.codegym.ung_dung_nghe_nhac.repository.ISongRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongService implements ISongService {
    private final ISongRepository songRepository;

    public SongService(ISongRepository songRepository) {
        this.songRepository = songRepository;
    }


    @Override
    public Page<Song> findAll(Pageable pageable) {
        return songRepository.findAll(pageable);
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song findById(Integer id) {
        return songRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Integer id) {
        songRepository.deleteById(id);
    }

    @Override
    public void update(Integer id, Song song) {
        Song song1 = findById(id);
        if (song1 != null){
            song1.setName(song.getName());
            song1.setSinger(song.getSinger());
            song1.setGenre(song.getGenre());
            song1.setUrl(song.getUrl());
            songRepository.save(song1);
        }
    }
}
