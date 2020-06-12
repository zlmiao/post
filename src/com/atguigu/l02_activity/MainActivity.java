package com.atguigu.l02_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private EditText et_main_message;
	private Button btn_main_start1;
	private Button btn_main_start2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//��ʼ����ͼ����
		et_main_message = (EditText) findViewById(R.id.et_main_message);  //�����
		btn_main_start1 = (Button) findViewById(R.id.btn_main_start1);
		btn_main_start2 = (Button) findViewById(R.id.btn_main_start2);
		//���õ������
		btn_main_start1.setOnClickListener(this);
		btn_main_start2.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {//v���Ƿ����¼�����ͼ���󣨲����ģ�
		if (v==btn_main_start1) {
//			Toast.makeText(this, "һ������", 0).show();
			//1).����Intent������ʽ��
			Intent intent = new Intent(this, SecondActivity.class);
			//2).ͨ��intentЯ����������
			String message = et_main_message.getText().toString();
			intent.putExtra("MESSAGE", message);
			//3).����Activity
			startActivity(intent);
			
		}else if (v==btn_main_start2) {
			//Toast.makeText(this, "���ص�����", 0).show();
			
			//1).����Intent������ʽ��
			Intent intent = new Intent(this, SecondActivity.class);
			//2).ͨ��intentЯ����������
			String message = et_main_message.getText().toString();
			intent.putExtra("MESSAGE", message);
			//3).���ص�����Activity
			int requestCode = 2;   //������
			startActivityForResult(intent, requestCode);
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		//�ж�code
		if (requestCode==2 && resultCode==3) {
			//��data��ȡ������
			String result = data.getStringExtra("RESULT");
			//��ʾ
			et_main_message.setText(result);
		}
			
	}
}
