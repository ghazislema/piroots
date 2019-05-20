/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Trafic;
import java.util.ArrayList;

/**
 *
 * @author Adly
 */
public interface IGenericCrud<T> {
	
	void add(T t);
	void  delete(T t);
	void display(ArrayList<T> t);
	void update(T t,String s,String b, int y);
        T findTraficByTraficStatue(String x);
        Trafic getTrafic(T t,int i);
}
