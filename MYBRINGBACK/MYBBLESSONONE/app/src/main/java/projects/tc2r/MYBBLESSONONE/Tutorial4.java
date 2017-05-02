package projects.tc2r.MYBBLESSONONE;
/**Custom View and Constructors
 * https://www.youtube.com/watch?v=vOY2AxbnRyc
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Tutorial4 extends AppCompatActivity {
    DrawingTheBall v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Create an new instance of this class, DrawingTheBall
        v = new DrawingTheBall(this);
        setContentView(v);
    }



}
