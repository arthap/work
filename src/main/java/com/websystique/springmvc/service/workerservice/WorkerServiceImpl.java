package com.websystique.springmvc.service.workerservice;

import com.websystique.springmvc.dao.workerdao.WorkerDao;import com.websystique.springmvc.model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    @Override
    public ResponseEntity<List<Worker>> getAll() {
        List<Worker> users = workerDao.getAll();
        if (users.isEmpty()) {
            return new ResponseEntity<List<Worker>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Worker>>(users, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<Worker> delete(long id) {
        Worker  worker = getById(id);
        if (worker == null) {
            return new ResponseEntity<Worker>(HttpStatus.NOT_FOUND);
        }
        workerDao.deleteWorker(worker);
        return new ResponseEntity<Worker>(HttpStatus.NO_CONTENT);
    }

    @Override
    @Transactional
    public ResponseEntity<Worker> update(long id, Worker worker) {
        Worker currentWorker = getById(id);
        if (currentWorker==null){
            return new ResponseEntity<Worker>(HttpStatus.NOT_FOUND);
        }
        worker.setId(id);
        workerDao.updateUserProfile(worker);
        return new ResponseEntity<Worker>(HttpStatus.OK);
    }

}
