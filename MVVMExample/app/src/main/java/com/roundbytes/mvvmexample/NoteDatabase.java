package com.roundbytes.mvvmexample;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase instance; //This is singleton, that means we cannot create more than 1 instance of this obejct

    public abstract NoteDao noteDao();

    //check if there is an isntance of NoteDatabase if not we create a new Instance
    public static synchronized  NoteDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), NoteDatabase.class, "note_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack) // THE IMPLEMENTATION OF POPULATE DATABASE
                    .build();
        }
        return instance;
    }

    //TO POPULATE DATABASE ON INITIAL CREATION - JUST A FAKE DATA
    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };
    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{
        private NoteDao noteDao;
        private PopulateDbAsyncTask(NoteDatabase db){
            noteDao = db.noteDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.insert(new Note("Title 1", "Desc 1",1));
            noteDao.insert(new Note("Title 2", "Desc 2",2));
            noteDao.insert(new Note("Title 3", "Desc 3",3));
            return null;
        }
    }
}
