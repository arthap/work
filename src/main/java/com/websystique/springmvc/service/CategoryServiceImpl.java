package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.CategoryDao;
import com.websystique.springmvc.dao.UserProfileDao;
import com.websystique.springmvc.model.Category;
import com.websystique.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by asargsyan on 2/1/17.
 */
@Service("categoryService")
@Transactional



public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao categoryDao;

    @Override
    public  List<Category> findAllUsers() {
        return categoryDao.findAllUsers();
    }
}
