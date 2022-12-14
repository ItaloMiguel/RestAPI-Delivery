package rest.api.delivery.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.api.delivery.domain.cliente.CadastrarClienteRequest;
import rest.api.delivery.domain.cliente.service.CadastrarCliente;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    private final CadastrarCliente cadastrarCliente;

    public ClienteController(CadastrarCliente cadastrarCliente) {
        this.cadastrarCliente = cadastrarCliente;
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody CadastrarClienteRequest request) {
        cadastrarCliente.execute(request);
        return ResponseEntity.ok().body("Cadastro realizado com sucesso!");
    }
}
