#!/bin/bash

# Set the path to your OpenTelemetry Java agent JAR file
# You need to download this file separately. Adjust the path as needed.
OTEL_AGENT_PATH="/Users/davidhope/Jersey19ExampleApp/untitled/opentelemetry-javaagent.jar"

# Set OpenTelemetry configuration
export OTEL_EXPORTER_OTLP_ENDPOINT="https://283fc108eb3d414f9aaddce1e079ac6c.apm.us-west2.gcp.elastic-cloud.com:443"
export OTEL_EXPORTER_OTLP_HEADERS="Authorization=Bearer xT1SqriGsY0MC4hYE2"

# Set service name (adjust as needed)
export OTEL_SERVICE_NAME="jersey-1-example"

# Run the application with OpenTelemetry Java agent
java -javaagent:${OTEL_AGENT_PATH} \
     -Dotel.traces.exporter=otlp \
     -Dotel.metrics.exporter=otlp \
     -Dotel.logs.exporter=otlp \
     -jar target/jersey-1-example-1.0-SNAPSHOT.jar
