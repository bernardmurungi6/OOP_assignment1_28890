# Tax Administration Management System 

A console-based Java OOP project for the AUCA practical assignment. It registers taxpayers, manages tax types and obligations, receives declarations, creates assessments, records payments, calculates penalties, processes refunds and issues tax-clearance decisions.

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

