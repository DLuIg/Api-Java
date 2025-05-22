package fiap.tds.DTOS;

import fiap.tds.models.TypeEvent;

public class EventDTO {
    private TypeEvent nome;

    public EventDTO() {
    }

    public EventDTO(TypeEvent nome) {
        this.nome = nome;
    }

    public TypeEvent getNome() {
        return nome;
    }

    public void setNome(TypeEvent nome) {
        this.nome = nome;
    }
}

