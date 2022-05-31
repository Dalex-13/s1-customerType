package com.nttdata.bootcamp.server;

import com.nttdata.bootcamp.entitys.Customer;
import com.nttdata.bootcamp.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Override
    public Flux<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Customer> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<Customer> save(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Mono<Customer> updateById(String id, Customer customer) {
        return this.findById(id)
                .flatMap(entity -> this.save(customer))
                .switchIfEmpty( Mono.error(new Exception()));
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }

}
