package com.promostree.resources.solr;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@Configuration
@EnableTransactionManagement
@PropertySource("classpath:solr.properties")
@EnableSolrRepositories("com.promostree.repositories.solr")
public class Application {
	@Autowired
	private Environment env;

	@Bean
	public SolrServer solrServer() {
		
		 return new HttpSolrServer(env.getRequiredProperty("solr.url"));
	}

	@Bean
	public SolrTemplate solrTemplate(SolrServer server) throws Exception {
		return new SolrTemplate(server);
	}

	/*
	 * @Bean public ModifiableSolrParams refresh(){ return new
	 * ModifiableSolrParams(); }
	 */
}
