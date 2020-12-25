package com.example.qqapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.qqapplication.db.Account;

import org.litepal.LitePal;

import java.util.List;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button_s;
    private Button button_l;
    private List<Account> account;
    private String id;
    private String passwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LitePal.initialize(this);
        setContentView(R.layout.activity_register);

        /*Account account = new Account();
        account.setId("123");
        account.setPasswd("123");
        account.save();*/

//        LitePal.findAll(Account.class);

        button_l = findViewById(R.id.button_l);
        button_s = findViewById(R.id.button_s);

        button_l.setOnClickListener(this);
        button_s.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        EditText editText1 = findViewById(R.id.username_ET);
        EditText editText2 = findViewById(R.id.password_ET);
        id = editText1.getText().toString();
        passwd = editText2.getText().toString();

        Log.d("Register", "21345");
        Log.d("Register", passwd);

        switch(view.getId()){
            case R.id.button_s:
                account = LitePal.where("accountId=?", id).find(Account.class);
                if (account.isEmpty()) {
                    Account addAccount = new Account();
                    addAccount.setId(id);
                    addAccount.setPasswd(passwd);
                    addAccount.save();
                    Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegisterActivity.this,"用户已存在",Toast.LENGTH_SHORT).show();

                }
                break;
            case R.id.button_l:
                AlertDialog.Builder alerbuilder = new AlertDialog.Builder(RegisterActivity.this);
                alerbuilder.setIcon(R.mipmap.ic_launcher);
                alerbuilder.setTitle("用户登录确认");
                alerbuilder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        account = LitePal.where("accountId=? and passwd=?", id, passwd).find(Account.class);
                        if (!account.isEmpty()) {
                            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(intent);
                            Toast.makeText(RegisterActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(RegisterActivity.this,"登陆失败",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alerbuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(RegisterActivity.this,"取消登陆",Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog myAlert = alerbuilder.create();
                myAlert.show();
                break;

            default:
                break;
        }
    }
}