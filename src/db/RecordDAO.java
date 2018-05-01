package db;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import defaultDATA.DefaultDATA;

public class RecordDAO {
  private static final String DATABASE_NAME = "eatRecord" ;
  public static final String DATE_COL = "date";
  public static final String PRICE1_COL = "price1";
  public static final String NAME1_COL = "name1";
  public static final String BOSS1_COL = "boss1";
  public static final String PRICE2_COL = "price2";
  public static final String NAME2_COL = "name2";
  public static final String BOSS2_COL = "boss2";
  
  public static final int DATE = 0 ;
  public static final int PRICE1 = 1 ;
  public static final int NAME1 = 2 ;
  public static final int BOSS1 = 3 ;
  public static final int PRICE2 = 4 ;
  public static final int NAME2 = 5 ;
  public static final int BOSS2 = 6 ;
  //��Ʈw����    
  private SQLiteDatabase db;

  // �غc�l�A�@�몺���γ����ݭn�ק�
  public RecordDAO( Context context ) {
    db = UserDBHelper.getDatabase(context);
  } // ItemDAO()
  
  //������Ʈw�A�@�몺���γ����ݭn�ק�
  public void close() {
    db.close();
  } // close()
  
  public void insert( Vector<String> item ) {
    // �إ߷ǳƷs�W��ƪ�ContentValues����
    ContentValues cv = new ContentValues();
    
    // �[�JContentValues����]�˪��s�W���
    // �Ĥ@�ӰѼƬO���W�١A �ĤG�ӰѼƬO��쪺���
    cv.put( DATE_COL, item.get( DATE ) );
    cv.put( PRICE1_COL, item.get( PRICE1 ) );
    cv.put( NAME1_COL, item.get( NAME1 ) );
    cv.put( BOSS1_COL, item.get( BOSS1 ) );
    cv.put( PRICE2_COL, item.get( PRICE2 ) );
    cv.put( NAME2_COL, item.get( NAME2 ) );
    cv.put( BOSS2_COL, item.get( BOSS2 ) );
    // �s�W�@����ƨè��o�s��
    // �Ĥ@�ӰѼƬO���W��
    // �ĤG�ӰѼƬO�S�����w���Ȫ��w�]��
    // �ĤT�ӰѼƬO�]�˷s�W��ƪ�ContentValues����
    db.insert( DATABASE_NAME, null, cv ) ;

  } // insert()
  
  public boolean update( String id, String sMoney ) {
    // �إ߷ǳƭק��ƪ�ContentValues����
    ContentValues cv = new ContentValues();
    return false;

    // �[�JContentValues����]�˪��ק���
    // �Ĥ@�ӰѼƬO���W�١A �ĤG�ӰѼƬO��쪺���        
    // cv.put( MONEY_COL, sMoney );

    // �]�w�ק��ƪ����󬰽s��
    // �榡���u���W�١׸�ơv
    // String where = ID_COL + "=" + id ;

    // ����ק��ƨæ^�ǭק諸��Ƽƶq�O�_���\
    // return db.update( DATABASE_NAME, cv, where, null) > 0 ;         
  } // update()
  
  public boolean delete(String id){
    // �]�w���󬰽s���A�榡���u���W��=��ơv
    String where = DATE_COL + "='" + id + "'" ;
    // �R�����w�s����ƨæ^�ǧR���O�_���\
    return db.delete( DATABASE_NAME, where , null) > 0;
  } // delete()
  
  public Vector< Vector<String> > getAll() {
    Vector<String> result = new Vector<String>();
    Vector< Vector<String> > rtn = new Vector< Vector<String> >() ;
    Cursor cursor = db.query(
                    DATABASE_NAME, null, null, null, null, null, null, null);

    while ( cursor.moveToNext() ) {
        result.add( cursor.getString( DATE ) );
        result.add( cursor.getString( PRICE1 ) );
        result.add( cursor.getString( NAME1 ) );
        result.add( cursor.getString( BOSS1 ) );
        result.add( cursor.getString( PRICE2 ) );
        result.add( cursor.getString( NAME2 ) );
        result.add( cursor.getString( BOSS2 ) );
        rtn.add( result ) ;
        result = new Vector<String>();
    } // while

    cursor.close();
    return rtn ;
  } // getAll()
  
  public int getSize() {
    return getAll().size() ;
  } // getSize()
} // class RecordDAO
