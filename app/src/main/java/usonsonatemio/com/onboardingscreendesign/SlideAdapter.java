package usonsonatemio.com.onboardingscreendesign;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SlideAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SlideAdapter(Context context) {
        this.context = context;
    }

    //Arraya
    public int[] slide_images = {
            R.drawable.period_blood,
            R.drawable.ic_pms,
            R.drawable.calendar_duracion,
            R.drawable.period_blood,
            R.drawable.birthday
    };

    public String[] slide_headings= {
            "PERIODO",
            "PMS",
            "DURACIÓN DEL CICLO",
            "ÚLTIMO PERIODO",
            "CUMPLEAÑOS"
    };

    public String[] slide_descs = {
            "¿Conoces cuánto dura tu periodo?",
            "¿Sufres el síndrome premenstrual?",
            "¿Cuánto dura tu ciclo normalmente?",
            "¿Recuerdas la fecha de tu último periodo?",
            "¿Cuál es tu fecha de cumpleaños?"
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view  == (RelativeLayout) object;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideimageview = (ImageView) view.findViewById(R.id.slide_image);
        TextView sliderHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);

        slideimageview.setImageResource(slide_images[position]);
        sliderHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);


        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
