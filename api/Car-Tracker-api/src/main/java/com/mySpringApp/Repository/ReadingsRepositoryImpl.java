package com.mySpringApp.Repository;

import com.mySpringApp.Entity.Readings;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ReadingsRepositoryImpl implements ReadingsRepository {

    @PersistenceContext
    EntityManager em;

    public Readings getReadingsofVehicle(String vin) {
        TypedQuery<Readings> query=em.createQuery("SELECT r from Readings r WHERE r.vin=:paramvin",Readings.class);
        query.setParameter("paramvin",vin);
        List<Readings> list=query.getResultList();
        if(list!=null && list.size()==1)
        {
            return list.get(0);
        }
        else{
            return null;
        }
    }

    public Readings createReadings( Readings readings) {

         em.persist(readings);

             return readings;

    }

}
