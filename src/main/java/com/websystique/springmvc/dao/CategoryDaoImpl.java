package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Category;
import com.websystique.springmvc.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by asargsyan on 2/1/17.
 */
@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractDao<Integer, Category> implements CategoryDao {
    @Override
    public List<Category> findAllUsers() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Category> category= (List<Category>) criteria.list();
//        User userProfileDao=new User();
//        persist(userProfileDao);

        // No need to fetch userProfiles since we are not showing them on list page. Let them lazy load.
        // Uncomment below lines for eagerly fetching of userProfiles if you want.
		/*
		for(User user : users){
			Hibernate.initialize(user.getUserProfiles());
		}*/
        return category;
    }
}
