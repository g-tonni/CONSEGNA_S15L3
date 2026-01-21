package giada_tonni;

import giada_tonni.DAO.EventiDAO;
import giada_tonni.DAO.LocationsDAO;
import giada_tonni.DAO.PartecipazioniDAO;
import giada_tonni.DAO.PersoneDAO;
import giada_tonni.entities.*;
import giada_tonni.exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("consegnas15l3pu");

    public static void main(String[] args) {

        EntityManager entityManager = emf.createEntityManager();

        EventiDAO ed = new EventiDAO(entityManager);
        PersoneDAO perd = new PersoneDAO(entityManager);
        LocationsDAO ld = new LocationsDAO(entityManager);
        PartecipazioniDAO pard = new PartecipazioniDAO(entityManager);

        LocalDate d1 = LocalDate.of(2026, 2, 1);

        Evento e1 = new Evento("Matrimonio", d1, "Un bellissimo matrimonio", TipoEvento.PRIVATO, 300);
        Evento e2 = new Evento("Anniversario", d1, "Anniversario stupendo", TipoEvento.PUBBLICO, 500);
        Evento e3 = new Evento("Comunione", d1, "Comunione speciale", TipoEvento.PRIVATO, 200);
        /* ed.save(e1);
        ed.save(e2);
        ed.save(e3);*/

        Persona p1 = new Persona("Giada", "Tonni", "gtonni@gmail.com", Sesso.F);
        Persona p2 = new Persona("Mario", "Rossi", "mrossi@gmail.com", Sesso.M);
        Persona p3 = new Persona("Luigi", "Bianchi", "lbianchi@gmail.com", Sesso.M);
        /* perd.save(p1);
        perd.save(p2);
        perd.save(p3);*/

        try {
            Evento eventoTrovato1 = ed.findEventoById("76214a6e-5a0c-4252-8140-b18fdb6b1b6c");
            System.out.println(eventoTrovato1);
            Persona personaTrovata1 = perd.findPersonaById("6c938cb1-d7c0-45e1-81b9-204ce0b2816c");
            System.out.println(personaTrovata1);
            Partecipazione partecipazione1 = new Partecipazione(StatoPartecipazione.CONFERMATA, eventoTrovato1, personaTrovata1);
            pard.save(partecipazione1);
        } catch (NotFoundException ex){
            System.out.println(ex.getMessage());
        }

        emf.close();
        entityManager.close();
    }
}
