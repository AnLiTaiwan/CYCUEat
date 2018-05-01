package com.example.cycueat;

import com.example.threecountryeat.R;
import com.example.threecountryeat.R.id;
import com.example.threecountryeat.R.layout;
import com.example.threecountryeat.R.menu;

import db.ItemDAO;
import db.RecordDAO;
import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class UserDefineList extends ActionBarActivity {

  private ListView userDef ;
  private Button backBtn ;
  private Button addBtn ;
  private OnClickListener addLis = new OnClickListener() {
    @Override
    public void onClick(View v) {
      // TODO Auto-generated method stub
      Intent goChoosePage = new Intent( UserDefineList.this, UserDefineAdd.class ) ;
      // startActivity( goChoosePage ); 
      startActivityForResult( goChoosePage, 0 ) ; 
    } // onClick()
  } ; // OnClickListener()
  
  private OnClickListener backLis = new OnClickListener() {
    @Override
    public void onClick(View v) {
      // TODO Auto-generated method stub
      finish() ;
    } // onClick()
  } ; // OnClickListener()
  
  private OnItemClickListener listVLis = new OnItemClickListener() {

    @Override
    public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
      Builder alert = new Builder( UserDefineList.this ) ;
      alert.setTitle( "吃不習慣嗎?") ;
      alert.setMessage( "吃膩了，要把紀錄刪除嗎?" ) ;
      alert.setIcon( R.drawable.ic_launcher ) ;
      alert.setPositiveButton( "繼續吃", new DialogInterface.OnClickListener() {

          @Override
          public void onClick(DialogInterface dialog, int which) {
            // grandpa say : nothing to do~  
          } // onClick()
        } // OnClickListener()
      ) ;
      alert.setNegativeButton( "刪除", new DialogInterface.OnClickListener() {

          @Override
          public void onClick(DialogInterface dialog, int which) {
             
            TextView tView = (TextView) view.findViewById( R.id.defdate ) ;
            ItemDAO db = new ItemDAO( UserDefineList.this ) ;
            db.delete( tView.getText().toString() ) ;
            db.close();
            userDef.setAdapter( new UserAdapter( getApplicationContext() ) ) ;

          } // onClick()
        } // OnClickListener()
      ) ;
      
      alert.show() ;
    } // onItemClick()
    
  } ; // listVLis
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_user_define_list);
    userDef = (ListView) findViewById( R.id.defineInUser ) ;
    userDef.setAdapter( new UserAdapter( getApplicationContext() ) ) ;
    userDef.setOnItemClickListener( listVLis ) ;
    backBtn = (Button) findViewById( R.id.backBtnInUser ) ;
    backBtn.setOnClickListener( backLis ) ;
    addBtn = (Button) findViewById( R.id.addBtnInUser ) ;
    addBtn.setOnClickListener( addLis ) ;
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.user_define_list, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();
    if (id == R.id.action_settings) {
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
  
  @Override
  protected void onActivityResult( int requestCode, int resultCode, Intent data ) {
    // 資料回傳接收
    super.onActivityResult( requestCode, resultCode, data ) ;
    userDef.setAdapter( new UserAdapter( getApplicationContext() ) ) ;
  } // onActivityResult()
}
