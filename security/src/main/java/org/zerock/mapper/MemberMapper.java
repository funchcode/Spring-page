package org.zerock.mapper;

import org.zerock.domain.MemberAuthVO;
import org.zerock.domain.MemberVO;

public interface MemberMapper {

	public void insert(MemberVO vo);
	
	public void insertAuth(MemberAuthVO vo);
	
	public MemberVO read(String uid);
	
}
