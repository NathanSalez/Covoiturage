/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

/**
 * Classe à utiliser pour tout type d'exception levé depuis les classes du package dao.<br/>
 * Une exception instance de cette classe signifie un problème au niveau de la<br/>
 * base de données.<br/>
 * @author Nathan Salez
 */
public class DaoException extends Exception {

    public DaoException(String message) {
        super(message);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }
    
}
