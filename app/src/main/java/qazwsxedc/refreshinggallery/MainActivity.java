package qazwsxedc.refreshinggallery;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    GridView grid;
    SwipeRefreshLayout swipeRefreshLayout;
    GridLayoutManager layoutManager;
    static ArrayList<String> paths;
    static database database;
    static SQLiteDatabase sqLiteDatabase;
    static Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        paths=new ArrayList<>();
        database=new database(this);
        sqLiteDatabase=database.getWritableDatabase();
        cursor=database.get_data(sqLiteDatabase);
        for(int i=0;i<cursor.getCount();i++)
        {
            cursor.moveToPosition(i);
            paths.add(cursor.getString(cursor.getColumnIndex(database.COL2)));
        }
        setContentView(R.layout.activity_main);
        swipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.swipe);
        recyclerView=(RecyclerView)findViewById(R.id.recycler);
        final recycleradapter adapter=new recycleradapter(MainActivity.this);
        layoutManager=new GridLayoutManager(getApplicationContext(),3);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                paths.clear();
               cursor= database.Sort_data(sqLiteDatabase);
                for(int i=0;i<cursor.getCount();i++)
                {
                    cursor.moveToPosition(i);
                    paths.add(cursor.getString(cursor.getColumnIndex(database.COL2)));

                }
                adapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);

            }
        });
    }
}
