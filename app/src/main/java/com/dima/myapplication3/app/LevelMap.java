package com.dima.myapplication3.app;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by victor on 6/13/14.
 */
public class LevelMap extends View {
    Paint paint = new Paint();
    Bitmap forestgrass;
    Bitmap foresttree;
    Bitmap player;
    Bitmap scaledfgrass;
    Bitmap scaledftree;
    Bitmap scaledplayer;
    int gridsize = 50;

    GenMap map;
    int width;
    int height;

    public LevelMap(Context context, GenMap map, int w, int h) {
        super(context);
        this.map = map;
        width = w;
        height = h;
        forestgrass = BitmapFactory.decodeResource(this.getResources(), R.drawable.grassforest);
        scaledfgrass = Bitmap.createScaledBitmap(forestgrass, gridsize, gridsize, true);
        foresttree = BitmapFactory.decodeResource(this.getResources(), R.drawable.treeforest1);
        scaledftree = Bitmap.createScaledBitmap(foresttree, gridsize, gridsize, true);
        player = BitmapFactory.decodeResource(this.getResources(), R.drawable.warriordown);
        scaledplayer = Bitmap.createScaledBitmap(player, gridsize, gridsize, true);
    }

    @Override
    public void onDraw(Canvas canvas) {
//        for(int x=0; x < 5; x++) {
//            for(int y=0; y < 5; y++) {
//                canvas.drawBitmap(scaled0, x*50, y*50, paint);
//            }
//        }


        for (int y = 0; y < map.forestsizey; y++) {
            for(int x=0; x < map.forestsizex; x++) {
                canvas.drawBitmap(scaledfgrass, x*gridsize+gridsize*(map.forestsizex/2), y*gridsize-gridsize*(map.startposy/2), paint);
                if(map.arrayMap[y][x] >= 6)
                    canvas.drawBitmap(scaledftree, x*gridsize+gridsize*(map.forestsizex/2), y*gridsize-gridsize*(map.startposy/2), paint);
                if(map.arrayMap[y][x] == 0)
                    canvas.drawBitmap(scaledplayer, x*gridsize+gridsize*(map.forestsizex/2), y*gridsize-gridsize*(map.startposy/2), paint);
            }
        }

//      this.invalidate();
    }
}
