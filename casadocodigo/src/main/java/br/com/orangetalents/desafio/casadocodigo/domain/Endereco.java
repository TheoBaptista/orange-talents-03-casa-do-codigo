package br.com.orangetalents.desafio.casadocodigo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @NotBlank
    private String logradouro;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotBlank
    private String cep;

    @ManyToOne
    private Estado estado;

    @NotNull
    @ManyToOne
    private Pais pais;

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}
