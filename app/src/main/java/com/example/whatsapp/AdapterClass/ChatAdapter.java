package com.example.whatsapp.AdapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsapp.Models.ChatModel;
import com.example.whatsapp.R;
import com.example.whatsapp.databinding.ChatRvBinding;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.viewHolder> {
    ArrayList<ChatModel> list;
    Context context;

    public ChatAdapter(ArrayList<ChatModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.chat_rv,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        ChatModel model=list.get(position);
        holder.binding.profileImage.setImageResource(model.getUserImage());
        holder.binding.nameTv.setText(model.getUserName());
        holder.binding.chatTv.setText(model.getUserLastMsg());
        holder.binding.timeTv.setText(model.getMsgTime());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ChatRvBinding binding;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            binding=ChatRvBinding.bind(itemView);
        }
    }
}
