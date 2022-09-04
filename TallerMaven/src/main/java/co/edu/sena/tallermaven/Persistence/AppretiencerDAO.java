/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.tallermaven.Persistence;

import co.edu.sena.tallermaven.model.Apprentice;
import co.edu.sena.tallermaven.persistence.EntityManagerHelper;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Aprendiz
 */
public class AppretiencerDAO implements IAppretiencerDAO{

    @Override
    public void insert(Apprentice apprentice) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(apprentice);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(Apprentice apprentice) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(apprentice);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(Apprentice apprentice) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(apprentice);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Apprentice findApprentice(Long Document) throws Exception {
        try {
           return EntityManagerHelper.getEntityManager().find(Apprentice.class, Document);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Apprentice> findAllApprentices() throws Exception {
        try {
            Query query= EntityManagerHelper.getEntityManager().createQuery("SELECT a FROM Apprentice a");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
