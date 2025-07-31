# Ride Sharing Console Client-Server System

A Java-based console application that implements a ride-sharing system using a client-server architecture with socket communication. The system consists of a central server that manages rides and two types of clients: riders and drivers.

## Architecture

```
┌─────────────────┐    ┌──────────────────────┐    ┌─────────────────┐
│   RiderClient   │◄──►│  RideManagerServer   │◄──►│  DriverClient   │
└─────────────────┘    └──────────────────────┘    └─────────────────┘
                              │
                              ▼
                       ┌──────────────┐
                       │ RideManager  │
                       │ Analytics    │
                       │ FareCalc     │
                       └──────────────┘
```

## Features

### Server Features
- **Ride Management**: Handle ride requests, assignments, and completions
- **User Management**: Register and manage riders and drivers
- **Real-time Communication**: Socket-based communication with clients
- **Analytics**: Generate reports on rides, earnings, and performance
- **Fare Calculation**: Dynamic fare calculation based on vehicle type and distance

### Rider Client Features
- **Registration**: Register as a new rider
- **Ride Booking**: Request rides with vehicle preference
- **Wallet Management**: Recharge wallet and view balance
- **Real-time Updates**: Receive ride status updates

### Driver Client Features
- **Registration**: Register as a driver with vehicle details
- **Ride Management**: Complete or cancel assigned rides
- **Earnings Tracking**: View earnings and wallet balance
- **Analytics Access**: View system analytics

## Project Structure

```
src/
├── server/
│   ├── RideManagerServer.java      # Main server application
│   ├── ClientHandler.java          # Handle individual client connections
│   ├── RideManager.java           # Core business logic
│   ├── Analytics.java             # Analytics and reporting
│   ├── FareCalculation.java       # Fare calculation logic
│   ├── Ride.java                  # Ride entity
│   ├── RideStatus.java            # Ride status enumeration
│   ├── User.java                  # Base user class
│   ├── Driver.java                # Driver entity
│   ├── Rider.java                 # Rider entity
│   ├── Vehicle.java               # Vehicle types enumeration
│   ├── Wallet.java                # Wallet management
│   └── Exceptions/
│       ├── InsufficientBalanceException.java
│       └── NoAvailableDriverException.java
├── client/
│   ├── RiderClient.java           # Rider console application
│   └── DriverClient.java          # Driver console application
├── common/
│   ├── Message.java               # Message structure for communication
│   ├── MessageType.java           # Message type enumeration
│   └── utils/
│       └── WebSocketUtils.java    # Utility functions
└── Main.java                      # Entry point
```

## Getting Started

### Prerequisites
- Java 11 or higher
- Terminal/Command Prompt

### Compilation
```bash
# Navigate to the project directory
cd src/RideSharingClientServer

# Compile all Java files
javac -d . src/**/*.java src/**/**/*.java *.java
```

### Running the Application

#### 1. Start the Server
```bash
java Main server
```
The server will start on port 8080 and initialize with sample drivers.

#### 2. Start Rider Client(s)
```bash
java Main rider
```

#### 3. Start Driver Client(s)
```bash
java Main driver
```

## Usage Guide

### For Riders
1. **Register**: Provide name and optional email
2. **Recharge Wallet**: Add funds before requesting rides
3. **Request Ride**: Choose vehicle type and provide pickup/destination
4. **Track Ride**: Monitor ride status updates

### For Drivers
1. **Register**: Provide name, email, vehicle details, and rating
2. **Manage Rides**: Complete rides by providing actual distance and duration
3. **View Earnings**: Check wallet balance and ride history

### Sample Workflow
1. Start the server
2. Start a driver client and register
3. Start a rider client and register
4. Rider recharges wallet (e.g., $100)
5. Rider requests a ride
6. Driver completes the ride
7. View analytics report

## Communication Protocol

The system uses a simple text-based protocol over TCP sockets:

**Message Format**: `MessageType|SenderId|key1=value1,key2=value2`

**Example Messages**:
- Registration: `REGISTER_RIDER|temp_id|name=John,email=john@example.com`
- Ride Request: `REQUEST_RIDE|rider_123|vehicleType=SEDAN,pickup=Airport,destination=City`
- Success Response: `SUCCESS|server|message=Ride completed,balance=75.50`

## Vehicle Types

| Vehicle | Capacity | Fare Multiplier |
|---------|----------|-----------------|
| SEDAN   | 4        | 1.0x            |
| SUV     | 6        | 1.5x            |
| BIKE    | 2        | 0.8x            |

## Fare Calculation

```
Fare = (Base Fare × Vehicle Multiplier) + (Distance × Rate) + (Time × Factor)
- Base Fare: $5.00
- Distance Rate: $2.00/km
- Time Factor: $0.50/minute
- Driver Commission: 80% of fare
```

## Analytics Features

The system provides comprehensive analytics including:
- Total rides, drivers, and riders
- Revenue and average fare analysis
- Vehicle type usage statistics
- Driver performance metrics
- Popular destinations
- Top spending riders

## Error Handling

- **Insufficient Balance**: Prevents ride booking without adequate funds
- **No Available Drivers**: Handles cases when no drivers match criteria
- **Connection Issues**: Graceful handling of client disconnections
- **Invalid Input**: Validation and error messages for user input

## Future Enhancements

- **Authentication**: User login/logout system
- **Real-time Location**: GPS tracking integration
- **Payment Gateway**: Integration with payment systems
- **Mobile App**: Native mobile applications
- **Database**: Persistent data storage
- **Load Balancing**: Multiple server instances

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License

This project is open source and available under the MIT License.
