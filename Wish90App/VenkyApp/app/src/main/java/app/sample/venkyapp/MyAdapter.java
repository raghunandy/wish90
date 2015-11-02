package app.sample.venkyapp;

import android.content.Context;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    public static List<Personsinfo> persons;
    MyAdapter(List<Personsinfo> persons){
        this.persons=persons;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayoutforcontacts,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(persons.get(position).name);
        holder.DOB.setText(persons.get(position).dateofbirth);
        //holder.image.setImageBitmap(persons.get(position).images);
        String a=persons.get(position).dateofbirth;
        if ((persons.get(position).image)!=null)
        holder.image.setImageURI(Uri.parse(persons.get(position).image));
        else
        holder.image.setImageResource(R.drawable.rsz_1rsz_default_image);
        try {
            Date dateOfBirth=new SimpleDateFormat("MMM dd, yyyy").parse(a);
            Date now=new Date();
            long diffMilliSeocnds=now.getTime()-dateOfBirth.getTime();
            String s=""+(long)(diffMilliSeocnds/1000);
            holder.sec.append(s);
            s=null;
            s=""+(long)(diffMilliSeocnds/(1000*60));
            holder.min.append(s);
            s=null;
            s=""+(long)(diffMilliSeocnds/(1000*60*60));
            holder.hour.append(s);
            s=null;
            s=""+(long)(diffMilliSeocnds/(24*60*60*1000));
            holder.days.append(s);
            s=null;
            s=""+(int)(diffMilliSeocnds/(7*24*60*60*1000));
            holder.weeks.append(s);
            s=null;

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }



    @Override
    public int getItemCount() {
        return persons.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        ImageView image;
        TextView name,years,days,weeks,months,hour,min,sec;
        TextView DOB;
        Intent intent;
        public ViewHolder(View v) {
            super(v);
            view =v;
            image=(ImageView)v.findViewById(R.id.person_photo);
            name=(TextView)v.findViewById(R.id.person_name);
            name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int x=getPosition();

                    intent=new Intent(view.getContext(),Dispalyinfo.class);
                    intent.putExtra("Name",persons.get(x).name);
                    intent.putExtra("dateofbirth",persons.get(x).dateofbirth);
                    intent.putExtra("picture",persons.get(x).image);
                    view.getContext().startActivity(intent);
                }
            });
            DOB=(TextView)v.findViewById(R.id.person_age);
           // years=(TextView)v.findViewById(R.id.years);
            //months=(TextView)v.findViewById(R.id.months);
            weeks=(TextView)v.findViewById(R.id.weeks);
            days=(TextView)v.findViewById(R.id.days);
            hour=(TextView)v.findViewById(R.id.hours);
            min=(TextView)v.findViewById(R.id.min);
            sec=(TextView)v.findViewById(R.id.seconds);
        }
    }



}