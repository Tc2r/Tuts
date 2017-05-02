package projects.tc2r.customlistview47;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

//Inherits from Array Adapter
class customAdapter extends ArrayAdapter<String> {
    public customAdapter(Context context, String[] colors) {
        super(context, R.layout.custom_row, colors);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater tcInflater = LayoutInflater.from(getContext());
        View customView = convertView;
        if (customView == null){
            tcInflater.inflate(R.layout.custom_row, parent, false);
        }

        String singleColorItem = getItem(position);
        TextView tcText = (TextView) customView.findViewById(R.id.tcLText);
        ImageView tcImage = (ImageView) customView.findViewById(R.id.tcImage);

        tcText.setText(singleColorItem);
        tcImage.setImageResource(R.drawable.tcram);
        return customView;
    }
}
