package projects.tc2r.imageeffects58;
/*
*THENEWBOSTON TUTORIAL - IMAGE EFFECTS 58
*https://www.youtube.com/watch?v=4x_G2j_0IH0
*
* 60 creating photo filters
*/
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView tcImageView;
    Drawable buckysFace;
    Bitmap bitmapImage;
    Bitmap saveImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tcImageView = (ImageView) findViewById(R.id.tcImageView);
        tcImageView.setImageResource(R.drawable.bucky);


    }

    //Invert a bitmap Image
    public static Bitmap invertImage(Bitmap original){

        Bitmap finalImage = Bitmap.createBitmap(original.getWidth(), original.getHeight(), original.getConfig());

        int A, R, G, B;
        int pixelColor;
        int height = original.getHeight();
        int width = original.getWidth();

        for(int y = 0; y< height; y++){
            for(int x = 0; x<width; x++)
            {
                pixelColor = original.getPixel(x,y);
                A = Color.alpha(pixelColor);
                R = 255 - Color.red(pixelColor);
                B = 255 - Color.blue(pixelColor);
                G = 255 - Color.green(pixelColor);
                finalImage.setPixel(x, y, Color.argb(A,R,G,B));
            }
        }
        return finalImage;
    }

    // Called when Invert Button Clicked
    public void onInvertImage(View view){
        buckysFace = ContextCompat.getDrawable(this, R.drawable.bucky);
        // takes jpeg and converts into a bitmap so we can work with pixels
        bitmapImage = ((BitmapDrawable) buckysFace).getBitmap();
        Bitmap newPhoto = invertImage(bitmapImage);
        tcImageView.setImageBitmap(newPhoto);
    }

    // Called When Filter Button Clicked
    public void onFilter(View view){
        Drawable[] layers = new Drawable[2];
        layers[0] = ContextCompat.getDrawable(this, R.drawable.bucky);
        layers[1] = ContextCompat.getDrawable(this, R.drawable.bucky2);

        //We turn all the layers stack into a drawable object so device can display.
        LayerDrawable layerDrawable = new LayerDrawable(layers);
        // We assign our drawable to the ImageView.
        tcImageView.setImageDrawable(layerDrawable);
    }

    // Called When Save Button Clicked
    public void onSave(View view){
        //Gets a Bitmap of the image
        saveImage = ((BitmapDrawable) tcImageView.getDrawable()).getBitmap();
        // Saves Image
        MediaStore.Images.Media.insertImage(getContentResolver(), saveImage , "title", "description");
        // Tells user of action
        Toast.makeText(this, "Image saved to device", Toast.LENGTH_LONG).show();

        //could not figure out how to save the layered Image.

    }

}
