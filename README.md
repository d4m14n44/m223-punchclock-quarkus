# M223 Punchclock

Folgende Schritte sind notwendig um die Applikation zu erstellen und zu starten: 
1. Stellen Sie sicher, dass OpenJDK 11 oder höher installiert und JAVA_HOME korrekt gesetzt ist.  
2. Installieren Sie (falls noch nicht vorhanden) Apache Maven 3.8.1 oder höher

==================================================================================================

Starten der Applikation:

Der HTTP Server, welcher mit Quarkus implementiert wurde wird für die Applikation benötigt.
Hierfür muss git bash im Quarkus Server Projekt geöffnet werden, anschliessend
muss folgender Code eingegeben werden:

StartUp Schritte:

1. Wechseln Sie auf der Kommandozeile oder Git Bash in den Ordner dieser Applikation. 
`cd m223-helloworld-quarkus/`
2. Starten Sie den HTTP Server mit 
```shell script
./mvnw compile quarkus:dev
```

Folgende Dienste stehen während der Ausführung im Profil dev zur Verfügung:

Swagger API: http://localhost:8080/q/swagger-ui/

H2 Console: http://localhost:8080/h2/ 
Datenquelle: jdbc:h2:mem:punchclock
Benutzername: zli
Passwort: zli

Rufen Sie die API Swagger auf und fügen Sie mit folgendem Code ein Entry hinzu:

{
"category": {
"id": 1
},
"checkIn": "2021-09-30T07:38:39.184Z",
"checkOut": "2021-09-30T07:38:39.184Z",
"location": {
"id": 1
},
"user": {
"id": 1
}

Anschliessend können Sie im folgenden File (LB_Oberholzer_Damian.zip/M223-PunchClock_FX/README.md) das GUI starten.