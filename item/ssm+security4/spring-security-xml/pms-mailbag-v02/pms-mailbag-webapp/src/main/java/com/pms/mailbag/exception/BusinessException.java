package com.pms.mailbag.exception;

public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8255788633730557364L;

	
	public BusinessException()
	{
		
	}
	public BusinessException(String message)
	{
		super(message);
	}
	public BusinessException(Throwable cause)
	{
		super(cause);
	}
	public BusinessException (String message,Throwable cause)
	{
		super(message, cause);
	}
	

}
