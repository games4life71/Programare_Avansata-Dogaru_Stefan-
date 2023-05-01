import Entities.AlbumsEntity;
import Entities.GenreEntity;
import Repositories.GenreRepository;
import jakarta.persistence.EntityManager;
import Factory.MyEntityManager;

import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        EntityManager entityManager = MyEntityManager.getInstance();
        entityManager.getTransaction().begin();

        GenreRepository genreRepository = new GenreRepository(entityManager);
//        List<GenreEntity> results = genreRepository.findAll();
//
//        for (GenreEntity genreEntity : results)
//        {
//            System.out.println(genreEntity.getName());
//        }

        GenreEntity newGenre = new GenreEntity("Pop12345");
        System.out.println(newGenre.getId());
        genreRepository.create(newGenre);
       List< GenreEntity> genreEntity = genreRepository.findByName("Pop12345");
        for(GenreEntity genreEntity1 : genreEntity)
        {
            System.out.println(genreEntity1.getName());
        }
        entityManager.getTransaction().commit();
        //save the changes
        entityManager.close();




    }
}
