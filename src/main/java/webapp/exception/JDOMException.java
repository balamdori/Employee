package webapp.exception;

public class JDOMException extends RuntimeException{
	public JDOMException() {
		super();
	}
	public JDOMException(String mes) {
		super(mes);
	}
	public JDOMException(String mes, Throwable e) {
		super(mes, e);
	}
}
