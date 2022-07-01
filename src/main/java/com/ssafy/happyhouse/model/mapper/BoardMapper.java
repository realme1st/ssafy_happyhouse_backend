package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.dto.Board;
@Mapper
public interface BoardMapper {
	public List<Board> selectBoard();
	public Board selectBoardByNo(int articleno);
	public int insertBoard(Board board);
	public int updateBoard(Board board);
	public int deleteBoard(int articleno);
	
	public int updateReply(Board board);
	public int deleteReply(Board board);
	
	List<Board> searchById(String id);
	List<Board> searchBySubject(String subject);
	
	public int updateHit(Board board);
	
}