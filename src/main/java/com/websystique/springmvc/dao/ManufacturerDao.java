package com.websystique.springmvc.dao;



import com.websystique.springmvc.model.Manufacturers;

import java.util.List;

/**
 * Created by asargsyan on 2/2/17.
 */
public interface ManufacturerDao {

    Manufacturers findById(int id);

    void saveManufacturers(Manufacturers manufacturers);




    void deleteManufacturersById(int id);

    void  deleteManufacturersAll();

    List<Manufacturers> findAllManufacturers();

    List<Manufacturers> findManufacturersByManufacturersId(long manufacturersId);

}
