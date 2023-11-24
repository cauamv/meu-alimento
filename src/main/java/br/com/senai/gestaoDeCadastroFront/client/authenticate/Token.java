package br.com.senai.gestaoDeCadastroFront.client.authenticate;

import java.time.LocalDateTime;

public class Token {

	private String valor;

	private LocalDateTime criadoEm;

	public Token(String valor) {
		this.valor = valor;
		this.criadoEm = LocalDateTime.now();
	}

	public String getValor() {
		return valor;
	}

	public boolean isExpirado() {
		LocalDateTime expiraEm = criadoEm.plusMinutes(5);
		LocalDateTime agora = LocalDateTime.now();
		return agora.isAfter(expiraEm);
	}

}
