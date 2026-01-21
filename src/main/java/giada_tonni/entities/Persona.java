package giada_tonni.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "persone")
public class Persona {
    @Id
    @GeneratedValue
    @Column(name = "persona_id")
    private UUID personaId;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "email")
    private String email;

    @Column(name = "sesso")
    @Enumerated(EnumType.STRING)
    private Sesso sesso;

    @OneToMany(mappedBy = "persona")
    private List<Partecipazione> listaPartecipazioni;

    public Persona(){}

    public Persona(String nome, String cognome, String email, Sesso sesso){
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.sesso = sesso;
    }

    public UUID getPersonaId() {
        return personaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }

    public List<Partecipazione> getListaPartecipazioni() {
        return listaPartecipazioni;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "personaId=" + personaId +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", sesso=" + sesso +
                '}';
    }
}
