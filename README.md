# ChataPP - Real-Time Chat Application

A modern, real-time chat application built with Spring Boot and WebSocket. This application allows multiple users to communicate instantly through a web-based interface with features like username customization and dark mode support.

## 🚀 Features

- **Real-time messaging**: Instant message delivery using WebSocket and STOMP protocol
- **User identification**: Custom usernames for each participant
- **Responsive UI**: Clean, modern interface with scrollable chat history
- **Dark mode**: Toggle between light and dark themes
- **Keyboard shortcuts**: Send messages with Enter key
- **Connection status**: Visual feedback for connection state
- **Error handling**: Graceful handling of connection failures

## 🛠 Technology Stack

- **Backend**: Spring Boot 4.0.5
- **WebSocket**: Spring WebSocket with STOMP protocol
- **Frontend**: HTML5, CSS3, JavaScript (ES6+)
- **Template Engine**: Thymeleaf
- **Build Tool**: Maven
- **Java Version**: 17
- **WebSocket Libraries**: SockJS, STOMP.js

## 📋 Prerequisites

Before running this application, make sure you have the following installed:

- **Java 17** or higher
- **Maven 3.6+** (or use the included Maven wrapper)
- A modern web browser with WebSocket support

## 🔧 Installation & Setup

1. **Clone the repository** (if applicable) or ensure you have the project files

2. **Navigate to the project directory**:
   ```bash
   cd ChataPP
   ```

3. **Build the application** using Maven:
   ```bash
   # Using Maven wrapper (recommended)
   ./mvnw clean install

   # Or using system Maven
   mvn clean install
   ```

## ▶️ Running the Application

### Development Mode
```bash
# Using Maven wrapper
./mvnw spring-boot:run

# Or using system Maven
mvn spring-boot:run
```

### Production Mode
```bash
# Build and run the JAR
./mvnw clean package
java -jar target/ChataPP-0.0.1-SNAPSHOT.jar
```

The application will start on `http://localhost:8080` by default.

## 💻 Usage

1. **Open your browser** and navigate to `http://localhost:8080`

2. **Enter a username** when prompted upon connection

3. **Start chatting**:
   - Type your message in the text area
   - Click "Send" button or press Enter
   - Messages appear instantly in the chat area

4. **Additional features**:
   - Click "Change Username!" to update your display name
   - Toggle "dark mode" for a different visual theme

## 🏗 Architecture Overview

### Backend Components

- **`ChataPpApplication.java`**: Main Spring Boot application class
- **`WebSocketConfig.java`**: WebSocket configuration with STOMP endpoints
- **`ChatController.java`**: Message handling controller
- **`Message.java`**: Data model for chat messages

### Frontend Components

- **`index.html`**: Main chat interface template
- **`Chat.css`**: Styling for light and dark modes
- **JavaScript**: WebSocket client connection and UI interactions

### WebSocket Configuration

- **Endpoint**: `/chat-websocket` (with SockJS fallback)
- **Message Broker**: `/topic` for broadcasting
- **Application Prefix**: `/app` for sending messages
- **Message Mapping**: `/app/message` → `/topic/messages`

## 📡 API Endpoints

### WebSocket Endpoints

- **STOMP Endpoint**: `/chat-websocket`
  - Used for establishing WebSocket connections
  - Supports SockJS fallback for older browsers

### Message Flow

1. **Send Message**: Client → `/app/message` (STOMP SEND)
2. **Broadcast**: Server → `/topic/messages` (STOMP SUBSCRIBE)

### Message Format

```json
{
  "from": "username",
  "content": "message text"
}
```

## 🔧 Configuration

The application uses Spring Boot's default configuration. Key settings in `application.properties`:

```properties
spring.application.name=ChataPP
# Server port (default: 8080)
# server.port=8080
```



## 📦 Build & Deployment

### Creating a JAR file

```bash
./mvnw clean package
```

The JAR file will be created in the `target/` directory.

### Docker Support

To create an OCI image:

```bash
./mvnw spring-boot:build-image
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 🆘 Troubleshooting

### Connection Issues

- **"Failed to connect to server"**: Ensure the Spring Boot application is running on port 8080
- **WebSocket not working**: Check browser console for errors; ensure WebSocket support is enabled

### Build Issues

- **Java version mismatch**: Ensure you're using Java 17
- **Maven errors**: Try using the Maven wrapper (`./mvnw`) instead of system Maven

### Common Errors

- **Port already in use**: Change the server port in `application.properties`
- **Missing dependencies**: Run `./mvnw clean install` to download all dependencies

## 📚 Additional Resources

- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [Spring WebSocket Guide](https://docs.spring.io/spring-boot/docs/current/reference/html/messaging.html#messaging.websockets)
- [STOMP Protocol](https://stomp.github.io/)
- [SockJS Documentation](https://github.com/sockjs/sockjs-client)

---

**Enjoy chatting with ChataPP! 🎉**
