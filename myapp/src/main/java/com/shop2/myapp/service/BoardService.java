package com.shop2.myapp.service;

import java.util.List;

import com.shop2.myapp.dto.BoardDTO;

public interface BoardService {
	public List<BoardDTO> boardList() throws Exception;
	public BoardDTO getBoard(int vno) throws Exception;
}
