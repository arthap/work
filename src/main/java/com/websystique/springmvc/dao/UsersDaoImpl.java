package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Users;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by asargsyan on 2/2/17.
 */
@Repository("UsersDao")
public class UsersDaoImpl  extends AbstractDao<Integer, Users> implements UsersDao {
    @Override
    public Users findById(int id) {
        return getByKey(id);
    }

    @Override
    public void saveUsers(Users users) {
        persist(users);

    }

    @Override
    public void updateUsers(Users users) {
      update(users);

    }

    @Override
    public void deleteUsersById(int id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("Id", id));
        Users user = (Users)crit.uniqueResult();
        delete(user);
    }

    @Override
    public void deleteUsersAll() {
        Query query = getSession().createSQLQuery("delete from Users ");

        query.executeUpdate();
    }

    @Override
    public List<Users> findAllUsers() {
        Criteria criteria = createEntityCriteria();
        return (List<Users>) criteria.list();
    }

    @Override
    public List<Users> findUsersByUser(String username) {


        Query query = getSession().createQuery("from Users where USERNAME = :USERNAME");
        query.setString("USERNAME", username);
        return  query.list();
    }
}
