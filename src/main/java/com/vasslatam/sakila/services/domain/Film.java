/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.services.domain;

import com.vasslatam.sakila.services.type.Rating;
import com.vasslatam.sakila.services.type.SpecialFeature;
import com.vasslatam.sakila.services.type.converter.SpecialFeaturesList;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author USERVASSPERU
 */
@Entity
@Table(name = "film")
public class Film implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "film_id")
    private int filmid;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "release_year")
    private LocalDate releaseyear;
    
    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;
    
    @ManyToOne
    @JoinColumn(name = "original_language_id")
    private Language originalLanguage;
    
    @Column(name = "rental_duration")
    private int rentalduration;
    
    @Column(name = "rental_rate")
    private double rentalrate;
    
    @Column(name = "length")
    private int length;
    
    @Column(name = "replacement_cost")
    private double replacementcost;
    
    @Column(name = "rating")
    private Rating rating;
     
    @Column(name = "special_features")
    @Convert(converter = SpecialFeaturesList.class)
    private List<SpecialFeature> specialFeatures;
    
    @Column(name = "last_update")
    private LocalDateTime lastupdate;

    public int getFilmid() {
        return filmid;
    }

    public void setFilmid(int filmid) {
        this.filmid = filmid;
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

    public LocalDate getReleaseyear() {
        return releaseyear;
    }

    public void setReleaseyear(LocalDate releaseyear) {
        this.releaseyear = releaseyear;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Language getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(Language originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public int getRentalduration() {
        return rentalduration;
    }

    public void setRentalduration(int rentalduration) {
        this.rentalduration = rentalduration;
    }

    public double getRentalrate() {
        return rentalrate;
    }

    public void setRentalrate(double rentalrate) {
        this.rentalrate = rentalrate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getReplacementcost() {
        return replacementcost;
    }

    public void setReplacementcost(double replacementcost) {
        this.replacementcost = replacementcost;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public List<SpecialFeature> getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(List<SpecialFeature> specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public LocalDateTime getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(LocalDateTime lastupdate) {
        this.lastupdate = lastupdate;
    }
    
    
    
}
