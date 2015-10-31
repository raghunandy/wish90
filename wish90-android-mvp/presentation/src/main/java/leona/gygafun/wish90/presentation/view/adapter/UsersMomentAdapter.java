/**
 * Wish 90
 *
 */
package leona.gygafun.wish90.presentation.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import leona.gygafun.wish90.presentation.R;
import leona.gygafun.wish90.presentation.model.UserModel;
import leona.gygafun.wish90.presentation.model.UserMomentModel;

import java.util.Collection;
import java.util.List;

/**
 * Adaptar that manages a collection of {@link UserModel}.
 */
public class UsersMomentAdapter extends RecyclerView.Adapter<UsersMomentAdapter.UserViewHolder> {

  public interface OnItemClickListener {
    void onUserItemClicked(UserMomentModel userModel);
  }

  private List<UserMomentModel> usersCollection;
  private final LayoutInflater layoutInflater;

  private OnItemClickListener onItemClickListener;

  public UsersMomentAdapter(Context context, Collection<UserMomentModel> usersCollection) {
    this.validateUsersCollection(usersCollection);
    this.layoutInflater =
        (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    this.usersCollection = (List<UserMomentModel>) usersCollection;
  }

  @Override public int getItemCount() {
    return (this.usersCollection != null) ? this.usersCollection.size() : 0;
  }

  @Override public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = this.layoutInflater.inflate(R.layout.row_user, parent, false);
    UserViewHolder userViewHolder = new UserViewHolder(view);

    return userViewHolder;
  }

  @Override public void onBindViewHolder(UserViewHolder holder, final int position) {
    final UserMomentModel userModel = this.usersCollection.get(position);
    holder.textViewTitle.setText(userModel.getRefContact().getContactName());
    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        if (UsersMomentAdapter.this.onItemClickListener != null) {
          UsersMomentAdapter.this.onItemClickListener.onUserItemClicked(userModel);
        }
      }
    });
  }

  @Override public long getItemId(int position) {
    return position;
  }

  public void setUsersCollection(Collection<UserMomentModel> usersCollection) {
    this.validateUsersCollection(usersCollection);
    this.usersCollection = (List<UserMomentModel>) usersCollection;
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

  static class UserViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.person_name) TextView textViewTitle;

    public UserViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
