package common;

import java.util.HashMap;
import java.util.Map;

public class Message {
    private MessageType type;
    private String senderId;
    private String receiverId;
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
        this.receiverId = receiverId;
    }

    // Getters
    public MessageType getType() { return type; }
    public String getSenderId() { return senderId; }
    public String getReceiverId() { return receiverId; }
    public Map<String, String> getPayload() { return payload; }
    public long getTimestamp() { return timestamp; }

    // Setters
    public void setReceiverId(String receiverId) { this.receiverId = receiverId; }
    public void setPayload(Map<String, String> payload) { this.payload = payload; }

    // Utility methods
    public void addPayload(String key, String value) {
        payload.put(key, value);
    }

    public void addPayload(String key, Number value) {
        payload.put(key, value.toString());
    }

    public void addPayload(String key, Boolean value) {
        payload.put(key, value.toString());
    }

    public String getPayloadString(String key) {
        return payload.get(key);
    }

    public Double getPayloadDouble(String key) {
        String value = payload.get(key);
        return value != null ? Double.parseDouble(value) : null;
    }

    public Boolean getPayloadBoolean(String key) {
        String value = payload.get(key);
        return value != null ? Boolean.parseBoolean(value) : null;
    }

    // Simple string representation
    public String toJson() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"type\":\"").append(type).append("\",");
        sb.append("\"senderId\":\"").append(senderId).append("\",");
        sb.append("\"receiverId\":\"").append(receiverId).append("\",");
        sb.append("\"timestamp\":").append(timestamp).append(",");
        sb.append("\"payload\":{");
        boolean first = true;
        for (Map.Entry<String, String> entry : payload.entrySet()) {
            if (!first) sb.append(",");
            sb.append("\"").append(entry.getKey()).append("\":\"").append(entry.getValue()).append("\"");
            first = false;
        }
        sb.append("}}");
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format("Message{type=%s, sender=%s, receiver=%s, timestamp=%d}", 
                           type, senderId, receiverId, timestamp);
    }
}
