package com.example.cycueat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import com.example.threecountryeat.R;
import com.example.threecountryeat.R.id;
import com.example.threecountryeat.R.layout;
import com.example.threecountryeat.R.menu;

import db.ItemDAO;
import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class UserDefineAdd extends ActionBarActivity {

  private Spinner type ;
  private EditText food ;
  private EditText price ;
  private EditText boss ;
  private Button sent ;
  private OnClickListener sentLis = new OnClickListener() {
    @Override
    public void onClick(View v) {
      if ( food.getText().toString().compareTo( "" ) == 0 || 
           price.getText().toString().compareTo( "" ) == 0 ||
           boss.getText().toString().compareTo( "" ) == 0 ) {
        Toast.makeText( UserDefineAdd.this, "請勿留下空白", Toast.LENGTH_SHORT ).show() ;
      } // if
      else {
        Vector<String> data = new Vector<String>() ;
        SimpleDateFormat sdf = new SimpleDateFormat( "EEE, d日  MMM yyyy HH:mm:ss Z" );
        Date date = new Date() ;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        data.add( sdf.format( calendar.getTime() ) ) ;
        data.add( price.getText().toString() ) ;
        data.add( food.getText().toString() ) ;
        data.add( type.getSelectedItem().toString()) ;
        data.add( boss.getText().toString() ) ;
        data.add( "0" ) ;
        ItemDAO db = new ItemDAO( UserDefineAdd.this ) ;
        db.insert( data ) ;
        db.close() ;
        finish() ;
      } // else
    } // onClick()
  } ; // OnClickListener()
  
  private final String[] TYPELIST = { "飯", "麵", "冬粉", "水餃", "湯餃", "粥", "湯", "飲料", "小點心" } ;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_user_define_add);
    food = (EditText) findViewById( R.id.infood ) ;
    price = (EditText) findViewById( R.id.inprice ) ;
    boss = (EditText) findViewById( R.id.inboss ) ;
    sent = (Button) findViewById( R.id.addsent ) ;
    sent.setOnClickListener( sentLis ) ;
    ArrayAdapter<String> lunchList = new ArrayAdapter<String>( UserDefineAdd.this, android.R.layout.simple_spinner_item, TYPELIST );
    type = (Spinner) findViewById( R.id.intype ) ;
    type.setAdapter( lunchList ) ;
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.user_define_add, menu);
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
}
