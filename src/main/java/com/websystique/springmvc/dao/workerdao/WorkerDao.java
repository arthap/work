package com.websystique.springmvc.dao.workerdao;

import com.websystique.springmvc.model.Worker;

import java.util.List;

/**
 * Created by sevak on 9/10/17.
 */
public interface WorkerDao {

    Worker getById(Long id);

    void create(Worker worker);

    List<Worker> getAll();

    void deleteWorker(Worker worker);

    void updateUserProfile(Worker worker);
}
