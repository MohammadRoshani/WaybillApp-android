package com.waybill.waybillapp.service.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.waybill.waybillapp.model.Converters;
import com.waybill.waybillapp.model.Message;

import java.util.Calendar;

@Database(entities = {Message.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class WaybillAppDatabase extends RoomDatabase {

    private static WaybillAppDatabase instance;
    private static final RoomDatabase.Callback roomCallback
            = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new InitDatabase(instance).execute();
        }
    };

    public static WaybillAppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context,
                            WaybillAppDatabase.class, "WaybillApp.db")
                    .addCallback(roomCallback)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract MessageDAO getMessageDAO();

    private static class InitDatabase extends AsyncTask<Void, Void, Void> {

        private final MessageDAO messageDAO;

        public InitDatabase(WaybillAppDatabase waybillAppDatabase) {
            this.messageDAO = waybillAppDatabase.getMessageDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            Message message1 = new Message("09331857657", "hello!", "mohammad", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), true);
            Message message2 = new Message("09335464657", "my message", "ali", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), true);
            Message message3 = new Message("09897857657", "But where does this pull the date and time from? the android device setting itself?", "ahmad", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), true);
            Message message4 = new Message("09353457657", "If you want to get the date and time in a specific pattern you can use the following", "reza", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), true);

            this.messageDAO.addMessage(message1);
            this.messageDAO.addMessage(message2);
            this.messageDAO.addMessage(message3);
            this.messageDAO.addMessage(message4);

            return null;
        }
    }
}
