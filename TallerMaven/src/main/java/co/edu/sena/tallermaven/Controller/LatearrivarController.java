/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.tallermaven.controller;

import co.edu.sena.tallermaven.model.LateArrival;
import co.edu.sena.tallermaven.persistence.DAOFactory;
import co.edu.sena.tallermaven.persistence.EntityManagerHelper;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public class LatearrivarController {
        public void validate (LateArrival lateArrival) throws Exception{
        if(lateArrival.getDateArrival()== null){
            throw new Exception ("El nombre de la carrera es obligatorio");
        }
        if(lateArrival.getObservations()== null){
            throw new Exception ("La observación es obligatorio");
        }
        if(lateArrival.getDocumentApprentice()== null){
            throw new Exception ("El documento del aprendiz es obligatorio");
        }        
    }

    public void insert (LateArrival lateArrival) throws Exception{
        validate(lateArrival);
        EntityManagerHelper.beginTransaction();
        DAOFactory.getLatearrivarDAO().insert(lateArrival);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }    
    
        public void update (LateArrival lateArrival) throws Exception{
        validate(lateArrival);
        LateArrival oldLateArrival = DAOFactory.getLatearrivarDAO().find(lateArrival.getId());
        if(oldLateArrival == null){
            throw new Exception ("No existe observación a modificar");
        }
        
        //merge
        oldLateArrival.setDateArrival(lateArrival.getDateArrival());
        oldLateArrival.setObservations(lateArrival.getObservations());
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getLatearrivarDAO().update(oldLateArrival);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }
             
    public void  delete (LateArrival lateArrival) throws Exception{
        if(lateArrival.getDateArrival()== null){
            throw new Exception ("La fecha es obligatorio");
        }
        LateArrival oldLateArrivald = DAOFactory.getLatearrivarDAO().find(lateArrival.getId());
        if(oldLateArrivald == null){
            throw new Exception ("No esta la observación a eliminar");
        }
        
        //merge;
        oldLateArrivald.setDateArrival(lateArrival.getDateArrival());
        oldLateArrivald.setObservations(lateArrival.getObservations());

        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getLatearrivarDAO().delete(oldLateArrivald);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }
    
    public LateArrival find(Integer id) throws Exception{
        if(id == null){
            throw new Exception ("La observación es obligatorio");
        }
        return DAOFactory.getLatearrivarDAO().find(id);
    }
    
    public List<LateArrival> findAll() throws Exception{
        return DAOFactory.getLatearrivarDAO().findAllLateArrival();
    }    
}
