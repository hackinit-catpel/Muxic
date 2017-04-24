package com.example.kolibreath.muxics;

import android.content.Context;
import android.nfc.cardemulation.HostApduService;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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
    private RecyclerView listView;

    private void initMusicItem(){
        for (int i=0;i<15;i++) {
            Music music = new Music("The queen"+i, "We are the Champions");
            musicList.add(music);
        }
    }
    private void initListView()
    {
        listView = (RecyclerView) findViewById(R.id.musicList);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        listView.setLayoutManager(manager);
        MusicRecylerAdpter adpter = new MusicRecylerAdpter(musicList);
        listView.setAdapter(adpter);
    }
    private void initWidget(){
       // textView = (TextView) findViewById(R.id.testText);
        mdrawerLayout = (DrawerLayout) findViewById(R.id.mdrawLayout);
        toolbar = (Toolbar) findViewById(R.id.toolBarForMainActivity);
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

    class MusicRecylerAdpter extends RecyclerView.Adapter<MusicRecylerAdpter.ViewHolder>{
        private List<Music> Mlist;

        public MusicRecylerAdpter(List<Music> list){
            Mlist = list;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.music_list_item,parent,false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Music music  = Mlist.get(position);
            holder.textView.setText(music.getName());
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            private TextView textView;
            public ViewHolder(View view ){
                super(view);
                textView = (TextView) view.findViewById(R.id.nameOfSong);

            }
        }

        @Override
        public int getItemCount() {
            return Mlist.size();
        }
    }

}
