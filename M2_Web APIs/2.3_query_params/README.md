## We Do: Query Parameters in Spring Boot

Starter code: [activities/03-we-query-params/starter](./activities/03-we-query-params/starter)

Solved code: [activities/03-we-query-params/solved](./activities/03-we-query-params/solved)

In this activity, you will add query parameters to the Record Store API.

Following along with the instructor throughout the exercise.

### Instructions

1. Open the Record Store API starter project in IntelliJ.

2. Open the controller class.

3. You can add query parameters to an endpoint much like you do path variables&mdash;using an annotation.

   - Add the `@RequestParam` annotation and define a method parameter for `artist` in the `getAllRecords` method. Note that we do not have to modify the path, as shown in the following example:

      ```java
      @RequestMapping(value = "/records", method = RequestMethod.GET)
      @ResponseStatus(value = HttpStatus.OK)
      public List<Record> getAllRecords(@RequestParam String artist) {

          return recordList;
      }
      ```

4. Using Insomnia or a browser, hit the GET `/records` endpoint.

      - You will receive an error shown in the application log indicating that the `Required String parameter 'artist' is not present.`

5. We can signify that a request parameter is optional by adding a value for `required` in the annotation, as follows:

      ```java
      @RequestMapping(value = "/records", method = RequestMethod.GET)
      @ResponseStatus(value = HttpStatus.OK)
      public List<Record> getAllRecords(@RequestParam(required = false) String artist) {

          return recordList;
      }
      ```

6. Implement the following code to make the `getAllRecords` method function as intended:

    ```java
    @RequestMapping(value = "/records", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Record> getAllRecords(@RequestParam(required = false) String artist) {
        List<Record> returnList = new ArrayList<>();

        if (artist != null) {
            for (Record record : recordList) {
                if(record.getArtist().contains(artist)) {
                    returnList.add(record);
                }
            }
        } else {
            returnList = recordList;
        }

        return returnList;
    }
    ```

7. Using Insomnia or your browser, hit the `/records` endpoint, first without any parameters and then with `?artist=Joel` appended to show how it changes the response.

    - We can also include multiple parameters if we want to, as follows:

        ```java
        @RequestMapping(value = "/records", method = RequestMethod.GET)
        @ResponseStatus(value = HttpStatus.OK)
        public List<Record> getAllRecords(@RequestParam(required = false) String artist, @RequestParam(required = false) String year) {
            List<Record> returnList = new ArrayList<>();

            if (artist != null) {
                for (Record record : recordList) {
                    if(record.getArtist().contains(artist)) {
                        returnList.add(record);
                    }
                }
            } else {
                returnList = recordList;
            }

            // Filtering by year left as an exercise for the learner

            return returnList;
        }
        ```

---

© 2023 2U. All Rights Reserved.
