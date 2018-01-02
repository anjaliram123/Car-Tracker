package com.mySpringApp.Repository;

import com.mySpringApp.Entity.Vehicles;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    @PersistenceContext
    private EntityManager em;

        public List<Vehicles> findAll(){
            TypedQuery<Vehicles> query = em.createQuery("SELECT vh from Vehicles vh ORDER BY vh.year DESC",
                    Vehicles.class);
            return query.getResultList();
    }
    public Vehicles findOne(String vin) {

        Vehicles vh = em.find(Vehicles.class,vin);
        return vh;
        }

    public Vehicles upsertVehicles(Vehicles v) {
        em.persist(v);
            return v;
    }

    public Vehicles update(String vin, Vehicles v) {
        em.merge(v);
        return v;
    }

    public void delete(String vin) {
            em.remove(vin);

            }
}
