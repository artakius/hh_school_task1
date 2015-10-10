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
public class Point {
    int x,y;
    Point()
    {}
    Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public int DistToPointSqr(Point p2)
    {
        return (int) (Math.pow(p2.x-this.x, 2)+ Math.pow(p2.y-this.y, 2));
    }
    
    public String toString ()
    {
        return x +" "+y;
    }
}
