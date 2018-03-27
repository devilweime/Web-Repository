package com.pms.mailbag.exception;

public class SystemException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4854794957244124259L;

	public SystemException()
	{
		
	}
	public SystemException(String message)
	{
		super(message);
	}
	public SystemException(Throwable cause)
	{
		super(cause);
	}
	public SystemException (String message,Throwable cause)
	{
		super(message, cause);
	}
	
	
}
