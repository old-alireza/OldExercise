package alireza.sn.exercise1;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

class ColorToast {
    private static final int RED = 0xffFF2A23;
    private static final int YELLOW = 0xffFFF148;
    private static final int GREEN = 0xff3BFF2B;
    private  static final  int ICON_ERROR = R.drawable.error;
    private  static final  int ICON_SUCCESS = R.drawable.success;
    private  static final  int ICON_WARNING = R.drawable.warning;
    Toast toast;
    View view;
    Context context;

    public ColorToast(Context context) {
        this.context = context;
        this.toast = new Toast(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.defualt_toast, null);
        toast.setView(view);
    }

    private View getView() {
        return view;
    }

    private void getText (String text) {
        if (view == null) return;

        ((TextView) view.findViewById(R.id.textView_message)).setText(text);
    }

    private Toast getToast () {
        return toast;
    }

    private void getIcon (int id_icon) {
        if (view == null)
            return;

        ((ImageView) view.findViewById(R.id.icon_alert)).setImageResource(id_icon);
    }

    public static Toast warning(Context context, String text, int duration) {
        ColorToast colorToast = new ColorToast(context);
        colorToast.getText(text);
        colorToast.getToast().setDuration(duration);
        colorToast.getIcon(ICON_WARNING);
        colorToast.getView().setBackgroundColor(YELLOW);
        colorToast.getToast().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM , 0 ,10);
        return colorToast.getToast();
    }

    public static Toast error (Context context , String text , int duration) {
        ColorToast colorToast = new ColorToast(context);
        colorToast.getText(text);
        colorToast.getToast().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM , 0 , 10);
        colorToast.getView().setBackgroundColor(RED);
        colorToast.getToast().setDuration(duration);
        colorToast.getIcon(ICON_ERROR);
        return colorToast.getToast();
    }

    public static Toast success (Context context , String text , int duration) {
        ColorToast colorToast = new ColorToast(context);
        colorToast.getText(text);
        colorToast.getToast().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM , 0 , 10);
        colorToast.getView().setBackgroundColor(GREEN);
        colorToast.getToast().setDuration(duration);
        colorToast.getIcon(ICON_SUCCESS);
        return colorToast.getToast();
    }

    public static  Toast image (Context context , int resImage , int duration){
        Toast toast = new Toast(context);
        LinearLayout layout = new LinearLayout(context);
        ImageView imageView = new ImageView(context);
        layout.setLayoutParams(new LinearLayout.LayoutParams(250 , 250));
        layout.addView(imageView);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.requestLayout();
        imageView.setImageResource(resImage);
        imageView.setLayoutParams(layout.getLayoutParams());
        toast.setView(layout);
        toast.setDuration(duration);
        toast.setGravity(Gravity.CENTER , 0 , 0);
        return toast;
    }

}

