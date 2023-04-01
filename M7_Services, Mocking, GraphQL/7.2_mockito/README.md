# We Do: Mockito

The purpose of this activity is to learn the Mockito mocking library and how the `mock`, `doReturn`, and `when` methods are used in testing scenarios.

- **Starter Code for this project:**   [./starter/record-collection](./starter/record-collection)

- **Solved Code for this project:**   [./solved/record-collection](./solved/record-collection)

Follow along with the instructor throughout the exercise.

**Instructions:**

In this activity, we will create a `ServiceLayerTest` test class in the package `com.company.reccoll.service`.

First, we need a helper method that sets up the class level `AlbumRepository albumRepository;` to be a mock object rather than a live repository in a JUnit test class that tests the Service Layer component in the Record Collection project.

    ```java
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
    ```

1. The first step is to create the mock object using the `mock` method.

2. Next, you will create two `Album` objects to use in configuring the mock object.

     - The first `Album` object represents an album that has been added to the database. Notice that it has an `id` property.

     - The second `Album` object represents an album that we want to save to the database. Notice that you don't set the `id` property but that **all other fields have the same values** as the first `Album` object.

     - Finally, you will create a `List` of `Album` objects and add our first album to the list. This represents what is returned from the repository when `getAllAlbums` is called.

3. After the data objects have been created, we configure the mock object to act in an expected way when certain methods are called:

     - The first `doReturn/when` tells the mock to return `album` (remember that this is the one with the id set) when the `addAlbum` method is called with `album2` as the parameter (remember that this is the one without the id set).

     - The second `doReturn/when` tells the mock to return `album` when the `getAlbum` method is called with `1` as the parameter.

     - The last `doReturn/when` tells the mock to return `aList` when the `getAllAlbums` method is called.

Some things to keep in mind:

- This is a fairly simple setup. You can set the mock up to have different responses for different inputs depending on how you want/need to call the repository's methods.

- If a method on the mock object is called with a parameter that hasn't been configured, like the code below, the mock will return the default value of whatever the return type is. For example, if the return type is an object, the mock will return null. If the return type is an int, it will return 0, and if the return type is a boolean, it will return false.

- This means that you have to carefully set up your scenarios and make sure that you call the methods with the exact values that you configured.

## Student Do: Set Up Label Repository Mock

Now, it's your chance.

Implement a helper method to return a mock object for the `Label` class.

Use the previous example as a guide as you implement the `setUpLabelRepositoryMock()` method.

## Student Do: Set Up Track Repository Mock

You will now implement another helper method, but this time to set up the mock object for the `Track` class.

Implement the `setUpTrackRepositoryMock()` method.

---

© 2023 2U. All Rights Reserved.
