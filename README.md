# 🎓 CampusConnect — Smart Lost & Found Matcher

> A smart campus lost-and-found platform that helps students report missing or recovered items and identify potential matches through an explainable weighted matching algorithm.

**CampusConnect** is a Java-focused college mini-project designed around a practical campus problem: lost items are often reported through disconnected channels, making it difficult to connect a lost report with a corresponding found item.

The platform brings reporting, discovery, potential-match ranking, status tracking, and recovery analytics into one clean dashboard while preserving a separate **Java OOP implementation** of the core matching system.

---

## 🚀 Live Demo

🌐 **[Open CampusConnect](https://campusconnect-smart.hatchable.site)**

💻 **[View Source Code](https://github.com/Mrunal-dev05/CampusConnect)**

---

## 🎯 The Problem

Campus lost-and-found workflows are often fragmented across:

- WhatsApp groups and student communities
- Notice boards
- Informal messages
- Separate lost and found lists
- Manual searching through reports

This makes it difficult to quickly determine whether a recently found item could belong to someone who reported it missing.

### 💡 The Idea

CampusConnect provides a centralized workflow where students can:

**Report → Discover → Compare → Review → Resolve**

Instead of claiming that two reports definitely belong together, the system calculates a **potential match score** and clearly explains the factors contributing to that score.

---

## ✨ Key Features

### 📌 Lost & Found Reporting

- Report lost items with structured information
- Report found items with matching fields
- Item category and location tracking
- Date-based reporting
- Detailed item descriptions
- Contact/preferred-contact information
- Form validation for required fields

### 🔎 Smart Potential Matching

The system compares lost and found reports using a transparent weighted scoring model:

| Matching Factor | Weight |
|---|---:|
| Same category | +30 |
| Same location | +25 |
| Date proximity | +20 |
| Item-name similarity | +15 |
| Description keyword overlap | +10 |
| **Maximum Score** | **100** |

### 📊 Match Confidence

| Score | Confidence |
|---:|---|
| **80–100** | 🔴 High |
| **60–79** | 🟠 Medium |
| **Below 60** | ⚪ Low |

The platform deliberately uses the term **Potential Match** rather than claiming definitive ownership.

### 🗂️ Browse & Search

Users can explore reports using:

- Lost / Found type
- Category
- Location
- Date
- Status
- Keyword search
- Most recent sorting
- Highest match-score sorting

### 🔄 Item Status Workflow

```text
Open
  ↓
Potential Match
  ↓
Claimed / Reviewed
  ↓
Returned
  ↓
Closed
```

### 📈 Analytics Dashboard

The dashboard provides an overview of campus lost-and-found activity, including:

- Total lost items
- Total found items
- Potential matches
- Successfully returned items
- Lost vs. found distribution
- Most common categories
- Most common locations
- Match success rate

### 🎛️ Match Review

Potential matches can be reviewed through actions such as:

- Relevant
- Not a Match
- Resolved

This keeps the matching process transparent and human-reviewed instead of presenting automated scoring as a final decision.

---

## 🔄 Core Platform Workflow

```text
       Student Report
             │
       ┌─────┴─────┐
       │           │
    Lost Item   Found Item
       │           │
       └─────┬─────┘
             ↓
      Matching Engine
             │
             ↓
    Potential Match Score
             │
      ┌──────┴──────┐
      │             │
   High/Medium     Low
      │             │
      ↓             ↓
  Review Match   Continue Search
      │
      ↓
   Resolution
      │
      ↓
    Returned
```

---

## 🧠 Matching Algorithm

The matching engine is intentionally **deterministic and explainable**.

For every Lost Item and Found Item pair:

1. Compare categories.
2. Compare reported locations.
3. Calculate the difference between report dates.
4. Compare item names.
5. Find meaningful overlapping description keywords.
6. Add the corresponding weighted points.
7. Cap the final score at **100**.
8. Convert the score into a confidence level.

### Example

```text
Lost Item
  Laptop Charger
  Category: Electronics
  Location: Lab 204
  Date: 2026-09-13

          VS

Found Item
  Dell Laptop Charger
  Category: Electronics
  Location: Lab 204
  Date: 2026-09-13

Category Match       +30
Location Match       +25
Same Date            +20
Name Similarity      +15
Description Overlap  +10
                     ───
Total                 100/100
Confidence            High
```

This approach demonstrates practical algorithmic thinking without making unsupported AI/ML claims.

---

## 🏗️ Architecture

```text
                         CampusConnect
                              │
             ┌────────────────┴────────────────┐
             │                                 │
       Browser Dashboard                 Java Core Implementation
             │                                 │
     ┌───────┼────────┐                ┌───────┼────────┐
     │       │        │                │       │        │
  Reports  Matching Analytics        Model  Service   Main
     │       │        │                │       │        │
     └───────┴────────┘                └───────┴────────┘
             │                                 │
             └──────────── Same Product ───────┘
                         Concept & Logic
```

The browser dashboard provides the interactive product experience, while the Java source demonstrates the academic/core implementation of the matching system.

---

## ☕ Java Implementation

The project keeps the Java implementation modular and follows standard object-oriented design.

### Core Classes

| Class | Responsibility |
|---|---|
| `Item` | Abstract base class for common item properties |
| `LostItem` | Represents a lost report |
| `FoundItem` | Represents a found report |
| `MatchResult` | Stores a lost/found pair and calculated score |
| `MatchingService` | Contains the weighted matching logic |
| `Main` | Console entry point and application workflow |

### Java Concepts Demonstrated

- **Abstraction** — `Item` is an abstract base class
- **Inheritance** — `LostItem` and `FoundItem` extend `Item`
- **Encapsulation** — private fields with public accessors
- **Collections** — `ArrayList` and `List`
- **Date & Time API** — `LocalDate` and `ChronoUnit`
- **Sorting** — `Comparator`
- **Exception Handling** — input validation and invalid input handling
- **Modular Design** — model, service and application layers

---

## 📁 Project Structure

```text
CampusConnect/
│
├── public/
│   ├── index.html
│   ├── styles.css
│   ├── app.js
│   │
│   └── java-src/
│       └── campusconnect/
│           ├── Main.java
│           │
│           ├── model/
│           │   ├── Item.java
│           │   ├── LostItem.java
│           │   ├── FoundItem.java
│           │   └── MatchResult.java
│           │
│           └── service/
│               └── MatchingService.java
│
└── README.md
```

The package structure mirrors the Java `package` declarations, making the source easier to understand, maintain and compile locally.

---

## 🛠️ Built With

**Java 17+ · HTML5 · CSS3 · JavaScript (ES6+) · LocalDate · Java Collections**

### Technology Roles

| Technology | Purpose |
|---|---|
| **Java 17+** | Core academic implementation and OOP design |
| **HTML5** | Dashboard structure and forms |
| **CSS3** | Responsive UI, layout and visual design |
| **JavaScript** | Browser-side interactions, matching demo and analytics |

---

## ⚙️ Run the Java Version Locally

### Prerequisites

- **JDK 17 or later**
- Git

### Clone the Repository

```bash
git clone https://github.com/Mrunal-dev05/CampusConnect.git
cd CampusConnect
```

### Compile

```bash
cd public/java-src
javac campusconnect/model/*.java campusconnect/service/*.java campusconnect/Main.java
```

### Run

```bash
java campusconnect.Main
```

The Java console application allows you to create lost/found reports, view reports and calculate potential matches.

---

## 🌐 Browser Demo

The hosted version provides a polished dashboard experience with:

- Dashboard overview
- Lost item reporting
- Found item reporting
- Search and filtering
- Potential match ranking
- Match review
- Item details
- Status management
- Analytics
- Responsive layout

👉 **[Launch CampusConnect](https://campusconnect-smart.hatchable.site)**

---

## 📊 Product Highlights

```text
             CampusConnect
                  │
       ┌──────────┼──────────┐
       │          │          │
    Report      Match      Analyze
       │          │          │
       ↓          ↓          ↓
    Lost/Found  Score     Insights
       │          │          │
       └──────────┼──────────┘
                  ↓
              Resolution
                  ↓
               Returned
```

The product focuses on one clear goal: **reduce the friction between reporting a lost item and discovering a relevant found report.**

---

## 🎓 Academic Value

CampusConnect was designed to demonstrate how core Java concepts can be applied to a practical software problem rather than building a purely theoretical console program.

The project combines:

- Object-oriented programming
- Algorithmic scoring
- Data structures
- Date-based comparison
- Input validation
- Ranking and sorting
- Modular architecture
- Responsive web UI
- Data-driven analytics

This makes it suitable as a **college mini-project, Java OOP project, portfolio project, and resume project**.

---

## 🔮 Future Improvements

Potential future iterations could include:

- 🗄️ Persistent database storage
- 🔐 Student authentication and authorization
- 📱 Mobile-first PWA support
- 📸 Image-based item comparison
- 🔔 Email or in-app notifications
- 🏫 College-specific campus locations
- 🤖 ML-assisted similarity recommendations
- 📊 More advanced recovery analytics
- ☁️ Production backend and scalable API

These are intentionally listed as future improvements and are **not represented as current functionality**.

---


> Built a Java-based Smart Lost & Found Matcher using OOP and a weighted 100-point matching algorithm, with a responsive web dashboard for reporting, search, match ranking, status tracking and analytics.

---

## 👨‍💻 Developer

**Mrunal Pimpale**  
Computer Engineering Student | Software Development & Algorithms

🔗 **GitHub:** [Mrunal-dev05](https://github.com/Mrunal-dev05)

---

## 📄 License

This project is developed for **academic learning, portfolio development and demonstration purposes**.
