package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.Notice;
import com.ssafy.happyhouse.model.mapper.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeMapper noticeMapper;
	
	@Override
	public List<Notice> retrieveNotice() {
		return noticeMapper.selectNotice();
	}

	@Override
	public Notice detailNotice(int articleno) {
		return noticeMapper.selectNoticeByNo(articleno);
	}

	@Override
	public boolean writeNotice(Notice notice) {
		return noticeMapper.insertNotice(notice) == 1;
	}

	@Override
	public boolean updateNotice(Notice notice) {
		return noticeMapper.updateNotice(notice) == 1;
	}

	@Override
	public boolean deleteNotice(int articleno) {
		return noticeMapper.deleteNotice(articleno) == 1;
	}

	@Override
	public List<Notice> searchById(String id) {
		return noticeMapper.searchById(id);
	}

	@Override
	public List<Notice> searchBySubject(String subject) {
		return noticeMapper.searchBySubject(subject);
	}

	@Override
	public boolean updateHit(Notice notice) {
		return noticeMapper.updateHit(notice) == 1;
	}

}
