# We Do: MockMvc Record Store Project Creation

**Solved Folders:** [03-we-record-store](./solved/)

Throughout this activity and the rest of the module, you will create and build a Record Store API. You will need to keep updating this project throughout the upcoming activities to stay current with the project.

Follow along with the instructor throughout the exercise.

## Instructions

1. Open the [Spring Initializr](https://start.spring.io/).

2. Select the following options:

    - Project: `Maven`

    - Language: `Java`

    - Spring Boot: `2.7.7 (SNAPSHOT)`

    - Project Metadata:

      - Group: `com.company`

      - Artifact: `record-store-api`

         > **Note:** Setting the Artifact value will automatically update the values for Name and Package Name.

      - Packaging: `Jar`

      - Java: `8`

3. For Dependencies add:

    - `Spring Web`

    - `Validation`

4. Click the `Generate` button to generate the project.

5. Unzip the project file that is generated and open it in IntelliJ.

6. Open the `pom.xml` file and add the following dependency in the `<dependencies> </dependencies>` section of the `pom.xml` file:

    ```xml
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13</version>
        <scope>test</scope>
    </dependency>
    ```

7. Add the springdoc-openapi-ui dependency in the `<dependencies> </dependencies>` section of the `pom.xml` file:

    ```xml
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-ui</artifactId>
        <version>1.6.8</version>
    </dependency>
    ```

8. Create a new class named `Record` in a package named `models`.

    - This class will serve as the Java object representing a single record in the record store.

      > **Note:** Make sure learners are successfully completing these steps along with you.

9. Add the following code to the new `Record` class:

    ```java
    // Imports excluded for brevity

    public class Record {

        private String artist;
        private String album;
        private String year;
        private int id;

        public Record() { }

        public Record(String artist, String album, String year, int id) {
            this.artist = artist;
            this.album = album;
            this.year = year;
            this.id = id;
        }

        public String getArtist() {
            return artist;
        }

        public void setArtist(String artist) {
            this.artist = artist;
        }

        public String getAlbum() {
            return album;
        }

        public void setAlbum(String album) {
            this.album = album;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Record record = (Record) o;
            return getId() == record.getId() &&
                    Objects.equals(getArtist(), record.getArtist()) &&
                    Objects.equals(getAlbum(), record.getAlbum()) &&
                    Objects.equals(getYear(), record.getYear());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getArtist(), getAlbum(), getYear(), getId());
        }
    }
    ```

10. Create a `RecordStoreController` class in a package named `controller`.

11. Create a `RecordStoreControllerTest` class as follows:

    - Point the cursor at the `RecordStoreController` class name.

    - Open the Navigate dropdown menu at the top of the IntelliJ window.

    - Select Test in that menu.

    - Select Create New Test.

    > **Note:** Make sure JUnit 4 is selected in the Testing Library dropdown menu.

12. Add the following code to the new test class, including the `@RunWith` and `@WebMvcTest` annotations at the top of the class:

    ```java
    // Imports excluded for brevity

    @RunWith(SpringRunner.class)
    @WebMvcTest(RecordStoreController.class)
    public class RecordStoreControllerTest {

        // Wiring in the MockMvc object
        @Autowired
        private MockMvc mockMvc;

        // ObjectMapper used to convert Java objects to JSON and vice versa
        private ObjectMapper mapper = new ObjectMapper();

        // A list of records for testing purposes
        private List<Record>  recordList;

        @Before
        public void setUp() {
            // Standard set up method for instantiating test objects
            // Don't have to do anything special for mockMvc since it's Autowired
        }
    }
    ```

---

© 2022 2U. All Rights Reserved.
