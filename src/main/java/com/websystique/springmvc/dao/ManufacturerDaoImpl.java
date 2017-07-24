package com.websystique.springmvc.dao;



import com.websystique.springmvc.model.Manufacturers;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by asargsyan on 2/2/17.
 */
@Repository("ManufacturerDao")
public class ManufacturerDaoImpl extends AbstractDao<Integer, Manufacturers> implements  ManufacturerDao {
    @Override
    public Manufacturers findById(int id) {

        return getByKey(id);
    }

    @Override
    public void saveManufacturers(Manufacturers manufacturers) {
        persist(manufacturers);
    }



    @Override
    public void deleteManufacturersById(int id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("MANUFACTURER_ID", id));
        Manufacturers manufacturers = (Manufacturers)crit.uniqueResult();
        delete(manufacturers);

    }

    @Override
    public void deleteManufacturersAll() {
        Query query = getSession().createSQLQuery("delete from Manufacturers ");

        query.executeUpdate();
    }

    @Override
    public List<Manufacturers> findAllManufacturers() {
        Criteria criteria = createEntityCriteria();
        return (List<Manufacturers>) criteria.list();
    }

    @Override
    public List<Manufacturers> findManufacturersByManufacturersId(long manufacturersId) {

        Query query = getSession().createQuery("from Manufacturers where Id= :Id");
        query.setLong("Id", manufacturersId);
        return  query.list();
    }
}
