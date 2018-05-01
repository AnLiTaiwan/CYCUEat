package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class MyDBHelper extends SQLiteOpenHelper { 
  
  private static final String DATABASE_NAME = "eatData";
  private static final int DATABASE_VERSION = 1;
  // ��Ʈw����A�T�w������ܼ�
  private static SQLiteDatabase database ;

  public MyDBHelper(Context context, String name, CursorFactory factory, int version) {
    super(context, name, factory, version);
    // TODO Auto-generated constructor stub
  } // MyDBHelper

  @Override
  public void onCreate(SQLiteDatabase db) {
    String sql = "CREATE TABLE 'eatData' ( " + "'id' TEXT NOT NULL,"
        + "'price' TEXT NOT NULL DEFAULT 'null'," + "'name' TEXT NOT NULL DEFAULT 'null',"
        + "'type' TEXT NOT NULL DEFAULT 'null'," + "'boss' TEXT NOT NULL DEFAULT 'null',"
        + "'system' TEXT NOT NULL DEFAULT 'null' ) ;" ;
    db.execSQL(sql);
  } // onCreate

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    // TODO Auto-generated method stub

  } // onUpgrade()

  //�ݭn��Ʈw������I�s�o�Ӥ�k�A�o�Ӥ�k�b�@�몺���γ����ݭn�ק�
  public static SQLiteDatabase getDatabase(Context context) {
      if (database == null || !database.isOpen()) {
          database = new MyDBHelper(context, DATABASE_NAME, 
                  null, DATABASE_VERSION).getWritableDatabase();
      }

      return database;
  } // getDatabase()
  
} // class DatabaseHelper
