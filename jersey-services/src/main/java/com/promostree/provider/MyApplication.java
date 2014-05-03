package com.promostree.provider;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.web.filter.RequestContextFilter;

import com.promostree.resource.UserResources;
import com.promostree.resource.VenueResources;

public class MyApplication extends ResourceConfig {

	/*
	 * private Set<Object> singletone; public MyApplication() { singletone = new
	 * HashSet<Object>(); singletone.add(new Responceee()); singletone.add(new
	 * JacksonFeature()); singletone.add(new MyObjectMapperProvider()); }
	 * 
	 * @Override public Set<Object> getSingletons() { return singletone; }
	 */

	// private Set<Class<?>> classes
	public MyApplication() {
		register(RequestContextFilter.class)
		.packages("com.promostree.resource", "com.fasterxml.jackson.jaxrs.base")
		.register(MyObjectMapperProvider.class);
	}

}