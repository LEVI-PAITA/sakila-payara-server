/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.services;

import com.vasslatam.sakila.services.domain.Category;
import com.vasslatam.sakila.services.repositories.CategoryRepository;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 * @author USERVASSPERU
 */
@ApplicationScoped
public class CategoryServices {
    @Inject
    private CategoryRepository categoryRepository;
    
    public List<Category> findByCategoria(String name){
        return categoryRepository.findByCategoria(name);
    }
}
