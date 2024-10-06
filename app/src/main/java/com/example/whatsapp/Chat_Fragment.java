package com.example.whatsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.whatsapp.AdapterClass.Adapter;
import com.example.whatsapp.AdapterClass.ChatAdapter;
import com.example.whatsapp.Models.ChatModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;


import java.util.ArrayList;

public class Chat_Fragment extends Fragment {
    FirebaseAuth auth;
    FirebaseDatabase database;
    FirebaseStorage storage;
    RecyclerView recyclerView;
    ArrayList<ChatModel> arrayList;
    FragmentActivity binding;

    public Chat_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        storage = FirebaseStorage.getInstance();


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat_, container, false);
        arrayList = new ArrayList<>();
        arrayList.add(new ChatModel(R.drawable.my, "adnan", "Hello g", "1:00"));
        arrayList.add(new ChatModel(R.drawable.my, "adnan", "Hello g", "1:00"));
        arrayList.add(new ChatModel(R.drawable.my, "adnan", "Hello g", "1:00"));
        arrayList.add(new ChatModel(R.drawable.my, "adnan", "Hello g", "1:00"));
        arrayList.add(new ChatModel(R.drawable.my, "adnan", "Hello g", "1:00"));
        arrayList.add(new ChatModel(R.drawable.my, "adnan", "Hello g", "1:00"));
        arrayList.add(new ChatModel(R.drawable.my, "adnan", "Hello g", "1:00"));
        arrayList.add(new ChatModel(R.drawable.my, "adnan", "Hello g", "1:00"));
        arrayList.add(new ChatModel(R.drawable.my, "adnan", "Hello g", "1:00"));
        ChatAdapter adapter = new ChatAdapter(arrayList, getContext());
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());


        recyclerView.setLayoutManager(layoutManager);


        return view;
    }
}