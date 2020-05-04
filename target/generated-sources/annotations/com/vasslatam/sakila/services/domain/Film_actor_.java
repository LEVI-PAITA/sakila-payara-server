package com.vasslatam.sakila.services.domain;

import com.vasslatam.sakila.services.domain.Actor;
import com.vasslatam.sakila.services.domain.Film;
import com.vasslatam.sakila.services.domain.FilmActorpk;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.6.v20200131-rNA", date="2020-05-04T11:43:35")
@StaticMetamodel(Film_actor.class)
public class Film_actor_ { 

    public static volatile SingularAttribute<Film_actor, Actor> actor;
    public static volatile SingularAttribute<Film_actor, FilmActorpk> filmActorPK;
    public static volatile SingularAttribute<Film_actor, Film> film;
    public static volatile SingularAttribute<Film_actor, LocalDateTime> lastupdate;

}