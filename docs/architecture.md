# Architecture Overview

Summary of the Task 3 design. The full design document (requirements, data model, API list, status workflow) is kept in the project documentation.

## Decision

Modular monolith: React (served by Nginx) → Spring Boot 4.1 REST API on Java 21 with embedded Tomcat → PostgreSQL 17. Built with Maven. Packaged as three Docker containers (MVP-15).

## Layers inside each feature module

```text
Controller  (@RestController: HTTP, validation, DTOs)
    ↓
Service     (@Service: business rules, transactions, ownership and status checks)
    ↓
Repository  (Spring Data JPA)
    ↓
PostgreSQL
```

## Planned feature packages (under `com.homestay`)

| Package | MVP tasks | Added in |
| --- | --- | --- |
| `common` | API response format, exceptions, global error handler | Sprint 1 |
| `config` | Security configuration, first admin account | Sprint 1 |
| `auth` | MVP-01 login, JWT | Sprint 1 |
| `user` | MVP-02 host accounts, roles | Sprint 1 |
| `property` | MVP-03, MVP-04 | Sprints 1 and 3 |
| `room` | MVP-05, MVP-06, MVP-07 | Sprints 2 and 3 |
| `guest` | MVP-08, MVP-09 | Sprints 2 and 3 |
| `booking` | MVP-10 to MVP-13 | Sprint 2, MVP-12 in Sprint 3 |
| `dashboard` | MVP-14 | Sprint 3 |

Packages are created when their first class is written, so the repository contains no empty placeholder folders.

## Core entities

User, Property, Room, Guest, Booking (five PostgreSQL tables, created by Flyway migrations).

## Runtime (after MVP-15)

```text
Browser → nginx :80 → backend :8080 (embedded Tomcat) → postgres :5432 (volume pgdata)
```

Only port 80 is published to the host machine.
