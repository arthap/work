package com.websystique.springmvc.service.workerservice;

import com.websystique.springmvc.dao.workerdao.WorkerDao;
import com.websystique.springmvc.model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sevak on 9/10/17.
 */
@Service
public class WorkerServiceImpl implements WorkerService{

    @Autowired
    private WorkerDao workerDao;


    @Override
    public Worker getById(Long id) {
        return workerDao.getById(id);
    }

    @Override
    public void create(Worker worker) {
        workerDao.create(worker);
    }
}
