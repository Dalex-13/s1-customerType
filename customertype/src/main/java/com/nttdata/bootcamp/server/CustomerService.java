package com.nttdata.bootcamp.server;

import com.nttdata.bootcamp.entitys.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

    public Flux<Customer> findAll();

    public Mono<Customer> findById(String id);

    public Mono<Customer> save(Customer customer);

    public Mono<Customer> updateById(String id, Customer customer);

    public Mono<Void> delete(String id);
}
