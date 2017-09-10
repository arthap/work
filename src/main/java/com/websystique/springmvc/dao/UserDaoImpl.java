package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.UserProfile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by sevak on 9/10/17.
 */
@Repository
public class UserDaoImpl extends AbstractDao<Long,UserProfile> implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

    public void create(UserProfile userProfile) {
        persist(userProfile);
    }


    public UserProfile getById(Long id){
        Session session = sessionFactory.openSession();
        UserProfile o = (UserProfile) session.get(UserProfile.class, id);
        session.close();
        return o;
    }



}
