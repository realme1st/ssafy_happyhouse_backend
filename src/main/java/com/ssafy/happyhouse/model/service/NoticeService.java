package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.Notice;

public interface NoticeService {
	public List<Notice> retrieveNotice();
	public Notice detailNotice(int articleno);
	public boolean writeNotice(Notice notice);
	public boolean updateNotice(Notice notice);
	public boolean deleteNotice(int articleno);
	
	List<Notice> searchById(String id);
	List<Notice> searchBySubject(String subject);
	
	public boolean updateHit(Notice notice);

}
