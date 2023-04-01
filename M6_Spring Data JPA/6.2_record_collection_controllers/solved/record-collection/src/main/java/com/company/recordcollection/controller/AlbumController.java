package com.company.recordcollection.controller;

import com.company.recordcollection.model.Album;
import com.company.recordcollection.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlbumController {
    @Autowired
    AlbumRepository repo;

    @GetMapping("/albums")
    public List<Album> getAlbums() {
        return repo.findAll();
    }

    @GetMapping("/albums/{id}")
    public Album getAlbumById(@PathVariable int id) {

        Optional<Album> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @GetMapping("/albums/title/{title}")
    public List<Album> getAlbumsByTitle(@PathVariable String title) {

        return repo.findByTitle(title);
    }

    @PostMapping("/albums")
    @ResponseStatus(HttpStatus.CREATED)
    public Album addAlbum(@RequestBody Album album) {
        return repo.save(album);
    }

    @PutMapping("/albums")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAlbum(@RequestBody Album album) {
        repo.save(album);
    }

    @DeleteMapping("/albums/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlbum(@PathVariable int id) {
        repo.deleteById(id);
    }
}
