# We Do: MockMvc Testing Strategy

**Starter & Solved Folders:** [04-we-mockmvc-test](./)

In this activity, you will develop a strategy, or set of guidelines, for using MockMvc to test controllers.

Follow along with the instructor throughout the exercise.

## Instructions

Paste the following code into the `RecordStoreControllerTest` class after the `public void setup()` method:

  ```java
  // Testing GET /records
  @Test
  public void shouldReturnAllRecordsInCollection() throws Exception {

      // ARRANGE
      // Convert Java object to JSON
      String outputJson = mapper.writeValueAsString(recordList);

      // ACT
      mockMvc.perform(get("/records"))                // Perform the GET request
            .andDo(print())                          // Print results to console
            .andExpect(status().isOk());              // ASSERT (status code is 200)
  }

  // Testing POST /records
  @Test
  public void shouldReturnNewRecordOnPostRequest() throws Exception {

      // ARRANGE
      Record inputRecord = new Record();
      inputRecord.setArtist("Bruce Springsteen");
      inputRecord.setAlbum("The River");
      inputRecord.setYear("1990");

      // Convert Java Object to JSON
      String inputJson = mapper.writeValueAsString(inputRecord);

      Record outputRecord = new Record();
      outputRecord.setArtist("Bruce Springsteen");
      outputRecord.setAlbum("The River");
      outputRecord.setYear("1990");
      outputRecord.setId(6);

      String outputJson = mapper.writeValueAsString(outputRecord);

      // ACT
      mockMvc.perform(
                post("/records")                            // Perform the POST request
                  .content(inputJson)                       // Set the request body
                  .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
              ) 
            .andDo(print())                                // Print results to console
            .andExpect(status().isCreated());              // ASSERT (status code is 201)
  }
  ```

> **Note:** Issues might arise if learners bring in the wrong MockMvc imports. If anyone encounters issues pulling in the proper imports to support the `RecordStoreControllerTest` class after adding the provided code, refer to the following required imports:

  ```java
  import com.company.recordstoreapi.models.Record;
  import com.fasterxml.jackson.databind.ObjectMapper;
  import org.junit.Before;
  import org.junit.Test;
  import org.junit.runner.RunWith;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
  import org.springframework.http.MediaType;
  import org.springframework.test.context.junit4.SpringRunner;
  import org.springframework.test.web.servlet.MockMvc; 
  import java.util.List;
  import static org.junit.Assert.*;
  import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
  import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
  import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
  import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
  ```

---

© 2022 2U. All Rights Reserved.
