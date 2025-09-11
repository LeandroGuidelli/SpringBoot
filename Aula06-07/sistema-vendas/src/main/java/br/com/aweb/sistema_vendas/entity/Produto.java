package br.com.aweb.sistema_vendas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 100)
    @NotBlank(message = "Nome é obrigatório e deve ter entre 3 e 100 caracteres")
    @Column(length = 100, nullable = false)
    private String nome;

    @NotBlank(message = "Descrição é obrigatória")
    @Column(length = 1000, nullable = false)
    private String descricao;

    @NotNull(message = "Preço é obrigatório")
    @Positive(message = "Valor deve ser maior que 0")
    @Column(nullable = false)
    private Double preco;

    @NotNull(message = "Quantidade é obrigatória")
    @PositiveOrZero(message = "Quantidade deve ser maior ou igual a 0")
    @Column(nullable = false)
    private Integer quantidade;
}
