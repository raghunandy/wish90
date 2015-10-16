package wish90.android.gygafun.wish90;

import android.content.Context;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    List<Personsinfo> persons;
    MyAdapter(List<Personsinfo> persons){
        this.persons=persons;
    }
    public LayoutInflater layoutInflater;


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayoutforcontacts,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(persons.get(position).name);
        holder.DOB.setText(persons.get(position).dateofbirth);
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name;
        TextView DOB;

        public ViewHolder(View v) {
            super(v);

            image=(ImageView)v.findViewById(R.id.person_photo);
            name=(TextView)v.findViewById(R.id.person_name);
            DOB=(TextView)v.findViewById(R.id.person_age);

        }
    }



}