package com.company.reccoll.service;

import com.company.reccoll.repository.*;
import com.company.reccoll.model.Album;
import com.company.reccoll.model.Artist;
import com.company.reccoll.model.Label;
import com.company.reccoll.model.Track;
import com.company.reccoll.viewmodel.AlbumViewModel;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;


import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

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
    public void shouldSaveArtist() {
        // Arrange
        Artist expectedResult = new Artist();
        expectedResult.setId(45);
        expectedResult.setInstagram("@RockStar");
        expectedResult.setName("The GOAT");
        expectedResult.setTwitter("@TheRockStar");

        Artist artist = new Artist();
        artist.setInstagram("@RockStar");
        artist.setName("The GOAT");
        artist.setTwitter("@TheRockStar");

        // ACT
        artist = service.saveArtist(artist);

        assertEquals(expectedResult, artist);
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
