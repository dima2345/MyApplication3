package com.dima.myapplication3.app;
import java.util.Arrays;
import java.util.Random;
/**
 * Created by victor on 6/11/14.
 */
public class GenMap {
    public int[][] arrayMap;
    public int forestsizex, forestsizey;
    public int finishx, finishy;
    public int playerx, playery;
    public int startposy;
    public int endposy;

    public void genArray(int mx, int my) {
        this.forestsizex = mx;
        this.forestsizey = my;

        Random rgen2 = new Random( System.currentTimeMillis() );
        rgen2.nextInt(forestsizey);
        startposy = rgen2.nextInt(forestsizey);
        endposy = rgen2.nextInt(forestsizey);

        arrayMap = new int[my][mx];
        int x;
        int y;
//        while (x != 15 && y != 10) {
//            Random rgen = new Random();
//            int condition = rgen.nextInt(1);
//            ArrayMap[x][y] = condition;
//            x++;
//            if (x == 16) ;
//            {
//                y++;
//            }
//
//        }
        Random rgen = new Random( System.currentTimeMillis() );
        rgen.nextInt(10);
        for(y=0; y < my; y++) {
            for(x=0; x < mx; x++) {
                int condition = rgen.nextInt(10);
                arrayMap[y][x] = condition;
                if(arrayMap[y][x] == 0)
                    arrayMap[y][x]=5;
                arrayMap[startposy][0] = 0;
            }
        }

        print(arrayMap, mx, my);

//        return arrayMap;
    }

    public void print(int[][] array, int sx, int sy)
    {
//        String str = Arrays.deepToString(array);
//        System.out.println(str);
        int x, y;
        for(y=0; y < sy; y++) {
            for(x=0; x < sx; x++) {
                System.out.print(array[y][x] + " ");
            }
            System.out.println();
        }
    }
}

//GenForest.Gen()