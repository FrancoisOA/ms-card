package pe.com.bootcamp.microservice.card.service;

import pe.com.bootcamp.microservice.card.entity.Card;
import pe.com.bootcamp.microservice.card.model.Account;
import reactor.core.publisher.Mono;

public interface CardService extends CrudService<Card, String> {
	Mono<Account> getAccount(String idAccount);
	 Mono<Card> findByBankAccount(String num);
}
