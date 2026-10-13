package com.example.ep2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DataBaseHelper (context: Context): SQLiteOpenHelper(
    context,
    DATABASE_NAME,
    null,
    DATABASE_VERSION){
    //DATOS DE LA BASE DE DATOS
    companion object{
        //Informacion de la BD
        private const val DATABASE_NAME = "music.db"
        private const val  DATABASE_VERSION = 1

        //Informacion de las tablas en la BD
        private const val TABLE_USUARIOS = "usuarios"
        private const val COL_ID = "id"
        private const val COL_NOMBRE = "nombre"
        private const val COL_CORREO = "correo"
        private const val COL_PASSWORD = "password"


    }

    //METODO ONCREATE - PARA CREAR LA BASE DE DATOS
    override fun onCreate(db: SQLiteDatabase?) {
        //crear tabla
        val crearTablaUsuario = """
            CREATE TABLE $TABLE_USUARIOS(
            $COL_ID INTEGER PRIMARY KEY AUTOINCREMENT,
            $COL_NOMBRE TEXT NOT NULL,
            $COL_CORREO TEXT NOT NULL,
            $COL_PASSWORD TEXT NOT NULL
            )
        """.trimIndent()
        db?.execSQL(crearTablaUsuario)
    }


    //METODO ONUPGRADE
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_USUARIOS")
    }
}