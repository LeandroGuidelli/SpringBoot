package br.com.aweb.sistema_vendas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    @Column(nullable = false, length = 255, unique = true)
    private String email;

    @NotNull(message = "CPF é obrigatório.")
    @Size(min = 11, max = 11, message = "O CPF deve ter exatamente 11 dígitos.")
    @Column(nullable = false, length = 11, unique = true)
    private String cpf;

    @NotNull(message = "Telefone é obrigatório.")
    @Column(nullable = false)
    private Long telefone;

    // Endereço detalhado
    @NotBlank(message = "Logradouro é obrigatório")
    @Column(nullable = false, length = 150)
    private String logradouro;

    @Column(nullable = true, length = 10)
    private String numero; // opcional

    @Column(nullable = true, length = 50)
    private String complemento; // opcional

    @NotBlank(message = "Bairro é obrigatório")
    @Column(nullable = false, length = 100)
    private String bairro;

    @NotBlank(message = "Cidade é obrigatório")
    @Column(nullable = false, length = 100)
    private String cidade;

    @NotBlank(message = "UF é obrigatório")
    @Size(min = 2, max = 2, message = "A UF deve ter 2 caracteres")
    @Column(nullable = false, length = 2)
    private String uf;

    @NotBlank(message = "CEP é obrigatório")
    @Size(min = 8, max = 8, message = "O CEP deve ter 8 dígitos")
    @Column(nullable = false, length = 8)
    private String cep;
}
