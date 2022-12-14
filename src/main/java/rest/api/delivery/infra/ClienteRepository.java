package rest.api.delivery.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import rest.api.delivery.domain.cliente.Cliente;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByEmail(String email);
}
