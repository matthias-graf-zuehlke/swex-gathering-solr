package com.zuehlke.examples.swex_solr_demo.solr;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "com.zuehlke.examples.swex-solr-demo.solr")
@Data
public class SolrProperties {
    private String url;
}
