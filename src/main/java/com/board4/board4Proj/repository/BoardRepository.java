package com.board4.board4Proj.repository;

import com.board4.board4Proj.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final SqlSessionTemplate sql;

    public void save(BoardDTO boardDTO) {
        sql.insert("Board.save", boardDTO);
    }

    public List<BoardDTO> list() {
        return sql.selectList("Board.list");
    }

    public BoardDTO detail(Long id) {
        return sql.selectOne("Board.detail", id);
    }

    public void update(BoardDTO boardDTO) {
        sql.update("Board.update", boardDTO);
    }

    public void delete(Long id) {
        sql.delete("Board.delete", id);
    }
}
