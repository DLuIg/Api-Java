package fiap.tds.repositories;

import fiap.tds.models.Maquinista;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MaquinistaRepository implements PanacheRepository<Maquinista> {

}
