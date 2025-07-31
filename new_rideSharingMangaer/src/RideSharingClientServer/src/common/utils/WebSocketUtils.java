package common.utils;

import common.Message;
import common.MessageType;

public class WebSocketUtils {
    
    public static Message createMessage(MessageType type, String senderId) {
        return new Message(type, senderId);
    }
    
    public static Message createMessage(MessageType type, String senderId, String receiverId) {
        return new Message(type, senderId, receiverId);
    }
    
    public static boolean isValidMessage(Message message) {
        return message != null && 
               message.getType() != null && 
               message.getSenderId() != null && 
               !message.getSenderId().trim().isEmpty();
    }
    
    public static String formatResponse(String status, String message) {
        return String.format("{\"status\":\"%s\", \"message\":\"%s\"}", status, message);
    }
    
    public static String formatError(String error) {
        return formatResponse("error", error);
    }
    
    public static String formatSuccess(String message) {
        return formatResponse("success", message);
    }
}
