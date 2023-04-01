# Client/Server Countdown
Esempio utilizzo delle *Socket*.

[Client](./src/Client.java) che invia al server il numero random 
da cui iniziare il countdown o [ClientInput](./src/ClientInput.java) 
che chiede all'utente il numero da inviare.

## Serial Server Countdown

[SerialServerCountDown](./src/SerialServerCountDown.java), 
server che gestisce le richieste di più client una alla volta: finché 
il server non ha finito di servire un client non può servirne un altro 
(li serve in modo seriale).

## Multithread Server Countdown

[MultithreadingServerCountDown](./src/MultithreadingServerCountDown.java),
server che gestisce le richiesta di più client in contemporanea.