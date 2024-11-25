# Successfactors Konnektor

SuccessFactors ist eine cloudbasierte Softwarelösung für Human Capital Management (HCM), die von SAP angeboten wird. Sie unterstützt Unternehmen bei der Verwaltung ihrer Mitarbeiterprozesse, einschließlich Talentmanagement, Personalentwicklung, Leistungsbewertung, Onboarding, Vergütungsmanagement und Nachfolgeplanung. SuccessFactors bietet eine umfassende Plattform für das Personalwesen (HR), die sich auf die Verbesserung der Mitarbeiterleistung und -bindung konzentriert, und ist bekannt für seine skalierbare, flexible und global einsetzbare HR-Softwarelösung.

Dieser Konnektor vereinfacht die Integration von Successfactors in Deine Prozesse, indem er:

- auf REST-Webservice-Technologien setzt,
- Zugriff auf Beispiel-Funktionalitäten von Successfactors bietet,
- und den Integrationsaufwand durch eine Demo-Implementierung mit Beispielaufrufen minimiert.

## Demo

Starte den Testprozess. Er gibt Dir Testdaten im Log zurück.

## Setup

Bevor jegliche Interaktionen zwischen der Axon Ivy Engine und den Successfactors-Services ausgeführt werden können, müssen diese miteinander bekannt gemacht werden. Dies kann wie folgt erfolgen:

1. Besorge Dir einen Successfactors-Account mit `host-name`, `user-name` und `password`.

2. Überschreibe die Variablen für `host-name`, `user-name` und `password` im Demo-Projekt, wie im folgenden Beispiel gezeigt:

```
Variablen:
  
  successfactors-connector:
  
    host: <myhost>
    
    username: <myuser>
  
    # [password]
    password: <mypass>
```
