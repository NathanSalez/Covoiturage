/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;

/**
 * Interface décrivant le comportement d'un Data Access Object (DAO).<br />
 * Un DAO a pour rôle de relier l'application à une base de données quelconque.
 * @author Nathan Salez
 */
public interface Dao<T> {
    
    /**
     * Insère l'objet en paramètre dans la base de données.
     * @param obj
     * @throws DaoException s'il n'y a pas d'insertion.
     */
    void create(T obj) throws DaoException;
    
    /**
     * Recherche un objet à partir de son id.
     * @param id
     * @return l'objet trouvé, null sinon.
     * @throws DaoException 
     */
    T research(int id) throws DaoException;
    
    /**
     * modifie un objet à l'aide de son id.
     * @param obj
     * @throws DaoException si la modification n'a pas été effectuée
     */
    void update(T obj) throws DaoException;
    
    /**
     * supprime l'objet de la base de données à partir de son id.
     * @param obj
     * @throws DaoException si la délétion n'a pas été effectuée.
     */
    void delete(T obj) throws DaoException;
    
    /**
     * récupère tous les objets T dans la base de données.
     * @return une collection de T.
     * @throws DaoException
     */
    Collection<T> findAll() throws DaoException;
}
