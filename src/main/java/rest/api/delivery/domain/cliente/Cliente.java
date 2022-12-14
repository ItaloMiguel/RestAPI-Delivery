package rest.api.delivery.domain.cliente;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import rest.api.delivery.domain.endereco.Endereco;

@Entity
@Table(name = "clientes")
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 30)
    private String nome;

    @NotBlank
    @Size(max = 30)
    private String sobrenome;

    @NotBlank
    @Size(max = 50)
    private String email;

    @NotBlank
    @Size(min = 3, max = 20)
    private String senha;

    @Embedded
    private Endereco endereco;

    public Cliente(CadastrarClienteRequest request) {
        this.nome = request.nome();
        this.sobrenome = request.sobrenome();
        this.email = request.email();
        this.senha = request.senha();
    }
}
