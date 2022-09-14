package com.example.gridlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Button btnsignup;
    EditText edtpass, edtemail;
    TextView linksignup;
    String ten, mk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        addcontrols();

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtemail.getText().length() != 0 && edtpass.getText().length() !=0){
                    if(edtemail.getText().toString().equals(ten) && edtpass.getText().toString().equals(mk)){
                        Toast.makeText(MainActivity2.this,"Ban da dang nhap thanh cong",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                        startActivity(intent);
                    }else if(edtemail.getText().toString().equals("khoa123") && edtpass.getText().toString().equals("123456")){
                        Toast.makeText(MainActivity2.this,"Ban da dang nhap thanh cong",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity2.this,"Ban da dang nhap that bai",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity2.this,"moi ban nhap day du thong tin",Toast.LENGTH_SHORT).show();
                }
            }
        });
        linksignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity2.this);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.layout_dangky);
                EditText edtepass_up = (EditText) dialog.findViewById(R.id.edtepass_up);
                EditText edtemail_up =(EditText) dialog.findViewById(R.id.edtemail_up);
                Button btnsignup =  (Button) dialog.findViewById(R.id.btnsignup);
                ImageView back_up = (ImageView) dialog.findViewById(R.id.back_up);

                back_up.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });

                btnsignup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ten = edtemail_up.getText().toString().trim();
                        mk = edtepass_up.getText().toString().trim();

                        edtemail.setText(ten);
                        edtpass.setText(mk);
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });

    }


    private void addcontrols() {
        btnsignup =(Button) findViewById(R.id.btnsignup);
        edtemail = (EditText) findViewById(R.id.edtemail);
        edtpass = (EditText) findViewById(R.id.edtpass);
        linksignup = (TextView) findViewById(R.id.linksignup);
    }
}