package com.user.jattana.View;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.user.jattana.DAO.EstateDAOImpl;
import com.user.jattana.Model.EstateProperty;
import com.user.jattana.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.myCustomAdapterHolder> {

    public ImageView.ScaleType scaleType=ImageView.ScaleType.FIT_XY;
    ArrayList<EstateProperty> estateProperty_list=new ArrayList<>();
    public Context context;
    EstateDAOImpl estateDAOImpl;
    private ArrayList<EstateProperty> estateProperty_arraylist;
    public CustomAdapter(){}

    public CustomAdapter(Context context,ArrayList<EstateProperty> estatePropertyList)
    {
        this.context=context;
        this.estateProperty_list=estatePropertyList;
        this.estateProperty_arraylist=new ArrayList<>();
        this.estateProperty_arraylist.addAll(estatePropertyList);

    }
//    public void OnDataChange(ArrayList<EstateProperty> estatePropertyList)
//    {
//        this.estateProperty_list=estateProperty_list;
//        notifyDataSetChanged();
//    }

    public void OnScaleChange(ImageView.ScaleType scaleType)
    {
        this.scaleType=scaleType;
        notifyDataSetChanged();
    }
    @Override
    public myCustomAdapterHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        View view=inflater.inflate(R.layout.item_layout,viewGroup,false);
        //---1
//        view.setBackgroundColor(Color.RED);

        myCustomAdapterHolder customAdapterHolder=new myCustomAdapterHolder(view);

        return customAdapterHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull myCustomAdapterHolder myCustomAdapterHolder, int pos) {

        EstateProperty estateProperty=estateProperty_list.get(pos);
        myCustomAdapterHolder.txt_result.setText(estateProperty.toString());
        if(pos%2==0) {
            myCustomAdapterHolder.itemView.setBackgroundColor(Color.LTGRAY);
        }
        else {
            myCustomAdapterHolder.itemView.setBackgroundColor(Color.WHITE);
        }

//        myCustomAdapterHolder.text_dir.setTextColor(Color.BLACK);
//        myCustomAdapterHolder.text_title.setTextColor(Color.BLACK);
    }

    @Override
    public int getItemCount() {
        return estateProperty_list.size();
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        estateProperty_list.clear();
        if (charText.length() == 0) {
            estateProperty_list.addAll(estateProperty_arraylist);
        } else {
            Log.d(">>>>>>filter", "filter: entering...."+estateProperty_arraylist.size()+" ---- "+charText);
//            Log.d(TAG, "filter: "+estateProperty_list.);
            for (EstateProperty ep : estateProperty_arraylist) {
                Log.d(">>>>>>filter", "filter: "+ep.getLocation()+" ---- "+charText);
                if (ep.toString().toLowerCase(Locale.getDefault()).contains(charText)){
//                        ep.getType().toLowerCase(Locale.getDefault()).contains(charText) ||
//                        ep.getLocation().toLowerCase(Locale.getDefault()).contains(charText) ||
//                        ep.getAskingPrice()s(charText)) {
                    estateProperty_list.add(ep);
                }
            }
        }
        notifyDataSetChanged();
    }

    public class myCustomAdapterHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txt_result;
        public myCustomAdapterHolder(@NonNull View itemView) {
            super(itemView);
            txt_result=itemView.findViewById(R.id.txt_result);

            // Toast.makeText(itemView.getContext(), "hello", Toast.LENGTH_SHORT).show();
//            img_item.setOnClickListener(this);
//            text_title.setOnClickListener(this);
//            text_dir.setOnClickListener(this);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent editProperty_intent=new Intent(context.getApplicationContext(),EditPropertyActivity.class);
                    //Bundle args = new Bundle();
                    //args.putSerializable("estateProperty_list",(Serializable)estateProperty_list);
                    int itemPosition =getAdapterPosition();
                    Log.d(">>>>>>>itemPos", "onClick: "+itemPosition);
                    estateDAOImpl=new EstateDAOImpl(context);
                    int estateProperty_id=estateProperty_list.get(itemPosition).getId();
                    Log.d(">>>>>>custom_id", "onClick: "+estateProperty_id);
//                    if()
                    EstateProperty estateProperty=estateDAOImpl.getEstateProperty(estateProperty_id);
                    Log.d(">>>>>>custom_ep", "onClick: "+estateProperty.toString());
                    editProperty_intent.putExtra("estateProperty", (Parcelable) estateProperty);
                    context.startActivity(editProperty_intent);
                }
            });

        }

        @Override
        public void onClick(View v) {
//            switch (v.getId())
//            {
//                case R.id.textView_dir:
//                    break;
//                case R.id.textView_title:
//                    break;
//                case R.id.imageView_pics:
//                    break;
//            }

        }
    }
}
