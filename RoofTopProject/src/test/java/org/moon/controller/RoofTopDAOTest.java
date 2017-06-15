package org.moon.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.moon.domain.RoofTopVO;
import org.moon.persistence.RoofTopDAO;
import org.moon.service.RoofTopService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
@WebAppConfiguration
public class RoofTopDAOTest {
	
	private static Logger log = Logger.getLogger(RoofTopDAOTest.class);
	
	@Inject
	private RoofTopDAO dao;
	
	@Inject
	private RoofTopService service;
	
	@Test
	public void insertTest()throws Exception{
		
		RoofTopVO vo = new RoofTopVO();
		
		vo.setRtname("비트캠프옥상");
		vo.setRtintroduction("비트캠프 옥상");
		vo.setRtemail("georgia@naver.com");
		vo.setRtphonenumber("010-240-9494");
		vo.setRtaddress("조지아시 조지아구 조지아동 조지아옥상");
		vo.setPrice(1000);
		vo.setMinpeople(2);
		vo.setMaxpeople(10);
		
		dao.create(vo);
		
		log.info("result: " + vo);
		
	}
	
	@Transactional
	@Test
	public void insertTest2()throws Exception{
		
		RoofTopVO vo = new RoofTopVO();
		
		vo.setRtname("비트캠프옥상");
		vo.setRtintroduction("비트캠프 옥상");
		vo.setRtemail("georgia@naver.com");
		vo.setRtphonenumber("010-240-9494");
		vo.setRtaddress("조지아시 조지아구 조지아동 조지아옥상");
		
		vo.setPrice(1000);
		vo.setMinpeople(2);
		vo.setMaxpeople(10);
		
		service.registRoofTop(vo);
		
		log.info("result: " + vo);
		
	}
	
	@Test
	public void uploadTag()throws Exception{
		
		
		String[] hashtags = {"one", "two", "three"};
		for(String hashtagname: hashtags) {
		    dao.addHashtag(hashtagname);
		    log.info("hashtags: "+hashtagname);
		}
		
		log.info("hashtags: "+hashtags);
	}
	
	@Test
	public void allList()throws Exception{
		
		List<RoofTopVO> list = new ArrayList<>();
		list = dao.allList();
		
		log.info("List: " + list);
		
	}
	
	@Test
	public void getCount()throws Exception{
		
		log.info("TotalCount: " + dao.totalCount());
		
	}

	
	

}
