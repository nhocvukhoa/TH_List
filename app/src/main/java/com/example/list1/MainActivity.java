package com.example.list1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;



import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Context context;
    ConstraintLayout rela;
    ArrayList<ProfileModel> profileData;
    CustomAdapter customAdapter;
    ProfileModel profileModel;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);

        //getviews
        listView = findViewById(R.id.listView);
        rela = (ConstraintLayout) findViewById(R.id.rela);
        profileData = new ArrayList<>();

        //add Countries Data
        populateCountriesData();

        customAdapter = new CustomAdapter(context, profileData);
        listView.setAdapter(customAdapter);
        registerForContextMenu(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(context, profileData.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Cập nhật");
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_content, menu);
    }

    public boolean onContextItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.them:
                Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.sua:
                Toast.makeText(this, "Sửa thành công", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.xoa:
                Toast.makeText(this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                customAdapter.RemoveItem(item.getGroupId());
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void populateCountriesData() {
        //music1
        profileModel=new ProfileModel();
        profileModel.setId(1);
        profileModel.setAvata(R.drawable.murakami);
        profileModel.setName("Haruki Murakami");
        profileModel.setTime("6h ago");
        profileModel.setAvata2(R.drawable.skyfall);
        profileData.add(profileModel);

        profileModel=new ProfileModel();
        profileModel.setId(2);
        profileModel.setAvata(R.drawable.nntu);
        profileModel.setName("Nguyễn Ngọc Tư");
        profileModel.setTime("7h ago");
        profileModel.setAvata2(R.drawable.warmoncoldnight);
        profileData.add(profileModel);

        profileModel=new ProfileModel();
        profileModel.setId(3);
        profileModel.setAvata(R.drawable.queen);
        profileModel.setName("Queens");
        profileModel.setTime("3h ago");
        profileModel.setAvata2(R.drawable.lietome);
        profileData.add(profileModel);

        profileModel=new ProfileModel();
        profileModel.setId(4);
        profileModel.setAvata(R.drawable.taylor);
        profileModel.setName("Taylor Swift");
        profileModel.setTime("3h ago");
        profileModel.setAvata2(R.drawable.folk);
        profileData.add(profileModel);

        profileModel=new ProfileModel();
        profileModel.setId(5);
        profileModel.setAvata(R.drawable.kurt);
        profileModel.setName("Kurt Cobain");
        profileModel.setTime("3h ago");
        profileModel.setAvata2(R.drawable.youbrokemefirst);
        profileData.add(profileModel);

        profileModel=new ProfileModel();
        profileModel.setId(6);
        profileModel.setAvata(R.drawable.kurt);
        profileModel.setName("Kurt Cobain");
        profileModel.setTime("3h ago");
        profileModel.setAvata2(R.drawable.youbrokemefirst);
        profileData.add(profileModel);

        profileModel=new ProfileModel();
        profileModel.setId(7);
        profileModel.setAvata(R.drawable.chris);
        profileModel.setName("Chris Martin");
        profileModel.setTime("15h ago");
        profileModel.setAvata2(R.drawable.fixyou);
        profileData.add(profileModel);

        profileModel=new ProfileModel();
        profileModel.setId(8);
        profileModel.setAvata(R.drawable.chris);
        profileModel.setName("Chris Martin");
        profileModel.setTime("15h ago");
        profileModel.setAvata2(R.drawable.fixyou);
        profileData.add(profileModel);
        
    }
}