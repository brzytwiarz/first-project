package io.mbab.sda.groupproject.repository;

import io.mbab.sda.groupproject.entity.Album;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
public class AlbumRepository implements CrudRepository<Album, Integer> {

    private final EntityManager em;

    @Override
    public List<Album> getAll() {
        return em.createQuery("FROM Album", Album.class)
                .getResultList();
    }

    @Override
    public Album findById(Integer id) {
        return null;
    }

    @Override
    public Album create(Album entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return entity;
    }

    @Override
    public Album update(Album entity) {
        return null;
    }

    @Override
    public void delete(Integer o) {}
}
