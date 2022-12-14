package com.waybill.waybillapp.service.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.waybill.waybillapp.model.Message;

import java.util.List;

@Dao
public interface MessageDAO {

    @Insert
    long addMessage(Message message);

    @Update
    int updateMessage(Message message);

    @Delete
    void deleteMessage(Message message);

    @Query("SELECT * FROM Message ORDER BY receivedDate")
    LiveData<List<Message>> getAllMessage();

    @Query("SELECT * FROM Message WHERE id = :messageId")
    LiveData<Message> getMessage(long messageId);

}
