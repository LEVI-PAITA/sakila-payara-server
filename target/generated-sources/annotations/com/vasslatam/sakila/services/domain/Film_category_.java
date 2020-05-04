package com.vasslatam.sakila.services.domain;

import com.vasslatam.sakila.services.domain.Category;
import com.vasslatam.sakila.services.domain.Film;
import com.vasslatam.sakila.services.domain.FilmCategoryPK;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.6.v20200131-rNA", date="2020-05-04T11:43:35")
@StaticMetamodel(Film_category.class)
public class Film_category_ { 

    public static volatile SingularAttribute<Film_category, LocalDateTime> lastUpdate;
    public static volatile SingularAttribute<Film_category, FilmCategoryPK> filmCategoryPK;
    public static volatile SingularAttribute<Film_category, Film> film;
    public static volatile SingularAttribute<Film_category, Category> category;

}