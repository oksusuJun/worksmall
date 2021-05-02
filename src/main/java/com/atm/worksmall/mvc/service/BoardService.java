package com.atm.worksmall.mvc.service;

import com.atm.worksmall.mvc.domain.Board;
import com.atm.worksmall.mvc.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardMapper mapper;

    /**
     * 목록 리턴
     * @return
     */
    public List<Board> getList() {
        return mapper.getList();
    }

    /**
     * 상세정보 리턴
     * @param boardSeq
     * @return
     */
    public Board get(int boardSeq) {
        return mapper.get(boardSeq);
    }

    /**
     * 게시판 등록
     * @param board
     */
    public void save(Board board) {
        mapper.save(board);
    }

    /**
     * 게시판 삭제
     * @param board
     */
    public void update(Board board) {
        mapper.update(board);
    }

    /**
     * 게시판 삭제
     * @param boardSeq
     */
    public void delete(int boardSeq) {
        mapper.delete(boardSeq);
    }
}
