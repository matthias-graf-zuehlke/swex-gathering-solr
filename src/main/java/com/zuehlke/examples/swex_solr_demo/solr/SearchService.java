package com.zuehlke.examples.swex_solr_demo.solr;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;
/* TODO Implement search
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpJdkSolrClient;
import java.util.stream.Collectors;
 */


@Service
@Slf4j
public class SearchService {
    /* TODO Implement search
    private final SolrClient solr;

    SearchService(SolrProperties solrProperties) {
        this.solr = new HttpJdkSolrClient.Builder(solrProperties.getUrl()).build();
    }
    */

    public Collection<Integer> search(String input) {
        return List.of();
        /* TODO Implement search
        try {
            final var solrQuery = new SolrQuery();
            solrQuery.set("q", input);
            solrQuery.set("fl", "id");
            solrQuery.setRows(1000);
            final var response = solr.query(solrQuery);
            return response.getResults().stream()
                    .map(s -> (String) s.getFieldValue("id"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            SolrCommunicationException.cannotSearch(input, e);
            return List.of();
        }
     */
    }
}
