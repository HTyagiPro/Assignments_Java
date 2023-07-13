class InvalidAgeException  extends RuntimeException {
	String msg;

	public InvalidAgeException() {
		
	}

	public InvalidAgeException(String msg) {
		this.msg = msg;
	}
	
	public String getMessage() {
		return msg;
	}
	
	public String toString() {
		return "InvalidAgeException" + msg;
	}
	
}
