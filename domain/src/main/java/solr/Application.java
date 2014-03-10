package solr;



import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableSolrRepositories
public class Application {

	@Bean
	public SolrServer solrServer() {
		return new HttpSolrServer("http://192.168.10.13:8983/solr/collection1/");
	}

	@Bean
	public SolrTemplate solrTemplate(SolrServer server) throws Exception {
		return new SolrTemplate(server);
	}
	@Bean
	public DaoImpl daoImpl(){
		return new DaoImpl();
	}
	/*
	@Bean
	public ModifiableSolrParams refresh(){
		return new ModifiableSolrParams();
	}*/
}
