package com.company.reccoll.controller;

import com.company.reccoll.model.Album;
import com.company.reccoll.repository.AlbumRepository;
import com.company.reccoll.service.ServiceLayer;
import com.company.reccoll.viewmodel.AlbumViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
