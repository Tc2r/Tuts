package projects.tc2r.savedatasql49;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText tcInput;
    TextView tcText;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tcInput = (EditText) findViewById(R.id.tcInput);
        tcText = (TextView) findViewById(R.id.tcText);
        dbHandler = new MyDBHandler(this, null, null, 1);
        printDatabase();
    }

    //Add a product to the database
    public void addButtonClicked(View view){
        Products product = new Products(tcInput.getText().toString());
        dbHandler.addProduct(product);
        printDatabase();

    }


    // Delete Items
    public void deleteButtonClicked(View view){
        String inputText = tcInput.getText().toString();
        dbHandler.deleteProduct(inputText);
        printDatabase();

    }

    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        tcText.setText(dbString);
        tcInput.setText(" ");

    }

}
