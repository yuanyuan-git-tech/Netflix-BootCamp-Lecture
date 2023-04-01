package com.company.recordcollection.repository;

import com.company.recordcollection.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {

    List<Track> findAllTracksByAlbumId(int albumId);
    List<Track> findByTitle(String trackTitle);

}
