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

        Location l1 = new Location("Villa bellissima", "Roma");
        Location l2 = new Location("Villa antica", "Firenze");
        Location l3 = new Location("Villa con piscina", "Napoli");
       /* ld.save(l1);
        ld.save(l2);
        ld.save(l3);*/

        /*try {
            Location locationTrovata1 = ld.findLocationById("376d1984-c758-4807-a408-a8df38db5997");
            Location locationTrovata2 = ld.findLocationById("c7a58577-b426-49e1-8ca8-91a882265473");
            Location locationTrovata3 = ld.findLocationById("d37ff236-4a0f-4b42-9560-a65d77d144a2");
            Evento e1 = new Evento("Matrimonio", d1, "Un bellissimo matrimonio", TipoEvento.PRIVATO, 300, locationTrovata1);
            Evento e2 = new Evento("Anniversario", d1, "Anniversario stupendo", TipoEvento.PUBBLICO, 500, locationTrovata2);
            Evento e3 = new Evento("Comunione", d1, "Comunione speciale", TipoEvento.PRIVATO, 200, locationTrovata3);
            ed.save(e1);
            ed.save(e2);
            ed.save(e3);
        } catch (NotFoundException ex){
            System.out.println(ex.getMessage());
        }*/


        Persona p1 = new Persona("Giada", "Tonni", "gtonni@gmail.com", Sesso.F);
        Persona p2 = new Persona("Mario", "Rossi", "mrossi@gmail.com", Sesso.M);
        Persona p3 = new Persona("Luigi", "Bianchi", "lbianchi@gmail.com", Sesso.M);
        /* perd.save(p1);
        perd.save(p2);
        perd.save(p3);*/

        try {
            Evento eventoTrovato1 = ed.findEventoById("347f07ad-bbfe-47a9-a9e0-1b8f2624ea0e");
            System.out.println(eventoTrovato1);
            Persona personaTrovata1 = perd.findPersonaById("6016857c-8da0-498e-8794-6679b18f2321");
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
