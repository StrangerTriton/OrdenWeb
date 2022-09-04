/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.tallermaven.controller;

import co.edu.sena.tallermaven.model.Apprentice;
import co.edu.sena.tallermaven.persistence.DAOFactory;
import co.edu.sena.tallermaven.persistence.EntityManagerHelper;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public class ApprenticeController {
    public void validate (Apprentice apprentice) throws Exception{
        if(apprentice == null){
            throw new Exception ("El aprendiz es obligatoria");
        }
        if(apprentice.getDocument()== null){
            throw new Exception ("El documento es obligatorio");
        }
        if(apprentice.getFullName()== null){
            throw new Exception ("El nombre completo es obligatorio");
        }        
        if(apprentice.getIdCourse()== null){
            throw new Exception ("El número de ficha es obligatoria");
        }
    }

    public void insert (Apprentice apprentice) throws Exception{
        validate(apprentice);
        EntityManagerHelper.beginTransaction();
        DAOFactory.getApprenticeDAO().insert(apprentice);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }    
    
        public void update (Apprentice apprentice) throws Exception{
        validate(apprentice);
        Apprentice oldApprentice = DAOFactory.getApprenticeDAO().findApprentice(apprentice.getDocument());
        if(oldApprentice == null){
            throw new Exception ("No existe el aprendiz a modificar");
        }
        
        //merge
        oldApprentice.setDocument(apprentice.getDocument());
        oldApprentice.setFullName(apprentice.getFullName());
        oldApprentice.setIdCourse(apprentice.getIdCourse());
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getApprenticeDAO().update(oldApprentice);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }
        
    public void  delete (Apprentice apprentice) throws Exception{
        if(apprentice.getDocument()== 0){
            throw new Exception ("El documento es obligatorio");
        }
        Apprentice oldApprentice = DAOFactory.getApprenticeDAO().findApprentice(apprentice.getDocument());
        if(oldApprentice == null){
            throw new Exception ("No existe el aprendiz a eliminar");
        }
        
        //merge;
        oldApprentice.setDocument(apprentice.getDocument());
        oldApprentice.setFullName(apprentice.getFullName());
        oldApprentice.setIdCourse(apprentice.getIdCourse());
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getApprenticeDAO().update(oldApprentice);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }        
       
    public Apprentice find(Long document) throws Exception{
        if(document == null){
            throw new Exception ("El documento es obligatorio");
        }
        return DAOFactory.getApprenticeDAO().findApprentice(document);
    }
    
    public List<Apprentice> findAll() throws Exception{
        return DAOFactory.getApprenticeDAO().findAllApprentices();
    }    
}