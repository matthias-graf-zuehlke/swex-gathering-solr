# SWEX Gathering 2025 Solr
Slides, example code and more for the SWEX Gathering 2025 Solr talk

# Slide
Sides can be found at [solr_swex_gathering.pptx](./solr_swex_gathering.pptx)

# Example
The spring boot example project can be started using
```
./mvnw spring-boot:run
```
The infrastructure (Solr, Database) can be started using docker compose
```
docker-compose up
```

The example provides a UI that can be accessed at http://localhost:8080. The application implements a database of computer games including manufacturer studio, genre and ratings.
When starting for the first time, the database must be initialized with the data from [games.csv](src/main/resources/games.csv). This can be done using the URL http://localhost:8080/api/initialize.

# Implement Solr in the example
The search function is not yet implemented in the example. To implement Solr, the following steps are necessary. All steps are marked with 'TODO Implement search' in the code.
* Add SolrJ dependency to the project in file [pom.xml](./pom.xml)
* Implement the initialization in [SearchService.java](./src/main/java/com/zuehlke/examples/swex_solr_demo/solr/SearchService.java)
* Implement the search in [IndexService.java](src/main/java/com/zuehlke/examples/swex_solr_demo/solr/IndexService.java)

# Links

* https://solr.apache.org/guide/solr/latest/getting-started/solr-tutorial.html
Official Solr documentation; Tutorials, guides for deployment and configuration, documentation of the query parser and much more

* https://hub.docker.com/_/solr
Official Docker image of Solr

* https://www.baeldung.com/apache-solrj
SolrJ Tutorial on baeldung.com
