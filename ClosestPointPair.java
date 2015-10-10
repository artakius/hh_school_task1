package hhTask1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Artak
 */

import java.io.*;
import java.util.*;
public class ClosestPointPair {
public static void main(String args[]) 
{
    System.out.println("Введите полный путь к файлу. Для выхода из программы введите q");
    Scanner sin = new Scanner(System.in);
    String file = sin.nextLine();
    if(file.compareTo("q")==0) return;
    
    try ( FileReader fr = new FileReader(file))//("C:\\MyJava\\hhTask1\\Points100000.txt"))
    {
        BufferedReader in = new BufferedReader(fr);
        String str;
        String[] stra = new String[2];
        TreeSet<Point> p = new TreeSet<Point>(new ComparatorPointsByXY());
        int id=0;
        while((str = in.readLine()) != null) 
        {
            stra=str.split(" ");
            p.add(new Point(Integer.parseInt(stra[0]),Integer.parseInt(stra[1])));
            id++;
        }
        List<Point> plist = new ArrayList<Point>();
        plist.addAll(p);
        System.out.println(Math.sqrt(Algs.FastAlg(plist)));
//        System.out.println(plist);
//        System.out.println(Math.sqrt(Algs.SimplAlg(plist)));
    } 
    catch(IOException e) {
        
        System.out.println("I/O Error: " + e);
        main(args);
    }
}

    
}
