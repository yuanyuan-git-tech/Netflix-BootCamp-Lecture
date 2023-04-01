package com.company.recordcollection.controller;

import com.company.recordcollection.model.Track;
import com.company.recordcollection.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TrackController {
    @Autowired
    TrackRepository repo;

    @GetMapping("/tracks")
    public List<Track> getTracks() {
        return repo.findAll();
    }

    @GetMapping("/tracks/{id}")
    public Track getTrackById(@PathVariable int id) {
        Optional<Track> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @GetMapping("/tracks/album/{id}")
    public List<Track> getTracksByAlbumId(@PathVariable int id) {
        return repo.findAllTracksByAlbumId(id);
    }

    @GetMapping("/tracks/title/{title}")
    public List<Track> getTracksByTitle(@PathVariable String title) {
        return repo.findByTitle(title);
    }

    @PostMapping("/tracks")
    @ResponseStatus(HttpStatus.CREATED)
    public Track addTrack(@RequestBody Track track) {
        return repo.save(track);
    }

    @PutMapping("/tracks")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTrack(@RequestBody Track track) {
        repo.save(track);
    }

    @DeleteMapping("/tracks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrack(@PathVariable int id) {
        repo.deleteById(id);
    }
}
