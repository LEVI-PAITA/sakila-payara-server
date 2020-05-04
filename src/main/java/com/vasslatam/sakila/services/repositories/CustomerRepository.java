/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.services.repositories;

import com.vasslatam.sakila.services.domain.Address_;
import com.vasslatam.sakila.services.domain.City_;
import com.vasslatam.sakila.services.domain.Customer;
import com.vasslatam.sakila.services.domain.Customer_;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author USERVASSPERU
 */
@ApplicationScoped
public class CustomerRepository {
    @Inject
    private EntityManager em;

    public BigDecimal getcustomer(int rental) {
        Query query = em.createNativeQuery("SELECT get_customer_balance(?,?)")
                .setParameter(1, rental).setParameter(2, LocalDateTime.now());
        BigDecimal result = (BigDecimal) query.getSingleResult();
        return result;

    }
    
    public Customer findById(int customerId){
        return em.find(Customer.class, customerId);
    }
    
    public List<Customer> findByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> customer = cq.from(Customer.class);
        String[] hints = (name == null ? "" : name).split(" ");
        cq.select(customer);
        List<Predicate> where = new ArrayList<>();
        for (String hint : hints) {
            String w = '%' + hint.replace(' ', '%') + '%';
            where.add(
                    cb.like(customer.get(Customer_.firstname), w));
            where.add(
                    cb.like(customer.get(Customer_.lastname), w)
            );
        }
        cq.where(
                cb.or(
                        where.toArray(new Predicate[0])
                )
        );
        customer.fetch(Customer_.addressid, JoinType.LEFT)
                .fetch(Address_.city, JoinType.LEFT)
                .fetch(City_.country, JoinType.LEFT);
        return em.createQuery(cq).getResultList();
    }
    
}
