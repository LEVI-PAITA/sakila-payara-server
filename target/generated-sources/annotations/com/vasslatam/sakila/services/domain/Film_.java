package com.vasslatam.sakila.services.domain;

import com.vasslatam.sakila.services.domain.Language;
import com.vasslatam.sakila.services.type.Rating;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.6.v20200131-rNA", date="2020-05-04T11:43:35")
@StaticMetamodel(Film.class)
public class Film_ { 

    public static volatile SingularAttribute<Film, Integer> length;
    public static volatile SingularAttribute<Film, Rating> rating;
    public static volatile SingularAttribute<Film, String> description;
    public static volatile SingularAttribute<Film, Language> language;
    public static volatile SingularAttribute<Film, String> title;
    public static volatile SingularAttribute<Film, LocalDate> releaseyear;
    public static volatile SingularAttribute<Film, Language> originalLanguage;
    public static volatile SingularAttribute<Film, Double> rentalrate;
    public static volatile SingularAttribute<Film, List> specialFeatures;
    public static volatile SingularAttribute<Film, Integer> filmid;
    public static volatile SingularAttribute<Film, Integer> rentalduration;
    public static volatile SingularAttribute<Film, Double> replacementcost;
    public static volatile SingularAttribute<Film, LocalDateTime> lastupdate;

}