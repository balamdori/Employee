package webapp.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import webapp.escape.BackGround;
import webapp.escape.Screen;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DateTest {
	static Log log = LogFactory.getLog(DateTest.class);
	
	/*@SuppressWarnings("deprecation")
	@Test
	public void test1() {
		Date current = new Date();
		log.info(current.toLocaleString());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void test2() {
		Calendar current = Calendar.getInstance();
		log.info(current.getTime().toLocaleString());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void test3() {
		Date current = new Date();
		
		current.setDate(current.getDate()+100);
		
		log.info("year = " + (current.getYear() + 1900));
		log.info("month = " + (current.getMonth() + 1));
		log.info("date = " + current.getDate());
		log.info("week = " + current.getDay()); //일요일 = 0, 월요일 = 1, 화요일 = 2, 수요일 = 3, 목요일 = 4, 금요일 = 5, 토요일 = 6
	}*/
	
	/*@SuppressWarnings("deprecation")
	@Test
	public void test4() {
		Date current = new Date(2015-1900, 3-1, 1);
		
		log.info(current.toLocaleString());
		log.info("start week = " + current.getDay());
		
		int month = current.getMonth();
		
		while(true) {
			current.setDate(current.getDate()+ 1);
			
			if(month != current.getMonth())
				break;
		}
		current.setDate(current.getDate()-1);
		log.info(current.toLocaleString());
		log.info("end week = " + current.getDay());
		log.info("end date = " + current.getDate());
		
		
		current.setDate(current.getDate()+ 100);
		log.info(current.toLocaleString());
		log.info("week = " + current.getDay());
	}*/
	@SuppressWarnings("deprecation")
	@Test
	public void test5() {
		System.out.println("월을 입력하세요");
		int Month;
		Scanner sc =new Scanner(System.in);
		Month = sc.nextInt();
		
		Date date = new Date(2015-1900, Month-1, 1);
		log.info(date.getMonth()+1+"월");
		
		int month = date.getMonth();
		while(true){
//			log.info(date.getDate());]
			System.out.print(date.getDate()+ " ");
			
			if(date.getDay() == 6){
				System.out.println();
			}
			date.setDate(date.getDate()+ 1);
			if(month != date.getMonth())
			break;
		}
		date.setDate(date.getDate()-1);
	}
//	@Test
	public void test6() {
		Screen.clear();

		Scanner scan = new Scanner(System.in);
		
		while(true){
			Screen.cursorPosition(5, 1);
			System.out.print("[yyyy/MM] : ");
			String param = scan.nextLine();
			
			if(param.equals("."))
				break;
			System.out.println("param = " + param);
		
		}		
//		Screen.reset();
	}
}
