package pe.com.bootcamp.microservice.card.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import pe.com.bootcamp.microservice.card.entity.Card;
import reactor.core.publisher.Mono;

@Repository
public interface ICardRepository extends ReactiveMongoRepository<Card, String>{
	Mono<Card> findByIdAccount(String idAccount);
	Mono<Card> findBytypeCard(String type);
	
}
