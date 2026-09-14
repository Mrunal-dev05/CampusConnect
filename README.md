# CampusConnect – Smart Lost & Found Matcher

A resume-ready Java college project that helps students report lost and found items and ranks potential matches using a transparent, explainable scoring algorithm.

## Overview
CampusConnect combines Java OOP, collections, date handling, validation, and ranking with a responsive browser dashboard. Users can submit campus lost/found reports, browse and filter records, review potential matches, and explore basic recovery analytics.

> **Important:** A match is presented as a **potential match**, not a definitive ownership claim.

## Key Features
- Lost and found item reporting with validation
- Search, filter and sort reports by type, category, location, date and status
- Explainable potential-match ranking with confidence levels
- Match review workflow: Relevant, Not a Match, Resolved
- Item status lifecycle: Open, Potential Match, Claimed, Returned, Closed
- Dashboard statistics and recent campus activity
- Analytics for lost vs. found, categories, locations, returned items and match success
- Responsive professional dashboard UI
- Java source organized into separate OOP classes

## Matching Algorithm
Each lost report is compared against found reports using weighted factors:

| Factor | Weight |
|---|---:|
| Same category | +30 |
| Same location | +25 |
| Date proximity | +20 |
| Item-name similarity | +15 |
| Description keyword overlap | +10 |
| **Maximum score** | **100** |

### Confidence Levels
- **High:** 80–100
- **Medium:** 60–79
- **Low:** below 60

The algorithm is deterministic and explainable, making it suitable for demonstrating core Java problem-solving rather than claiming artificial intelligence.

## Java Concepts Demonstrated
- **Abstraction:** `Item` as an abstract base class
- **Inheritance:** `LostItem` and `FoundItem` extend `Item`
- **Encapsulation:** private fields with controlled access through getters
- **Collections:** `ArrayList` and `List`
- **Date/Time API:** `LocalDate` and `ChronoUnit`
- **Sorting:** `Comparator`
- **Exception handling:** input validation and error handling
- **Modular design:** model, service and application layers

## Project Structure
```text
public/
├── index.html
├── styles.css
├── app.js
└── java-src/
    └── campusconnect/
        ├── Main.java
        ├── model/
        │   ├── Item.java
        │   ├── LostItem.java
        │   ├── FoundItem.java
        │   └── MatchResult.java
        └── service/
            └── MatchingService.java
```

## Architecture
```text
User Interface
     │
     ▼
Browser Dashboard (HTML / CSS / JavaScript)
     │
     ├── Reporting & Validation
     ├── Search / Filter / Sort
     ├── Match Ranking
     └── Analytics

Academic Java Implementation
     │
     ├── campusconnect.Main
     ├── campusconnect.model
     └── campusconnect.service.MatchingService
```

The hosted Hatchable demo is a client-side browser implementation of the same product and matching concept. The Java source is preserved separately as the academic implementation; Hatchable does not execute Java source code.

## Run the Java Version Locally
Requires **JDK 17+**.

From the `public/java-src` directory:

```bash
javac campusconnect/model/*.java campusconnect/service/*.java campusconnect/Main.java
java campusconnect.Main
```

## Hosted Demo
**CampusConnect:** https://campusconnect-smart.hatchable.site

## Tech Stack
- Java 17+
- HTML5
- CSS3
- JavaScript (ES6+)
- LocalDate / Java Collections
- Hatchable for hosted browser demo

## Resume Description
**CampusConnect – Smart Lost & Found Matcher | Java, OOP, Collections, HTML/CSS/JavaScript**  
Built a campus lost-and-found system with an explainable weighted matching algorithm that ranks potential matches using category, location, date proximity, item-name similarity and description keywords. Implemented Java OOP with inheritance, encapsulation, collections, date handling, sorting and validation, and developed a responsive dashboard with search, filtering, status workflows and analytics.

## Author
Mrunal-dev05
