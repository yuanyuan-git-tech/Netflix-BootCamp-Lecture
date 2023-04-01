# We Do: Testing With Mock Objects - Continued

- **Starter Code for this project:**   [./starter/](./starter/)

- **Solved Code for this project:**   [./solved/](./solved/)

With this activity, we pick up where left off in the last class and continue to learn about testing with mock objects.

Follow along with the instructor throughout the exercise.

**Instructions:**

## We Do: Set Up Artist Repository Mock

Let's finish the helper methods by setting up the mock for the `Artist` repository. Implement the following code:

    ```java
    private void setUpArtistRepositoryMock() {
        artistRepository = mock(ArtistRepository.class);
        Artist artist = new Artist();
        artist.setId(45);
        artist.setInstagram("@RockStar");
        artist.setName("The GOAT");
        artist.setTwitter("@TheRockStar");

        Artist artist2 = new Artist();
        artist2.setInstagram("@RockStar");
        artist2.setName("The GOAT");
        artist2.setTwitter("@TheRockStar");

        List aList = new ArrayList();
        aList.add(artist);

        doReturn(artist).when(artistRepository).save(artist2);
        doReturn(Optional.of(artist)).when(artistRepository).findById(45);
        doReturn(aList).when(artistRepository).findAll();
    }
    ```
    
## We Do: Using Mock Objects

The purpose of this section is to learn how to set up mock objects and use them in a unit test. We'll go through the entire `ServiceLayerTest` class from the starter code and point out how we've implemented some of the tests. You will then be responsible for completing the test suite.

    ```java
    public class ServiceLayerTest {

        ServiceLayer service;
        AlbumRepository albumRepository;
        ArtistRepository artistRepository;
        LabelRepository labelRepository;
        TrackRepository trackRepository;

        @Before
        public void setUp() throws Exception {
            setUpAlbumRepositoryMock();
            setUpArtistRepositoryMock();
            setUpLabelRepositoryMock();
            setUpTrackRepositoryMock();

            service = new ServiceLayer(albumRepository, artistRepository, labelRepository, trackRepository);

        }

        // Helper methods
        private void setUpAlbumRepositoryMock() {
            albumRepository = mock(AlbumRepository.class);
            Album album = new Album();
            album.setId(1);
            album.setArtistId(45);
            album.setLabelId(10);
            album.setTitle("Greatest Hits");
            album.setListPrice(new BigDecimal("14.99"));
            album.setReleaseDate(LocalDate.of(1999, 05, 15));

            Album album2 = new Album();
            album2.setArtistId(45);
            album2.setLabelId(10);
            album2.setTitle("Greatest Hits");
            album2.setListPrice(new BigDecimal("14.99"));
            album2.setReleaseDate(LocalDate.of(1999, 05, 15));

            List<Album> aList = new ArrayList<>();
            aList.add(album);

            doReturn(album).when(albumRepository).save(album2);
            doReturn(Optional.of(album)).when(albumRepository).findById(1);
            doReturn(aList).when(albumRepository).findAll();
        }

        private void setUpArtistRepositoryMock() {
            artistRepository = mock(ArtistRepository.class);
            Artist artist = new Artist();
            artist.setId(45);
            artist.setInstagram("@RockStar");
            artist.setName("The GOAT");
            artist.setTwitter("@TheRockStar");

            Artist artist2 = new Artist();
            artist2.setInstagram("@RockStar");
            artist2.setName("The GOAT");
            artist2.setTwitter("@TheRockStar");

            List aList = new ArrayList();
            aList.add(artist);

            doReturn(artist).when(artistRepository).save(artist2);
            doReturn(Optional.of(artist)).when(artistRepository).findById(45);
            doReturn(aList).when(artistRepository).findAll();
        }

        private void setUpLabelRepositoryMock() {
            labelRepository = mock(LabelRepository.class);
            Label label = new Label();
            label.setId(10);
            label.setName("Blue Note");
            label.setWebsite("www.bluenote.com");

            Label label2 = new Label();
            label2.setName("Blue Note");
            label2.setWebsite("www.bluenote.com");

            List lList = new ArrayList<>();
            lList.add(label);

            doReturn(label).when(labelRepository).save(label2);
            doReturn(Optional.of(label)).when(labelRepository).findById(10);
            doReturn(lList).when(labelRepository).findAll();
        }

        private void setUpTrackRepositoryMock() {
            trackRepository = mock(TrackRepository.class);
            Track track = new Track();
            track.setId(1);
            track.setAlbumId(1);
            track.setRunTime(180);
            track.setTitle("Number 1 Hit!");

            Track track2 = new Track();
            track.setAlbumId(1);
            track.setRunTime(180);
            track.setTitle("Number 1 Hit!");

            List tList = new ArrayList<>();
            tList.add(track);

            doReturn(track).when(trackRepository).save(track2);
            doReturn(Optional.of(track)).when(trackRepository).findById(1);
            doReturn(tList).when(trackRepository).findAll();
            doReturn(tList).when(trackRepository).findAllTracksByAlbumId(1);
        }

        @Test
        public void shouldSaveLabel() {
            // Arrange
            Label expectedResult = new Label();
            expectedResult.setId(10);
            expectedResult.setName("Blue Note");
            expectedResult.setWebsite("www.bluenote.com");

            Label label = new Label();
            label.setName("Blue Note");
            label.setWebsite("www.bluenote.com");

            // ACT
            label = service.saveLabel(label);

            assertEquals(expectedResult, label);
        }

        @Test
        public void shouldFindAlbum() {
            AlbumViewModel toCompare = new AlbumViewModel();
            toCompare.setId(1);
            toCompare.setTitle("Greatest Hits");
            toCompare.setListPrice(new BigDecimal("14.99"));
            toCompare.setReleaseDate(LocalDate.of(1999, 05, 15));

            Artist artistToCompare = new Artist();
            artistToCompare.setId(45);
            artistToCompare.setInstagram("@RockStar");
            artistToCompare.setName("The GOAT");
            artistToCompare.setTwitter("@TheRockStar");

            Label labelToCompare = new Label();
            labelToCompare.setId(10);
            labelToCompare.setName("Blue Note");
            labelToCompare.setWebsite("www.bluenote.com");

            toCompare.setArtist(artistToCompare);
            toCompare.setLabel(labelToCompare);

            Track track = new Track();
            track.setId(1);
            track.setAlbumId(1);
            track.setRunTime(180);
            track.setTitle("Number 1 Hit!");

            List trackList = new ArrayList<>();
            trackList.add(track);
            toCompare.setTracks(trackList);

            AlbumViewModel albumViewModel = service.findAlbum(1);
            assertEquals(albumViewModel, toCompare);
        }
    }
    ```

## Student Do: Using Mock Objects

In this activity, you will implement the `shouldSaveArtist()` test. 

Remember that since you're using Mockito, you're mimicking behavior without having to rely on your external dependencies. As such, you don't need to add any new `Artist` objects, as your helper methods have already been set up to mock the behavior of your database.

---

© 2023 2U. All Rights Reserved.