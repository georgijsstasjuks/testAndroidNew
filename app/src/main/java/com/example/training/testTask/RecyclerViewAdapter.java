package com.example.training.testTask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.training.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    interface OnStateClickListener{
        void onStateClick(ClientModel client, int position);
    }

    private  OnStateClickListener mOnClickListener;
    private  LayoutInflater mInflater;
    private ArrayList<ClientModel> mClients;

    RecyclerViewAdapter(Context context, ArrayList<ClientModel> clients, OnStateClickListener onClickListener){
        this.mInflater = LayoutInflater.from(context);
        this.mClients = clients;
        this.mOnClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.activity_main_recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ClientModel client = mClients.get(position);
        holder.mTextView.setText(client.getUserName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickListener.onStateClick(client, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mClients.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView mTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.textView);
        }
    }
}
