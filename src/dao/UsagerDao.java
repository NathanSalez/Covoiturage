/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Usager;

/**
 *
 * @author naysson
 */
public interface UsagerDao extends Dao<Usager> {
    
    /**
     * Renvoie les informations de l'usager correspondant aux paramètres
     * @param login
     * @param motDePasse
     * @return null si mauvais couple login/mdp.
     * @throws DaoException 
     */
    Usager connecter(String login, String motDePasse) throws DaoException;
    
}
