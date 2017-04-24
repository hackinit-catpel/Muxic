package com.example.kolibreath.muxics;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kolibreath.muxics.Classes.Music;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private DrawerLayout mdrawerLayout;
    private Toolbar toolbar;
    List<Music> musicList = new ArrayList<>();
    private ListView listView;

    private void initMusicItem(){
        for (int i=0;i<15;i++) {
            Music music = new Music("The queen"+i, "We are the Champions");
            musicList.add(music);
        }
    }
    private void initListView()
    {
        MusicAdapter adapter = new MusicAdapter(MainActivity.this,R.layout.music_list_item,musicList);
        listView.setAdapter(adapter




        );
    }
    private void initWidget(){
       // textView = (TextView) findViewById(R.id.testText);
        mdrawerLayout = (DrawerLayout) findViewById(R.id.mdrawLayout);
        toolbar = (Toolbar) findViewById(R.id.toolBarForMainActivity);
        listView = (ListView) findViewById(R.id.musicList);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.mipmap.ic_reorder_black_24dp);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        initMusicItem();
        initListView();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                try {
                    mdrawerLayout.openDrawer(GravityCompat.START);
                    break;
                }catch (Exception e){
                    e.printStackTrace();
                }
        }
        return true;
    }
    class MusicAdapter extends ArrayAdapter<Music>{

        private int resourceId;
        public MusicAdapter(Context context, int resoureceId, List<Music> list){
            super(context,resoureceId,list);
            this.resourceId =resoureceId;

        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            Music music = getItem(position);
            View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            TextView textView  = (TextView) view.findViewById(R.id.nameOfSong);
            textView.setText(music.getName());
            return view;
        }
    }
}
