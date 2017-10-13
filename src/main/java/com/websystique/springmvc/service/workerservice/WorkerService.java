package com.websystique.springmvc.service.workerservice;

import com.websystique.springmvc.model.Worker;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sevak on 9/10/17.
 */
@Service
public interface WorkerService {
    Worker getById(Long id);

    Worker getByEmail(String email);

    void create(Worker worker);

    ResponseEntity<List<Worker>> getAll();

    ResponseEntity<Worker> delete(long id);

    ResponseEntity<Worker> update(long id, Worker worker);
}
