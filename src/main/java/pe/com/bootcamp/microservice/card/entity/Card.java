package pe.com.bootcamp.microservice.card.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Document(collection = "tb_withdraw")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Card {
	@Id
	private String id;
	private String idAccount;// id cuenta asociada
	private String typeCard;// debito, credito
	private String numDocUser; //documento de usuario
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date dateCard; //fecha transaccion	
	private Boolean status;
}