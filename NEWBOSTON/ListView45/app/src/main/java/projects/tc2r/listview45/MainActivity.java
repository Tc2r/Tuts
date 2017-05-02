package projects.tc2r.listview45;


import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] colors = {"blue","red","yellow","green","orange"};
        ListAdapter tcAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, colors);
        ListView tcListView = (ListView)findViewById(R.id.tcListView);
        tcListView.setAdapter(tcAdapter);

        tcListView.setOnItemClickListener( new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                String color = String.valueOf(parent.getItemAtPosition(position));
                Toast.makeText(MainActivity.this, color, Toast.LENGTH_LONG).show();

            }
        }
        );




    }
}
