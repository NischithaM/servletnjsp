package com.cruds.exception;

public class SException extends RuntimeException {
	private String info;
	
	public SException(String info)
	{
		this.info=info;
	}

	public String getInfo() {
		return info;
	}

}