/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 *
 * @author naysson
 */
@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Lieu {
    
    int id;
    
    String ville;
    
    String rue;
    
    String commentaire;
}
