package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.domain.Location;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.Path;
import java.util.List;

// Gleiche Methoden einfach mit anderen Daten implementieren
@ApplicationScoped

public class LocationService {

    @Inject
    private EntityManager entityManager;

    @Transactional
    public Location createLocation(Location location) {
        this.entityManager.persist(location);
        return location;
    }

    @SuppressWarnings("unchecked")
    public List<Location> findAll() {
        var query = this.entityManager.createQuery("FROM Location");
        return query.getResultList();
    }

    public Location getLocation(Long Id) {
        return this.entityManager.find(Location.class, Id);
    }

    @Transactional
    public void delete(Long Id) {
        Location l = getLocation(Id);
        this.entityManager.remove(l);
    }

    @Transactional
    public Location update(Location location) {
        this.entityManager.merge(location);
        return location;
    }

    public EntityManager getEntityManager() {
        return this.entityManager;
    }
}
