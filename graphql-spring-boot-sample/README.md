# graphql-spring-boot-sample
Sample app using [graphql-spring-boot](https://github.com/graphql-java-kickstart/graphql-spring-boot).

## Getting Started
- Download and run the app
```
git clone git@github.com:bignerdranch/BNR-graphql-java-samples.git &&
cd BNR-graphql-java-samples &&
./gradlew bootRun
```
- Hit the GraphQL endpoint with your favorite tool!
    - The URL is `http://localhost:8080/graphql`
    - A sample GraphQL query to get you started:
    ```
    {
      cows {
        id
        color
      }
    }
    ```
    - A sample GET request using the above GraphQL query (properly escaped): `http://localhost:8080/graphql?query=%7Bcows%7Bid%20color%7D%7D`
    - A sample POST request body using the above GraphQL query:
    ```
    {
        "query": "query { cows { id color } }"
    }
    ```
## Check out the Initial Sample Data
See the [BNRRepository class](src/main/java/com/bnr/graphql/repository/BNRRepository.java).
  
## Run the Automated Tests
From the root directory of the git repo, run `./gradlew test`.