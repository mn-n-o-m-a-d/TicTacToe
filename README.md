# Homework: Tic Tac Toe
Zu erstellen ist ein textbasiertes Tic Tac Toe Spiel.

## Spielbrett (Game Board):

Erstelle eine unveränderliche Klasse GameBoard, die den Zustand eines Tic-Tac-Toe-Spielbretts darstellt.
Das Brett ist ein 3x3-Raster, das drei mögliche Werte für jede Zelle enthalten kann: X, O oder - (für leere Felder).
Es soll möglich sein, das Spielbrett zu Spielbeginn mit einem bestimmten Spielstand zu befüllen. Es wird eingebeben, in welcher Zeile und Spalte das Symbol gesetzt werden soll.

Füge eine Methode playMove(char player, int row, int col) hinzu, die eine neue GameBoard-Instanz mit dem aktualisierten Zustand nach einem Zug zurückgibt. 
Diese Methode sollte eine Exception werfen, wenn der Zug illegal ist. 
Der Spieler darf solange probieren, bis ein gültiger Zug gesetzt wurde.

## Spiellogik (Game Logic):

Implementiere eine Klasse TicTacToeGame, um den Spielablauf zu steuern.
Das Spiel sollte abwechselnd zwischen zwei Spielern, X und O, wechseln.

Nach jedem Zug sollte das Spiel auf eine Gewinnbedingung oder ein Unentschieden prüfen. Verwende Methoden, um die Logik zur Überprüfung des Spielstatus zu kapseln.
Das Spiel endet, wenn ein Spieler gewinnt (drei seiner Symbole in einer Reihe, Spalte oder Diagonale) oder alle Zellen gefüllt sind (Unentschieden).

## Benutzerinteraktion:

Nach jedem Zug drucke den aktuellen Zustand des Bretts und alle Nachrichten bezüglich des Spielausgangs (Gewinn oder Unentschieden).
Prüfe, ob ein gültiges Symbol eingegeben wurde (auch, ob das Symbol gerade dran ist)

## Speichern und Laden des Brettes
Das Spiel kann nach jedem Zug in eine Textdatei abgespeichert werden. Aus einem zweiten File geht hervor, welches Symbol als nächstes dran ist.
Speichern zB
1. File
x-o
x--
---

2. File:
o

Geht auch in einem File!

## Sonstige Anfoderungen
Ziel ist es, Deine GameBoard-Klasse wirklich unveränderlich zu machen: Sobald ein Spielbrettobjekt erstellt wurde, sollte sein Zustand nicht modifizierbar sein.
Kapsle die Spiellogik innerhalb der Klasse TicTacToeGame, um die Interaktion zwischen dem Spiel und den Spielern klar zu halten.
Öffentliche Methoden sollten auf die für die Interaktion mit dem Spiel notwendigen beschränkt sein.
Wenn du mit einem array arbeitest, könnte folgendes hilfreich sein: https://www.geeksforgeeks.org/system-arraycopy-in-java/