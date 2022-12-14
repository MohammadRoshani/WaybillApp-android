package com.waybill.waybillapp.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

/**
 * The type Message.
 */
@Entity
public class Message {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String phoneNumber;
    private String messageContent;
    private String receiverName;
    private Date receivedDate;
    private Date sendDate;
    private boolean isSent;

    /**
     * Instantiates a new Message.
     */
    @Ignore
    public Message() {
    }

    /**
     * Instantiates a new Message.
     *
     * @param phoneNumber    the phone number
     * @param messageContent the message content
     * @param receiverName   the receiver name
     * @param receivedDate   the received date
     * @param sendDate       the send date
     * @param isSent         the is sent
     */
    public Message(String phoneNumber, String messageContent, String receiverName, Date receivedDate, Date sendDate, boolean isSent) {
        this.phoneNumber = phoneNumber;
        this.messageContent = messageContent;
        this.receiverName = receiverName;
        this.receivedDate = receivedDate;
        this.sendDate = sendDate;
        this.isSent = isSent;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets message content.
     *
     * @return the message content
     */
    public String getMessageContent() {
        return messageContent;
    }

    /**
     * Sets message content.
     *
     * @param messageContent the message content
     */
    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    /**
     * Gets receiver name.
     *
     * @return the receiver name
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * Sets receiver name.
     *
     * @param receiverName the receiver name
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    /**
     * Gets received date.
     *
     * @return the received date
     */
    public Date getReceivedDate() {
        return receivedDate;
    }

    /**
     * Sets received date.
     *
     * @param receivedDate the received date
     */
    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    /**
     * Gets send date.
     *
     * @return the send date
     */
    public Date getSendDate() {
        return sendDate;
    }

    /**
     * Sets send date.
     *
     * @param sendDate the send date
     */
    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    /**
     * Is sent boolean.
     *
     * @return the boolean
     */
    public boolean isSent() {
        return isSent;
    }

    /**
     * Sets sent.
     *
     * @param sent the sent
     */
    public void setSent(boolean sent) {
        isSent = sent;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", messageContent='" + messageContent + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", receivedDate=" + receivedDate +
                ", sendDate=" + sendDate +
                ", isSent=" + isSent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (id != message.id) return false;
        if (isSent != message.isSent) return false;
        if (phoneNumber != null ? !phoneNumber.equals(message.phoneNumber) : message.phoneNumber != null)
            return false;
        if (messageContent != null ? !messageContent.equals(message.messageContent) : message.messageContent != null)
            return false;
        if (receiverName != null ? !receiverName.equals(message.receiverName) : message.receiverName != null)
            return false;
        if (receivedDate != null ? !receivedDate.equals(message.receivedDate) : message.receivedDate != null)
            return false;
        return sendDate != null ? sendDate.equals(message.sendDate) : message.sendDate == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (messageContent != null ? messageContent.hashCode() : 0);
        result = 31 * result + (receiverName != null ? receiverName.hashCode() : 0);
        result = 31 * result + (receivedDate != null ? receivedDate.hashCode() : 0);
        result = 31 * result + (sendDate != null ? sendDate.hashCode() : 0);
        result = 31 * result + (isSent ? 1 : 0);
        return result;
    }
}
