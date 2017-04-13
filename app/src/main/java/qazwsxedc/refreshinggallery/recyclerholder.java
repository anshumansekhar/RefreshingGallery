package qazwsxedc.refreshinggallery;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Anshuman-HP on 13-03-2017.
 */

public class recyclerholder extends RecyclerView.ViewHolder {
    ImageView img;
    public recyclerholder(View itemView) {
        super(itemView);
        img = (ImageView) itemView.findViewById(R.id.image);
    }
}
