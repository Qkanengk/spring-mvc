package com.codegym.ung_dung_nghe_nhac.entity;

import com.codegym.ung_dung_nghe_nhac.utils.annotations.ValidSongSinger;
import com.codegym.ung_dung_nghe_nhac.utils.annotations.ValidSongURL;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Vui lòng nhập tên bài hát")
    private String name;
    @NotBlank(message = "Vui lòng nhập tên ca sĩ")
    @ValidSongSinger
    private String singer;
    @NotBlank(message = "Vui lòng nhập thể loại")
    private String genre;
    @NotBlank(message = "Vui lòng nhập URL bài hát")
    @ValidSongURL
    private String url;

}
