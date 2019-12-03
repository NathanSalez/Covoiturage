/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl.jdbc;

import dao.Dao;
import dao.DaoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe implémentant l'interface Dao.<br/>
 * Son rôle est de spécifier la connexion de l'application à la base de données<br/>
 * JDBC dont les informations sont données.
 * @author Nathan Salez
 */
public abstract class JdbcDao<T> implements Dao<T> {
    
    protected Connection connector;

    public JdbcDao() throws DaoException
    {
        try {
            SQLConnect();
            System.out.println("JdbcDao - connexion à la base de données réussie.");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(JdbcDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException(ex);
        }
    }

    /**
     * Permet d'initialiser la connexion du programme à la base de données
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private void SQLConnect() throws ClassNotFoundException, SQLException {
        String driverClass = "org.apache.derby.jdbc.EmbeddedDriver";
        String urlDatabase = "jdbc:derby://localhost:1527/COVOITURAGE";
        String userName = "test";
        String password = "test";
        Class.forName(driverClass);
        this.connector = DriverManager.getConnection(urlDatabase,userName,password);
    }
    
}
