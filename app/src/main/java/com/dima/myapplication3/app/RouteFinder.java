package com.dima.myapplication3.app;

/**
 * Created by victor on 6/12/14.
 */
public class RouteFinder {

    private int sizex;
    private int sizey;
    private int finishx;
    private int finishy;
    private boolean[][] visitedArray;
    private int[][] map;
    private int y;

    public RouteFinder(int[][] map, int finishx, int finishy, int sizex, int sizey){
        this.sizex=sizex;
        this.sizey=sizey;
        this.finishx=finishx;
        this.finishy=finishy;
        this.map=map;
        visitedArray = new boolean[sizey][sizex];
    }

    public boolean findStep(int x, int startposy){
        y = startposy;
        int x1=x-1;
        int x2=x+1;
        int y1=y-1;
        int y2=y+1;
//        System.out.println("X="+x+" Y="+y);

        if (visitedArray[y][x]){
            return false;
        }else{
            visitedArray[y][x]=true;
        }

        if(x == finishx && y == finishy) {
            return true;
        }

        if(map[y][x] >= 6 || map[finishy][finishx] >= 6){
            return false;
        }

        boolean b1=false;
        boolean b2=false;
        boolean b3=false;
        boolean b4=false;
        boolean b5=false;
        boolean b6=false;
        boolean b7=false;
        boolean b8=false;
        if(x1>=0 && x1 < sizex && map[y][x1] <= 5){
            b1 = findStep(x1, y);
        }
        if(x2>=0 && x2 < sizex && map[y][x2] <= 5){
            b2 = findStep(x2, y);
        }
        if(y1>=0 && y1 < sizey && map[y1][x] <= 5){
            b3 = findStep(x, y1);
        }
        if(y2>=0 && y2 < sizey && map[y2][x] <= 5){
            b4 = findStep(x, y2);
        }
        if(x1>=0 && x1 < sizex && y1>=0 && y1 < sizey && map[y1][x1] <= 5){
            b5 = findStep(x1, y1);
        }
        if(y2>=0 && y2 < sizey && x2>=0 && x2 < sizex && map[y2][x2] <= 5){
            b6 = findStep(x2, y2);
        }
        if(y2>=0 && y2 < sizey && x1>=0 && x1 < sizex && map[y2][x1] <= 5){
            b7 = findStep(x1, y2);
        }
        if(y1>=0 && y1 < sizey && x2>=0 && x2 < sizex && map[y1][x2] <= 5){
            b8 = findStep(x2, y1);
        }
        if(b1 || b2 || b3 || b4 || b5 || b6 || b7 || b8){
            return true;
        }
//        System.out.println("Should never be here");
    return false;
    }
}
