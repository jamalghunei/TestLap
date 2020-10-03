package com.example.testlap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adbterdescribtion extends RecyclerView.Adapter<Adbterdescribtion.viewHolder> {
    List<describtion> desc;
    Context context;


    public Adbterdescribtion(Context context,List<describtion> desc) {
this.desc=desc;
this.context=context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.image,parent,false);
    return new viewHolder(view) ;
    }


    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        describtion item = desc.get(position);

        holder.t.setText(item.getSender());
        Picasso.get().load(item.getSender()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return desc.size();
    }

    class viewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView t;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            t=itemView.findViewById(R.id.textView);
            imageView=itemView.findViewById(R.id.imageView);




        }}
}
