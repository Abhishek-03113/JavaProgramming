# Copilot Instructions for Ride Sharing System

<!-- Use this file to provide workspace-specific custom instructions to Copilot. For more details, visit https://code.visualstudio.com/docs/copilot/copilot-customization#_use-a-githubcopilotinstructionsmd-file -->

## Project Overview
This is a Java console-based ride-sharing client-server application using socket communication. The system consists of:

- **RideManagerServer**: Central server managing all ride operations
- **RiderClient**: Console application for passengers
- **DriverClient**: Console application for drivers
- **Common**: Shared message protocols and utilities

## Architecture Patterns
- **Client-Server**: Socket-based communication
- **Observer Pattern**: Message listeners for real-time updates
- **Command Pattern**: Message handling based on MessageType
- **Factory Pattern**: User creation (Rider/Driver)

## Key Design Principles
1. **Separation of Concerns**: Clear separation between server logic, client UIs, and common protocols
2. **Thread Safety**: Use concurrent collections for managing client connections
3. **Error Handling**: Comprehensive exception handling for network and business logic errors
4. **Protocol Design**: Simple text-based protocol for cross-platform compatibility

## Coding Standards
- Use meaningful variable and method names
- Follow Java naming conventions (camelCase for methods/variables, PascalCase for classes)
- Add comprehensive JavaDoc comments for public methods
- Handle all checked exceptions appropriately
- Use Optional for nullable values
- Prefer composition over inheritance where applicable

## Message Protocol
All messages follow the format: `MessageType|SenderId|key1=value1,key2=value2`

## Common Operations
- User registration and authentication
- Ride lifecycle management (request → assign → start → complete)
- Wallet operations (recharge, deduct, balance check)
- Real-time status updates
- Analytics and reporting

## Testing Considerations
- Test server with multiple concurrent clients
- Validate message parsing and serialization
- Test error scenarios (network failures, invalid input)
- Performance testing with multiple ride requests

## Security Notes
- Input validation on all user inputs
- Proper resource cleanup (sockets, streams)
- Error messages should not expose sensitive information
