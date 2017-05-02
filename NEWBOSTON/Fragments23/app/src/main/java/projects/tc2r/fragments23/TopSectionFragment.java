package projects.tc2r.fragments23;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Tc2r on 8/11/2016.
 */

public class TopSectionFragment extends Fragment {
    private static EditText topTextInput;
    private static EditText bottomTextInput;
    private static Button button;

    TopSectionListener activityCommander;

    public interface TopSectionListener{
        public void createMeme(String top, String bottom);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            activityCommander = (TopSectionListener) context;

        }catch(ClassCastException e){
            throw new ClassCastException(activityCommander.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        //We use inflater.inflate to tell app which layout we're using for a fragment.
        View view = inflater.inflate(R.layout.top_section_fragment, container, false);

        topTextInput = (EditText) view.findViewById(R.id.topTextInput);
        bottomTextInput = (EditText)view.findViewById(R.id.bottomTextInput);
        button = (Button) view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Any code for when button gets clicked will be in the ButtonClicked Class
                buttonClicked(v);
            }
        });
        return view;
    }

    //Called whenever the button is clicked
    public void buttonClicked(View view){
        activityCommander.createMeme(topTextInput.getText().toString(), bottomTextInput.getText().toString());

    }
}
