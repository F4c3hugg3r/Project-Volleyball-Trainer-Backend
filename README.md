# Volleyballtrainer-Backend

Dies ist das **Backend** für das Projekt des Moduls Webtechnologien von *Lennard Dubhorn* 

Informationen zur **Funktionsweise** sind in der README des Frontend-Reposirotories zu finden.

## Funktionsweise und Datenbankanbindung

Dieses Backend kommuniziert mit einer **Prostgres Datenbank**, welche auf Render erstelt wurde und verwaltet **Stats** die dadurch erstellt werden, dass ein User Fragen beantwortet. Die Stats werden nach Id und Rating (1-4) als zusammenhängender primärschlüssel gespeichert. Außerdem gibt es noch eine Anzahl, welche bei erneutem Beantworten der Frage und gleichen rating inkrementiert wird.

