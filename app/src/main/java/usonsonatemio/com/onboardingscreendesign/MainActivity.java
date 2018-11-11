package usonsonatemio.com.onboardingscreendesign;

import android.opengl.Visibility;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private SlideAdapter slideAdapter;
    private TextView[] mDtos;
    private Button btnAnterior, btnSiguiente;
    private int mCurrentPage;
    private RelativeLayout maincontainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSlideViewPager = findViewById(R.id.SlideViewPager);
        mDotLayout = findViewById(R.id.dotsLayout);
        btnAnterior = findViewById(R.id.btnPrevio);
        btnSiguiente = findViewById(R.id.btnSiguiente);
        slideAdapter = new SlideAdapter(this);
        maincontainer = findViewById(R.id.MainContainer);

        mSlideViewPager.setAdapter(slideAdapter);

        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlideViewPager.setCurrentItem(mCurrentPage + 1);
            }
        });

        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlideViewPager.setCurrentItem(mCurrentPage - 1);
            }
        });

    }

    public void addDotsIndicator(int position){
        mDtos = new TextView[5];
        mDotLayout.removeAllViews();

        for (int i = 0; i <  mDtos.length; i++){
            mDtos[i] = new TextView(this);
            mDtos[i].setText(Html.fromHtml("&#8226;"));
            mDtos[i].setTextSize(35);
            mDtos[i].setTextColor(getResources().getColor(R.color.colorTransparentwhite));

            mDotLayout.addView(mDtos[i]);

        }

        if(mDtos.length > 0){
            mDtos[position].setTextColor(getResources().getColor(R.color.white));
        }


    }


    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDotsIndicator(position);
            mCurrentPage = position;


            if(position == 0){
                btnSiguiente.setEnabled(true);
                btnAnterior.setEnabled(false);
                btnAnterior.setVisibility(View.INVISIBLE);

                btnAnterior.setText("");
                btnSiguiente.setText("Siguiente");

            }else if(position == mDtos.length - 1 ){
                btnSiguiente.setEnabled(true);
                btnAnterior.setEnabled(true);
                btnAnterior.setVisibility(View.VISIBLE);

                btnAnterior.setText("Anterior");
                btnSiguiente.setText("Terminar");

            }else{
                btnSiguiente.setEnabled(true);
                btnAnterior.setEnabled(true);
                btnAnterior.setVisibility(View.VISIBLE);

                btnAnterior.setText("Anterior");
                btnSiguiente.setText("Siguiente");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
