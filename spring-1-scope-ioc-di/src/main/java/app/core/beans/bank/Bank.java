package app.core.beans.bank;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Bank {

	@Value("${bank.code: 555}")
	private int code;
	@Value("${bank.name}")
	private String name;
	@Value("${bank.address}")
	private String address;

}
