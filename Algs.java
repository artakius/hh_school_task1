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

public class Algs {
    static int SimplAlg(List<Point> points)
    {
        Point pi = new Point();
        Point pj = new Point();        
        Iterator<Point> itrp = points.iterator();
        
        int dist_tmp, min_dist=1000000000;
    // Перебираем квадраты расстояний между всевозможными парами точек
    // и выбираем минимальное из них
        while(itrp.hasNext())
        {
            pi = itrp.next();
            while(itrp.hasNext())
            {
                pj = itrp.next();
                if((dist_tmp = pi.DistToPointSqr(pj))<min_dist)
                {
                    min_dist = dist_tmp;
                }      
            }
            points.remove(pi);
            itrp=points.iterator();
        }
        return min_dist;
    }
    
    static int FastAlg(List<Point> points)
    {
        int min_dist=1000000000;
        int s;
        List<Point> points_tmp = new LinkedList<Point>();
        List<Point> tmp1 = new LinkedList<Point>();
        List<Point> tmp2 = new LinkedList<Point>();
        points_tmp.addAll(points);
        s=points_tmp.size();
        
    // Если набор содержит меньшн 4х точек, то вызываем SimplAlg(от данного набора)    
        if(s<=3)
        {
            return Algs.SimplAlg(points_tmp);
        }
        
        
        min_dist=Math.min(min_dist,Math.min(
        Algs.FastAlg(points_tmp.subList(0, s/2)),
        Algs.FastAlg(points_tmp.subList(s/2,s))));
        
    // Склейка ответов от двух наборов
    // Пограничные точки (точки которые находятся от линии раздела на расстоянии не болше 
    // чем минимальное из минимальных расстояниq в двух наборах)добавляем в объект типа TreeSet<Point> 
    // чтобы на выходе получить уже отсортированный по координате y набор точек
    // Поскольку точки уже отсортированы по XY, то достаточно последовательно перебрать точки находящиеся
    // слева и справа на расстоянии sqrt(min_dist)от точки c индексом s/2 
        int i=1;
        Set<Point> merge_points = new TreeSet<Point>(new ComparatorPointsByY());
        while(i<s/2 && points_tmp.get(s/2).x - points_tmp.get(s/2-i).x < Math.sqrt(min_dist))
        {
            merge_points.add(points_tmp.get(s/2-i));
            i++;
        }
        i=1;
        while(i<s/2 && points_tmp.get(s/2+i).x - points_tmp.get(s/2).x < Math.sqrt(min_dist))
        {
            merge_points.add(points_tmp.get(s/2+i));
            i++;
        }
        if(!merge_points.isEmpty()) merge_points.add(points_tmp.get(s/2));
        
    // Передаем набор уже отсортированных пограничных точек из TreeSet в ArrayList
    // чтобы можно было работать с индексами
        List<Point> mp_list = new ArrayList<Point>();
        mp_list.addAll(merge_points);       
        
        int smp=mp_list.size();
        int imp;
        int tmp_dist;
        
        
    // Проверяем есть ли среди набора пограничных точек точки с расстоянием меньше чем min_dist
    // если такие точки есть, то min_dist присваиваем значение квадрата расстояния между этими точками
        for(Point mp: mp_list)
        {
            imp = mp_list.indexOf(mp)+1;
            while( imp<smp && mp.y - mp_list.get(imp).y <Math.sqrt(min_dist))
            {
                tmp_dist = mp.DistToPointSqr(mp_list.get(imp));
                if(tmp_dist < min_dist) min_dist = tmp_dist;
                imp++;
            }
            
        }
        
        
        return min_dist;
    }
}
