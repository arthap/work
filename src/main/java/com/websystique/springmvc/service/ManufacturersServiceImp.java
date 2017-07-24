package com.websystique.springmvc.service;


import com.websystique.springmvc.dao.ManufacturerDao;
import com.websystique.springmvc.model.Manufacturers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by asargsyan on 2/2/17.
 */
public class ManufacturersServiceImp implements ManufacturersService {
    @Autowired
    ManufacturerDao manufacturerDao;


    @Override
    public Manufacturers findById(int id) {
        return manufacturerDao.findById(id);
    }

    @Override
    public void saveManufacturers(Manufacturers manufacturers) {
        manufacturerDao.saveManufacturers(manufacturers);

    }



    @Override
    public void deleteManufacturersById(int id) {
        manufacturerDao.deleteManufacturersById(id);

    }

    @Override
    public void deleteManufacturersAll() {
        manufacturerDao.deleteManufacturersAll();

    }

    @Override
    public List<Manufacturers> findAllManufacturers() {
        return manufacturerDao.findAllManufacturers();
    }

    @Override
    public List<Manufacturers> findManufacturersByManufacturersId(long manufacturersId) {
        return manufacturerDao.findManufacturersByManufacturersId(manufacturersId);
    }
}
