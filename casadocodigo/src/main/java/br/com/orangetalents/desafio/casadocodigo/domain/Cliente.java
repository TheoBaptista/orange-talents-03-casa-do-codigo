package br.com.orangetalents.desafio.casadocodigo.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    private String documento;

    @NotBlank
    private String telefone;

    @NotNull
    @Embedded
    private Endereco endereco;

    public Cliente(String email, String nome, String sobrenome, String documento, String telefone, Endereco endereco) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.telefone = telefone;
        this.endereco = endereco;
    }

}
