package pe.com.bootcamp.microservice.card.service;

import reactor.core.publisher.Mono;

public interface CrudService <T, ID>{
    Mono<T> save(T t);
    Mono<T> update(T t);
    Mono<T> deleteById(ID id);
}
