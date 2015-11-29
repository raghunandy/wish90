package leona.gygafun.wish90.presentation.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import leona.gygafun.wish90.presentation.R;
import leona.gygafun.wish90.presentation.di.components.DaggerUserComponent;
import leona.gygafun.wish90.presentation.di.components.UserComponent;

public class ManageWish extends BaseActivity implements View.OnClickListener{


    @Bind({R.id.toggleButtonSeconds,R.id.toggleButtonMinutes,R.id.toggleButtonHours,
            R.id.toggleButtonDays,R.id.toggleButtonWeeks,R.id.toggleButtonMonths,R.id.toggleButtonYears})
    List<ToggleButton> toggleButtons;
    @Bind(R.id.btnWishNow)
    Button wishNow;
    private UserComponent userComponent;
    Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_wish);
        extras=getIntent().getExtras();
        ButterKnife.bind(this);
        this.initializeInjector();
        this.setTitle("Wish " + extras.getString("contactName"));
        setToggleButton(toggleButtons.get(0), extras.getString("seconds"));
        setToggleButton(toggleButtons.get(1),extras.getString("minutes"));
        setToggleButton(toggleButtons.get(2),extras.getString("hours"));
        setToggleButton(toggleButtons.get(3),extras.getString("days"));
        setToggleButton(toggleButtons.get(4), extras.getString("weeks"));
        setToggleButton(toggleButtons.get(5), extras.getString("months"));
        setToggleButton(toggleButtons.get(6), extras.getString("years"));
        toggleButtons.get(0).setOnClickListener(this);
        toggleButtons.get(1).setOnClickListener(this);
        toggleButtons.get(2).setOnClickListener(this);
        toggleButtons.get(3).setOnClickListener(this);
        toggleButtons.get(4).setOnClickListener(this);
        toggleButtons.get(5).setOnClickListener(this);
        toggleButtons.get(6).setOnClickListener(this);

    }
    final ButterKnife.Action<ToggleButton> CHANGE_COLOR = new ButterKnife.Action<ToggleButton>() {

        @Override
        public void apply(ToggleButton toggleButton, int index) {
            if(toggleButton.isChecked()) {
                toggleButton.setBackgroundColor(Color.parseColor("#ADD8E6"));
                toggleButton.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            }else {
                toggleButton.setBackgroundColor(Color.YELLOW);
                toggleButton.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
            }
        }
    };

    public void onClick(View v){
        ButterKnife.apply(toggleButtons,CHANGE_COLOR);
    }

    private void setToggleButton(ToggleButton toggleButton, String string) {
        toggleButton.setText(string);
        toggleButton.setTextOff(string);
        toggleButton.setTextOn(string);
    }
    @OnClick(R.id.btnWishNow) void wishNowOnClickListener(){
        Intent intent = new Intent(this, ConveyWishActivity.class);
        intent.putExtra("contactName", extras.getString("contactName"));
        startActivity(intent);
    }
    private void initializeInjector() {
        this.userComponent = DaggerUserComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }
}
