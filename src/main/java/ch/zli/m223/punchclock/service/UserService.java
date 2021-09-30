package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    private EntityManager entityManager;

    @Transactional
    public User createUser(User user) {
        this.entityManager.persist(user);
        return user;
    }

    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        var query = this.entityManager.createQuery("FROM User");
        return query.getResultList();
    }

    public User getUser(Long Id) {
        return this.entityManager.find(User.class, Id);
    }

    @Transactional
    public void delete(Long Id) {
        User user = getUser(Id);
        this.entityManager.remove(user);
    }

    @Transactional
    public User update(User user) {
        this.entityManager.merge(user);
        return user;
    }

    public EntityManager getEntityManager() {
        return this.entityManager;
    }

}
