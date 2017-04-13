package qazwsxedc.refreshinggallery;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Anshuman-HP on 13-03-2017.
 */

public class database extends SQLiteOpenHelper {
    public static  final String db_name="IMAGES";
    public  static final String table_name="Images_Table";
    public static  final String COL1="ID";
    public static final String COL4="Sl_NO";
    public static final String COL2="Path";
    public static final String COL3="Count";
    public database(Context context) {
        super(context, db_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE "+table_name+"("+COL1+" INTEGER PRIMARY KEY ,"+COL2+" TEXT,"+COL3+" INTEGER,"+
                    COL4+" INTEGER )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+table_name);
        Log.e("test","On Upgrade");
        onCreate(db);

    }
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
    public void insert_data(int id,String path,int i,SQLiteDatabase db)
    {
        ContentValues contentValues =new ContentValues();
        contentValues.put(COL1,id);
        contentValues.put(COL2,path);
        contentValues.put(COL3,0);
        contentValues.put(COL4,i);
        db.insert(database.table_name,null,contentValues);
    }

    public Cursor get_data(SQLiteDatabase db)
    {
        Cursor cursor;
        String[] projections={database.COL1,database.COL2,database.COL3,database.COL4};
        //cursor=db.query(database.table_name,projections,null,null,null,null,database.COL3);
        cursor=db.query(database.table_name,projections,null,null,null,null,null,null);
        return cursor;

    }
    public Cursor Sort_data(SQLiteDatabase db)
    {
        Cursor cursor;
        String[] projections={database.COL1,database.COL2,database.COL3,database.COL4};
        cursor=db.query(database.table_name,projections,null,null,null,null,database.COL3+" DESC");
        return cursor;
    }
    public void update(String id,String path,int count,int  sl_no,SQLiteDatabase db)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put(database.COL1,id);
        contentValues.put(database.COL2,path);
        contentValues.put(database.COL3,count);
        contentValues.put(database.COL4,sl_no);
        String selection=database.COL1+"="+id;
        int row=db.update(database.table_name,contentValues,selection,null);
        Log.e("TEST","updated "+row);
        Log.e("gf",String.valueOf(count));
    }
}
