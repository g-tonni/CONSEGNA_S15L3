package giada_tonni.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "eventi")
public class Evento {

    @Id
    @GeneratedValue
    @Column(name = "evento_id")
    private UUID eventoId;

    @Column(name = "titolo", nullable = false, length = 30)
    private String titolo;

    @Column(name = "data_evento", nullable = false)
    private LocalDate dataEvento;

    @Column(name = "descrizione", nullable = false, columnDefinition = "TEXT")
    private String descrizione;

    @Column(name = "tipo_evento", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;

    @Column(name = "max_persone", nullable = false)
    private int maxPersone;

    @OneToMany(mappedBy = "evento")
    private List<Partecipazione> listaPartecipazioni;

    // COSTRUTTORI

    public Evento(){}

    public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int maxPersone) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.maxPersone = maxPersone;
    }

    // GETTER E SETTER

    public UUID getId() {
        return eventoId;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getMaxPersone() {
        return maxPersone;
    }

    public void setMaxPersone(int maxPersone) {
        this.maxPersone = maxPersone;
    }

    // STAMPA


    @Override
    public String toString() {
        return "Evento{" +
                "id=" + eventoId +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", maxPersone=" + maxPersone +
                '}';
    }
}
