# SWEX Gathering 2025 Solr
Slides, example code and more for the SWEX Gathering 2025 Solr talk

# Slides
Sides can be found at [solr_swex_gathering.pptx](./solr_swex_gathering.pptx)

# Example
This repository contains an example project that demonstrates how to use Solr in a Spring Boot application. The example project is a simple web application providing a list of computer games which can be browsed and searched. In its current state, no Solr interaction is implemented yet and the search never returns any results.

The example provides a UI that can be accessed at http://localhost:8080. 

The spring boot example project can be started using
```
./mvnw spring-boot:run
```
The infrastructure (Database) can be started using docker compose
```
docker-compose up
```

When starting for the first time, the database must be initialized with the data from [games.csv](src/main/resources/games.csv). This can be done using a GET request to http://localhost:8080/api/initialize.

# Implement Solr
To implement Solr, the following steps are necessary. The code for all steps is already implemented in the example project, but commented out and marked with `TODO Implement search`.
1. Start Solr as infrastructure by adding a Solr-Container to  [docker-compose.yml](./docker-compose.yml) and start it using `docker-compose up`. Afterward, Solr can be accessed at http://localhost:8983/solr/
2. Add the SolrJ dependency to the project in [pom.xml](./pom.xml)
3. Implement indexing in [IndexService.java](src/main/java/com/zuehlke/examples/swex_solr_demo/solr/IndexService.java)
4. Index all documents using a GET request to  http://localhost:8080/api/initialize
5. Access the solr UI at http://localhost:8983/solr/ and perform an actual search, e.g. for "summary:Elden" or "team:EA". This must work now
6. Implement searching in [SearchService.java](./src/main/java/com/zuehlke/examples/swex_solr_demo/solr/SearchService.java). Then you can do the same searches in the UI

# Schema Optimizations
The current search implementation is very basic. E.g. you always have to define in which field you want to search. To improve this, we can provide our own schema. This can either be done by provide the schema as file, or by changing the schema on the fly via the UI. The first option is more sustainable as you can easily commit the schema to your version control system. The second option is more suitable for development as you can easily test different schema configurations. An optimized [managed-schema.xml](src/main/solr/managed-schema.xml) file already exists, to integrate into solr you have to
1. Uncomment '- /custom-config' in [docker-compose.yml](./docker-compose.yml) and recreate docker containers using 'docker-compose down' and 'docker-compose up'
2. Re-Index all documents using  http://localhost:8080/api/initialize

# Links

* https://solr.apache.org/guide/solr/latest/getting-started/solr-tutorial.html
Official Solr documentation; Tutorials, guides for deployment and configuration, documentation of the query parser and much more

* https://hub.docker.com/_/solr
Official Docker image of Solr

* https://www.baeldung.com/apache-solrj
SolrJ Tutorial on baeldung.com
