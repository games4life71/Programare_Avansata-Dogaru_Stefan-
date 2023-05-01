package Repositories;

import Entities.GenreEntity;
import jakarta.persistence.EntityManager;

import java.util.List;

public class GenreRepository
{

    EntityManager entityManager;
    public GenreRepository(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    public void create(GenreEntity genreEntity)
    {
        entityManager.persist(genreEntity);

    }

    public List<GenreEntity> findByName(String name)
    {
        return entityManager.createNamedQuery("GenreEntity.findByName", GenreEntity.class)
                .setParameter("name", name)
                .getResultList();
    }
    public List<GenreEntity> findAll()
    {
        return entityManager.createNamedQuery("GenreEntity.findAll", GenreEntity.class)
                .getResultList();
    }

}
