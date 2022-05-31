package com.nttdata.bootcamp.controller;

import com.nttdata.bootcamp.entitys.Customer;
import com.nttdata.bootcamp.server.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CustomerController {

    private final CustomerService service;



    @PostMapping("/add")
    public Mono<Customer> registrar(@RequestBody Customer customer){
        log.info("creando tipo de usuario");
        return service.save(customer);
    }

    @GetMapping("/listar")
    public Flux<Customer> listAll(){
        log.info("listando los usuarios");
        return service.findAll();
    }


    @GetMapping("/listar/{id}")
    public Mono<Customer> listById(@PathVariable String id){
        log.info("buscando tipo de usuario por ID");
        return service.findById(id);
    }

    @PutMapping("/actualizar/{id}")
    public Mono<Customer> putById(@PathVariable String id, @RequestBody Customer customer){
        log.info("Actualizando usuario por Id");
        return service.updateById(id, customer);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteById(@PathVariable String id){
        log.info("Eliminando usuario por Id");
        return service.delete(id);
    }
}
