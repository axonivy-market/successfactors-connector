# Successfactors Connector

SuccessFactors ist eine cloudbasierte Softwarelösung für das Personalmanagement
(Human Capital Management, HCM) von SAP. Sie unterstützt Unternehmen bei der
Verwaltung ihrer Mitarbeiterprozesse, darunter Talentmanagement,
Mitarbeiterentwicklung, Leistungsbewertung, Onboarding, Vergütungsmanagement und
Nachfolgeplanung. SuccessFactors bietet eine umfassende HR-Plattform, die sich
auf die Verbesserung der Mitarbeiterleistung und -bindung konzentriert und für
ihre skalierbare, flexible und weltweit einsetzbare HR-Softwarelösung bekannt
ist.

Dieser Konnektor vereinfacht die Integration von Successfactors in Ihre Prozesse
durch:

- Unter Verwendung von REST-Webdiensttechnologien
- Sie bieten Zugriff auf Beispielfunktionen von Successfactors.
- und Minimierung des Integrationsaufwands durch eine Demo-Implementierung mit
  Beispielaufrufen.

## Demo

1. Rufen Sie den Testprozess auf. Er gibt Ihnen die Testdaten im Protokoll
   zurück.

## Setup

Before any interactions between the Axon Ivy Engine and Successfactors services
can be run, they have to be introduced to each other. This can be done as
follows:

1. Erstellen Sie ein Successfactors-Konto unter `mit dem Hostnamen`, dem
   Benutzernamen `` und dem Passwort `` , um es zu verwenden.

1. Überschreiben Sie die Variablen für `host-name`, `user-name` und `password`
   im Demo-Projekt wie im folgenden Beispiel gezeigt.

```
Variables:

  successfactors-connector:

    host: <myhost>

    username: <myuser>

    # [password]
    password: <mypass>
```
