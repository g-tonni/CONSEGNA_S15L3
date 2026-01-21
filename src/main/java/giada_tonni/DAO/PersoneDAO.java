package giada_tonni.DAO;

import giada_tonni.entities.Persona;
import giada_tonni.exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PersoneDAO {
    private final EntityManager entityManager;

    public PersoneDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void save(Persona persona){
        // 1. Creare la transazione
        EntityTransaction transaction = entityManager.getTransaction();

        // 2. Aprire la transazione
        transaction.begin();

        // 3. Fare il persist
        entityManager.persist(persona);

        // 4. Fare il commit
        transaction.commit();

        // 5. Log di controllo
        System.out.println("Persona salvata");
    }

    public Persona findPersonaById(String id) throws NotFoundException {
        Persona found = entityManager.find(Persona.class, UUID.fromString(id));
        if(found == null) throw new NotFoundException(id);
        return found;
    }

    public void deletePersonaById(String id) {
        // 1. Trovare l'evento da eliminare
        Persona found = this.findPersonaById(id);

        // 2. Creare una transazione
        EntityTransaction transaction = entityManager.getTransaction();

        // 3. Aprire la transazione
        transaction.begin();

        // 4. Rimuovere l'oggetto con un remove
        entityManager.remove(found);

        // 5. Fare il commit
        transaction.commit();

        // 6. Log di controllo
        System.out.println("Persona eliminata");
    }
}
