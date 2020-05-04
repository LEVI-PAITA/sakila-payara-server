/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.services.repositories;

import com.vasslatam.sakila.services.domain.Actor;
import com.vasslatam.sakila.services.domain.Actor_;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author USERVASSPERU
 */
@ApplicationScoped
public class ActorRepository {
    @Inject
    private EntityManager em;
    
    public List<Actor>findAll(){
        TypedQuery<Actor> query = em.createQuery("select a from Actor a", Actor.class);
        return query.getResultList();
    }
    
     public List<Actor> findByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Actor> cq = cb.createQuery(Actor.class);
        Root<Actor> actor = cq.from(Actor.class);
        String nameWildcard = '%' + name.replace(' ', '%') + '%';
        cq.select(actor)
                .where(
                        //cb.or(
                                cb.like(actor.get(Actor_.firstname), nameWildcard)
                                //cb.like(actor.get(Actor_.lastname), nameWildcard)
                        //)
                );
        cq.orderBy(cb.desc(actor.get(Actor_.firstname)));
        TypedQuery<Actor> query = em.createQuery(cq);
        return query.getResultList();
    }
}
