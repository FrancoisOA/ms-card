package pe.com.bootcamp.microservice.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.com.bootcamp.microservice.card.entity.Card;
import pe.com.bootcamp.microservice.card.service.CardService;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path="/card")
public class CardController {

    @Autowired
    CardService cardService;
 
 

    @PostMapping("/card")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Card> saveCard(@RequestBody Card card){
    	log.info("save card");
        return cardService.save(card);
    }

    @GetMapping("/card/account/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Card>getCardByBankAccount(@PathVariable String id){
    	log.info("get  card");
        return cardService.findByBankAccount(id);
    }
    
    @PutMapping("/card-update")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Card> updateCard(@RequestBody Card card){
    	log.info("update card");
        return cardService.update(card);
    }
         
}