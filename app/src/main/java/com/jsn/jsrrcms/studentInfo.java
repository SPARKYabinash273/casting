package com.jsn.jsrrcms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class studentInfo extends AppCompatActivity {
    studentInformation std = new studentInformation();

    String value="";
    String name="";
    TextView tvname,tvroll,tvdept,tvcontact;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);
        std=new studentInformation();
        std.setName("Name");
        final ProgressDialog pd=new ProgressDialog(this,ProgressDialog.STYLE_SPINNER);
        pd.setMessage("Fetching Information");
        pd.setCancelable(false);
        pd.show();

        Intent intent=getIntent();
        name=intent.getStringExtra("Name");
        Log.e("name is",name);
        if(name.equals("Email"))
            value=intent.getStringExtra("Email").trim();
        else
            value=intent.getStringExtra("RollNo");
        Log.e("email is", value);
        try{
            FirebaseDatabase database= FirebaseDatabase.getInstance();
            DatabaseReference databaseReference=database.getReference();
            databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    try {
                        // Toast.makeText(StudentInformationActivity.this, "Hello bro Again", Toast.LENGTH_SHORT).show();
                        Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                        for (DataSnapshot child : children) {
                            studentInformation std1=child.getValue(studentInformation.class);
                            //check for subjects
                            if(name.equals("Email")&&std1.getEmail().equalsIgnoreCase(value))
                                std = std1;
                            else if(name.equals("RollNo")&&std1.getRollno().equalsIgnoreCase(value))
                                std = std1;
                        }
                        pd.dismiss();
                        fn();
                    } catch (Exception e) {
                        Log.e("Exception is", e.toString());
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }catch(Exception e){
            Log.e("Exception is",e.toString());
        }

    }
    void fn(){
        try{
            if(std.getName().equals("Name")&&name.equals("RollNo")){
                Toast.makeText(getApplicationContext(), "Roll No. not found", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(studentInfo.this,select_roll_no.class);
                startActivity(intent);
                finish();
            }
        }catch(Exception e){

        }
        tvname=(TextView)findViewById(R.id.infotext4);
        tvroll=(TextView)findViewById(R.id.infotext);
        tvdept=(TextView)findViewById(R.id.infotext2);
        tvcontact=(TextView)findViewById(R.id.infotext3);
        lv=(ListView)findViewById(R.id.infolist);
        //Toast.makeText(StudentInformationActivity.this, "fn is called", Toast.LENGTH_SHORT).show();
        tvname.setText(std.getName());
        tvroll.setText(std.getRollno());
        tvdept.setText(std.getDepartment());
        tvcontact.setText(std.getPhone());
        ArrayList<Integer> al=std.getSubjects();
        ArrayList<String> subjectList=new ArrayList<String>();
        int count=0;
        int countTot=0;
        double sum1;
        double sum2;
        double sum3;

        for(int i=0;i<7;i++){
            int val=al.get(i);
            if(val!=-1){
                count=count+val%1000;
                String str="CS0"+(i+1)+"   ----   "+val%1000+" / ";
                sum1=val%1000;
                sum2=val/1000;
                sum3=sum1/sum2;
                sum3=sum3*100;
                val=val/1000;
                countTot=countTot+val%1000;

                str=str+val%1000+" Percentage "+new DecimalFormat("##.##").format(sum3)+"%";

                subjectList.add(str);

            }
        }
        if(countTot==0)
            countTot=1;
        Toast.makeText(studentInfo.this, "Your Total Attendance is--"+(count*100)/countTot+"%", Toast.LENGTH_LONG).show();
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,subjectList);
        lv.setAdapter(arrayAdapter);

    }
}
