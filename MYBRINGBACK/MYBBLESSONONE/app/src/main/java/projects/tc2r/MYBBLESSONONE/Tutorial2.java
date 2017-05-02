package projects.tc2r.MYBBLESSONONE;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Tutorial2 extends ListActivity {

    String classNames[] = {"MainActivity", "Sweet", "Tutorial1", "Tutorial2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, classNames));

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String openClass = classNames[position];

        // We make a try in case there is errors
        try{
            Class selected = Class.forName("projects.tc2r.MYBBLESSONONE." + openClass);
            Intent intent = new Intent(this, selected);
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
