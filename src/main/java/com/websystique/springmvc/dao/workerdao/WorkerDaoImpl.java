package com.websystique.springmvc.dao.workerdao;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.model.Worker;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by sevak on 9/10/17.
 */
@Repository
public class WorkerDaoImpl extends AbstractDao<Long, Worker> implements WorkerDao {

    @Override
    public Worker getById(Long id) {
        Session session = openSession();
        Worker worker = (Worker) session.get(Worker.class, id);
        closeSession(session);
        return worker;
    }

    @Override
    public Worker getByEmail(String email){
        Session session = openSession();
        Worker worker = (Worker) session.get(Worker.class,email);
        closeSession(session);
        return worker;
    }

    @Override
    @Transactional
    public void create(Worker worker) {
        persist(worker);
    }

    @Override
    public List<Worker> getAll() {
        Session session = openSession();
        List<Worker> workers = session.createCriteria(Worker.class).list();
        closeSession(session);
        return workers;
    }

    @Override
    public void deleteWorker(Worker worker) {
        delete(worker);
    }

    @Override
    public void updateUserProfile(Worker worker) {
        update(worker);
    }
}
