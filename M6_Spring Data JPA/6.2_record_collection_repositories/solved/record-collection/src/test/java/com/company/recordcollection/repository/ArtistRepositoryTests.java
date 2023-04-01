package com.company.recordcollection.repository;

import com.company.recordcollection.model.Album;
import com.company.recordcollection.model.Artist;
import com.company.recordcollection.model.Label;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ArtistRepositoryTests {

    @Autowired
    ArtistRepository artistRepository;

    @Before
    public void setUp() throws Exception {
        artistRepository.deleteAll();
    }

    @Test
    public void shouldAddArtist() {

        //Arrange...
        Artist artist = new Artist();
        artist.setName("Rock Star");
        artist.setInstagram("@RockStar");
        artist.setTwitter("@TheRockStar");

        //Act...
        artist = artistRepository.save(artist);

        Optional<Artist> artist1 = artistRepository.findById(artist.getId());

        //Assert...
        assertEquals(artist1.get(), artist);
    }

    @Test
    public void shouldGetArtistById() {

        //Arrange...
        // Need to create a Label and an Artist first
        Artist artist = new Artist();
        artist.setName("Rock Start");
        artist.setInstagram("@RockStart");
        artist.setTwitter("@TheRockStar");
        artist = artistRepository.save(artist);

        Artist artist2 = new Artist();
        artist2.setName("Pop Star");
        artist2.setInstagram("@PopStar");
        artist2.setTwitter("@ThePopStar");
        artist2 = artistRepository.save(artist2);

        //Act...
        Optional<Artist> foundArtist = artistRepository.findById(artist.getId());

        //Assert...
        assertEquals(foundArtist.get(), artist);
    }

    @Test
    public void shouldUpdateArtist() {

        //Arrange...
        Artist artist = new Artist();
        artist.setName("Rock Star");
        artist.setInstagram("@RockStart");
        artist.setTwitter(("@TheRockStar"));

        artist = artistRepository.save(artist);

        artist.setName("Pop Star");
        artist.setInstagram("@PopStar");
        artist.setTwitter("@ThePopstar");

        artistRepository.save(artist);

        //Act...
        Optional<Artist> artist1 = artistRepository.findById(artist.getId());

        //Assert...
        assertEquals(artist1.get(), artist);
    }

    @Test
    public void shouldGetAllArtists() {

        //Arrange...
        Artist artist = new Artist();
        artist.setName("Rock Star");
        artist.setInstagram("@RockStart");
        artist.setTwitter(("@TheRockStar"));

        artist = artistRepository.save(artist);

        artist = new Artist();
        artist.setName("Super Star");
        artist.setInstagram("@SuperStart");
        artist.setTwitter(("@TheSuperStar"));

        artist = artistRepository.save(artist);

        //Act...
        List<Artist> aList = artistRepository.findAll();

        //Assert...
        assertEquals(aList.size(), 2);
    }

    @Test
    public void shouldGetArtistByName() {

        //Arrange...
        Artist artist = new Artist();
        artist.setName("Rock Star");
        artist.setInstagram("@RockStar");
        artist.setTwitter(("@TheRockStar"));

        artist = artistRepository.save(artist);

        artist = new Artist();
        artist.setName("Super Star");
        artist.setInstagram("@SuperStar");
        artist.setTwitter(("@TheSuperStar"));

        artist = artistRepository.save(artist);

        //Act...
        List<Artist> aList = artistRepository.findByName("Super Star");

        //Assert...
        assertEquals(aList.size(), 1);
    }

    @Test
    public void shouldDeleteArtistById() {

        //Arrange...
        Artist artist = new Artist();
        artist.setName("Rock Star");
        artist.setInstagram("@RockStar");
        artist.setTwitter("@TheRockStar");

        artist = artistRepository.save(artist);

        Optional<Artist> artist1 = artistRepository.findById(artist.getId());

        assertEquals(artist1.get(), artist);

        //Act...
        artistRepository.deleteById(artist.getId());

        artist1 = artistRepository.findById(artist.getId());

        //Assert...
        assertFalse(artist1.isPresent());
    }
}