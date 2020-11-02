package com.cruds.exception;

public class DMSException extends RuntimeException {
	private String info;
		
		public DMSException(String info)
		{
			this.info=info;
		}

		public String getInfo() {
			return info;
		}

}
