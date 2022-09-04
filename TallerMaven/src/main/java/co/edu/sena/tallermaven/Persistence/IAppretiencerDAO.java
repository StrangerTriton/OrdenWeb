/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.tallermaven.Persistence;

import co.edu.sena.tallermaven.model.Apprentice;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public interface IAppretiencerDAO {
    public void insert(Apprentice apprentice) throws Exception;
    public void update(Apprentice apprentice) throws Exception;
    public void delete(Apprentice apprentice) throws Exception;
    public Apprentice findApprentice(Long Document) throws Exception;
    public List<Apprentice> findAllApprentices() throws Exception;
    
}
