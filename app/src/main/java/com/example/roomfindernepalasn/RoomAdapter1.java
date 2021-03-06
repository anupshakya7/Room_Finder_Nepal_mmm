package com.example.roomfindernepalasn;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RoomAdapter1 extends RecyclerView.Adapter<RoomViewHolder1>{

    private Sale_Fragment mContext;
    private List<RoomDataList> myRoomList;


    public RoomAdapter1(Sale_Fragment mContext, List<RoomDataList> myRoomList) {
        this.mContext = mContext;
        this.myRoomList = myRoomList;
    }

    @Override
    public RoomViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mView= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row_item,parent,false);

        return new RoomViewHolder1(mView);
    }



    public void onBindViewHolder(@NonNull final RoomViewHolder1 holder, int position) {

        Glide.with(mContext)
                .load(myRoomList.get(position).getRoomImage())
                .into(holder.imageView);

//        holder.imageView.setImageResource(myRoomList.get(position).getRoomImage());
        holder.mDescription.setText(myRoomList.get(position).getRoomDescription());
        holder.mLocation.setText(myRoomList.get(position).getRoomLocation());
        holder.mPrice.setText(myRoomList.get(position).getRoomPrice());

//        holder.mCardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(v.getContext(),DetailActivity.class);
//                intent.putExtra("Image",myRoomList.get(holder.getAdapterPosition()).getRoomImage());
//                intent.putExtra("Description",myRoomList.get(holder.getAdapterPosition()).getRoomDescription());
//                mContext.startActivity(intent);
//            }
//        });

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(),RoomDetailActivity1.class);
                intent.putExtra("Image",myRoomList.get(holder.getAdapterPosition()).getRoomImage());
                intent.putExtra("Description",myRoomList.get(holder.getAdapterPosition()).getRoomDescription());
                intent.putExtra("Location",myRoomList.get(holder.getAdapterPosition()).getRoomLocation());
                intent.putExtra("Price",myRoomList.get(holder.getAdapterPosition()).getRoomPrice());
                intent.putExtra("ketValue",myRoomList.get(holder.getAdapterPosition()).getKey());
                mContext.startActivity(intent);

            }
        });


    }



    @Override
    public int getItemCount() {
        return myRoomList.size();
    }



}

class RoomViewHolder1 extends RecyclerView.ViewHolder{

    ImageView imageView;
    TextView mDescription,mLocation,mPrice;
    CardView mCardView;

    public RoomViewHolder1(View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.ivImage);
        mDescription = itemView.findViewById(R.id.tvDescription);
        mLocation = itemView.findViewById(R.id.tvLocation);
        mPrice = itemView.findViewById(R.id.tvPrice);

        mCardView=itemView.findViewById(R.id.myCardView);
    }
}
