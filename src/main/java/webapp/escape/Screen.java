package webapp.escape;


public class Screen {
	
	public static final int BLACK	= 40;
	public static final int RED	= 41;
	public static final int GREEN	= 42;
	public static final int YELLOW	= 43;
	public static final int BLUE	= 44;
	public static final int MAGENT	= 45;
	public static final int CYAN	= 46;
	public static final int WHITE	= 47;
	
	
	public static void clear(){
		System.out.print("\033[2J");
		System.out.flush();//
	}
	public static void cursorPosition(int line, int col){
		if(line < 1 || col < 1)
			throw new RuntimeException("cursorPosition error " + line+ " "+col);
		
		System.out.print("\033["+line+";"+col+"H");
		System.out.flush();
	}
	public static void backGround(BackGround color){ // int형 타입이 아니라 enum 바꾸게 되면 지정된 상수 외의 숫자가 들어가지 않는다.
		System.out.print("\033["+color.value+"m");
		System.out.flush();
	}
	public static void backGround(int color){
		if(color < 40 || color > 47)
			throw new RuntimeException("backGround color value error : "+color);
		
		System.out.print("\033["+color+"m");
		System.out.flush();
	}
	public static void foreGround(ForeGround color){
		System.out.print("\033["+color.value+"m");
		System.out.flush();
	}
	public static void foreGround(int color){
		color -= 10;
		if(color < 30 || color > 37)
			throw new RuntimeException("foreGround color value error : "+color);
		
		System.out.print("\033["+color+"m");
		System.out.flush();
	}
	public static void reset(){
		System.out.print("\033[0m");
		System.out.flush();
	}
	synchronized public static void print(int line, int col, String c){
		cursorPosition(line, col);
		System.out.print(c);
		System.out.flush();
	}	
}