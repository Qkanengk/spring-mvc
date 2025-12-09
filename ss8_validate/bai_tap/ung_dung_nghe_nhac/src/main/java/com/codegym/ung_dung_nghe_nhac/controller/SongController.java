package com.codegym.ung_dung_nghe_nhac.controller;

import com.codegym.ung_dung_nghe_nhac.entity.Song;
import com.codegym.ung_dung_nghe_nhac.service.ISongService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/songs")
public class SongController {
    private final ISongService songService;

    public SongController(ISongService songService) {
        this.songService = songService;
    }

    @GetMapping("")
    public String findAll(@PageableDefault(size = 5) Pageable pageable, Model model) {
        Page<Song> songPage = songService.findAll(pageable);
        model.addAttribute("songs", songPage);
        return "song/list";
    }

    @GetMapping("delete")
    public String delete(@RequestParam("id") Integer id){
        songService.remove(id);
        return "redirect:/songs";
    }

    @GetMapping("add")
    public String showAddForm(Model model){
        model.addAttribute("song", new Song());
        return "song/add";
    }


    @PostMapping("add")
    public String add(@Valid @ModelAttribute Song song, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return  "song/add";
        }
        songService.save(song);
        return "redirect:/songs";
    }

    @GetMapping("update")
    public String showUpdateForm(@RequestParam("id") Integer id, Model model){
        Song song = songService.findById(id);
        model.addAttribute("song", song);
        return "song/update";
    }
    @PostMapping("update")
    public String update(@Valid @ModelAttribute Song song, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return  "song/update";
        }
        songService.update(song.getId(), song);
        return "redirect:/songs";
    }
}
