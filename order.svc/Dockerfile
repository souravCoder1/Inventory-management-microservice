# Use a base image with your application dependencies
FROM openjdk:17-jdk-alpine

# Set environment variables
ENV APP_HOME /order

# Create application directory
WORKDIR $APP_HOME

# Copy application JAR file into the container
COPY target/order.jar $APP_HOME/order.jar

# Copy OpenTelemetry Java agent JAR into the container
COPY opentelemetry-javaagent.jar $APP_HOME/opentelemetry-javaagent.jar

# Expose the port on which your application runs
EXPOSE 8085

# Define the command to run your application with OpenTelemetry Java agent
CMD ["java", "-javaagent:opentelemetry-javaagent.jar", "-Dotel.exporter.jaeger.endpoint=http://jaeger:14250", "-jar", "order.jar"]
