package com.example.musicdb.model.binding;

import com.example.musicdb.model.entity.enums.ArtistNameEnum;
import com.example.musicdb.model.entity.enums.GenreEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumAddBindingModel {

    private String name;
    private String imageUrl;
    private String description;
    private Integer copies;
    private BigDecimal price;
    private LocalDate releasedDate;
    private String producer;
    private GenreEnum genre;
    private ArtistNameEnum artist;

    public AlbumAddBindingModel() {
    }

    @Size(min = 3, max = 20, message = "Name length must be between 3 and 20 characters!")
    public String getName() {
        return name;
    }

    public AlbumAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @Size(min = 5, message = "Must be at least 5 characters!")
    public String getImageUrl() {
        return imageUrl;
    }

    public AlbumAddBindingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    @Size(min = 5, message = "Must be at least 5 characters!")
    public String getDescription() {
        return description;
    }

    public AlbumAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @NotNull(message = "Must not be null!")
    @Min(value = 10, message = "Must be more than 10!")
    public Integer getCopies() {
        return copies;
    }

    public AlbumAddBindingModel setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    @PositiveOrZero(message = "Price must be positive number!")
    @NotNull(message = "Price cannot be null!")
    public BigDecimal getPrice() {
        return price;
    }

    public AlbumAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @NotNull(message = "You must select a date!")
    @PastOrPresent(message = "Date cannot be in the future!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public AlbumAddBindingModel setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
        return this;
    }

    public String getProducer() {
        return producer;
    }

    public AlbumAddBindingModel setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    @NotNull(message = "Please select a genre!")
    public GenreEnum getGenre() {
        return genre;
    }

    public AlbumAddBindingModel setGenre(GenreEnum genre) {
        this.genre = genre;
        return this;
    }

    @NotNull(message = "Please select an artist!")
    public ArtistNameEnum getArtist() {
        return artist;
    }

    public AlbumAddBindingModel setArtist(ArtistNameEnum artist) {
        this.artist = artist;
        return this;
    }
}
