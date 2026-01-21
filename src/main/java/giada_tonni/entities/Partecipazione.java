package giada_tonni.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {

    @Id
    @GeneratedValue
    @Column(name = "partecipazione_id")
    private UUID partecipazioneId;

    @Column(name = "stato")
    @Enumerated(EnumType.STRING)
    private StatoPartecipazione stato;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    public Partecipazione(){}

    public Partecipazione(StatoPartecipazione stato, Evento evento, Persona persona){
        this.stato = stato;
        this.evento = evento;
        this.persona = persona;
    }

    public UUID getPartecipazioneId() {
        return partecipazioneId;
    }

    public StatoPartecipazione getStato() {
        return stato;
    }

    public void setStato(StatoPartecipazione stato) {
        this.stato = stato;
    }

    public Evento getEvento() {
        return evento;
    }

    public Persona getPersona() {
        return persona;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "partecipazioneId=" + partecipazioneId +
                ", stato=" + stato +
                ", evento=" + evento +
                ", persona=" + persona +
                '}';
    }
}
