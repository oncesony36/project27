package org.moon.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
@WebAppConfiguration
public class ConTest {
	
	private static Logger log = Logger.getLogger(ConTest.class);
	
	@Inject
	private DataSource ds;
	
	@Test
	public void conTest() throws Exception{
		
		/*Class.forName("oracle.jdbc.driver.OracleDriver");
		String user = "team";
		String password = "1234";
		String url = "jdbc:oracle:thin:@192.168.0.187:1521:XE";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		log.info("Oracle :"+con);*/
		
		log.info(ds.getConnection());
		
		
	}

}
