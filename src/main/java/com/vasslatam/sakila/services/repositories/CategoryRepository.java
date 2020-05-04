/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.services.repositories;

import com.vasslatam.sakila.services.domain.Category;
import com.vasslatam.sakila.services.domain.Category_;
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
public class CategoryRepository {
    @Inject
    private EntityManager em;
    
    public List<Category> findByCategoria(String name){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Category> cq = cb.createQuery(Category.class);
        Root<Category> categoria = cq.from(Category.class);
        String nameCategory = '%' + name.replace(' ', '%') + '%';
        cq.select(categoria)
                .where(
                        cb.like(categoria.get(Category_.name), nameCategory)
                );
        TypedQuery<Category> query = em.createQuery(cq);
        return query.getResultList();
    }
}
