# Use a base image with your application dependencies
FROM openjdk:17-jdk-alpine

# Set environment variables
ENV APP_HOME /cart

# Create application directory
WORKDIR $APP_HOME

# Copy application JAR file into the container
COPY target/cart.jar $APP_HOME/cart.jar

# Copy OpenTelemetry Java agent JAR into the container
COPY ../opentelemetry-javaagent.jar $APP_HOME/opentelemetry-javaagent.jar

# Expose the port on which your application runs
EXPOSE 8081

# Define the command to run your application with OpenTelemetry Java agent
CMD ["java", "-javaagent:opentelemetry-javaagent.jar", "-Dotel.exporter.otlp.protocol=grpc", "-Dotel.exporter.jaeger.endpoint=http://localhost:14250", "-jar", "cart.jar"]
