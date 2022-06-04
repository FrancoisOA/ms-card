package pe.com.bootcamp.microservice.card.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.com.bootcamp.microservice.card.config.WebclientConfig;
import pe.com.bootcamp.microservice.card.entity.Card;
import pe.com.bootcamp.microservice.card.model.Account;
import pe.com.bootcamp.microservice.card.repository.ICardRepository;
import pe.com.bootcamp.microservice.card.service.CardService;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

	@Autowired
	ICardRepository cardRepo;

	private WebclientConfig webclient = new WebclientConfig();

 

	@Override
	public Mono<Card> save(Card tran) {
		log.info("save card");
		tran.setStatus(true);
		tran.setDateCard(new Date());
		return cardRepo.save(tran);
	}

	@Override
	public Mono<Card> update(Card t) {
		log.info("update card");
		return cardRepo.findById(t.getId()).switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NO_CONTENT))).flatMap(o -> {
			if (t.getIdAccount() != null) {
				o.setIdAccount(t.getIdAccount());
			}
			if (t.getTypeCard()!= null) {
				o.setTypeCard(t.getTypeCard());
			}
			if (t.getNumDocUser() != null) {
				o.setNumDocUser(t.getNumDocUser());
			}
			if (t.getStatus() != null) {
				o.setStatus(t.getStatus());
			}
			return cardRepo.save(o);
		});
	}

	@Override
	public Mono<Card> deleteById(String id) {
		log.info("delete card");
		return cardRepo.findById(id).switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NO_CONTENT))).flatMap(o -> {
			o.setStatus(false);
			return cardRepo.save(o);
		});
	}

	@Override
	public Mono<Card> findByBankAccount(String num) {
		return cardRepo.findByIdAccount(num);
	}

	@Override
	public Mono<Account> getAccount(String idAccount) {
		return webclient.getAccount(idAccount);
	}

 
}
