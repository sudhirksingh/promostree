package com.promostree.domain.user;

public class Generic<T>{
	T object;
	Generic(T object)
	{
		this.object=object;
	}
	
	public T getObject()
	{
		return object;
	}
	
	public void putObject(T object)
	{
		this.object=object;
	}
	
	
}
