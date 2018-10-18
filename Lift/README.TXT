PROJEKTBEZEICHNUNG: lift
VERSION: 1.0
AUTOR: Polytri
BENUTZERHINWEISE: E-Mail an: team-polytri@gmail.com 

Funktionen:

Beim Konstruktor wird nach maximalen Personen, maximalen Etagen, minimale Etagen und Geschwindigkeit(1000 = 1 sekunde) gefragt.
Der Konstruktor erkennt direkt durch if abfragen ob die Werte möglich sind und Korrigiert, durch multiplikation mit -1.
Die aktuellen Personen werden auf 0 gesetzt und die aktuelle Etage auf die minimale Etage.
Am Ende wird noch doorOpen auf falsch gesetzt und benachrichtigt, dass ein Aufzug erstellt wurde.

Die erste Funktion ist toggleDoor(). Dort wird als erstes die Konsole mit System.out.print('\u000C') gelehrt.
Dann wird die doorOpen invertiert und darauf eine dem neuen Zustand entsprechende Ausgabe in die Konsole gegeben.
Danach wird mit einem sleep() Befehl noch eine 3/4 Sekunde gewartet bevor die Funktion endet.

Der sleep Befehl ist standart mässig in Java vorhanden und wird mit der Befehlkette:
try {
    Thread.sleep( /*Zeit die gewarted werden soll*/ );
} catch (InterruptedException ex) {

}
korrekt aufgerufen.

Als nächstes habe ich die driveTo() Funktion Programmiert. Als erstes wird dort überprüft ob die Tür offen ist und wenn sie offen
ist wird die Funktion toggleDoor() aufgerufen. 
Als nächstes wird überprüft ob die neue Etage größer oder kleiner als die möglichen Etagen ist.
Ist dem nicht so wird die eine while-Schleife, also eine Schleife die eine Aktion sollange wiederholt, bis die angegebene Bedingung 
Falsch ist. In diesem Fall läuft die while-Schleife solange bis die akktuelle Etage gleich ist wie die erwünschte Etage.
in dieser Schleife wird als erstes die akktúelle Etage um eins erhöht. Danach wird die Konsole geleert und die Nummer der aktuellen 
Etage ausgegeben. Als letztes wird mit dem sleep-Befehl solange gewartet, wie speed groß ist.
Wenn die Schleife vertig ist wird ein letztes mal die Konsole geleert und die Nachricht "Ping! New Story: " + aktualStory ausgegeben.

Als nächstes habe ich die Funktion gettingIn(int Persons) programmiert. Als erstes leert die Funktion die Konsole und überprüft ob die 
doorOpen false ist und falls das so ist ruft sie toggleDoor() aufgerufen. Danach überprüft er ob die eingegebene Zahl kleiner 0 ist oder 
die angestrebte gesamt Anzahl größer als die der möglichen Personenen Zahl ist. Wenn dem so ist wird eine Fehlermeldung in die Konsole 
ausgegeben. Wenn alles in Ordnung ist wird die aktuelle Personen Zahl mit der der zusätzlichen Personen addiert und eine Nachricht in die
Konsole ausgegeben. als letztes wird noch eine 3/4 Sekunde gewartet.

Die Funktion gettingOut() wurde genauso Programmiert wie die Funktion gettingIn (). Der einzige Unterschied ist, dass die angestrebte 
Personen Zahl nicht kleiner 0 sein darf und subtrahiert statt adiert wird.