package com.company.recordcollection.repository;

import com.company.recordcollection.model.Album;
import com.company.recordcollection.model.Artist;
import com.company.recordcollection.model.Label;
import com.company.recordcollection.model.Track;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TrackRepositoryTests {

    @Autowired
    TrackRepository trackRepository;
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    ArtistRepository artistRepository;
    @Autowired
    LabelRepository labelRepository;

    @Before
    public void setUp() throws Exception {
        trackRepository.deleteAll();
        albumRepository.deleteAll();
        artistRepository.deleteAll();
        labelRepository.deleteAll();
    }

    @Test
    public void shouldAddTrack() {

        //Arrange...
        // Need to create a Label, Artist, and Album first
        Label label = new Label();
        label.setName("A&M");
        label.setWebsite("www.aandm.com");
        label = labelRepository.save(label);

        Artist artist = new Artist();
        artist.setName("Rock Start");
        artist.setInstagram("@RockStart");
        artist.setTwitter("@TheRockStar");
        artist = artistRepository.save(artist);

        Album album = new Album();
        album.setTitle("Greatest Hits");
        album.setArtistId(artist.getId());
        album.setLabelId(label.getId());
        album.setReleaseDate(LocalDate.of(2010, 1, 5));
        album.setListPrice(new BigDecimal("21.95"));

        album = albumRepository.save(album);

        //Act...
        Track track = new Track();
        track.setTitle("The Big Hit");
        track.setRunTime(180);
        track.setAlbumId(album.getId());
        track = trackRepository.save(track);

        //Assert...
        Optional<Track> track1 = trackRepository.findById(track.getId());

        assertEquals(track1.get(), track);
    }

    @Test
    public void shouldGetAlbumById() {

        //Arrange...
        // Need to create a Label and an Artist first
        Label label = new Label();
        label.setName("A&M");
        label.setWebsite("www.aandm.com");
        label = labelRepository.save(label);

        Artist artist = new Artist();
        artist.setName("Rock Start");
        artist.setInstagram("@RockStart");
        artist.setTwitter("@TheRockStar");
        artist = artistRepository.save(artist);

        Album album = new Album();
        album.setTitle("Greatest Hits");
        album.setArtistId(artist.getId());
        album.setLabelId(label.getId());
        album.setReleaseDate(LocalDate.of(2010, 1, 5));
        album.setListPrice(new BigDecimal("21.95"));

        album = albumRepository.save(album);

        //Act...
        Track track1 = new Track();
        track1.setTitle("The Big Hit");
        track1.setRunTime(180);
        track1.setAlbumId(album.getId());
        trackRepository.save(track1);

        Track track2 = new Track();
        track2.setTitle("Just A Song");
        track2.setRunTime(120);
        track2.setAlbumId(album.getId());
        trackRepository.save(track2);

        //Assert...
        Optional<Track> foundTrack = trackRepository.findById(track1.getId());

        assertEquals(foundTrack.get(), track1);
    }

    @Test
    public void shouldUpdateTrack() {

        //Arrange...
        // Need to create a Label, Artist, and Album first
        Label label = new Label();
        label.setName("A&M");
        label.setWebsite("www.aandm.com");
        label = labelRepository.save(label);

        Artist artist = new Artist();
        artist.setName("Rock Start");
        artist.setInstagram("@RockStart");
        artist.setTwitter("@TheRockStar");
        artist = artistRepository.save(artist);

        Album album = new Album();
        album.setTitle("Greatest Hits");
        album.setArtistId(artist.getId());
        album.setLabelId(label.getId());
        album.setReleaseDate(LocalDate.of(2010, 1, 5));
        album.setListPrice(new BigDecimal("21.95"));

        album = albumRepository.save(album);

        Track track = new Track();
        track.setTitle("The Big Hit");
        track.setRunTime(180);
        track.setAlbumId(album.getId());
        track = trackRepository.save(track);

        //Act...
        track.setTitle("NEW TITLE");
        track.setRunTime(12);

        trackRepository.save(track);

        //Assert...
        Optional<Track> track1 = trackRepository.findById(track.getId());

        assertEquals(track1.get(), track);
    }

    @Test
    public void shouldGetAllTracks() {

        //Arrange...
        // Need to create a Label, Artist, and Album first
        Label label = new Label();
        label.setName("A&M");
        label.setWebsite("www.aandm.com");
        label = labelRepository.save(label);

        Artist artist = new Artist();
        artist.setName("Rock Start");
        artist.setInstagram("@RockStart");
        artist.setTwitter("@TheRockStar");
        artist = artistRepository.save(artist);

        Album album = new Album();
        album.setTitle("Greatest Hits");
        album.setArtistId(artist.getId());
        album.setLabelId(label.getId());
        album.setReleaseDate(LocalDate.of(2010, 1, 5));
        album.setListPrice(new BigDecimal("21.95"));

        album = albumRepository.save(album);

        Album album1 = new Album();
        album1.setTitle("Lesser Hits");
        album1.setArtistId(artist.getId());
        album1.setLabelId(label.getId());
        album1.setReleaseDate(LocalDate.of(2012, 6, 25));
        album1.setListPrice(new BigDecimal("9.95"));

        album1 = albumRepository.save(album1);

        Track track = new Track();
        track.setTitle("The Big Hit");
        track.setRunTime(180);
        track.setAlbumId(album.getId());
        track = trackRepository.save(track);

        track = new Track();
        track.setTitle("Just A Song");
        track.setRunTime(120);
        track.setAlbumId(album1.getId());
        track = trackRepository.save(track);

        //Act...
        List<Track> tList = trackRepository.findAll();

        //Assert...
        assertEquals(tList.size(), 2);
    }

    @Test
    public void shouldGetTracksByAlbum() {

        //Arrange...
        // Need to create a Label, Artist, and Album first
        Label label = new Label();
        label.setName("A&M");
        label.setWebsite("www.aandm.com");
        label = labelRepository.save(label);

        Artist artist = new Artist();
        artist.setName("Rock Start");
        artist.setInstagram("@RockStart");
        artist.setTwitter("@TheRockStar");
        artist = artistRepository.save(artist);

        Album album = new Album();
        album.setTitle("Greatest Hits");
        album.setArtistId(artist.getId());
        album.setLabelId(label.getId());
        album.setReleaseDate(LocalDate.of(2010, 1, 5));
        album.setListPrice(new BigDecimal("21.95"));

        album = albumRepository.save(album);

        Album album1 = new Album();
        album1.setTitle("Lesser Hits");
        album1.setArtistId(artist.getId());
        album1.setLabelId(label.getId());
        album1.setReleaseDate(LocalDate.of(2012, 6, 25));
        album1.setListPrice(new BigDecimal("9.95"));

        album1 = albumRepository.save(album1);

        //Act...
        Track track = new Track();
        track.setTitle("The Big Hit");
        track.setRunTime(180);
        track.setAlbumId(album.getId());
        track = trackRepository.save(track);

        track = new Track();
        track.setTitle("Just A Song");
        track.setRunTime(120);
        track.setAlbumId(album1.getId());
        track = trackRepository.save(track);

        track = new Track();
        track.setTitle("A Little Tune");
        track.setRunTime(100);
        track.setAlbumId(album1.getId());
        track = trackRepository.save(track);

        //Assert...
        List<Track> tList = trackRepository.findAllTracksByAlbumId(album.getId());
        assertEquals(tList.size(), 1);

        tList = trackRepository.findAllTracksByAlbumId(album1.getId());
        assertEquals(tList.size(), 2);
    }

    @Test
    public void shouldGetTrackByTitle() {

        //Arrange...
        // Need to create a Label, Artist, and Album first
        Label label = new Label();
        label.setName("A&M");
        label.setWebsite("www.aandm.com");
        label = labelRepository.save(label);

        Artist artist = new Artist();
        artist.setName("Rock Start");
        artist.setInstagram("@RockStart");
        artist.setTwitter("@TheRockStar");
        artist = artistRepository.save(artist);

        Album album = new Album();
        album.setTitle("Greatest Hits");
        album.setArtistId(artist.getId());
        album.setLabelId(label.getId());
        album.setReleaseDate(LocalDate.of(2010, 1, 5));
        album.setListPrice(new BigDecimal("21.95"));

        album = albumRepository.save(album);

        Album album1 = new Album();
        album1.setTitle("Lesser Hits");
        album1.setArtistId(artist.getId());
        album1.setLabelId(label.getId());
        album1.setReleaseDate(LocalDate.of(2012, 6, 25));
        album1.setListPrice(new BigDecimal("9.95"));

        album1 = albumRepository.save(album1);


        Track track = new Track();
        track.setTitle("The Big Hit");
        track.setRunTime(180);
        track.setAlbumId(album.getId());
        track = trackRepository.save(track);

        track = new Track();
        track.setTitle("Just A Song");
        track.setRunTime(120);
        track.setAlbumId(album1.getId());
        track = trackRepository.save(track);

        track = new Track();
        track.setTitle("A Little Tune");
        track.setRunTime(100);
        track.setAlbumId(album1.getId());
        track = trackRepository.save(track);

        //Act...
        List<Track> tList = trackRepository.findByTitle("The Big Hit");

        //Assert...
        assertEquals(tList.size(), 1);
    }

    @Test
    public void shouldDeleteTrackById() {

        //Arrange...
        // Need to create a Label, Artist, and Album first
        Label label = new Label();
        label.setName("A&M");
        label.setWebsite("www.aandm.com");
        label = labelRepository.save(label);

        Artist artist = new Artist();
        artist.setName("Rock Start");
        artist.setInstagram("@RockStart");
        artist.setTwitter("@TheRockStar");
        artist = artistRepository.save(artist);

        Album album = new Album();
        album.setTitle("Greatest Hits");
        album.setArtistId(artist.getId());
        album.setLabelId(label.getId());
        album.setReleaseDate(LocalDate.of(2010, 1, 5));
        album.setListPrice(new BigDecimal("21.95"));

        album = albumRepository.save(album);

        Track track = new Track();
        track.setTitle("The Big Hit");
        track.setRunTime(180);
        track.setAlbumId(album.getId());
        track = trackRepository.save(track);

        Optional<Track> track1 = trackRepository.findById(track.getId());

        assertEquals(track1.get(), track);

        //Act...
        trackRepository.deleteById(track.getId());

        track1 = trackRepository.findById(track.getId());

        //Assert...
        assertFalse(track1.isPresent());
    }
}