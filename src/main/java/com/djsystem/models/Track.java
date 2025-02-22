package com.djsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String artist;
    private String duration;
    private Integer bpm;
    private Integer order;
    private String filePath;
    
    public Track() {}
    
    public Track(String title, String artist, String duration, Integer bpm, String filePath) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.bpm = bpm;
        this.filePath = filePath;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }
    
    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }
    
    public Integer getBpm() { return bpm; }
    public void setBpm(Integer bpm) { this.bpm = bpm; }
    
    public Integer getOrder() { return order; }
    public void setOrder(Integer order) { this.order = order; }
    
    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }
}