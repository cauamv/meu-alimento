package br.com.senai.gestaoDeCadastroFront.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class UsuarioDto {

	private Integer id;
	
	@NotBlank(message = "O email é obrigatório")
	private String email;
	
	@NotBlank(message = "A senha é obrigatória")
	private String senha;
	
	@NotBlank(message = "A papel é obrigatório")
	private String role;
	
	public boolean isPersistida() {
		return getId() != null && getId() > 0;
	}
	
}
