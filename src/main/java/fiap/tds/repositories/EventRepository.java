package fiap.tds.repositories;

import fiap.tds.models.Event;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EventRepository implements PanacheRepository<Event> {
}
