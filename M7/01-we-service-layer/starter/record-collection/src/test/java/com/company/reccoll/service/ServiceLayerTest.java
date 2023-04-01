package com.company.reccoll.service;

import com.company.reccoll.model.Album;
import com.company.reccoll.model.Label;
import com.company.reccoll.repository.AlbumRepository;
import com.company.reccoll.repository.ArtistRepository;
import com.company.reccoll.repository.LabelRepository;
import com.company.reccoll.repository.TrackRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class ServiceLayerTest {
    ServiceLayer serviceLayer;
    AlbumRepository albumRepository;
    ArtistRepository artistRepository;
    LabelRepository labelRepository;
    TrackRepository trackRepository;

    // First we need a helper method that sets up the class level AlbumRepository albumRepository;
    private void setUpAlbumRepository() {
        albumRepository = mock(AlbumRepository.class);
        // The first Album object represents an album that has been added to the database.
        // Notice that it has an id property.
        Album album = new Album();
        album.setId(1);
        album.setArtistId(45);
        album.setLabelId(10);
        album.setTitle("Greatest Hits");
        album.setListPrice(new BigDecimal("14.99"));
        album.setReleaseDate(LocalDate.of(1999, 05, 15));
        // The second Album object represents an album that we want to save to the database.
        // Notice that you don't set the id property but that all other fields have the same values as the first Album object.
        Album album2 = new Album();
        album2.setArtistId(45);
        album2.setLabelId(10);
        album2.setTitle("Greatest Hits");
        album2.setListPrice(new BigDecimal("14.99"));
        album2.setReleaseDate(LocalDate.of(1999, 05, 15));

        List<Album> aList = new ArrayList<>();
        aList.add(album);
        // The first doReturn/when tells the mock to return album
        // (remember that this is the one with the id set) when the addAlbum method is called with album2
        // as the parameter (remember that this is the one without the id set).
        doReturn(album).when(albumRepository).save(album2);
        // The second doReturn/when tells the mock to return album when the getAlbum method is called with 1 as the parameter.
        doReturn(Optional.of(album)).when(albumRepository).findById(1);
        // The last doReturn/when tells the mock to return aList when the getAllAlbums method is called.
        doReturn(aList).when(albumRepository).findAll();
    }

    private void setUpLabelRepositoryMock() {
        LabelRepository mockLabelRepository = mock(LabelRepository.class);
        // Optional<Label> label = labelRepository.findById(album.getLabelId());
        Album album = new Album();
        album.setId(1);
        album.setArtistId(45);
        album.setLabelId(10);
        album.setTitle("Greatest Hits");
        album.setListPrice(new BigDecimal("14.99"));
        album.setReleaseDate(LocalDate.of(1999, 05, 15));
        Label label = new Label();
        label.setId(album.getLabelId());
        doReturn(Optional.of(label)).when(mockLabelRepository).findById(album.getLabelId());
    }

}