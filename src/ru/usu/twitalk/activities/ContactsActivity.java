package ru.usu.twitalk.activities;

import java.util.ArrayList;

import ru.usu.twitalk.Data;
import ru.usu.twitalk.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ContactsActivity extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contacts);
		
		TextView tvView = (TextView) findViewById(R.id.contactsHeader);
		
		//if (Data.contactsWithMsgs.isEmpty()) {
		if (Data.FOLLOWERS.isEmpty()) {
			tvView.setText("� ��� ��� ��� �� ������ ��������");
		}
		else {
		//Object[] contacts = Data.contactsWithMsgs.keySet().toArray();
			ArrayList<String> contacts = Data.FOLLOWERS;
		
		// ������� ������
		ListView lvContacts = (ListView) findViewById(R.id.lvContacts);
		
		// ������� �������
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
    		R.layout.my_list_item, contacts);
		
		// ����������� ������� ������
		lvContacts.setAdapter(adapter);
		
		
		lvContacts.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				TextView chosenContact = (TextView) view.findViewById(view.getId());
				Intent intent = new Intent("ru.usu.intent.action.showmsgs");
				intent.putExtra("chosenContact", chosenContact.getText());
				startActivity(intent);
				}
			});
		
		}
	}
}