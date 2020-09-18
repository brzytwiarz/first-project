package io.mbab.sda.groupproject.repository;

import io.mbab.sda.groupproject.entity.Album;
import io.mbab.sda.groupproject.entity.Song;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
public class SongRepository implements CrudRepository<Song, Integer> {

    private final EntityManager em;

    @Override
    public List<Song> getAll() {
        return em.createQuery("FROM Song", Song.class)
                .getResultList();
    }



    @Override
    public Song findById(Integer id) {
        return null;
    }

    @Override
    public Song create(Song entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return entity;
    }

    @Override
    public Song update(Song entity) {
        return null;
    }

    @Override
    public void delete(Integer o) {}

    public Album getAlbumById(Integer id) {
        em.getTransaction().begin();
        Album album = em.find(Album.class, id);
        em.getTransaction().commit();
        return album;
    }
}
