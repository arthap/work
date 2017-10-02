package com.websystique.springmvc.controller;

import com.websystique.springmvc.model.Worker;
import com.websystique.springmvc.service.workerservice.WorkerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    @ApiOperation(value = "Create worker", notes = "this operation allows to create new worker profile")
    public ResponseEntity<Void> createUser(@RequestBody Worker worker) {
        workerService.create(worker);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/workers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get workers", notes = "get all workers profile")
    public ResponseEntity<List<Worker>> getUser() {
        return workerService.getAll();
    }

    @RequestMapping(value = "/workers/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Remove worker", notes = "Remove worker by id")
    public ResponseEntity<Worker> deleteWorker(
            @ApiParam(value = "worker id", required = true)
            @PathVariable("id") long id) {
        return workerService.delete(id);
    }


    @RequestMapping(value = "/workers/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get worker", notes = "Get worker by id")
    public ResponseEntity<Worker> getUser(
            @ApiParam(value = "worker id", required = true)
            @PathVariable("id") Long id) {

        Worker byId = workerService.getById(id);
        return new ResponseEntity<Worker>(byId, HttpStatus.OK);
    }

    @RequestMapping(value = "/workers/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "Update worker", notes = "Update worker")
    public ResponseEntity<Worker> updateWorker(@PathVariable("id") long id, @RequestBody Worker worker) {
        return workerService.update(id, worker);
    }

}
