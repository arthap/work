package com.websystique.springmvc.service.workerservice;

import com.websystique.springmvc.model.Worker;
import org.springframework.stereotype.Service;

/**
 * Created by sevak on 9/10/17.
 */
@Service
public interface WorkerService {
    Worker getById(Long id);

    void create(Worker worker);
}
