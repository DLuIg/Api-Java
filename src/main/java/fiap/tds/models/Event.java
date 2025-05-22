package fiap.tds.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "event")
public class Event extends PanacheEntity {
    @Enumerated(EnumType.STRING)
    private TypeEvent nome;

    public Event() {
    }

    public Event(TypeEvent nome) {
        this.nome = nome;
    }

    public TypeEvent getNome() {
        return nome;
    }

    public void setNome(TypeEvent nome) {
        this.nome = nome;
    }
}
