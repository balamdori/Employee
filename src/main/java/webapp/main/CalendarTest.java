package webapp.main;

import java.util.Scanner;
import java.util.StringTokenizer;

import webapp.escape.Screen;

public class CalendarTest {

	public static void printCalendar(int year, int month) {
		Screen.cursorPosition(3, 5);
		System.out.println("year = " + year + ", month = " + month);
	}

	public static void main(String[] args) {
		Screen.clear();
		Scanner sc = new Scanner(System.in);

		while (true) {

			boolean flag = true;
			String param = "";
			do {
				flag = true;
				Screen.cursorPosition(20, 1);
				System.out.print("[yyyy-MM] : ");
				param = sc.nextLine();
				Screen.clear();
				System.out.println("param = " + param);
				
//				flag = param.matches("[1-9][0-9][0-9][0-9]/[0-9][0-2]");
				flag = param.matches("[1-9][0-9]{3}/[0-9]{2}");

				if (param.length() != 7)
					flag = false;
			} while (!flag);
			StringTokenizer tokens = new StringTokenizer(param, "/");
			int year = Integer.parseInt((String)tokens.nextElement());
			int month = Integer.parseInt((String)tokens.nextElement());
			if ( month < 13 && month > 0)
				printCalendar(year, month);
//			printCalendar(2015, 2);
		}

	}

}
