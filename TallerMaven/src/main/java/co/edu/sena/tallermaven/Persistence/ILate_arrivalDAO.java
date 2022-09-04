/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.tallermaven.Persistence;

import co.edu.sena.tallermaven.model.Course;
import co.edu.sena.tallermaven.model.LateArrival;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public interface ILate_arrivalDAO {
    public void insert(LateArrival lateArrival) throws Exception;
    public void update(LateArrival lateArrival) throws Exception;
    public void delete(LateArrival lateArrival) throws Exception;
    public LateArrival find(Integer id) throws Exception;
    public List<LateArrival> findAllLateArrival() throws Exception;
}
