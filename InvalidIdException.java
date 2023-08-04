class InvalidIdException extends RuntimeException{
	String msg;
	
	
	
	public InvalidIdException() {
	}
	
	
	


	public InvalidIdException(String msg) {
		this.msg = msg;
	}


	public String getMessage() {
		return msg;
	}
	

	public String toString() {
		return "InvalidIdException " + msg;
	}
	
	
	
}