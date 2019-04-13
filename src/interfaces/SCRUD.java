/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;

/**
 *
 * @author ouagh
 */
public interface SCRUD <T> {
    
    void insert(T a);
    void delete(int id);
    void update(T a);
    ArrayList<T> findAll();
    
    
}
