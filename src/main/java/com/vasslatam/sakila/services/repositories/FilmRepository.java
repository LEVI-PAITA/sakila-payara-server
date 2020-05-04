/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.services.repositories;

import com.vasslatam.sakila.services.domain.Actor;
import com.vasslatam.sakila.services.domain.Actor_;
import com.vasslatam.sakila.services.domain.Category;
import com.vasslatam.sakila.services.domain.Film;
import com.vasslatam.sakila.services.domain.Film_;
import com.vasslatam.sakila.services.domain.Film_actor;
import com.vasslatam.sakila.services.domain.Film_actor_;
import com.vasslatam.sakila.services.domain.Film_category;
import com.vasslatam.sakila.services.domain.Film_category_;
import com.vasslatam.sakila.services.type.Rating;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

/**
 *
 * @author USERVASSPERU
 */
@ApplicationScoped
public class FilmRepository {
    @Inject
    private EntityManager em;
    
    public List<Film>findAll(){
        TypedQuery<Film> query = em.createQuery("select f from Film f", Film.class);
        return query.getResultList();
    }
    
    public List<Film>findFilmByTitle(String name){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Film> cq = cb.createQuery(Film.class);
        Root<Film> film = cq.from(Film.class);
        cq.select(film).where(
                cb.like(film.get(Film_.title), name.replaceAll(" ", "%"))
        );
        TypedQuery<Film> query = em.createQuery(cq);
        return query.getResultList();
    }
    
    public List<Film>findByActor(Actor actor){
        //Se utiliza para construir consultas de criterios, expresiones,ordenamientos,predicados.
        CriteriaBuilder cb = em.getCriteriaBuilder();
        
        //Define la funcionalidad especifica de las consultas de nivel superior 
        CriteriaQuery<Film> cq = cb.createQuery(Film.class);
        
        //Un tipo raiz en la clausula from. Las raices de consulta siempre hacen referencia a entidades
        Root<Film_actor> filmactor = cq.from(Film_actor.class);
        
        cq.select(filmactor.get(Film_actor_.film))
                .where(
                        cb.equal(filmactor.get(Film_actor_.actor),actor)
                );
        
        //Interfaz utilizada para controlar la ejecucion de consultas escritas
        TypedQuery<Film> query = em.createQuery(cq);
        return query.getResultList();
    }
    
    public List<Film>findByActores(List<Actor> actores){
        //List<Film> filmActores = new ArrayList<>();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Film> cq = cb.createQuery(Film.class);
        Root<Film_actor> filmactores = cq.from(Film_actor.class);
        
        cq.select(filmactores.get(Film_actor_.film))
                .where(
                        filmactores.get(Film_actor_.actor).in(actores)
                );
        TypedQuery<Film> query = em.createQuery(cq);
        return query.getResultList();
    }
   
    public List<Film>findBycategorias(List<Category> categorias){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Film> cq = cb.createQuery(Film.class);
        Root<Film_category> filmcategorias = cq.from(Film_category.class);
        cq.select(filmcategorias.get(Film_category_.film))
                .where(
                        filmcategorias.get(Film_category_.category).in(categorias)
                );
        TypedQuery<Film> query = em.createQuery(cq);
        return query.getResultList();
    }
    
    public List<Film_actor>findByFilm(String actor,String descripcion, String title,Rating rating){
        //Rating ratg = Rating.valueOf(rating);
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Film_actor> cq = cb.createQuery(Film_actor.class);
        Root<Film_actor> filmactor = cq.from(Film_actor.class);
        
        Join<Film_actor, Actor> ac = filmactor.join(Film_actor_.actor);
        Join<Film_actor, Film> f = filmactor.join(Film_actor_.film);
        
        String actorWildcard = '%' + actor.replace(' ', '%') + '%';
        String descripWildcard = '%' + descripcion.replace(' ', '%') + '%';
        String titleWildcard = '%' + title.replace(' ', '%') + '%';
        
        cq.select(filmactor)
                .where(
                        cb.like(ac.get(Actor_.firstname),actorWildcard),
                        cb.and(cb.like(f.get(Film_.description), descripWildcard)),
                        cb.and(cb.like(f.get(Film_.title),titleWildcard)),
                        cb.and(cb.equal(f.get(Film_.rating), rating))
                );
        TypedQuery<Film_actor> query = em.createQuery(cq);
        return query.getResultList();
    }
    
}
