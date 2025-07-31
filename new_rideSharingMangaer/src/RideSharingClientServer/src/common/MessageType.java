package common;

public enum MessageType {
    // Authentication
    REGISTER_RIDER,
    REGISTER_DRIVER,
    LOGIN,
    LOGOUT,
    
    // Ride operations
    REQUEST_RIDE,
    RIDE_ASSIGNED,
    ACCEPT_RIDE,
    DECLINE_RIDE,
    START_RIDE,
    COMPLETE_RIDE,
    CANCEL_RIDE,
    
    // Status updates
    RIDE_STATUS_UPDATE,
    DRIVER_STATUS_UPDATE,
    LOCATION_UPDATE,
    
    // Wallet operations
    RECHARGE_WALLET,
    WALLET_BALANCE,
    
    // Analytics
    ANALYTICS_REQUEST,
    ANALYTICS_RESPONSE,
    
    // General
    SUCCESS,
    ERROR,
    NOTIFICATION
}
