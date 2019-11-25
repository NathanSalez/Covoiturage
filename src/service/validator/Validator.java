/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.validator;

/**
 * Interface de validation d'un objet T.
 * @author Nathan Salez
 */
public interface Validator<T> {
    
    /**
     * Valide l'objet en paramètre.
     * Appel à effectuer à chaque début de traitement "critique".
     * @param object 
     */
    void validate(T object) throws IllegalArgumentException;
}
