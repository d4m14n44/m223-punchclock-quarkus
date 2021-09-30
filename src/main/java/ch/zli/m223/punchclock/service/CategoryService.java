package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Category;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

// Gleiche Methoden einfach mit anderen Daten implementieren
@ApplicationScoped
public class CategoryService {

    @Inject
    private EntityManager entityManager;

    @Transactional
    public Category createCategory(Category category) {
        this.entityManager.persist(category);
        return category;
    }

    @SuppressWarnings("unchecked")
    public List<Category> findAll() {
        var query = this.entityManager.createQuery("FROM Category");
        return query.getResultList();
    }

    public Category getCategory(Long Id) {
        return this.entityManager.find(Category.class, Id);
    }

    @Transactional
    public void delete(Long Id) {
        Category category = getCategory(Id);
        this.entityManager.remove(category);
    }

    @Transactional
    public Category update(Category category) {
        this.entityManager.merge(category);
        return category;
    }

    public EntityManager getEntityManager() {
        return this.entityManager;
    }

}
