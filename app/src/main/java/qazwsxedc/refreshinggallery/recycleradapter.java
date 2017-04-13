package qazwsxedc.refreshinggallery;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by Anshuman-HP on 13-03-2017.
 */

public class recycleradapter extends RecyclerView.Adapter<recyclerholder> {
    Activity activity;
    public recycleradapter(Activity activity) {
        this.activity = activity;
    }
    @Override
    public recyclerholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new recyclerholder( activity.getLayoutInflater().inflate(R.layout.card, parent, false));
    }
    @Override
    public void onBindViewHolder(final recyclerholder holder,  int position) {
        Glide.with(activity.getApplicationContext())
                .load(MainActivity.paths.get(position))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(holder.img);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor=MainActivity.database.get_data(MainActivity.sqLiteDatabase);
                cursor.moveToPosition(holder.getAdapterPosition());
                int d=cursor.getInt(cursor.getColumnIndex(database.COL3));
                Log.e("TAG",String.valueOf(d));
                int f=cursor.getInt(cursor.getColumnIndex(database.COL4));
                String id=cursor.getString(cursor.getColumnIndex(database.COL1));
                String path=cursor.getString(cursor.getColumnIndex(database.COL2));
                MainActivity.database.update(id,path,d+1,f,MainActivity.sqLiteDatabase);
                Intent h=new Intent(activity,Full_image.class);
                h.putExtra("Position",holder.getAdapterPosition());
                h.putExtra("Count",d+1);
                activity.startActivity(h);
            }
        });
    }
    @Override
    public int getItemCount() {
        return MainActivity.paths.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }
}
