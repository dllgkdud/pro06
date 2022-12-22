package com.shop2.myapp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop2.myapp.dto.BoardDTO;
import com.shop2.myapp.service.BoardService;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Resource
	private BoardService BoardService;
	
	@GetMapping("list")
	public String BoardList(Model model) throws Exception {
		List<BoardDTO> list = BoardService.boardList();
		model.addAttribute("list", list);
		return "board/list";
	}
	
	@GetMapping("detail")
	public String BoardDetail(@RequestParam("vno") int vno, Model model) throws Exception {
		BoardDTO board = BoardService.getBoard(vno);
		model.addAttribute("board", board);
		return "board/detail";
	}
}