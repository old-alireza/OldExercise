package alireza.sn.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    ArrayAdapter <String> adapter;
    List<String> list ;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_actvity);
        listView = findViewById(R.id.list_view);
        prepareData();
        refreshDisplay();
    }

    private void prepareData() {
        list = new ArrayList<>();
        list.add("Tehran");
        list.add("Esfahan");
        list.add("Zahedan");
        list.add("Alborz");
        list.add("Tabriz");
        list.add("Ghom");
        list.add("Mashhad");
        list.add("Kerman");
        list.add("Yazd");
        list.add("Kermanshah");
    }

    private void refreshDisplay() {
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListActivity.this, list.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("add").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            int i=0;
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                list.add("item"+i);
                adapter.notifyDataSetChanged();
                i++;
                return false;
            }
        });

        menu.add("remove").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if(list.isEmpty())
                   return false;

                list.remove(list.size()-1);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}