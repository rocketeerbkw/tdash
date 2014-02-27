PORT="8085"
LOGGING="--accessLoggerClassName=winstone.accesslog.SimpleAccessLogger"

java  -jar bin/winstone-0.9.10.jar --webappsDir=build --directoryListings=false ${LOGGING} --httpPort=${PORT}
