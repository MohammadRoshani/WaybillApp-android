package com.waybill.waybillapp.service;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.waybill.waybillapp.model.Message;
import com.waybill.waybillapp.service.database.MessageDAO;
import com.waybill.waybillapp.service.database.WaybillAppDatabase;

import java.util.List;
import java.util.concurrent.Executors;

public class WaybillRepository {

    private final MessageDAO messageDAO;

    private LiveData<Message> messages;

    public WaybillRepository(Application application) {
        WaybillAppDatabase waybillAppDatabase = WaybillAppDatabase.getInstance(application);
        messageDAO = waybillAppDatabase.getMessageDAO();
    }

    public LiveData<List<Message>> getAllMessages() {
        return messageDAO.getAllMessage();
    }

    public LiveData<Message> getMessage(long messageId) {
        return messageDAO.getMessage(messageId);
    }

    public void addMessage(Message message) {
        Executors.newSingleThreadExecutor().execute(() -> {
            messageDAO.addMessage(message);
        });
    }

    public void updateMessage(Message message) {
        Executors.newSingleThreadExecutor().execute(() -> {
            messageDAO.updateMessage(message);
        });
    }

    public void deleteMessage(Message message) {
        Executors.newSingleThreadExecutor().execute(() -> {
            messageDAO.deleteMessage(message);
        });
    }
}
