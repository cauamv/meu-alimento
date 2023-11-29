package br.com.senai.gestaoDeCadastroFront.client.decode;

import java.security.Key;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class TokenDecoder {
	
	private final String SECRET = "36763979244226452948404D635166546A576D5A7134743777217A25432A462D";
	
	public String extrairIdRestauranteDo(String tokenGerado) {
		Claims detalhes = extrairDetalhesDo(tokenGerado);
		System.out.println(detalhes.toString());
		return detalhes.get("idDoRestaurante", String.class);
	}
	
	public String extrairIdRoleDo(String tokenGerado) {
		Claims detalhes = extrairDetalhesDo(tokenGerado);
		System.out.println(detalhes.toString());
		return detalhes.get("role", String.class);
	}
	
	private Key getChaveDeAssinatura() {
		byte[] keyByte = Decoders.BASE64.decode(SECRET);
		return Keys.hmacShaKeyFor(keyByte);
	}
	
	private Claims extrairDetalhesDo(String tokenGerada) {
		return Jwts.parserBuilder()
				.setSigningKey(getChaveDeAssinatura())
				.build()
				.parseClaimsJws(tokenGerada)
				.getBody();
	}
}
