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
class ComparatorPointsByY implements Comparator<Point>{
    public int compare(Point p1, Point p2)
    {
        return Integer.compare(p2.y, p1.y);        
    }
}
