/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.tallermaven.Persistence;

import co.edu.sena.tallermaven.model.LateArrival;
import co.edu.sena.tallermaven.persistence.EntityManagerHelper;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Aprendiz
 */
public class Late_ArrivalDAO implements ILate_arrivalDAO{

    @Override
    public void insert(LateArrival lateArrival) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(lateArrival);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(LateArrival lateArrival) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(lateArrival);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(LateArrival lateArrival) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(lateArrival);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public LateArrival find(Integer id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(LateArrival.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<LateArrival> findAllLateArrival() throws Exception {
        try {
            Query query = EntityManagerHelper.getEntityManager().createQuery("SELECT l FROM LateArrival l");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
