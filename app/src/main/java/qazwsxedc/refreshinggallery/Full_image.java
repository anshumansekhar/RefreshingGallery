package qazwsxedc.refreshinggallery;

import android.content.ContentValues;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Full_image extends AppCompatActivity {
    ImageView img;
    TextView counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);
        Intent i=getIntent();
        int pos=i.getIntExtra("Position",-1);
        int count=i.getIntExtra("Count",0);
        img=(ImageView)findViewById(R.id.img);
        counter=(TextView)findViewById(R.id.Counter);
        counter.append(""+count);
        //counter.setText(count);
        Glide.with(this)
                .load(MainActivity.paths.get(pos))
                .into(img);
    }
}
