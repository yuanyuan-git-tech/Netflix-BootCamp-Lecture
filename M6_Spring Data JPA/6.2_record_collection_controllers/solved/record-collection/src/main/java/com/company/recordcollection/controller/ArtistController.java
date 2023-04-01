package com.company.recordcollection.controller;

import com.company.recordcollection.model.Artist;
import com.company.recordcollection.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ArtistController {
    @Autowired
    ArtistRepository repo;

    @GetMapping("/artists")
    public List<Artist> getArtists() {
        return repo.findAll();
    }

    @GetMapping("/artists/{id}")
    public Artist getArtistById(@PathVariable int id) {
        Optional<Artist> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @GetMapping("/artists/name/{name}")
    public List<Artist> getArtistsByName(@PathVariable String name) {
        return repo.findByName(name);
    }

    @PostMapping("/artists")
    @ResponseStatus(HttpStatus.CREATED)
    public Artist addArtist(@RequestBody Artist artist) {
        return repo.save(artist);
    }

    @PutMapping("/artists")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateArtist(@RequestBody Artist artist) {
        repo.save(artist);
    }

    @DeleteMapping("/artists/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArtist(@PathVariable int id) {
        repo.deleteById(id);
    }
}
