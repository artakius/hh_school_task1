/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hhTask1;

/**
 *
 * @author Artak
 */

import java.util.*;
class ComparatorPointsByXY implements Comparator<Point>{
    public int compare(Point p1, Point p2)
    {
        int result;
        result=Integer.compare(p1.x, p2.x);
        if((result=Integer.compare(p1.x, p2.x))!=0) return result;
        else return Integer.compare(p1.y, p2.y);        
    }
}
