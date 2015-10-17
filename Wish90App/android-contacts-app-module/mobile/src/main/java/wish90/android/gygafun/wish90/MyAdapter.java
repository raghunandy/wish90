package wish90.android.gygafun.wish90;

import android.content.Context;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    public static List<Personsinfo> persons;
    String nameofperson;
    String dateofbirth;
    MyAdapter()
    {}
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
        public View view;
        ImageView image;
        TextView name;
        TextView DOB;
        Intent intent;
        MyAdapter adapter1=new MyAdapter();
        public ViewHolder(View v) {
            super(v);
            view=v;
            image=(ImageView)v.findViewById(R.id.person_photo);
            name=(TextView)v.findViewById(R.id.person_name);
            name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int x=getPosition();

                    intent=new Intent(view.getContext(),Dispalyinfo.class);

                    intent.putExtra("Name",persons.get(x).name);
                    intent.putExtra("dateofbirth",persons.get(x).dateofbirth);
                    view.getContext().startActivity(intent);
                }
            });
            DOB=(TextView)v.findViewById(R.id.person_age);

        }
    }



}