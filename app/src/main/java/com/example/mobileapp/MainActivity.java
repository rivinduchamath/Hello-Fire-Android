package com.example.mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {

    private Button addButton;
    private EditText valueField;
    private TextView textView;
    private Firebase mRootRef;
    private Firebase mRootRef1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valueField = (EditText) findViewById(R.id.valueField);
        addButton = (Button) findViewById(R.id.addBtn);
        textView = (TextView) findViewById(R.id.textView);

        mRootRef = new Firebase("https://mobileapp-41e97.firebaseio.com/Users");
        mRootRef1 = new Firebase("https://mobileapp-41e97.firebaseio.com/Users/Name");


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = valueField.getText().toString();
                Firebase childRef = mRootRef.child("Name");
                childRef.setValue(value);
            }
        });

      mRootRef1.addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(DataSnapshot dataSnapshot) {
              String value = dataSnapshot.getValue(String.class);
              textView.setText(value);
          }

          @Override
          public void onCancelled(FirebaseError firebaseError) {
          }
      });
    }
}
