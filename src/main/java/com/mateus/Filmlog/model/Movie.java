package com.mateus.Filmlog.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    private String id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private LocalDate releaseDate;

    @Column(nullable = false)
    private LocalDateTime createDate;

    public Movie(String id, String title, String description, LocalDate releaseDate, LocalDateTime createDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.createDate = createDate;
    }

    public Movie() {
    }

    @PrePersist
    public void initialize() {
        if (id == null)
            this.id = UUID.randomUUID()
                      .toString()
                      .replace("-", "")
                      .substring(0, 8);
        if (createDate == null)
            this.createDate = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
}
