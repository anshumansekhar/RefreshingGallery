package qazwsxedc.refreshinggallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by Anshuman-HP on 18-03-2017.
 */

public class gridadapter extends BaseAdapter {
    Context ctx;

    public gridadapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return MainActivity.cursor.getCount();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.card,parent);
        ImageView img=(ImageView)view.findViewById(R.id.image);
        Glide.with(ctx)
                .load(MainActivity.paths.get(position))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(img);
        return view;
    }
}
