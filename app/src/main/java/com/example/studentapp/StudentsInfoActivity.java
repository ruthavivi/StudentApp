package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.studentapp.model.Model;

public class StudentsInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_info);
        Intent intent=getIntent();
        String id=intent.getStringExtra("id");
        TextView text=findViewById(R.id.StudentInfo_text_v);
        Model.instance.getStudentById(id);
        text.setText(id);

        Button buttonOne = findViewById(R.id.edit_bttn);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                System.out.println("Button Clicked");
                Intent intent1 = new Intent(StudentsInfoActivity.this, EditStudentActivity.class);
                startActivity(intent1);
            }
        });


    }
}