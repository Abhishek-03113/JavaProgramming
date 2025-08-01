package common.utils;

import java.util.*;

public class Message {

    private MessageType type;
    private String senderId;
    private String recieverId;
    private Map<String, String> payload;
    private long timestamp;

    public Message(MessageType type, String senderId) {
        this.type = type;
        this.senderId = senderId;
        this.timestamp = System.currentTimeMillis();
        this.payload = new HashMap<>();
    }

    public Message(MessageType type, String senderId, String receiverId) {
        this(type, senderId);
        this.recieverId = receiverId;
    }

    public MessageType getType() {
        return type;
    }

    public String getSenderId() {
        return senderId;
    }

    public String getReceiverId() {
        return recieverId;
    }

    public Map<String, String> getPayload() {
        return payload;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setReceiverId(String receiverId) {
        this.recieverId = receiverId;
    }

    public void setPayload(Map<String, String> payload) {
        this.payload = payload;
    }

    public void addPayload(String key, String value) {
        payload.put(key, value);
    }

    public String getPayloadString(String key) {
        return payload.get(key);
    }

    public double getPayloadDouble(String key) {
        String value = payload.get(key);
        return value != null ? Double.parseDouble(value) : null;
    }

    public Boolean getPayloadBoolean(String key) {
        String value = payload.get(key);
        return value != null ? Boolean.parseBoolean(value) : null;
    }

    public String toJson() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"type\":\"").append(type).append("\",");
        sb.append("\"senderId\":\"").append(senderId).append("\",");
        sb.append("\"receiverId\":\"").append(recieverId).append("\",");
        sb.append("\"timestamp\":").append(timestamp).append(",");
        sb.append("\"payload\":{");
        boolean first = true;
        for (Map.Entry<String, String> entry : payload.entrySet()) {
            if (!first)
                sb.append(",");
            sb.append("\"").append(entry.getKey()).append("\":\"").append(entry.getValue()).append("\"");
            first = false;
        }
        sb.append("}}");
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format("Message{type=%s, sender=%s, receiver=%s, timestamp=%d}",
                type, senderId, recieverId, timestamp);
    }

}
