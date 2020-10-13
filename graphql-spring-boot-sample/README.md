# graphql-spring-boot-sample
Sample app using [graphql-spring-boot](https://github.com/graphql-java-kickstart/graphql-spring-boot).

## Getting Started
- Clone the repository
- Run the Spring Boot app `./gradlew bootRun`
- Hit the GraphQL endpoint with your favorite tool!
    - The URL is `http://localhost:8080/graphql`
    - A sample GraphQL query to get you started:
    ```
    {
      cows {
        id
        color
        age
      }
    }
    ```