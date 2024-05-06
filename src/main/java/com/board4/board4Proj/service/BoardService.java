package com.board4.board4Proj.service;

import com.board4.board4Proj.dto.BoardDTO;
import com.board4.board4Proj.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void save(BoardDTO boardDTO) {
        boardRepository.save(boardDTO);
    }

    public List<BoardDTO> list() {
        return boardRepository.list();
    }

    public BoardDTO detail(Long id) {
        return boardRepository.detail(id);
    }

    public void update(BoardDTO boardDTO) {
        boardRepository.update(boardDTO);
    }

    public void delete(Long id) {
        boardRepository.delete(id);
    }
}
