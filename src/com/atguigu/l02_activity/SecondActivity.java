package com.atguigu.l02_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * �����
 * 
 * @author zlmiao
 *
 */
public class SecondActivity extends Activity {

	private EditText et_second_message;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		et_second_message = (EditText) findViewById(R.id.et_second_message);
		
		//4). �õ�intent����
		Intent intent = getIntent();
		//5). ͨ��intent��ȡ��������
		String message = intent.getStringExtra("MESSAGE");
		//6). ��ʾ��EditText
		et_second_message.setText(message);
	}
	
	public void back1(View v) {
		//�رյ�ǰ����
		finish();
	}
	
	public void back2(View v) {
		
		//����һ�����
		int resultCode = 3;
			//׼��һ�����������ݵ�intent����
		Intent data = new Intent();
		String result = et_second_message.getText().toString();
		data.putExtra("RESULT", result);
			//���ý��
		setResult(resultCode, data );
		
		//�رյ�ǰ����
		finish();
	}
}
