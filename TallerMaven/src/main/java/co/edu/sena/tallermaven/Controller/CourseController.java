/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.tallermaven.controller;

import co.edu.sena.tallermaven.model.Course;
import co.edu.sena.tallermaven.persistence.DAOFactory;
import co.edu.sena.tallermaven.persistence.EntityManagerHelper;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public class CourseController {
        public void validate (Course course) throws Exception{
        if(course.getId() == null){
            throw new Exception ("El numero de ficha es obligatoria");
        }
        if(course.getCareer()== null){
            throw new Exception ("El nombre de la carrera es obligatorio");
        }
    }

    public void insert (Course course) throws Exception{
        validate(course);
        EntityManagerHelper.beginTransaction();
        DAOFactory.getCourseDAO().insert(course);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }    
    
        public void update (Course course) throws Exception{
        validate(course);
        Course oldCourse = DAOFactory.getCourseDAO().find(course.getId());
        if(oldCourse == null){
            throw new Exception ("No existe la ficha a modificar");
        }
        
        //merge
        oldCourse.setId(course.getId());
        oldCourse.setCareer(course.getCareer());
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getCourseDAO().update(oldCourse);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }
        
    public void  delete (Course course) throws Exception{
        if(course.getId()== 0){
            throw new Exception ("El numero de ficha es obligatorio");
        }
        Course oldCourse = DAOFactory.getCourseDAO().find(course.getId());
        if(oldCourse == null){
            throw new Exception ("No la ficha a eliminar");
        }
        
        //merge;
        oldCourse.setId(course.getId());
        oldCourse.setCareer(course.getCareer());

        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getCourseDAO().delete(oldCourse);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }        
    
    
    public Course find(Integer id) throws Exception{
        if(id == 0){
            throw new Exception ("El numero de ficha es obligatorio");
        }
        return DAOFactory.getCourseDAO().find(id);
    }
    
    public List<Course> findAll() throws Exception{
        return DAOFactory.getCourseDAO().findAll();
    }    
}
