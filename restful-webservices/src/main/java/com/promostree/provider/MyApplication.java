package com.promostree.provider;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.web.filter.RequestContextFilter;

import com.promostree.response.Responsive;
public class MyApplication extends ResourceConfig {

/*	private Set<Object> singletone;
	public MyApplication() {
		singletone = new HashSet<Object>();
		singletone.add(new Responceee());
		singletone.add(new JacksonFeature());
		singletone.add(new MyObjectMapperProvider());
	}

		@Override
public Set<Object> getSingletons() {
	return singletone;
	}

*/
	
//  private Set<Class<?>> classes
 public MyApplication()
 {
 register(RequestContextFilter.class);
 register(Responsive.class);
 register(JacksonFeature.class);
 register(MyObjectMapperProvider.class);
 }


}