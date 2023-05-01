package Factory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class MyEntityManager
{
    private static EntityManager entityManager ;

    private MyEntityManager()
    {

    }
    public  static EntityManager getInstance()
    {
        if(entityManager == null)
        {
            EntityManagerFactory entityManagerFactory = jakarta.persistence.Persistence.createEntityManagerFactory("music");
            entityManager = (EntityManager) entityManagerFactory.createEntityManager();
         return    entityManager;
        }
        return entityManager;
    }
    public static void close()
    {
        entityManager.close();
    }
}
