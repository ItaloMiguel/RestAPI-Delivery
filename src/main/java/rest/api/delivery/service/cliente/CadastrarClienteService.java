package rest.api.delivery.service.cliente;

import org.springframework.stereotype.Service;
import rest.api.delivery.application.exception.EmailAlreadExistException;
import rest.api.delivery.domain.cliente.CadastrarClienteRequest;
import rest.api.delivery.domain.cliente.Cliente;
import rest.api.delivery.domain.cliente.service.CadastrarCliente;
import rest.api.delivery.infra.ClienteRepository;

import java.util.Optional;

@Service
public class CadastrarClienteService implements CadastrarCliente {

    private final ClienteRepository repository;

    public CadastrarClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(CadastrarClienteRequest request) {
        verificaSeEmailExiste(request.email());
        Cliente cliente = new Cliente(request);
    }

    private void verificaSeEmailExiste(String email) {
        boolean emailBoolean = repository.existsByEmail(email);
        if(emailBoolean) {
            throw new EmailAlreadExistException(email);
        }
    }
}
