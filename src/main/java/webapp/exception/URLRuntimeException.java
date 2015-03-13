package webapp.exception;

public class URLRuntimeException extends RuntimeException{
	public URLRuntimeException() {
		super();
	}
	public URLRuntimeException(String mes) {
		super(mes);
	}
	public URLRuntimeException(String mes, Throwable e) {
		super(mes, e);
	}
}
