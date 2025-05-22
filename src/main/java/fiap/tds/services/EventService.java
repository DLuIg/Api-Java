package fiap.tds.services;

import fiap.tds.DTOS.EventDTO;
import fiap.tds.models.Event;
import fiap.tds.models.TypeEvent;
import fiap.tds.repositories.EventRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class EventService {
    @Inject
    EventRepository eventRepository;
    public void criarEvento(TypeEvent tipo){
        var event = new Event();
        event.setNome(tipo);
        System.out.println(event.getNome());
        eventRepository.persist(event);
    }

    public Object getAll() {
        return eventRepository.listAll();
    }
}
