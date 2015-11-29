/**
 * Wish 90: The new age wishing app
 * Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/
 */
package leona.gygafun.wish90.presentation.view.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import leona.gygafun.wish90.presentation.R;
import leona.gygafun.wish90.presentation.di.components.UserComponent;
import leona.gygafun.wish90.presentation.model.UserMomentModel;
import leona.gygafun.wish90.presentation.presenter.UserMomentDetailsPresenter;
import leona.gygafun.wish90.presentation.util.TextUtil;
import leona.gygafun.wish90.presentation.view.UserMomentDetailsView;
import leona.gygafun.wish90.presentation.view.activity.ManageWish;

import javax.inject.Inject;

/**
 * Fragment that shows details of a certain user.
 */

public class UserMomentMomentDetailsFragment extends BaseFragment implements UserMomentDetailsView {

    private static final String ARGUMENT_KEY_USER_MOMENT = "org.android10.ARGUMENT_USER_MOMENT";
    private static final int COUNTER_THREAD_DELAY = 1;

    private UserMomentModel userMomentModel;
    private boolean stopCounterThread = false;




    @Inject
    private UserMomentDetailsPresenter userMomentDetailsPresenter;

    @Bind(R.id.contact_name)
    TextView contactName;
    @Bind(R.id.days)
    TextView days;
    @Bind(R.id.weeks)
    TextView weeks;
    @Bind(R.id.mins)
    TextView mins;
    @Bind(R.id.moment_date_time)
    TextView momentDateTime;
//    @Bind(R.id.milliSecs)
//    TextView milliSecs;
    @Bind(R.id.secs)
    TextView secs;
    @Bind(R.id.contact_image)
    ImageView contactImage;
    @Bind(R.id.hours)
    TextView hours;

    @Bind(R.id.milliSecs)
    TextView milliSecs;

    @Bind(R.id.years)
    TextView years;

    @Bind(R.id.months)
    TextView months;

    @Bind(R.id.btnWish) Button wishButton;

    public UserMomentMomentDetailsFragment() {
    }

    public static UserMomentMomentDetailsFragment newInstance(UserMomentModel userMomentModel) {
        UserMomentMomentDetailsFragment userMomentDetailsFragment = new UserMomentMomentDetailsFragment();

        Bundle argumentsBundle = new Bundle();
        argumentsBundle.putSerializable(ARGUMENT_KEY_USER_MOMENT, userMomentModel);
        userMomentDetailsFragment.setArguments(argumentsBundle);

        return userMomentDetailsFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_user_moment_details, container, false);
        ButterKnife.bind(this, fragmentView);

        return fragmentView;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.initialize();
    }

    @Override
    public void onResume() {
        super.onResume();
        this.userMomentDetailsPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        this.userMomentDetailsPresenter.pause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.userMomentDetailsPresenter.destroy();
    }

    private void initialize() {
        this.getComponent(UserComponent.class).inject(this);
        this.userMomentDetailsPresenter.setView(this);
        this.userMomentModel = (UserMomentModel) getArguments().getSerializable(ARGUMENT_KEY_USER_MOMENT);
        this.userMomentDetailsPresenter.initialize(this.userMomentModel);
    }

    @Override
    public void renderUser(UserMomentModel userMomentModel) {

        if (userMomentModel != null) {
            contactName.setText(TextUtil.makeStringCamelCase(userMomentModel.getRefContact().getContactName()));
            momentDateTime.setText(TextUtil.makeSimpleDatString(userMomentModel.getMomentDateTime()));
            if ((userMomentModel.getRefContact().getContactImage()) != null) {
                contactImage.setImageURI(Uri.parse(userMomentModel.getRefContact().getContactImage()));
            } else {
                contactImage.setImageResource(R.drawable.contact_default_image);
            }
            updateDynamicUI();
        }
    }

    private Handler counterThread=new Handler();
    private class CounterThread extends  Thread{
        @Override
        public void run() {
            if (!stopCounterThread) {
                updateDynamiUIElements();
                counterThread.postDelayed(this, COUNTER_THREAD_DELAY);
            }
        }
    }
    public void updateDynamicUI() {
        counterThread.postDelayed(new CounterThread(), COUNTER_THREAD_DELAY);
    }

    public void updateDynamiUIElements() {

        Date momDate = userMomentModel.getMomentDateTime();
        long momDateMillSec = System.currentTimeMillis() - momDate.getTime();


        DecimalFormat formatter = new DecimalFormat("  #,###");

        String formattedMilli = formatter.format(momDateMillSec);
        milliSecs.setText(formattedMilli + " ms");


        String formattedYears = formatter.format((momDateMillSec / ( 24 * 60 * 60 * 1000)/365));
        years.setText(formattedYears + " years");

        String formattedMonths = formatter.format((int)(((float)momDateMillSec / ( 24 * 60 * 60 * 1000)/365)*12));
        months.setText(formattedMonths + " months");

        String formattedWeeks = formatter.format((momDateMillSec / (7 * 24 * 60 * 60 * 1000)));
        weeks.setText(formattedWeeks + " weeks");

        String formattedDays = formatter.format((momDateMillSec / (24 * 60 * 60 * 1000)));
        days.setText(formattedDays + " days");

        String formattedHours = formatter.format((momDateMillSec / (60 * 60 * 1000)));
        hours.setText(formattedHours + " hours");

        String formattedMins = formatter.format((momDateMillSec / (60 * 1000)));
        mins.setText(formattedMins + " minutes");

        String formattedSecs = formatter.format((momDateMillSec / ( 1000)));
        secs.setText(formattedSecs + " seconds");


    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRetry() {

    }

    @Override
    public void hideRetry() {

    }

    @Override
    public void showError(String message) {
        this.showToastMessage(message);
    }

    @Override
    public Context getContext() {
        return getActivity().getApplicationContext();
    }

    /**
     * Loads all users.
     */
    private void loadUserDetails() {
        if (this.userMomentDetailsPresenter != null) {
            this.userMomentDetailsPresenter.initialize(this.userMomentModel);
        }

    }

//  @OnClick(R.id.bt_retry)
//  void onButtonRetryClick() {
//    UserMomentMomentDetailsFragment.this.loadUserDetails();
//  }


    @Override
    public void onDetach() {
        super.onDetach();
        stopCounterThread = true;
    }

    @OnClick (R.id.btnWish) void wishButtonOnClickListener(){

        Intent intent;
        intent = new Intent(UserMomentMomentDetailsFragment.this.getActivity(), ManageWish.class);
        Bundle bundle=new Bundle();

        bundle.putString("contactName", contactName.getText().toString());
        bundle.putString("seconds",secs.getText().toString());
        bundle.putString("minutes", mins.getText().toString());
        bundle.putString("hours", hours.getText().toString());
        bundle.putString("days",days.getText().toString());
        bundle.putString("weeks",weeks.getText().toString());
        bundle.putString("months",months.getText().toString());
        bundle.putString("years",years.getText().toString());

        intent.putExtras(bundle);
        startActivity(intent);
    }

}
