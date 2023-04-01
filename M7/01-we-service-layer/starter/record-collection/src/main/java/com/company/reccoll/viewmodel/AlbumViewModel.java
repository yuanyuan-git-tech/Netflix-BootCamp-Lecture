package com.company.reccoll.viewmodel;

import com.company.reccoll.model.Artist;
import com.company.reccoll.model.Label;
import com.company.reccoll.model.Track;

import java.math.BigDecimal;
import java.sql.Array;
import java.time.LocalDate;
import java.util.*;


public class AlbumViewModel {
    private int id;
    private List<Track> tracks = new ArrayList<>();
    private String title;
    private Artist artist;
    private LocalDate releaseDate;
    private Label label;
    private BigDecimal listPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumViewModel that = (AlbumViewModel) o;
        return id == that.id && Objects.equals(tracks, that.tracks) && Objects.equals(title, that.title) && Objects.equals(artist, that.artist) && Objects.equals(releaseDate, that.releaseDate) && Objects.equals(label, that.label) && Objects.equals(listPrice, that.listPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tracks, title, artist, releaseDate, label, listPrice);
    }

    @Override
    public String toString() {
        return "AlbumViewModel{" +
                "id=" + id +
                ", tracks=" + tracks +
                ", title='" + title + '\'' +
                ", artist=" + artist +
                ", releaseDate=" + releaseDate +
                ", label=" + label +
                ", listPrice=" + listPrice +
                '}';
    }
}
