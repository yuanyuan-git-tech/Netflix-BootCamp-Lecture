## We Do: DTO Validation

**Starter & Solved Folders:** [01-we-dto-validation](./)

In this activity, you will use JSR 303 annotations and the `@Valid` annotation to ensure that incoming JSON objects conform to your applications' business rules.

1. To implement a RESTful API, we need an object to map the data. This is called the **Data Transfer Object (DTO)**.  Return to the Record Store project and open the `Record` class. This is the DTO for this application. The Record Store project should be updated in accordance with the most recent Student Do activity.

   - If not, use the starter code provided.

2. Add the following annotation to the `artist` property at the top of the class:

    ```java
    public class Record {

        @NotEmpty(message = "You must supply a value for artist.")
        private String artist;
        private String album;
        private String year;
        private int id;

        // Constructors, getters, setters, etc. omitted for brevity
    }
    ```

3. Now you will add the `@Valid` annotation to the controller.

4. Open the `RecordStoreController` class and add `@Valid` to the `createRecord` method annotation, as shown in the following code:

    ```java
    @RequestMapping(value = "/records", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Record createRecord(@RequestBody @Valid Record record) {

        record.setId(idCounter++); 
        recordList.add(record);

        return record;
    }
    ```

5. Note the following:

     - We are only adding the `@Valid` annotation to the `Record` parameter for this method.

     - We can stack annotations on parameters. We are applying both the `@RequestBody` and `@Valid` annotations to this parameter.

6. Use Insomnia to test the POST route, and notice that an error is returned if we do not include the `artist` property in the request body.

    - Note that the response is vague and only informs us that the request was a `Bad Request`.

    - Check the application log in the IntelliJ console. The application log specifically states that a field error occurred:

      `[Field error in object 'record' on field 'artist': rejected value [null]; codes [NotEmpty.record.artist,NotEmpty.artist,NotEmpty.java.lang.String,NotEmpty]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [record.artist,artist]; arguments []; default message [artist]]; default message [You must supply a value for artist.]] ]`

    - We note a detailed error response in the application log, but a vague response is returned to the caller. We will address this issue soon.

---

© 2022 2U. All Rights Reserved.
