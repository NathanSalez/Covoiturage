/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl.jdbc;

import dao.DaoException;
import dao.DaoFactory;
import dao.UsagerDao;

/**
 *
 * @author naysson
 */
public class JdbcFactory extends DaoFactory {

    @Override
    public UsagerDao getUsagerDao() throws DaoException
    {
        return JdbcUsagerDao.getInstance();
    }
}
