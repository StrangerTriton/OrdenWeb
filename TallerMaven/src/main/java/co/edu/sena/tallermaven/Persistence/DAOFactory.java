/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.tallermaven.persistence;

import co.edu.sena.tallermaven.Persistence.AppretiencerDAO;
import co.edu.sena.tallermaven.Persistence.IAppretiencerDAO;
import co.edu.sena.tallermaven.Persistence.ILate_arrivalDAO;
import co.edu.sena.tallermaven.Persistence.Late_ArrivalDAO;

/**
 *
 * @author Aprendiz
 */
public class DAOFactory {
    private static IAppretiencerDAO apprenticeDAO = new AppretiencerDAO();
    private static ICourseDAO courseDAO = new CourseDAO();
    private static ILate_arrivalDAO latearrivarDAO = new Late_ArrivalDAO();

    public static IAppretiencerDAO getApprenticeDAO() {
        return apprenticeDAO;
    }

    public static ICourseDAO getCourseDAO() {
        return courseDAO;
    }

    public static ILate_arrivalDAO getLatearrivarDAO() {
        return latearrivarDAO;
    }
    
}
