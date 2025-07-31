// import server.RideManagerServer;
// import client.RiderClient;
// import client.DriverClient;

// public class Main {
//     public static void main(String[] args) {
//         if (args.length > 0) {
//             String mode = args[0].toLowerCase();
            
//             switch (mode) {
//                 case "server":
//                     System.out.println("Starting Ride Manager Server...");
//                     RideManagerServer server = new RideManagerServer();
                    
//                     // Add shutdown hook
//                     Runtime.getRuntime().addShutdownHook(new Thread(server::stop));
                    
//                     server.start();
//                     break;
                    
//                 case "rider":
//                     System.out.println("Starting Rider Client...");
//                     try {
//                         new RiderClient().start();
//                     } catch (Exception e) {
//                         System.err.println("Error starting Rider Client: " + e.getMessage());
//                     }
//                     break;
                    
//                 case "driver":
//                     System.out.println("Starting Driver Client...");
//                     try {
//                         new DriverClient().start();
//                     } catch (Exception e) {
//                         System.err.println("Error starting Driver Client: " + e.getMessage());
//                     }
//                     break;
                    
//                 default:
//                     showUsage();
//             }
//         } else {
//             showUsage();
//         }
//     }
    
//     private static void showUsage() {
//         System.out.println("🚗 Ride Sharing System");
//         System.out.println("Usage: java Main <mode>");
//         System.out.println();
//         System.out.println("Modes:");
//         System.out.println("  server  - Start the Ride Manager Server");
//         System.out.println("  rider   - Start the Rider Client");
//         System.out.println("  driver  - Start the Driver Client");
//         System.out.println();
//         System.out.println("Examples:");
//         System.out.println("  java Main server");
//         System.out.println("  java Main rider");
//         System.out.println("  java Main driver");
//         System.out.println();
//         System.out.println("Note: Start the server first, then connect clients.");
//     }
// }
