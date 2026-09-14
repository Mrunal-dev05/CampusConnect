# CampusConnect – Smart Lost & Found Matcher

A Java-focused college mini-project for reporting lost and found campus items and ranking potential matches using a transparent weighted scoring algorithm.

## Features
- Report lost and found items
- Browse, search, filter and sort campus reports
- Potential-match ranking with confidence levels
- Analytics for lost, found, returned, categories and locations
- Status workflow: Open, Potential Match, Claimed, Returned, Closed
- Responsive dark dashboard UI
- Java OOP source preserved in `public/java-src/`

## Matching Algorithm
| Factor | Weight |
|---|---:|
| Same category | +30 |
| Same location | +25 |
| Date proximity | +20 |
| Item-name similarity | +15 |
| Description keyword overlap | +10 |
| **Maximum** | **100** |

Confidence: **High** 80–100, **Medium** 60–79, **Low** below 60.

The matcher reports a **potential match**, not a definitive ownership claim.

## Java Concepts
- OOP and inheritance: `Item`, `LostItem`, `FoundItem`
- Encapsulation with private fields and accessors
- Collections with `ArrayList` and `List`
- `LocalDate` for dates
- `Comparator` for ranking
- Exception handling and input validation

## Project Structure
```text
public/
├── index.html
├── styles.css
├── app.js
└── java-src/
    ├── Item.java
    ├── LostItem.java
    ├── FoundItem.java
    ├── MatchResult.java
    ├── MatchingService.java
    └── Main.java
```

The hosted Hatchable demo is a browser-based JavaScript implementation of the same matching concept; Hatchable does not execute the Java source. The Java files are included as the academic implementation/source for the project.

## Demo
Hosted on Hatchable: https://campusconnect-smart.hatchable.site

## Run the Java version locally
Place the Java files into package directories matching their declarations (`campusconnect/`, `campusconnect/model/`, `campusconnect/service/`) and compile with a Java 17+ JDK.

```bash
javac campusconnect/model/*.java campusconnect/service/*.java campusconnect/Main.java
java campusconnect.Main
```

## Author
Mrunal-dev05
