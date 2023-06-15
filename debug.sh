./gradlew build
java -agentlib:jdwp=transport=dt_socket,address=8080,server=y,suspend=y -jar ./build/libs/engine3d-1.0-SNAPSHOT.jar