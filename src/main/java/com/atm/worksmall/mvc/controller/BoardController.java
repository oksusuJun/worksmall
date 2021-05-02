package com.atm.worksmall.mvc.controller;

import com.atm.worksmall.mvc.domain.Board;
import com.atm.worksmall.mvc.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    /**
     * 목록 리턴
     * @return
     */
    @GetMapping
    public List<Board> getList() {
        return boardService.getList();
    }

    /**
     * 상세정보 리턴
     * @param boardSeq
     * @return
     */
    @GetMapping("/{boardSeq}")
    public Board get(@PathVariable int boardSeq) {
        return boardService.get(boardSeq);
    }

    /**
     * 게시판 등록 -> 등록/수정 처리 같이 해도 됨
     * @param board
     */
    @GetMapping("/save")
    public void save(Board board) {
        boardService.save(board);
    }

    /**
     * 게시판 삭제
     * @param board
     */
    @GetMapping("/update/{boardSeq}")
    public void update(@PathVariable Board board) {
        boardService.update(board);
    }

    /**
     * 게시판 삭제
     * @param boardSeq
     */
    @GetMapping("/delete/{boardSeq}")
    public void delete(@PathVariable int boardSeq) {
        boardService.delete(boardSeq);
    }

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("/home");

        //modelAndView.setViewName("home");

        Map<String, Object> map = new HashMap<>();
        map.put("name", "Bamdule");
        map.put("date", LocalDateTime.now());

        modelAndView.addObject("data", map);

        return modelAndView;
    }
}
