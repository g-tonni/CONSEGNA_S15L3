package giada_tonni.DAO;

import giada_tonni.entities.Evento;
import giada_tonni.exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventiDAO {

     private final EntityManager entityManager;

     public EventiDAO(EntityManager entityManager){
         this.entityManager = entityManager;
     }

     public void save(Evento evento){
         // 1. Creare la transazione
         EntityTransaction transaction = entityManager.getTransaction();

         // 2. Aprire la transazione
         transaction.begin();

         // 3. Fare il persist
         entityManager.persist(evento);

         // 4. Fare il commit
         transaction.commit();

         // 5. Log di controllo
         System.out.println("Evento salvato");
     }

     public Evento findById(long id) throws NotFoundException {
         Evento found = entityManager.find(Evento.class, id);
         if(found == null) throw new NotFoundException(id);
         return found;
     }

     public void deleteById(long id){
         // 1. Trovare l'evento da eliminare
         Evento found = this.findById(id);

         // 2. Creare una transazione
         EntityTransaction transaction = entityManager.getTransaction();

         // 3. Aprire la transazione
         transaction.begin();

         // 4. Rimuovere l'oggetto con un remove
         entityManager.remove(found);

         // 5. Fare il commit
         transaction.commit();

         // 6. Log di controllo
         System.out.println("Evento eliminato");
     }


}
