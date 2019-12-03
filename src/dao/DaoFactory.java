/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dao.impl.jdbc.JdbcFactory;

/**
 *
 * @author naysson
 */
public abstract class DaoFactory {
    
    public final static DaoFactory getDaoFactory(PersistenceType type)
    {
        switch(type)
        {
            case JDBC :
                return new JdbcFactory();
                
            default:
                return null;
        }
    }
    
    
    public abstract UsagerDao getUsagerDao() throws DaoException;
    
}
