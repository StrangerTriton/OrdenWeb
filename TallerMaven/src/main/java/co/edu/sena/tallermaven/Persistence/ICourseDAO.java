/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.tallermaven.persistence;

import co.edu.sena.tallermaven.model.Course;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public interface ICourseDAO {
    public void insert(Course course)throws Exception;
    public void update(Course course)throws Exception;
    public void delete(Course course)throws Exception;    
    
    public Course find(Integer id)throws Exception;
    public List<Course> findAll() throws Exception; 
}
