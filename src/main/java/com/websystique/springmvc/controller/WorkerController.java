package com.websystique.springmvc.controller;

import com.websystique.springmvc.model.Worker;
import com.websystique.springmvc.service.workerservice.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sevak on 9/10/17.
 */
@RestController
@RequestMapping(value = "/api")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @RequestMapping(value = "/worker", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Void> createUser(@RequestBody Worker worker) {
        workerService.create(worker);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/workers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Worker>> getUser() {
        return workerService.getAll();
    }

    @RequestMapping(value = "/workers/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Worker> deleteWorker(@PathVariable("id") long id) {

        return workerService.delete(id);
    }


    @RequestMapping(value = "/workers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Worker> getUser(@PathVariable("id") Long id) {

        Worker byId = workerService.getById(id);
        return new ResponseEntity<Worker>(byId, HttpStatus.OK);
    }

    @RequestMapping(value = "/workers/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Worker> updateWorker(@PathVariable("id") long id,@RequestBody Worker worker) {
        return workerService.update(id,worker);
    }

}
