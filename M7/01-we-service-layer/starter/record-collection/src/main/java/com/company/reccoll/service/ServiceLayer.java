package com.company.reccoll.service;

import com.company.reccoll.model.Album;
import com.company.reccoll.model.Artist;
import com.company.reccoll.model.Label;
import com.company.reccoll.model.Track;
import com.company.reccoll.repository.AlbumRepository;
import com.company.reccoll.repository.ArtistRepository;
import com.company.reccoll.repository.LabelRepository;
import com.company.reccoll.repository.TrackRepository;
import com.company.reccoll.viewmodel.AlbumViewModel;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    /**
     * ALBUM API
     * @param viewModel
     */
    @Transactional
    public AlbumViewModel saveAlbum(AlbumViewModel viewModel) {
        // Persist Album
        Album album = new Album();
        album.setTitle(viewModel.getTitle());
        album.setReleaseDate(viewModel.getReleaseDate());
        album.setListPrice(viewModel.getListPrice());
        album.setLabelId(viewModel.getLabel().getId());
        album.setArtistId(viewModel.getArtist().getId());
        album = albumRepository.save(album);
        viewModel.setId(album.getId());

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
                .forEach(t -> {
                    t.setAlbumId(viewModel.getId());
                    t = trackRepository.save(t);
                });
    }
    @Transactional
    public void removeAlbum(int id) {
        // You will first remove the associated Tracks. You have to do this first because of the FK relationship.
        //Then you will remove the Album entry.
        List<Track> trackList = trackRepository.findAllTracksByAlbumId(id);
        trackList.stream()
                .forEach(track -> trackRepository.deleteById(track.getId()));
        albumRepository.deleteById(id);
    }


    public AlbumViewModel findAlbum(int id) {
        // Get the album object first
        Optional<Album> album = albumRepository.findById(id);

        return album.isPresent() ? buildAlbumViewModel(album.get()) : null;
    }
    public List<AlbumViewModel> findAllAlbums() {
        // Get all album objects
        List<Album> albumList = albumRepository.findAll();
        List<AlbumViewModel> albumViewModels = new ArrayList<>();
        for (Album album : albumList) {
            AlbumViewModel avm = buildAlbumViewModel(album);
            albumViewModels.add(avm);
        }
        return albumViewModels;
    }

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
}
