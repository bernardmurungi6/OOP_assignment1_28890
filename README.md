# Tax Administration Management System (TAMS)

A console-based Java OOP project for the AUCA practical assignment. It registers taxpayers, manages tax types and obligations, receives declarations, creates assessments, records payments, calculates penalties, processes refunds and issues tax-clearance decisions.

> **Teaching simulation only.** All rates, deadlines, amounts and thresholds are fictional and must not be used to compute real tax liabilities.

## OOP concepts demonstrated

- Encapsulation (private fields, getters/setters)
- Two levels of abstract inheritance (`TaxParty` -> `RegisteredTaxpayer` -> taxpayers)
- Hierarchical inheritance (`IndividualTaxpayer` and `CorporateTaxpayer` share `RegisteredTaxpayer`)
- Interfaces (`Identifiable`, `Validatable`)
- Runtime polymorphism (`TaxParty[]` and `Identifiable[]`)
- Constructor chaining (`super(...)` and `this(...)`)
- Custom exceptions and input validation
- Arrays only: no collection framework, no database, no GUI

## Project structure

```
AUCA_ID/
└── src/com/auca/
    ├── interfaces/          Identifiable, Validatable
    ├── abstracts/           TaxParty, RegisteredTaxpayer
    ├── individualtaxpayer/  IndividualTaxpayer
    ├── corporatetaxpayer/   CorporateTaxpayer
    ├── revenueofficer/      RevenueOfficer
    ├── taxtype/             TaxType
    ├── taxobligation/       TaxObligation
    ├── taxdeclaration/      TaxDeclaration
    ├── taxassessment/       TaxAssessment
    ├── taxpayment/          TaxPayment
    ├── penalty/             Penalty
    ├── taxrefund/           TaxRefund
    ├── taxclearance/        TaxClearance
    ├── exceptions/          9 custom exceptions
    └── main/                Main (menu, forms, storage)
```

## Requirements

- JDK 11 or newer (developed with JDK 21)

## Compile and run

From the project folder:

```bash
mkdir out
javac -d out $(find src -name "*.java")
java -cp out com.auca.main.Main
```

Windows (Command Prompt):

```bat
mkdir out
javac -d out src\com\auca\*\*.java
java -cp out com.auca.main.Main
```

In IntelliJ / Eclipse / NetBeans: open the folder, mark `src` as the sources root and run `com.auca.main.Main`.

## Main menu

| # | Option | # | Option |
|---|--------|---|--------|
| 1 | Register Individual Taxpayer | 12 | Record Tax Payment |
| 2 | Register Corporate Taxpayer | 13 | Calculate / Record Penalty |
| 3 | Register Revenue Officer | 14 | Request / Approve Refund |
| 4 | Register Tax Type | 15 | Request / Issue Tax Clearance |
| 5 | Create Tax Obligation | 16 | Search Record by ID / TIN |
| 6 | File Tax Declaration | 17 | Update Eligible Record |
| 7 | Assess Declaration | 18 | View Taxpayer Statement |
| 8 | Confirm Assessment | 19 | View Outstanding Balances |
| 9 | View All Records | 20 | View Tax Reports |
| 10 | View Declaration History | 21 | Demonstrate Polymorphism |
| 11 | View Assessment History | 0 | Exit |

## How the forms work

Every entity uses a four-step form: identification, details, validation/calculation, then review and save.

- Type `BACK` to return to the previous step and `CANCEL` to discard everything.
- At review, choose **SAVE**, **EDIT FIELD** (by field number) or **CANCEL**.
- Records are stored only when you press SAVE, so a cancelled form changes nothing.
- If a related record is missing (for example an unknown tax type), you can register it on the spot and the form resumes with your values.

## Suggested demo flow

1. Register an individual taxpayer with a bad TIN (e.g. `12345`), then correct it to 9 digits.
2. Register a corporate taxpayer with the same TIN and watch it be rejected.
3. Register an officer, a tax type, an obligation, then file a declaration (try a wrong declared tax first).
4. Record a late-filing penalty, assess, confirm, then make two partial payments.
5. Try a duplicate payment reference and an amount above the balance.
6. Use option 17 to amend the assessment adjustment to create an overpayment, then request and approve a refund.
7. Request and issue a tax clearance, then check options 18-21.

## Business rules (all fictional)

- Expected tax = taxable amount x rate / 100, rounded HALF_UP to 2 decimals.
- Late-filing penalty = base amount x penalty rate / 100 (illustrative 5%).
- Balance = assessment total + penalties - payments.
- Payments require a CONFIRMED assessment and cannot exceed the balance.
- Refunds need a verified overpayment and an active officer whose approval limit covers the amount.
- Clearance needs an active taxpayer with no unresolved declarations or overdue unpaid obligations 
