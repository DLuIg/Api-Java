package fiap.tds.services;

import fiap.tds.models.Maquinista;
import fiap.tds.repositories.MaquinistaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class MaquinistaService {

    private static final Logger LOGGER = Logger.getLogger(MaquinistaService.class);

    @Inject
    MaquinistaRepository maquinistaRepository;

    public boolean autenticar(String email, String senha) {
        try {
            Optional<Maquinista> maquinista = maquinistaRepository.find("email", email).firstResultOptional();
            if (maquinista.isEmpty()) {
                return false;
            }
            Maquinista maquinista1 = maquinista.get();
            return maquinista1.getSenha().equals(senha);
        } catch (Exception e) {
            LOGGER.error("Erro ao autenticar maquinista com email: " + email, e);
            return false;
        }
    }

    public List<Maquinista> getAll() {
        try {
            return maquinistaRepository.findAll().list();
        } catch (Exception e) {
            LOGGER.error("Erro ao buscar todos os maquinistas", e);
            return List.of(); // retorna lista vazia em caso de erro
        }
    }
}