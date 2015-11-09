/**
 * Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/
 *
 */
package leona.gygafun.wish90.presentation.view.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toolbar;

import butterknife.Bind;
import butterknife.BindDrawable;
import butterknife.ButterKnife;
import leona.gygafun.wish90.presentation.R;
import leona.gygafun.wish90.presentation.model.UserModel;
import leona.gygafun.wish90.presentation.model.UserMomentModel;
import leona.gygafun.wish90.presentation.util.TextUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Adaptar that manages a collection of {@link UserModel}.
 */
public class UserMomentsAdapter extends RecyclerView.Adapter<UserMomentsAdapter.UserMomentViewHolder> {

  public interface OnItemClickListener {
    void onUserItemClicked(UserMomentModel userModel);
  }

  private List<UserMomentModel> userMomentCollection;
  private final LayoutInflater layoutInflater;
  private Context context;

  //@BindDrawable(R.drawable.contact_default_image)

  private OnItemClickListener onItemClickListener;

  public UserMomentsAdapter(Context context, Collection<UserMomentModel> usersCollection) {
    this.validateUsersCollection(usersCollection);
    this.context=context;
    this.layoutInflater =
        (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    this.userMomentCollection = (List<UserMomentModel>) usersCollection;
  }

  @Override public int getItemCount() {
    return (this.userMomentCollection != null) ? this.userMomentCollection.size() : 0;
  }

  @Override public UserMomentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = this.layoutInflater.inflate(R.layout.row_moment, parent, false);
    UserMomentViewHolder userMomentViewHolder = new UserMomentViewHolder(view);

    return userMomentViewHolder;
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  @Override public void onBindViewHolder(UserMomentViewHolder holder, final int position) {
    final UserMomentModel userMomentModel = this.userMomentCollection.get(position);
    Date momDate=userMomentModel.getMomentDateTime();
    long momDateMillSec=System.currentTimeMillis()-momDate.getTime();
    String cName=TextUtil.makeStringCamelCase(userMomentModel.getRefContact().getContactName());
    holder.contactName.setText(cName);
    String mDate= TextUtil.makeSimpleDatString(userMomentModel.getMomentDateTime());

    holder.weeks.setText((momDateMillSec/(7*24*60*60*1000))+" weeks");

    holder.days.setText((momDateMillSec/(24*60*60*1000))+" days");
    holder.hours.setText((momDateMillSec/(60*60*1000))+" hours");
    holder.min.setText((momDateMillSec / (  60 * 1000)) + " minutes");

    if ((userMomentModel.getRefContact().getContactImage())!=null) {
      holder.contactImage.setImageURI(Uri.parse(userMomentModel.getRefContact().getContactImage()));
    }
    else{
      holder.contactImage.setImageResource(R.drawable.contact_default_image);
    }
  holder.imageButton.setImageResource(R.drawable.ic_card_options);
    holder.momentDateTime.setText(mDate);
    final PopupMenu popup=new PopupMenu(this.context,holder.imageButton);
    MenuInflater menuInflater=popup.getMenuInflater();
    menuInflater.inflate(R.menu.main, popup.getMenu());
    holder.imageButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        popup.show();
      }
    });
   // popup.show();

    /*List<String> list = new ArrayList<String>();
    list.add("");
    list.add("Wish Now!");
    list.add("Alert Me");
    list.add("Schedule a Wish");

    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item, list);
    dataAdapter.setDropDownViewResource(R.layout.row_moment);
    holder.options.setAdapter(dataAdapter);*/
        holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override public void onClick(View v) {
        if (UserMomentsAdapter.this.onItemClickListener != null) {
          UserMomentsAdapter.this.onItemClickListener.onUserItemClicked(userMomentModel);
        }
      }
    });
  }

  @Override public long getItemId(int position) {
    return position;
  }

  public void setUserMomentCollection(Collection<UserMomentModel> usersCollection) {
    this.validateUsersCollection(usersCollection);
    this.userMomentCollection = (List<UserMomentModel>) usersCollection;
    this.notifyDataSetChanged();
  }

  public void setOnItemClickListener (OnItemClickListener onItemClickListener) {
    this.onItemClickListener = onItemClickListener;
  }

  private void validateUsersCollection(Collection<UserMomentModel> usersCollection) {
    if (usersCollection == null) {
      throw new IllegalArgumentException("The list cannot be null");
    }
  }


  static class UserMomentViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.contact_name) TextView contactName;

    @Bind(R.id.moment_date_time) TextView momentDateTime;
    @Bind(R.id.contact_image) ImageView contactImage;
    @Bind(R.id.weeks) TextView weeks;
    @Bind(R.id.days) TextView days;
    @Bind(R.id.hours) TextView hours;
    @Bind(R.id.min) TextView min;
    @Bind(R.id.imageButton)
    ImageButton imageButton;
    //@Bind(R.id.optionsSpinner)    Spinner options;


    public UserMomentViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
