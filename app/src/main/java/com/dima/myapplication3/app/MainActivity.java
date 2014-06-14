package com.dima.myapplication3.app;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.graphics.Color;
import android.view.Window;

public class MainActivity extends Activity {
    LevelMap levelMap;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        setContentView(R.layout.activity_main);

        int forestsizex =20;
        int forestsizey =20;
        GenMap map = new GenMap();
        boolean found=false;
        int counter=0;
        while(!found && counter<100) {
            counter++;
            map.genArray(forestsizex, forestsizey);
            RouteFinder rf = new RouteFinder(map.arrayMap, forestsizex-1, map.endposy, forestsizex, forestsizey);

            found = rf.findStep(0, map.startposy);
            System.out.print("Found route: ");
            System.out.println(found);
        }

        levelMap = new LevelMap(this, map, forestsizex, forestsizey);
        levelMap.setBackgroundColor(Color.BLACK);
        setContentView(levelMap);

    }

    public void getImage(){

//        Bitmap image1 = BitmapFactory.decodeResource( this.getResources(), R.drawable.treeforest1);

    }


  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
