package giada_tonni.DAO;

import giada_tonni.entities.Location;
import giada_tonni.exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class LocationsDAO {
    private final EntityManager entityManager;

    public LocationsDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void save(Location location){
        // 1. Creare la transazione
        EntityTransaction transaction = entityManager.getTransaction();

        // 2. Aprire la transazione
        transaction.begin();

        // 3. Fare il persist
        entityManager.persist(location);

        // 4. Fare il commit
        transaction.commit();

        // 5. Log di controllo
        System.out.println("Location salvata");
    }

    public Location findLocationById(String id) throws NotFoundException {
        Location found = entityManager.find(Location.class, UUID.fromString(id));
        if(found == null) throw new NotFoundException(id);
        return found;
    }

    public void deleteLocationById(String id) {
        // 1. Trovare l'evento da eliminare
        Location found = this.findLocationById(id);

        // 2. Creare una transazione
        EntityTransaction transaction = entityManager.getTransaction();

        // 3. Aprire la transazione
        transaction.begin();

        // 4. Rimuovere l'oggetto con un remove
        entityManager.remove(found);

        // 5. Fare il commit
        transaction.commit();

        // 6. Log di controllo
        System.out.println("Location eliminata");
    }
}
