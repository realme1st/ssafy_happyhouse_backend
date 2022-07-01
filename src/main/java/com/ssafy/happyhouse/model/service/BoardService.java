package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.Board;

public interface BoardService {
	public List<Board> retrieveBoard();
	public Board detailBoard(int articleno);
	public boolean writeBoard(Board board);
	public boolean updateBoard(Board board);
	public boolean deleteBoard(int articleno);
	
	public boolean updateReply(Board board);
	public boolean deleteReply(Board board);
	
	List<Board> searchById(String id);
	List<Board> searchBySubject(String subject);
	
	public boolean updateHit(Board board);
}
