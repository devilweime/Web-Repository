package com.pms.mailbag.exception;

public class ParamterException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9113839573759205869L;

	public ParamterException()
	{
		
	}
	public ParamterException(String message)
	{
		super(message);
	}
	public ParamterException(Throwable cause)
	{
		super(cause);
	}
	public ParamterException (String message,Throwable cause)
	{
		super(message, cause);
	}

	
	
}
