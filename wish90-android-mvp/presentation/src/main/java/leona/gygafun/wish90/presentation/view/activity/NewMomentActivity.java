package leona.gygafun.wish90.presentation.view.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import leona.gygafun.wish90.domain.repository.UserMomentFields.*;
import leona.gygafun.wish90.presentation.R;
import leona.gygafun.wish90.presentation.di.components.DaggerUserComponent;
import leona.gygafun.wish90.presentation.di.components.UserComponent;
import leona.gygafun.wish90.presentation.model.UserMomentModel;
import leona.gygafun.wish90.presentation.presenter.UserMomentDetailsPresenter;
import leona.gygafun.wish90.presentation.view.UserMomentDetailsView;


public class NewMomentActivity extends BaseActivity implements UserMomentDetailsView {


    private UserMomentModel userMomentModel;

    @Inject
    private UserMomentDetailsPresenter userMomentDetailsPresenter;

    @Bind(R.id.momentType)
    AutoCompleteTextView  momentType;

    @Bind(R.id.saveNewMoment)
    AutoCompleteTextView  saveNewMoment;

    @Bind(R.id.momentDateTime)
    EditText momentDateTime;

    @Bind(R.id.refContactInput)
    EditText refContactInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_moment);

        ButterKnife.bind(this);

        initStaticUI();
        
        userMomentModel=extractMoment(savedInstanceState);
        userMomentDetailsPresenter.setView(this);
        userMomentDetailsPresenter.initialize(userMomentModel);

    }

    private UserMomentModel extractMoment(Bundle savedInstanceState) {
        return (UserMomentModel) savedInstanceState.get("userMomentModel");
    }

    public void initStaticUI(){
        MOMENT_TYPES[] momentTypes = MOMENT_TYPES.values();
        String[] list=new String[momentTypes.length];
        for(int i=0;i<momentTypes.length;i++){
            list[i]=momentTypes[i].toString();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        momentType.setAdapter(adapter);

    }


    @OnClick(R.id.saveNewMoment)
    public void onSaveMoment(){
        String momentType="DummyMoment";
        Date date=new Date();
        userMomentDetailsPresenter.saveUserMoment();
    }


    @Override
    public void renderUser(UserMomentModel user) {

    }

    @Override
    public void showRetry() {

    }

    @Override
    public Context getContext() {
        return getContext();
    }

    @Override
    public void hideRetry() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String message) {

    }

}
