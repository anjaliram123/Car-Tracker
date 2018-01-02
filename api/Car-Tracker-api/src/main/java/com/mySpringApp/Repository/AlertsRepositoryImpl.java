package com.mySpringApp.Repository;


import com.mySpringApp.Entity.Alerts;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AlertsRepositoryImpl  implements AlertsRepository {

    @PersistenceContext
    EntityManager em;

    public List<Alerts> findAllAlerts() {

        TypedQuery<Alerts> query =em.createQuery("SELECT al from Alerts al ORDER BY al.timestamp",Alerts.class);
        List<Alerts> list= query.getResultList();
        return list;
    }

    public Alerts findAlertsofVehicle(String vin)
    {
       TypedQuery<Alerts> query = em.createQuery("SELECT a from Alerts a WHERE a.vin=:paramvin",Alerts.class);
            query.setParameter("paramvin",vin);
        List<Alerts> list = query.getResultList();
        if(list!=null && list.size()==1)
        {
            return list.get(0);
        }
        else{
            return null;
        }
    }

    public Alerts createAlerts(Alerts alerts)
    {
         em.persist(alerts);

         return alerts;
         }
}
