# We Do: Echo Service API Documentation

Starter code: [activities/01-we-echo-service-api-doc/starter](./activities/01-we-echo-service-api-doc/starter)

Solved code: [activities/01-we-echo-service-api-doc/solved](./activities/01-we-echo-service-api-doc/solved)

In this activity, we will use the springdoc-openapi-ui dependency to automatically generate API documentation and a user interface to test the Echo Service API.

Follow along with the instructor throughout the activity.

## Instructions

1. Add the springdoc-openapi-ui dependency to the project `pom.xml` file:

    > **Note:** The springdoc-openapi-ui dependency can be found on the [MvnRepository Springdoc OpenAPI UI page](https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-ui).

    ```xml
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-ui</artifactId>
        <version>1.6.8</version>
    </dependency>
    ```

2. Restart the server to enable springdoc-openapi-ui.

3. Capture the auto-generated API documentation.

    * Hit the local server with the URI `/v3/api-docs`&mdash;for example, `http://localhost:8080/v3/api-docs`.

4. The JSON-formatted documentation of your API should be returned and visible in your browser.

5. Open the [Swagger Editor website](https://editor.swagger.io/).

6. Clear the contents from the editor pane by selecting File, then Clear Editor.

7. Copy the JSON-formatted documentation from your browser into the editor pane of the Swagger Editor.

8. If you are prompted to convert the JSON to YAML, select Yes.

9. After you complete the JSON-to-YAML conversion in the Swagger Editor, the contents of the editor pane should resemble the following example:

    ```yml
    openapi: 3.0.1
    info:
      title: OpenAPI definition
      version: v0
    servers:
      - url: http://localhost:8080
        description: Generated server url
    paths:
      /echo/{input}:
        get:
          tags:
            - echo-range-service-controller
          operationId: echo
          parameters:
            - name: input
              in: path
              required: true
              schema:
                type: integer
                format: int32
          responses:
            '200':
              description: OK
              content:
                '*/*':
                  schema:
                    type: integer
                    format: int32
    components: {}
    ```

    > **Note:** The editor pane on the left displays the OpenAPI 3.0 API document, and the UI pane on the right displays the endpoints that are available to be called. Due to cross-origin constraints, you will not be able to directly hit your local API from that UI pane. Instead, refer to the instructions on how to use the OpenAPI UI to run a test against your local API.

10. Use the OpenAPI 3.0 User Interface to test the API locally. Open the Swagger User Interface at `http://localhost:8080/swagger-ui.html`, and follow these steps to test any of the endpoints:

    * Click the endpoint button you want to test. The UI parameters for that endpoint should open.

    * Select Try It Out on the right side of the screen.

    * If input is required, enter that into the input text field.

    * Select Execute.

    * Results will be displayed in the lower pane.

---

© 2023 2U. All Rights Reserved.
