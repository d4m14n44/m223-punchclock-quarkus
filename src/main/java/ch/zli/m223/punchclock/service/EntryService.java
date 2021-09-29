package ch.zli.m223.punchclock.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.punchclock.domain.Entry;
import io.quarkus.security.Authenticated;

// Es existiert nur eine Instanz
@ApplicationScoped
public class EntryService {
    // Service = Verbindung zur DB
    @Inject
    private EntityManager entityManager;

    public EntryService() {
    }

    @Transactional 
    public Entry createEntry(Entry entry) {
        entityManager.persist(entry);
        return entry;
    }

    @SuppressWarnings("unchecked")
    public List<Entry> findAll() {
        var query = entityManager.createQuery("FROM Entry");
        return query.getResultList();
    }

    public Entry getEntry(Long id) {
        // entityManager = Schnittstelle zur DB
        // find(entry.class) => Damit klar ist, nach was in der DB gsucht werden soll
        return entityManager.find(Entry.class, id);
    }

    // Braucht man wenn man Daten verändern
    @Transactional
    public void delete(Long id) {
        Entry e = getEntry(id);
        entityManager.remove(e);
    }

    @Transactional
    public Entry update(Entry entry) {
        // Auf die ID verglichen Mergen aufgrund ihrer ID
        entityManager.merge(entry);
        return entry;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
