package alireza.sn.exercise1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class SpinnerCustom extends BaseAdapter {
    public int flags_array[] ;
    public String nameCountries_array[] ;
    Context context;

    public SpinnerCustom (Context context , int [] flags , String [] nameCountries) {
        this.context = context;
        this.flags_array = flags;
        this.nameCountries_array = nameCountries;
        // =====================-================------------------
    }

    //==================
    @Override
    public int getCount() {
        return flags_array.length;
    }

    @Override
    public Object getItem(int position) {
        return nameCountries_array[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HolderView holderView;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.spinner_countries , parent , false);
            holderView = new HolderView(convertView);
            convertView.setTag(holderView);
        } else
            holderView = (HolderView) convertView.getTag();

        holderView.fill(position,flags_array , nameCountries_array);

        return convertView;
    }
}

  class HolderView {
    ImageView flags ;
    TextView nameCountries ;

    public HolderView(View convertView) {
        flags = convertView.findViewById(R.id.flag);
        nameCountries = convertView.findViewById(R.id.name_country);
    }

    public void fill(int position, int[] flags_array, String[] nameCountries_array){

        flags.setImageResource(flags_array[position]);
        nameCountries.setText(nameCountries_array[position]);
    }
}

