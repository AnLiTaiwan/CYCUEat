package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class UserDBHelper extends SQLiteOpenHelper { 
  
  private static final String DATABASE_NAME = "eatRecord";
  private static final int DATABASE_VERSION = 1;
  // ��Ʈw����A�T�w������ܼ�
  private static SQLiteDatabase database ;

  public UserDBHelper(Context context, String name, CursorFactory factory, int version) {
    super(context, name, factory, version);
    // TODO Auto-generated constructor stub
  } // MyDBHelper

  @Override
  public void onCreate(SQLiteDatabase db) {
    String sql = "CREATE TABLE '" + DATABASE_NAME + "' ( " + 
                 "'" + RecordDAO.DATE_COL + "' TEXT NOT NULL," + 
                 "'" + RecordDAO.PRICE1_COL + "' TEXT NOT NULL DEFAULT 'null'," + 
                 "'" + RecordDAO.NAME1_COL + "' TEXT NOT NULL DEFAULT 'null'," + 
                 "'" + RecordDAO.BOSS1_COL + "' TEXT NOT NULL DEFAULT 'null'," + 
                 "'" + RecordDAO.PRICE2_COL + "' TEXT NOT NULL DEFAULT 'null'," + 
                 "'" + RecordDAO.NAME2_COL + "' TEXT NOT NULL DEFAULT 'null'," +
                 "'" + RecordDAO.BOSS2_COL + "' TEXT NOT NULL DEFAULT 'null' ) ;" ;
    db.execSQL(sql);
  } // onCreate

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    // TODO Auto-generated method stub

  } // onUpgrade()

  //�ݭn��Ʈw������I�s�o�Ӥ�k�A�o�Ӥ�k�b�@�몺���γ����ݭn�ק�
  public static SQLiteDatabase getDatabase(Context context) {
      if (database == null || !database.isOpen()) {
          database = new UserDBHelper(context, DATABASE_NAME, 
                  null, DATABASE_VERSION).getWritableDatabase();
      }

      return database;
  } // getDatabase()
  
} // class UserDBHelper
