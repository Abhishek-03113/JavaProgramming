package common.utils;

public class WebSocketUtils {
    public static Message createMessage(MessageType type, String senderId) {
        return new Message(type, senderId);
    }

    public static Message createMessage(MessageType type, String senderId, String receiverId) {
        return new Message(type, senderId, receiverId);
    }

    public static boolean isValidMessage(Message message) {
        return message != null && message.getType() != null && message.getSenderId() != null;
    }

    public static String formatResponse(String status, String message) {
        return String.format("{\"status\":\"%s\", \"message\":\"%s\"}", status, message);
    }

    public static String formatErrorResponse(String error) {
        return formatResponse("error", error);
    }

    public static String formatSuccessResponse(String message) {
        return formatResponse("success", message);
    }

}
