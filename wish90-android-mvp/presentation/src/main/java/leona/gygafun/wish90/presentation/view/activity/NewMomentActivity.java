package leona.gygafun.wish90.presentation.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import leona.gygafun.wish90.domain.repository.UserMomentFields.*;
import leona.gygafun.wish90.presentation.R;
import leona.gygafun.wish90.presentation.di.components.DaggerUserComponent;
import leona.gygafun.wish90.presentation.di.components.UserComponent;
import leona.gygafun.wish90.presentation.model.UserMomentModel;


public class NewMomentActivity extends BaseActivity {

    @Bind(R.id.momentType)
    AutoCompleteTextView  momentType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_moment);

        ButterKnife.bind(this);

        MOMENT_TYPES[] momentTypes = MOMENT_TYPES.values();
        String[] list=new String[momentTypes.length];
        for(int i=0;i<momentTypes.length;i++){
            list[i]=momentTypes[i].toString();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        momentType.setAdapter(adapter);


    }


    @OnClick(R.id.momentType)
    public void onSaveMoment(){



    }


}
