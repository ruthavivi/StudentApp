package com.example.studentapp;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.studentapp.model.Model;
import com.example.studentapp.model.Student;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Student>data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data= Model.instance.getAllStudents();



        ListView list=findViewById(R.id.main_list_v);
        MyAdapter adapter=new MyAdapter();
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Log.d("Tag","Row#"+i+"was selected");
                Intent intent=new Intent(MainActivity.this,StudentsInfoActivity.class);
                intent.putExtra("id",data.get(i).id);
                startActivity(intent);




            }





        });
        ImageButton btn = (ImageButton)findViewById(R.id.add_image_bttn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddStudentActivity.class);
                startActivity(intent);
            }
        });







    }
    class MyAdapter extends BaseAdapter{



        @Override
        public int getCount() {

            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {


            if(view==null){
                view=getLayoutInflater().inflate(R.layout.list_row,null);

                Log.d("Tag","creating new view for row"+i);
            }else{
                Log.d("Tag","reusing old view for row"+i);
            }



            Student student=data.get(i);
            TextView text= view.findViewById(R.id.listrow_text_v);
            text.setText(student.id);
            return view;
        }
    }
}