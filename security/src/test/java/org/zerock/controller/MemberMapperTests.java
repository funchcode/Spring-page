package org.zerock.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.MemberAuthVO;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml","file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class MemberMapperTests {
	
	@Setter(onMethod_={@Autowired})
	private PasswordEncoder encoder;
	
	@Setter(onMethod_={@Autowired})
	private MemberMapper mapper;
	
	@Test
	public void insert() {
		
		for(int i = 0 ; i < 100 ; i ++) {
			MemberVO vo = new MemberVO();
			vo.setUid("uid"+i);
			vo.setUpw(encoder.encode("upw"+i));
			vo.setUname("uname"+i);
			
			mapper.insert(vo);
			
			if(i>=0) {
				MemberAuthVO uvo = new MemberAuthVO();
				uvo.setUid("uid"+i);
				mapper.insertAuth(uvo);
			}
			if(i>=50) {
				MemberAuthVO uvo = new MemberAuthVO();
				uvo.setUid("uid"+i);
				uvo.setAuth("ROLE_MANAGER");
				mapper.insertAuth(uvo);
			}
			if(i>=90) {
				MemberAuthVO uvo = new MemberAuthVO();
				uvo.setUid("uid"+i);
				uvo.setAuth("ROLE_ADMIN");
				mapper.insertAuth(uvo);
			}
		}
		
	}
	
}
