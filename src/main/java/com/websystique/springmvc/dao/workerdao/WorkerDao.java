package com.websystique.springmvc.dao.workerdao;

import com.websystique.springmvc.model.Worker;

/**
 * Created by sevak on 9/10/17.
 */
public interface WorkerDao {

    Worker getById(Long id);

    void create(Worker worker);
}
