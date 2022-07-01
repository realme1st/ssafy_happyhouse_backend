package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.dto.Notice;
@Mapper
public interface NoticeMapper {
	public List<Notice> selectNotice();
	public Notice selectNoticeByNo(int articleno);
	public int insertNotice(Notice notice);
	public int updateNotice(Notice notice);
	public int deleteNotice(int articleno);
	
	List<Notice> searchById(String id);
	List<Notice> searchBySubject(String subject);
	
	public int updateHit(Notice notice);
}
