package com.abhay.kotlintutorial

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.ContentValues
import android.database.sqlite.SQLiteConstraintException


class DataBaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
        override fun onCreate(db: SQLiteDatabase) {
            db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,MARKS INTEGER)");
        }

    val COL_1 = "ID"
    val COL_2 = "NAME"
    val COL_3 = "SURNAME"
    val COL_4 = "MARKS"
    val DATABASE_NAME = "Student.db"
    val TABLE_NAME = "Student_table"

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            // This database is only a cache for online data, so its upgrade policy is
            // to simply to discard the data and start over
           // db.execSQL(SQL_DELETE_ENTRIES)
            db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
            onCreate(db)
        }

        override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            onUpgrade(db, oldVersion, newVersion)
        }

    @Throws(SQLiteConstraintException::class)
    fun insertData(name: String, surname: String, marks: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_2, name)
        contentValues.put(COL_3, surname)
        contentValues.put(COL_4, marks)
        val result = db.insert(TABLE_NAME, null, contentValues)
        db.close()

        //To Check Whether Data is Inserted in DataBase
        return if (result.equals(-1)) {
            false
        } else {
            true
        }
    }



    @Throws(SQLiteConstraintException::class)
    fun deleteData(id: String): Int? {
        val db = this.writableDatabase
        return db.delete(TABLE_NAME, "ID=?", arrayOf(id))

    }

    @Throws(SQLiteConstraintException::class)
    fun getAllData(): Cursor {
        val db = this.writableDatabase
        return db.rawQuery("Select * from " + TABLE_NAME, null)
    }


    fun updateData(id: String, name: String, surname: String, marks: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_2, name)
        contentValues.put(COL_3, surname)
        contentValues.put(COL_4, marks)
        val result = db.update(TABLE_NAME, contentValues, "ID =?", arrayOf(id))
        return if (result > 0) {
            true
        } else {
            false
        }
    }



        companion object {

            // If you change the database schema, you must increment the database version.
            val DATABASE_VERSION = 1
            val DATABASE_NAME = "Student.db"

         }

    }


