package giada_tonni;

import giada_tonni.DAO.EventiDAO;
import giada_tonni.entities.Evento;
import giada_tonni.entities.TipoEvento;
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

        LocalDate d1 = LocalDate.of(2026, 2, 1);

        Evento e1 = new Evento("Matrimonio", d1, "Un bellissimo matrimonio", TipoEvento.PRIVATO, 300);
        Evento e2 = new Evento("Anniversario", d1, "Anniversario stupendo", TipoEvento.PUBBLICO, 500);
        Evento e3 = new Evento("Comunione", d1, "Comunione speciale", TipoEvento.PRIVATO, 200);
        /* ed.save(e1);
        ed.save(e2);
        ed.save(e3);*/

      /*  try {
            Evento eventoTrovato = ed.findById(2);
            System.out.println(eventoTrovato);
        } catch (NotFoundException ex){
            System.out.println(ex.getMessage());
        }

        try {
            ed.deleteById(4);
        } catch (NotFoundException ex){
            System.out.println(ex.getMessage());
        }*/

        emf.close();
        entityManager.close();
    }
}
