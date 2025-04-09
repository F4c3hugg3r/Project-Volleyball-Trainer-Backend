# Volleyballtrainer-Backend

Dies ist das **Backend** für das Projekt Volleyball-Trainer-App von *Lennard Dubhorn* 

## Funktionsweise und Datenbankanbindung

Dieses Backend kommuniziert mit einer ```Prostgres``` Datenbank und verwaltet *Stats*. Es implementiert die HTTP Schnittstelle inkl. CRUD Operationen und die Kommunikation zur Datenbank im ```MVC-Architekturmuster``` und mithilfe vom Java-```Spring Framework```. *Stats* werden, indem ein User spezifische Fragen zu von ihm gewählten Szenarien beantwortet, erstellt und anschließend nach Id und Rating (1-4) als zusammenhängender Primärschlüssel gespeichert. 

Informationen bezüglich der Funktionalität der App sind in der README des [Frontend-Repositories](https://github.com/F4c3hugg3r/Project-Volleyball-Trainer-Frontend) zu finden.
