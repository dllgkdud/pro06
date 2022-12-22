package com.shop2.myapp.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shop2.myapp.dto.BoardDTO;

@Mapper
public interface BoardMapper {
	public List<BoardDTO> boardList() throws Exception;
	public BoardDTO getBoard(int vno) throws Exception;
}
