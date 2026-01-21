package giada_tonni.DAO;

import giada_tonni.entities.Partecipazione;
import giada_tonni.exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PartecipazioniDAO {
    private final EntityManager entityManager;

    public PartecipazioniDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void save(Partecipazione partecipazione){
        // 1. Creare la transazione
        EntityTransaction transaction = entityManager.getTransaction();

        // 2. Aprire la transazione
        transaction.begin();

        // 3. Fare il persist
        entityManager.persist(partecipazione);

        // 4. Fare il commit
        transaction.commit();

        // 5. Log di controllo
        System.out.println("Partecipazione salvata");
    }

    public Partecipazione findPartecipazioneById(String id) throws NotFoundException {
        Partecipazione found = entityManager.find(Partecipazione.class, UUID.fromString(id));
        if(found == null) throw new NotFoundException(id);
        return found;
    }

    public void deletePartecipazioneById(String id) {
        // 1. Trovare l'evento da eliminare
        Partecipazione found = this.findPartecipazioneById(id);

        // 2. Creare una transazione
        EntityTransaction transaction = entityManager.getTransaction();

        // 3. Aprire la transazione
        transaction.begin();

        // 4. Rimuovere l'oggetto con un remove
        entityManager.remove(found);

        // 5. Fare il commit
        transaction.commit();

        // 6. Log di controllo
        System.out.println("Partecipazione eliminata");
    }
}
