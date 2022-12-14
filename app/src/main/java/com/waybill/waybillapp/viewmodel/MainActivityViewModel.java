package com.waybill.waybillapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.waybill.waybillapp.model.Message;
import com.waybill.waybillapp.service.WaybillRepository;

import java.util.Calendar;
import java.util.List;

/**
 * The type Main activity view model.
 */
public class MainActivityViewModel extends AndroidViewModel {

    private WaybillRepository waybillRepository;

    private MutableLiveData<Message> currentMessageLiveData;
    private MutableLiveData<String> serverBaseUrlLiveData;


    /**
     * Instantiates a new Main activity view model.
     *
     * @param application the application
     */
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        waybillRepository = new WaybillRepository(application);


    }

    /**
     * Gets all messages.
     *
     * @return the all messages
     */
    public LiveData<List<Message>> getAllMessages() {
        return waybillRepository.getAllMessages();
    }

    /**
     * Gets message.
     *
     * @param messageId the message id
     * @return the message
     */
    public LiveData<Message> getMessage(long messageId) {
        return waybillRepository.getMessage(messageId);
    }

    /**
     * Add message.
     *
     * @param message the message
     */
    public void addMessage(Message message) {
        waybillRepository.addMessage(message);
    }

    /**
     * Update message.
     *
     * @param message the message
     */
    public void updateMessage(Message message) {
        waybillRepository.updateMessage(message);

    }

    /**
     * Delete message.
     *
     * @param message the message
     */
    public void deleteMessage(Message message) {
        waybillRepository.deleteMessage(message);

    }

    /**
     * Gets current message live data.
     *
     * @return the current message live data
     */
    public MutableLiveData<Message> getCurrentMessageLiveData() {
        if (currentMessageLiveData == null) {
            currentMessageLiveData = new MutableLiveData<>();
        }
        return currentMessageLiveData;
    }

    /**
     * Gets server base url live data.
     *
     * @return the server base url live data
     */
    public MutableLiveData<String> getServerBaseUrlLiveData() {
        if (serverBaseUrlLiveData == null) {
            serverBaseUrlLiveData = new MutableLiveData<>();
        }
        return serverBaseUrlLiveData;
    }

    /**
     * On send message.
     */
    public void onSendMessage(CharSequence phoneNumber, CharSequence content) {
        Message message = new Message(phoneNumber.toString(),content.toString(),"", Calendar.getInstance().getTime(),Calendar.getInstance().getTime(),false);
        saveMessage(message);
    }


    /**
     * On pulling message.
     */
    public void onPullingMessage() {
        getCurrentMessageLiveData().setValue(new Message());
    }

    private void saveMessage(Message message) {

        waybillRepository.addMessage(message);
    }
}
