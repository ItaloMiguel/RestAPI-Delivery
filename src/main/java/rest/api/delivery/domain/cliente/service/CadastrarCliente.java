package rest.api.delivery.domain.cliente.service;

import rest.api.delivery.domain.cliente.CadastrarClienteRequest;

public interface CadastrarCliente {

    void execute(CadastrarClienteRequest request);
}
