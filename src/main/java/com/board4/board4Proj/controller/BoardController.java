package com.board4.board4Proj.controller;

import com.board4.board4Proj.dto.BoardDTO;
import com.board4.board4Proj.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("save")
    public String save(){
        return "save";
    }

    @PostMapping("/save")
    public String save(BoardDTO boardDTO, Model model){
        boardService.save(boardDTO);
        model.addAttribute("board",boardDTO);
        System.out.println("model = " + model);
        return "index";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<BoardDTO> boardDTO = boardService.list();
        model.addAttribute("board", boardDTO);
        System.out.println("model = " + model);
        return "list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable("id") Long id, Model model){
        BoardDTO boardDTO = boardService.detail(id);
        model.addAttribute("board", boardDTO);
        System.out.println("model = " + model);
        return "detail";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model){
        BoardDTO boardDTO = boardService.detail(id);
        model.addAttribute("board", boardDTO);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String update(BoardDTO boardDTO, Model model){
        boardService.update(boardDTO);
        BoardDTO boardDto = boardService.detail(boardDTO.getId());
        model.addAttribute("board", boardDto);
        System.out.println("model = " + model);
        return "detail";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        boardService.delete(id);
        return "redirect:/list";
    }

}
