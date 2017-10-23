package com.websystique.springmvc.dao.userdao;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.model.UserProfile;
import com.websystique.springmvc.model.enums.UserProfileType;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sevak on 9/10/17.
 */
@Repository
public class UserDaoImpl extends AbstractDao<Long, UserProfile> implements UserDao {


    public void create(UserProfile userProfile) {
        persist(userProfile);
    }


    @Override
    public UserProfile getById(Long id) {
        Session session = openSession();
        UserProfile userProfile = (UserProfile) session.get(UserProfile.class, id);
        closeSession(session);
        return userProfile;
    }

    @Override
    public UserProfile getUserByEmail(String email) {
        Session session = openSession();
        Criteria criteria = session.createCriteria(UserProfile.class);
        return (UserProfile) criteria.add(Restrictions.eq("email", email)).uniqueResult();
    }

    @Override
    public List<UserProfile> getAll() {
        Session session = openSession();
        List<UserProfile> userProfiles = session.createCriteria(UserProfile.class).list();
        closeSession(session);
        return userProfiles;
    }

    @Override
    public void deleteUserProfile(UserProfile userProfile) {
        delete(userProfile);
    }

    @Override
    public void updateUserProfile(UserProfile userProfile) {
        update(userProfile);
    }
}
