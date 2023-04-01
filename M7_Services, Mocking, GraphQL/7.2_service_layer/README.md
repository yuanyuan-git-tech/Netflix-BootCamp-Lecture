# We Do: Service Layer Implementation

In this section, you will demonstrate how to implement a service layer component. Service layer components are just plain Java classes but you will learn how they work with controllers, repositories, viewmodels, and DTOs.

Use the following files: 

- **Starter Code for this project:**   [./starter/record-collection](./starter/record-collection)

- **Schema for Record Collection Project:**  [./record-collection-schema.sql](./record-collection-schema.sql)

- **Solved Code for this project:**   [./solved/record-collection](./solved/record-collection)

Follow along with the instructor throughout the exercise.

**Instructions:**

You will use the Record Collection project to demonstrate the service layer and viewmodel implementation. You will build off the solution to the in-class activity from the JPA lesson.

## Student Do: AlbumViewModel

In the package com.company.reccoll.viewmodel, create an AlbumViewModel class:

- The AlbumViewModel contains the information of the Album DTO but it also has the following:

  - An Artist object (rather than just the id)
  - A Label object (rather than just the id)
  - A list of associated Tracks (the Album DTO does not contain any reference to Tracks)

- This model is more convenient for the end user.

## We Do: Injecting the Repositories

The service layer needs references to all four repositories.

- This is standard: You have class-level properties, a constructor that sets the repository references, and you use the `@Autowired` annotation so that Spring will inject these references into our service layer object. Note that you must include the `@Component` annotation on the ServiceLayer class so that Spring knows about our class.

- In the package com.company.reccoll.service, create the ServiceLayer class:

    ```java
    @Component
    public class ServiceLayer {

        private AlbumRepository albumRepository;
        private ArtistRepository artistRepository;
        private LabelRepository labelRepository;
        private TrackRepository trackRepository;

        @Autowired
        public ServiceLayer(AlbumRepository albumRepository, ArtistRepository artistRepository,
                            LabelRepository labelRepository, TrackRepository trackRepository) {
            this.albumRepository = albumRepository;
            this.artistRepository = artistRepository;
            this.labelRepository = labelRepository;
            this.trackRepository = trackRepository;
        }
    }
    ```

## We Do: Saving an Album

The following method is responsible for converting the incoming viewmodel into DTOs.

- Your business rules (expressed as FK relationships in the DB) allow you to create a new album and new tracks, but you have to use an existing `Artist` and `Label`, which is why you won't do anything with the `Artist` and `Label` objects.

- This method creates a new `Album`, persists it with the `albumRepository`, sets the new id on the `viewModel`, and then creates the new `Tracks`.

- Note that you use the `@Transactional` annotation to ensure that everything either gets saved or rolled back:

    ```java
        @Transactional
        public AlbumViewModel saveAlbum(AlbumViewModel viewModel) {

            // Persist Album
            Album a = new Album();
            a.setTitle(viewModel.getTitle());
            a.setReleaseDate(viewModel.getReleaseDate());
            a.setListPrice(viewModel.getListPrice());
            a.setLabelId(viewModel.getLabel().getId());
            a.setArtistId(viewModel.getArtist().getId());
            a = albumRepository.save(a);
            viewModel.setId(a.getId());

            // Add Album Id to Tracks and Persist Tracks
            List<Track> tracks = viewModel.getTracks();

            tracks.stream()
                    .forEach(t ->
                    {
                        t.setAlbumId(viewModel.getId());
                        trackRepository.save(t);
                    });

            tracks = trackRepository.findAllTracksByAlbumId(viewModel.getId());
            viewModel.setTracks(tracks);

            return viewModel;
        }
    ```

## We Do: Finding an Album

Next, you'll implement a `findAlbum` method.

- This method calls the `albumRepository` to get the requested `Album` object by id.

- It then calls the `buildAlbumViewModel` helper method to create the viewmodel.

- Finally, it returns the viewmodel:

    ```java
        public AlbumViewModel findAlbum(int id) {

            // Get the album object first
            Optional<Album> album = albumRepository.findById(id);

            return album.isPresent() ? buildAlbumViewModel(album.get()) : null;
        }
    ```

## We Do: ViewModel Builder Method

Next, a method that creates an `AlbumViewModel` object from the given `Album` object.

- It gets the associated `Artist` and `Label` objects using the appropriate repository for each.

- It gets the associated `Track` list using the `trackRepository`.

- It constructs the viewmodel object and returns it:

    ```java
        private AlbumViewModel buildAlbumViewModel(Album album) {

            // Get the associated artist
            Optional<Artist> artist = artistRepository.findById(album.getArtistId());

            // Get the associated label
            Optional<Label> label = labelRepository.findById(album.getLabelId());

            // Get the tracks associated with the album
            List<Track> trackList = trackRepository.findAllTracksByAlbumId(album.getId());

            // Assemble the AlbumViewModel
            AlbumViewModel avm = new AlbumViewModel();
            avm.setId(album.getId());
            avm.setTitle(album.getTitle());
            avm.setReleaseDate(album.getReleaseDate());
            avm.setListPrice(album.getListPrice());
            avm.setArtist(artist.get());
            avm.setLabel(label.get());
            avm.setTracks(trackList);

            // Return the AlbumViewModel
            return avm;
        }
    ```

## Student Do: Finding All Albums

- Working in the `ServiceLayer` class, implement a `findAllAlbums` method.

- This method is similar to `findAlbum`.

- This method creates a list of `AlbumViewModel` objects from the `Album` list returned by the repository.

- It then returns the `AlbumViewModel` list.

## We Do: Updating an Album

This is similar to `saveAlbum` except that you will delete any previously associated `Tracks` and then create new `Track` entries for the album.

- Note that you will use the `@Transactional` annotation:

    ```java
        @Transactional
        public void updateAlbum(AlbumViewModel viewModel) {

            // Update the album information
            Album album = new Album();
            album.setId(viewModel.getId());
            album.setArtistId(viewModel.getArtist().getId());
            album.setLabelId(viewModel.getLabel().getId());
            album.setListPrice(viewModel.getListPrice());
            album.setReleaseDate(viewModel.getReleaseDate());

            albumRepository.save(album);

            // We don't know if any track have been removed so delete all associated tracks
            // and then associate the tracks in the viewModel with the album
            List<Track> trackList = trackRepository.findAllTracksByAlbumId(album.getId());
            trackList.stream()
                    .forEach(track -> trackRepository.deleteById(track.getId()));

            List<Track> tracks = viewModel.getTracks();
            tracks.stream()
                    .forEach(t ->
                    {
                        t.setAlbumId(viewModel.getId());
                        t = trackRepository.save(t);
                    });
        }
    ```

## Student Do: Removing an Album

- Working in the `ServiceLayer` class, implement a `removeAlbum` method.

- This method takes in the album `id` as a parameter.

- You will first remove the associated `Tracks`. You have to do this first because of the FK relationship.

- Then you will remove the `Album` entry.

- Be sure to mark the method as `@Transactional`.

## Updating the Controller

- Update the `AlbumController` class to make use of the `ServiceLayer`:

    ```java
    package com.company.reccoll.controller;

    import com.company.reccoll.service.ServiceLayer;
    import com.company.reccoll.viewmodel.AlbumViewModel;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    public class AlbumController {
        @Autowired
        ServiceLayer serviceLayer;

        @GetMapping("/albums")
        public List<AlbumViewModel> getAlbums() {
            return serviceLayer.findAllAlbums();
        }

        @GetMapping("/albums/{id}")
        public AlbumViewModel getAlbumById(@PathVariable int id) {
            return serviceLayer.findAlbum(id);
        }

        @PostMapping("/albums")
        @ResponseStatus(HttpStatus.CREATED)
        public AlbumViewModel addAlbum(@RequestBody AlbumViewModel albumViewModel) {
            return serviceLayer.saveAlbum(albumViewModel);
        }

        @PutMapping("/albums")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void updateAlbum(@RequestBody AlbumViewModel albumViewModel) {
            serviceLayer.updateAlbum(albumViewModel);
        }

        @DeleteMapping("/albums/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteAlbum(@PathVariable int id) {
            serviceLayer.removeAlbum(id);
        }
    }
    ```

---

© 2023 2U. All Rights Reserved.
