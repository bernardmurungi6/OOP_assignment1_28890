
import java.util.Scanner;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;
import java.math.BigDecimal;
import auca.individualtaxpayer.IndividualTaxpayer;
import auca.exceptions.ValidationException;
import auca.corporatetaxpayer.CorporateTaxpayer;
import auca.revenueofficer.RevenueOfficer;
import auca.taxtype.TaxType;
import auca.abstracts.RegisteredTaxpayer;
import auca.taxobligation.TaxObligation;
import auca.taxdeclaration.TaxDeclaration;
import auca.taxassesment.TaxAssessment;
import auca.abstracts.RegisteredTaxpayer;
import auca.taxpayment.TaxPayment;
import auca.penalty.Penalty;
import auca.taxrefund.TaxRefund;
import auca.taxclearance.TaxClearance;
import auca.abstracts.TaxParty;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static IndividualTaxpayer[] individualTaxpayers =
            new IndividualTaxpayer[100];
    static int individualCount = 0;

    static CorporateTaxpayer[] corporateTaxpayers =
            new CorporateTaxpayer[100];
    static int corporateCount = 0;

    static RevenueOfficer[] revenueOfficers = new RevenueOfficer[100];
    static int officerCount = 0;

    static TaxType[] taxTypes = new TaxType[100];
    static int taxTypeCount = 0;

    static TaxObligation[] taxObligations = new TaxObligation[100];
    static int obligationCount = 0;

    static TaxDeclaration[] taxDeclarations = new TaxDeclaration[100];
    static int declarationCount = 0;

    static TaxAssessment[] taxAssessments = new TaxAssessment[100];
    static int assessmentCount = 0;

    static TaxPayment[] taxPayments = new TaxPayment[100];
    static int paymentCount = 0;

    static Penalty[] penalties = new Penalty[100];
    static int penaltyCount = 0;

    static TaxRefund[] taxRefunds = new TaxRefund[100];
    static int refundCount = 0;

    static TaxClearance[] taxClearances = new TaxClearance[100];
    static int clearanceCount = 0;

    public static void main(String[] args) {

        int choice = -1;

        while (choice != 0) {

            System.out.println("\n===========================");
            System.out.println("TAX ADMINISTRATION MANAGEMENT");
            System.out.println("=============================");

            System.out.println("1. Register Individual Taxpayer");
            System.out.println("2. Register Corporate Taxpayer");
            System.out.println("3. Register Revenue Officer");
            System.out.println("4. Register Tax Type");
            System.out.println("5. Create Tax Obligation");
            System.out.println("6. File Tax Declaration");
            System.out.println("7. Assess Declaration");
            System.out.println("8. Confirm Assessment");
            System.out.println("9. View All Records");
            System.out.println("10. View Declaration History");
            System.out.println("11. View Assessment History");
            System.out.println("12. Record Tax Payment");
            System.out.println("13. Calculate / Record Penalty");
            System.out.println("14. Request / Approve Refund");
            System.out.println("15. Request / Issue Tax Clearance");
            System.out.println("16. Search Record by ID / TIN");
            System.out.println("17. Update Eligible Record");
            System.out.println("18. View Taxpayer Statement");
            System.out.println("19. View Outstanding Balances");
            System.out.println("20. View Tax Report");
            System.out.println("21. Demonstrate Polymorphism");
            System.out.println("0. Exit");
            System.out.println("=============================");

            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    registerIndividualTaxpayer();
                    break;

                case 2:
                    registerCorporateTaxpayer();
                    break;

                case 3:
                    registerRevenueOfficer();
                    break;

                case 4:
                    registerTaxType();
                    break;

                case 5:
                    createTaxObligation();
                    break;

                case 6:
                    fileTaxDeclaration();
                    break;

                case 7:
                    assessDeclaration();
                    break;

                case 8:
                    confirmAssessment();
                    break;

                case 9:
                    viewAllRecords();
                    break;

                case 10:
                    viewDeclarationHistory();
                    break;

                case 11:
                    viewAssessmentHistory();
                    break;

                case 12:
                    recordTaxPayment();
                    break;

                case 13:
                    calculateAndRecordPenalty();
                    break;

                case 14:
                    requestAndApproveRefund();
                    break;

                case 15:
                    requestTaxClearance();
                    break;

                case 16:
                    searchRecord();
                    break;

                case 17:
                    updateEligibleRecord();
                    break;

                case 18:
                    viewTaxpayerStatement();
                    break;

                case 19:
                    viewOutstandingBalances();
                    break;

                case 20:
                    viewTaxReports();
                    break;

                case 21:
                    demonstratePolymorphism();
                    break;

                case 0:
                    System.out.println("Thank you for using TAMS!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }


    public static void registerIndividualTaxpayer() {


            String[] data = new String[18];

            int step = 1;

            while (step <= 4) {

                if (step == 1) {

                    System.out.println("\n===== STEP 1 OF 4: PERSONAL DETAILS =====");

                    System.out.println("01 Party ID       [String, 4-30 characters]");
                    System.out.println("02 First Name     [String, 2-60 characters]");
                    System.out.println("03 Last Name      [String, 2-60 characters]");
                    System.out.println("04 Email          [Valid email]");
                    System.out.println("05 Phone          [10-15 digits]");
                    System.out.println("06 Date of Birth  [YYYY-MM-DD]");

                    // Party ID
                    while (true) {
                        System.out.print("Party ID: ");
                        data[0] = sc.nextLine().trim();

                        if (data[0].length() >= 4 && data[0].length() <= 30) {
                            break;
                        }

                        System.out.println("Party ID must contain 4-30 characters.");
                    }

                    // First name
                    while (true) {
                        System.out.print("First Name: ");
                        data[1] = sc.nextLine().trim();

                        if (data[1].length() >= 2 && data[1].length() <= 60) {
                            break;
                        }

                        System.out.println("First name must contain 2-60 characters.");
                    }

                    // Last name
                    while (true) {
                        System.out.print("Last Name: ");
                        data[2] = sc.nextLine().trim();

                        if (data[2].length() >= 2 && data[2].length() <= 60) {
                            break;
                        }

                        System.out.println("Last name must contain 2-60 characters.");
                    }

                    // Email
                    while (true) {
                        System.out.print("Email: ");
                        data[3] = sc.nextLine().trim();

                        if (data[3].matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
                                && data[3].length() <= 120) {
                            break;
                        }

                        System.out.println("Please enter a valid email.");
                    }

                    // Phone
                    while (true) {
                        System.out.print("Phone: ");
                        data[4] = sc.nextLine().trim();

                        if (data[4].matches("\\+?[0-9]{10,15}")) {
                            break;
                        }

                        System.out.println("Phone must contain 10-15 digits.");
                    }

                    // Date of birth
                    while (true) {
                        System.out.print("Date of Birth (YYYY-MM-DD): ");

                        try {
                            data[5] = sc.nextLine().trim();

                            LocalDate birthDate = LocalDate.parse(data[5]);

                            if (birthDate.isBefore(LocalDate.now())) {
                                break;
                            }

                            System.out.println("Date of birth must be before today.");

                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date. Use YYYY-MM-DD.");
                        }
                    }

                    System.out.println("\nStep 1 completed.");
                    System.out.println("1. NEXT");
                    System.out.println("0. CANCEL");
                    System.out.print("Choose: ");

                    String choice = sc.nextLine();

                    if (choice.equals("1")) {
                        step = 2;
                    } else if (choice.equals("0")) {
                        System.out.println("Registration cancelled.");
                        return;
                    } else {
                        System.out.println("Invalid choice.");
                    }
                }


                else if (step == 2) {

                    System.out.println("\n===== STEP 2 OF 4: TAX REGISTRATION DETAILS =====");

                    System.out.println("07 TIN                [9 digits]");
                    System.out.println("08 Registration Date  [YYYY-MM-DD]");
                    System.out.println("09 Taxpayer Status    [ACTIVE/INACTIVE]");
                    System.out.println("10 District           [String]");
                    System.out.println("11 Sector              [String]");
                    System.out.println("12 Tax Office          [String]");

                    // TIN
                    while (true) {
                        if (data[6] != null) {
                            break;
                        }

                        System.out.print("TIN: ");
                        data[6] = sc.nextLine().trim();

                        if (data[6].matches("[0-9]{9}")) {
                            break;
                        }

                        System.out.println("TIN must contain exactly 9 digits.");
                        data[6] = null;
                    }

                    // Registration date
                    while (true) {
                        if (data[7] != null) {
                            break;
                        }

                        System.out.print("Registration Date (YYYY-MM-DD): ");

                        try {
                            String date = sc.nextLine().trim();
                            LocalDate registrationDate = LocalDate.parse(date);

                            LocalDate birthDate = LocalDate.parse(data[5]);

                            if (registrationDate.isAfter(LocalDate.now())) {
                                System.out.println("Registration date cannot be in the future.");
                            } else if (!registrationDate.isAfter(birthDate)) {
                                System.out.println("Registration date must be after date of birth.");
                            } else {
                                data[7] = date;
                            }

                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date. Use YYYY-MM-DD.");
                        }
                    }

                    // Taxpayer status
                    while (true) {
                        if (data[8] != null) {
                            break;
                        }

                        System.out.print("Taxpayer Status (ACTIVE/INACTIVE): ");
                        String status = sc.nextLine().trim().toUpperCase();

                        if (status.equals("ACTIVE") || status.equals("INACTIVE")) {
                            data[8] = status;
                            break;
                        }

                        System.out.println("Enter ACTIVE or INACTIVE.");
                    }

                    // District
                    while (true) {
                        if (data[9] != null) {
                            break;
                        }

                        System.out.print("District: ");
                        data[9] = sc.nextLine().trim();

                        if (!data[9].isEmpty()) {
                            break;
                        }

                        System.out.println("District is required.");
                        data[9] = null;
                    }

                    // Sector
                    while (true) {
                        if (data[10] != null) {
                            break;
                        }

                        System.out.print("Sector: ");
                        data[10] = sc.nextLine().trim();

                        if (!data[10].isEmpty()) {
                            break;
                        }

                        System.out.println("Sector is required.");
                        data[10] = null;
                    }

                    // Tax Office
                    while (true) {
                        if (data[11] != null) {
                            break;
                        }

                        System.out.print("Tax Office: ");
                        data[11] = sc.nextLine().trim();

                        if (!data[11].isEmpty()) {
                            break;
                        }

                        System.out.println("Tax Office is required.");
                        data[11] = null;
                    }

                    System.out.println("\nStep 2 completed.");

                    System.out.println("1. NEXT");
                    System.out.println("2. BACK");
                    System.out.println("0. CANCEL");

                    System.out.print("Choose: ");
                    String choice = sc.nextLine();

                    if (choice.equals("1")) {
                        step = 3;
                    } else if (choice.equals("2")) {
                        step = 1;
                    } else if (choice.equals("0")) {
                        System.out.println("Registration cancelled.");
                        return;
                    } else {
                        System.out.println("Invalid choice. Try again.");
                    }
                }


                else if (step == 3) {

                    System.out.println("\n===== STEP 3: INDIVIDUAL DETAILS =====");

                    // National ID
                    while (data[12] == null) {
                        System.out.print("Enter National ID (16 digits): ");
                        String nationalId = sc.nextLine();

                        if (nationalId.matches("[0-9]{16}")) {
                            data[12] = nationalId;
                        } else {
                            System.out.println("Invalid National ID. It must contain 16 digits.");
                        }
                    }

                    // Occupation
                    while (data[13] == null) {
                        System.out.print("Enter Occupation: ");
                        String occupation = sc.nextLine();

                        if (!occupation.trim().isEmpty()) {
                            data[13] = occupation;
                        } else {
                            System.out.println("Occupation is required.");
                        }
                    }

                    // Business name
                    while (data[14] == null) {
                        System.out.print("Enter Business Name (or N/A): ");
                        String businessName = sc.nextLine();

                        if (!businessName.trim().isEmpty()) {
                            data[14] = businessName;
                        } else {
                            System.out.println("Business name is required. Enter N/A if you have no business.");
                        }
                    }

                    // Business start date
                    while (data[15] == null) {
                        System.out.print("Enter Business Start Date (YYYY-MM-DD): ");
                        String businessDate = sc.nextLine();

                        try {
                            LocalDate date = LocalDate.parse(businessDate);

                            if (date.isAfter(LocalDate.now())) {
                                System.out.println("Business start date cannot be in the future.");
                            } else {
                                data[15] = businessDate;
                            }

                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date. Use YYYY-MM-DD.");
                        }
                    }

                    // Annual turnover
                    while (data[16] == null) {
                        System.out.print("Enter Annual Turnover: ");
                        String turnover = sc.nextLine();

                        try {
                            BigDecimal amount = new BigDecimal(turnover);

                            if (amount.compareTo(BigDecimal.ZERO) < 0) {
                                System.out.println("Annual turnover cannot be negative.");
                            } else {
                                data[16] = turnover;
                            }

                        } catch (NumberFormatException e) {
                            System.out.println("Invalid amount. Enter a number.");
                        }
                    }

                    // Resident status
                    while (data[17] == null) {
                        System.out.print("Is the taxpayer a resident? (YES/NO): ");
                        String resident = sc.nextLine();

                        if (resident.equalsIgnoreCase("YES")) {
                            data[17] = "YES";
                        } else if (resident.equalsIgnoreCase("NO")) {
                            data[17] = "NO";
                        } else {
                            System.out.println("Please enter YES or NO.");
                        }
                    }

                    // Navigation
                    System.out.println("\n1. NEXT");
                    System.out.println("2. BACK");
                    System.out.println("0. CANCEL");
                    System.out.print("Choose an option: ");

                    int option = Integer.parseInt(sc.nextLine());

                    if (option == 1) {
                        step = 4;
                    } else if (option == 2) {
                        step = 2;
                    } else if (option == 0) {
                        System.out.println("Registration cancelled.");
                        return;
                    } else {
                        System.out.println("Invalid option.");
                    }
                }


                else if (step == 4) {

                    System.out.println("\n===== STEP 4: REVIEW AND SAVE =====");

                    System.out.println("1. Party ID: " + data[0]);
                    System.out.println("2. First Name: " + data[1]);
                    System.out.println("3. Last Name: " + data[2]);
                    System.out.println("4. Email: " + data[3]);
                    System.out.println("5. Phone Number: " + data[4]);
                    System.out.println("6. Date of Birth: " + data[5]);
                    System.out.println("7. TIN: " + data[6]);
                    System.out.println("8. Registration Date: " + data[7]);
                    System.out.println("9. Taxpayer Status: " + data[8]);
                    System.out.println("10. District: " + data[9]);
                    System.out.println("11. Sector: " + data[10]);
                    System.out.println("12. Tax Office: " + data[11]);
                    System.out.println("13. National ID: " + data[12]);
                    System.out.println("14. Occupation: " + data[13]);
                    System.out.println("15. Business Name: " + data[14]);
                    System.out.println("16. Business Start Date: " + data[15]);
                    System.out.println("17. Annual Turnover: " + data[16]);
                    System.out.println("18. Resident: " + data[17]);

                    System.out.println("\n1. EDIT A FIELD");
                    System.out.println("2. SAVE");
                    System.out.println("0. CANCEL");
                    System.out.print("Choose an option: ");

                    int option = Integer.parseInt(sc.nextLine());

                    if (option == 1) {

                        System.out.print("Enter field number to edit (1-18): ");
                        int field = Integer.parseInt(sc.nextLine());

                        if (field >= 1 && field <= 18) {
                            data[field - 1] = null;

                            if (field <= 6) {
                                step = 1;
                            } else if (field <= 12) {
                                step = 2;
                            } else {
                                step = 3;
                            }
                        } else {
                            System.out.println("Invalid field number.");
                        }

                    } else if (option == 2) {


                        boolean duplicate = false;

                        for (int i = 0; i < individualCount; i++) {

                            if (individualTaxpayers[i].getId().equals(data[0])) {
                                System.out.println("This Party ID already exists.");
                                duplicate = true;
                                break;
                            }

                            if (individualTaxpayers[i].getTin().equals(data[6])) {
                                System.out.println("This TIN already exists.");
                                duplicate = true;
                                break;
                            }

                            if (individualTaxpayers[i].getNationalId().equals(data[12])) {
                                System.out.println("This National ID already exists.");
                                duplicate = true;
                                break;
                            }
                        }

                        if (duplicate) {
                            continue;
                        }


                        if (individualCount >= individualTaxpayers.length) {
                            System.out.println("Registration storage is full.");
                            return;
                        }

                        try {
                            IndividualTaxpayer taxpayer = new IndividualTaxpayer(
                                    data[0], data[1], data[2], data[3], data[4],
                                    LocalDate.parse(data[5]),
                                    data[6],
                                    LocalDate.parse(data[7]),
                                    data[8], data[9], data[10], data[11],
                                    data[12], data[13], data[14],
                                    LocalDate.parse(data[15]),
                                    new BigDecimal(data[16]),
                                    data[17].equalsIgnoreCase("YES")
                            );

                            taxpayer.validate();

                            individualTaxpayers[individualCount] = taxpayer;
                            individualCount++;

                            System.out.println("Individual taxpayer registered successfully!");

                            return;

                        } catch (ValidationException e) {
                            System.out.println("Registration failed: " + e.getMessage());
                            return;
                        }

                    } else if (option == 0) {
                        System.out.println("Registration cancelled.");
                        return;
                    } else {
                        System.out.println("Invalid option.");
                    }
                }

            }


    }

    public static void registerCorporateTaxpayer() {

        String[] data = new String[18];

        int step = 1;

        while (step <= 4) {

            if (step == 1) {

                System.out.println("\n=== STEP 1: PERSONAL DETAILS ===");


                if (step == 1) {

                    System.out.println("\n=== STEP 1: PERSONAL DETAILS ===");

                    System.out.print("Enter Party ID: ");
                    data[0] = sc.nextLine();

                    System.out.print("Enter First Name: ");
                    data[1] = sc.nextLine();

                    System.out.print("Enter Last Name: ");
                    data[2] = sc.nextLine();

                    System.out.print("Enter Email: ");
                    data[3] = sc.nextLine();

                    System.out.print("Enter Phone Number: ");
                    data[4] = sc.nextLine();

                    System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
                    data[5] = sc.nextLine();

                    step = 2;
                }


            }

            else if (step == 2) {
                System.out.println("\n=== STEP 2: TAX REGISTRATION DETAILS ===");

                    System.out.print("Enter TIN (9 digits): ");
                    data[6] = sc.nextLine();

                    System.out.print("Enter Registration Date (YYYY-MM-DD): ");
                    data[7] = sc.nextLine();

                    System.out.print("Enter Taxpayer Status (ACTIVE/INACTIVE): ");
                    data[8] = sc.nextLine();

                    System.out.print("Enter District: ");
                    data[9] = sc.nextLine();

                    System.out.print("Enter Sector: ");
                    data[10] = sc.nextLine();

                    System.out.print("Enter Tax Office: ");
                    data[11] = sc.nextLine();

                    step = 3;
                }



            else if (step == 3) {

                System.out.println("\n=== STEP 3: CORPORATE DETAILS ===");

                System.out.print("Enter Company Registration No: ");
                data[12] = sc.nextLine();

                System.out.print("Enter Legal Name: ");
                data[13] = sc.nextLine();

                System.out.print("Enter Incorporation Date (YYYY-MM-DD): ");
                data[14] = sc.nextLine();

                System.out.print("Enter Business Sector: ");
                data[15] = sc.nextLine();

                System.out.print("Enter Authorized Representative: ");
                data[16] = sc.nextLine();

                System.out.print("Enter Annual Turnover: ");
                data[17] = sc.nextLine();

                step = 4;
            }



            else if (step == 4) {

                System.out.println("\n=== STEP 4: REVIEW CORPORATE TAXPAYER ===");

                System.out.println("\n--- PERSONAL DETAILS ---");
                System.out.println("Party ID: " + data[0]);
                System.out.println("First Name: " + data[1]);
                System.out.println("Last Name: " + data[2]);
                System.out.println("Email: " + data[3]);
                System.out.println("Phone: " + data[4]);
                System.out.println("Date of Birth: " + data[5]);

                System.out.println("\n--- TAX REGISTRATION DETAILS ---");
                System.out.println("TIN: " + data[6]);
                System.out.println("Registration Date: " + data[7]);
                System.out.println("Status: " + data[8]);
                System.out.println("District: " + data[9]);
                System.out.println("Sector: " + data[10]);
                System.out.println("Tax Office: " + data[11]);

                System.out.println("\n--- CORPORATE DETAILS ---");
                System.out.println("Company Registration No: " + data[12]);
                System.out.println("Legal Name: " + data[13]);
                System.out.println("Incorporation Date: " + data[14]);
                System.out.println("Business Sector: " + data[15]);
                System.out.println("Authorized Representative: " + data[16]);
                System.out.println("Annual Turnover: " + data[17]);

                System.out.println("\n1. Save Corporate Taxpayer");
                System.out.println("2. Cancel Registration");

                System.out.print("Choose an option: ");
                String choice = sc.nextLine();

                if (choice.equals("2")) {
                    System.out.println("Registration cancelled.");
                    return;
                }

                else if (choice.equals("1")) {

                    if (corporateCount >= corporateTaxpayers.length) {
                        System.out.println("Corporate taxpayer storage is full.");
                        return;
                    }


                    boolean duplicate = false;
                    int duplicateStep = 0;


                    for (int i = 0; i < individualCount; i++) {

                        if (individualTaxpayers[i].getId().equals(data[0])) {
                            System.out.println("Party ID already exists.");
                            duplicate = true;
                            duplicateStep = 1;
                            break;
                        }

                        if (individualTaxpayers[i].getTin().equals(data[6])) {
                            System.out.println("TIN already exists.");
                            duplicate = true;
                            duplicateStep = 2;
                            break;
                        }
                    }

                    for (int i = 0; i < corporateCount && !duplicate; i++) {

                        if (corporateTaxpayers[i].getId().equals(data[0])) {
                            System.out.println("Party ID already exists.");
                            duplicate = true;
                            duplicateStep = 1;
                            break;
                        }

                        if (corporateTaxpayers[i].getTin().equals(data[6])) {
                            System.out.println("TIN already exists.");
                            duplicate = true;
                            duplicateStep = 2;
                            break;
                        }

                        if (corporateTaxpayers[i].getCompanyRegistrationNo().equals(data[12])) {
                            System.out.println("Company Registration No already exists.");
                            duplicate = true;
                            duplicateStep = 3;
                            break;
                        }
                    }

                    if (duplicate) {
                        step = duplicateStep;
                        continue;
                    }

                    try {

                        CorporateTaxpayer corporate = new CorporateTaxpayer(
                                data[0],
                                data[1],
                                data[2],
                                data[3],
                                data[4],
                                LocalDate.parse(data[5]),

                                data[6],
                                LocalDate.parse(data[7]),
                                data[8],
                                data[9],
                                data[10],
                                data[11],

                                data[12],
                                data[13],
                                LocalDate.parse(data[14]),
                                data[15],
                                data[16],
                                new BigDecimal(data[17])
                        );

                        corporate.validate();

                        corporateTaxpayers[corporateCount] = corporate;

                        corporateCount++;

                        System.out.println("\nCorporate Taxpayer registered successfully!");

                    }

                    catch (DateTimeParseException e) {
                        System.out.println("Invalid date. Use YYYY-MM-DD.");
                        step = 1;
                    }

                    catch (NumberFormatException e) {
                        System.out.println("Invalid annual turnover. Enter a valid number.");
                        step = 3;
                    }

                    catch (ValidationException e) {
                        System.out.println("Validation Error: " + e.getMessage());
                        step = 3;
                    }

                    return;
                }

                else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }

        }
    }


    public static void registerRevenueOfficer() {

        String[] data = new String[12];

        int step = 1;

        while (step <= 3) {

            // STEP 1: PERSONAL DETAILS
            if (step == 1) {

                System.out.println("\n=== STEP 1: PERSONAL DETAILS ===");

                System.out.print("Enter Party ID: ");
                data[0] = sc.nextLine();

                System.out.print("Enter First Name: ");
                data[1] = sc.nextLine();

                System.out.print("Enter Last Name: ");
                data[2] = sc.nextLine();

                System.out.print("Enter Email: ");
                data[3] = sc.nextLine();

                System.out.print("Enter Phone Number: ");
                data[4] = sc.nextLine();

                System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
                data[5] = sc.nextLine();

                step = 2;
            }

            // STEP 2: OFFICER DETAILS
            else if (step == 2) {

                System.out.println("\n=== STEP 2: OFFICER DETAILS ===");

                System.out.print("Enter Staff Number: ");
                data[6] = sc.nextLine();

                System.out.print("Enter Department: ");
                data[7] = sc.nextLine();

                System.out.print("Enter Role: ");
                data[8] = sc.nextLine();

                System.out.print("Enter Hire Date (YYYY-MM-DD): ");
                data[9] = sc.nextLine();

                System.out.print("Enter Approval Limit: ");
                data[10] = sc.nextLine();

                System.out.print("Is the officer active? (YES/NO): ");
                data[11] = sc.nextLine();

                if (!data[11].equalsIgnoreCase("YES")
                        && !data[11].equalsIgnoreCase("NO")) {

                    System.out.println("Please enter YES or NO.");
                    continue;
                }

                step = 3;
            }

            else if (step == 3) {

                System.out.println("\n=== REVIEW REVENUE OFFICER ===");

                System.out.println("Party ID: " + data[0]);
                System.out.println("First Name: " + data[1]);
                System.out.println("Last Name: " + data[2]);
                System.out.println("Email: " + data[3]);
                System.out.println("Phone Number: " + data[4]);
                System.out.println("Date of Birth: " + data[5]);

                System.out.println("Staff Number: " + data[6]);
                System.out.println("Department: " + data[7]);
                System.out.println("Role: " + data[8]);
                System.out.println("Hire Date: " + data[9]);
                System.out.println("Approval Limit: " + data[10]);
                System.out.println("Active: " + data[11]);

                System.out.println("\n1. Save Officer");
                System.out.println("2. Cancel Registration");

                System.out.print("Choose an option: ");
                String choice = sc.nextLine();

                if (choice.equals("1")) {

                    if (officerCount >= revenueOfficers.length) {
                        System.out.println("Officer storage is full.");
                        return;
                    }

                    boolean duplicate = false;

                    for (int i = 0; i < officerCount; i++) {

                        if (revenueOfficers[i].getId().equals(data[0])) {
                            System.out.println("Party ID already exists.");
                            duplicate = true;
                            break;
                        }

                        if (revenueOfficers[i].getStaffNumber().equals(data[6])) {
                            System.out.println("Staff Number already exists.");
                            duplicate = true;
                            break;
                        }
                    }

                    if (duplicate) {
                        step = 1;
                        continue;
                    }

                    try {

                        LocalDate dateOfBirth = LocalDate.parse(data[5]);
                        LocalDate hireDate = LocalDate.parse(data[9]);

                        BigDecimal approvalLimit = new BigDecimal(data[10]);

                        boolean active = data[11].equalsIgnoreCase("YES");

                        RevenueOfficer officer = new RevenueOfficer(
                                data[0],
                                data[1],
                                data[2],
                                data[3],
                                data[4],
                                dateOfBirth,
                                data[6],
                                data[7],
                                data[8],
                                hireDate,
                                approvalLimit,
                                active
                        );

                        officer.validate();

                        revenueOfficers[officerCount] = officer;
                        officerCount++;

                        System.out.println("\nRevenue Officer registered successfully!");

                        return;

                    } catch (DateTimeParseException e) {

                        System.out.println("Invalid date. Use YYYY-MM-DD.");
                        step = 1;

                    } catch (NumberFormatException e) {

                        System.out.println("Invalid approval limit. Enter a valid number.");
                        step = 2;

                    } catch (ValidationException e) {

                        System.out.println("Validation Error: " + e.getMessage());
                        step = 1;
                    }

                } else if (choice.equals("2")) {

                    System.out.println("Registration cancelled.");
                    return;

                } else {

                    System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }


    public static void registerTaxType() {

        String[] data = new String[6];

        System.out.println("\n=== REGISTER TAX TYPE ===");

        System.out.print("Enter Tax Type ID: ");
        data[0] = sc.nextLine();

        System.out.print("Enter Tax Code: ");
        data[1] = sc.nextLine();

        System.out.print("Enter Tax Name: ");
        data[2] = sc.nextLine();

        System.out.print("Enter Tax Rate (%): ");
        data[3] = sc.nextLine();

        System.out.print("Enter Filing Frequency (Monthly/Quarterly/Annual): ");
        data[4] = sc.nextLine();

        System.out.print("Is this tax type active? (YES/NO): ");
        data[5] = sc.nextLine();

        if (!data[5].equalsIgnoreCase("YES")
                && !data[5].equalsIgnoreCase("NO")) {
            System.out.println("Please enter YES or NO.");
            return;
        }

        if (taxTypeCount >= taxTypes.length) {
            System.out.println("Tax Type storage is full.");
            return;
        }


        for (int i = 0; i < taxTypeCount; i++) {

            if (taxTypes[i].getTaxTypeId().equalsIgnoreCase(data[0])) {
                System.out.println("Tax Type ID already exists.");
                return;
            }

            if (taxTypes[i].getTaxCode().equalsIgnoreCase(data[1])) {
                System.out.println("Tax Code already exists.");
                return;
            }
        }

        try {

            BigDecimal rate = new BigDecimal(data[3]);

            boolean active = data[5].equalsIgnoreCase("YES");

            TaxType taxType = new TaxType(
                    data[0],
                    data[1],
                    data[2],
                    rate,
                    data[4],
                    active
            );

            taxType.validate();

            taxTypes[taxTypeCount] = taxType;
            taxTypeCount++;

            System.out.println("\nTax Type registered successfully!");

        } catch (NumberFormatException e) {

            System.out.println("Invalid rate. Enter a valid number.");

        } catch (ValidationException e) {

            System.out.println("Validation Error: " + e.getMessage());
        }
    }



    public static void createTaxObligation() {

        System.out.println("\n=== CREATE TAX OBLIGATION ===");


        if (individualCount == 0 && corporateCount == 0) {
            System.out.println("No registered taxpayers found.");
            return;
        }

        if (taxTypeCount == 0) {
            System.out.println("No tax types found. Register a tax type first.");
            return;
        }

        System.out.print("Enter Obligation ID: ");
        String obligationId = sc.nextLine();


        for (int i = 0; i < obligationCount; i++) {

            if (taxObligations[i].getObligationId()
                    .equalsIgnoreCase(obligationId)) {

                System.out.println("Obligation ID already exists.");
                return;
            }
        }


        System.out.println("\n=== SELECT TAXPAYER ===");

        System.out.println("1. Individual Taxpayer");
        System.out.println("2. Corporate Taxpayer");

        System.out.print("Choose taxpayer type: ");
        String taxpayerChoice = sc.nextLine();

        RegisteredTaxpayer taxpayer = null;

        try {

            if (taxpayerChoice.equals("1")) {

                if (individualCount == 0) {
                    System.out.println("No individual taxpayers registered.");
                    return;
                }

                System.out.println("\nIndividual Taxpayers:");

                for (int i = 0; i < individualCount; i++) {
                    System.out.println((i + 1) + ". "
                            + individualTaxpayers[i].getDisplayName());
                }

                System.out.print("Select taxpayer number: ");
                int selected = Integer.parseInt(sc.nextLine());

                if (selected < 1 || selected > individualCount) {
                    System.out.println("Invalid taxpayer selection.");
                    return;
                }

                taxpayer = individualTaxpayers[selected - 1];

            } else if (taxpayerChoice.equals("2")) {

                if (corporateCount == 0) {
                    System.out.println("No corporate taxpayers registered.");
                    return;
                }

                System.out.println("\nCorporate Taxpayers:");

                for (int i = 0; i < corporateCount; i++) {
                    System.out.println((i + 1) + ". "
                            + corporateTaxpayers[i].getDisplayName());
                }

                System.out.print("Select taxpayer number: ");
                int selected = Integer.parseInt(sc.nextLine());

                if (selected < 1 || selected > corporateCount) {
                    System.out.println("Invalid taxpayer selection.");
                    return;
                }

                taxpayer = corporateTaxpayers[selected - 1];

            } else {

                System.out.println("Invalid taxpayer type.");
                return;
            }

            // STEP 2: SELECT TAX TYPE
            System.out.println("\n=== SELECT TAX TYPE ===");

            for (int i = 0; i < taxTypeCount; i++) {

                if (taxTypes[i].isActive()) {
                    System.out.println((i + 1) + ". "
                            + taxTypes[i].getTaxName()
                            + " - " + taxTypes[i].getRate() + "%");
                }
            }

            System.out.print("Select Tax Type number: ");
            int taxSelection = Integer.parseInt(sc.nextLine());

            if (taxSelection < 1 || taxSelection > taxTypeCount) {
                System.out.println("Invalid tax type selection.");
                return;
            }

            TaxType taxType = taxTypes[taxSelection - 1];

            if (!taxType.isActive()) {
                System.out.println("This tax type is inactive.");
                return;
            }

            // STEP 3: ENTER TAX PERIOD
            System.out.println("\n=== ENTER TAX PERIOD ===");

            System.out.print("Enter Period Start (YYYY-MM-DD): ");
            LocalDate periodStart = LocalDate.parse(sc.nextLine());

            System.out.print("Enter Period End (YYYY-MM-DD): ");
            LocalDate periodEnd = LocalDate.parse(sc.nextLine());

            System.out.print("Enter Due Date (YYYY-MM-DD): ");
            LocalDate dueDate = LocalDate.parse(sc.nextLine());

            // STEP 4: REVIEW
            System.out.println("\n=== REVIEW TAX OBLIGATION ===");

            System.out.println("Obligation ID: " + obligationId);
            System.out.println("Taxpayer: " + taxpayer.getDisplayName());
            System.out.println("Tax Type: " + taxType.getTaxName());
            System.out.println("Period Start: " + periodStart);
            System.out.println("Period End: " + periodEnd);
            System.out.println("Due Date: " + dueDate);

            System.out.println("\n1. Save Obligation");
            System.out.println("2. Cancel");

            System.out.print("Choose an option: ");
            String choice = sc.nextLine();

            if (choice.equals("1")) {

                if (obligationCount >= taxObligations.length) {
                    System.out.println("Obligation storage is full.");
                    return;
                }

                TaxObligation obligation = new TaxObligation(
                        obligationId,
                        taxpayer,
                        taxType,
                        periodStart,
                        periodEnd,
                        dueDate
                );

                obligation.validate();

                taxObligations[obligationCount] = obligation;
                obligationCount++;

                System.out.println("\nTax Obligation created successfully!");

            } else if (choice.equals("2")) {

                System.out.println("Operation cancelled.");

            } else {

                System.out.println("Invalid choice. Obligation not saved.");
            }

        } catch (NumberFormatException e) {

            System.out.println("Please enter a valid number.");

        } catch (DateTimeParseException e) {

            System.out.println("Invalid date. Use YYYY-MM-DD.");

        } catch (ValidationException e) {

            System.out.println("Validation Error: " + e.getMessage());
        }
    }



    public static void fileTaxDeclaration() {

        if (declarationCount >= taxDeclarations.length) {
            System.out.println("Declaration storage is full.");
            return;
        }

        if (obligationCount == 0) {
            System.out.println("No tax obligations available.");
            return;
        }

        System.out.println("\n=== FILE TAX DECLARATION ===");

        // STEP 1: DISPLAY TAX OBLIGATIONS
        System.out.println("\nAvailable Tax Obligations:");

        for (int i = 0; i < obligationCount; i++) {

            System.out.println((i + 1) + ". "
                    + taxObligations[i].getTaxpayer().getDisplayName()
                    + " | "
                    + taxObligations[i].getTaxType().getTaxName());
        }

        System.out.print("\nSelect obligation number: ");

        TaxObligation selectedObligation;

        try {

            int choice = Integer.parseInt(sc.nextLine());

            if (choice < 1 || choice > obligationCount) {
                System.out.println("Invalid obligation selection.");
                return;
            }

            selectedObligation = taxObligations[choice - 1];

        } catch (NumberFormatException e) {

            System.out.println("Please enter a valid number.");
            return;
        }

        // STEP 2: ENTER DECLARATION DETAILS
        System.out.println("\n=== DECLARATION DETAILS ===");

        System.out.print("Enter Declaration ID: ");
        String declarationId = sc.nextLine();


        for (int i = 0; i < declarationCount; i++) {

            if (taxDeclarations[i].getDeclarationId()
                    .equalsIgnoreCase(declarationId)) {

                System.out.println("Declaration ID already exists.");
                return;
            }
        }

        System.out.print("Enter Taxable Amount: ");
        String taxableInput = sc.nextLine();

        System.out.print("Enter Declared Tax: ");
        String taxInput = sc.nextLine();

        try {

            LocalDate fillingDate = LocalDate.now();

            BigDecimal taxableAmount = new BigDecimal(taxableInput);
            BigDecimal declaredTax = new BigDecimal(taxInput);

            TaxDeclaration declaration = new TaxDeclaration(
                    declarationId,
                    selectedObligation,
                    fillingDate,
                    taxableAmount,
                    declaredTax,
                    "SUBMITTED"
            );

            declaration.validate();


            taxDeclarations[declarationCount] = declaration;
            declarationCount++;

            System.out.println("\nTax Declaration filed successfully!");

        } catch (NumberFormatException e) {

            System.out.println("Invalid amount. Enter a valid number.");

        } catch (ValidationException e) {

            System.out.println("Validation Error: " + e.getMessage());
        }
    }



    public static void assessDeclaration() {

        if (declarationCount == 0) {
            System.out.println("No tax declarations available.");
            return;
        }

        if (assessmentCount >= taxAssessments.length) {
            System.out.println("Assessment storage is full.");
            return;
        }

        System.out.println("\n=== ASSESS TAX DECLARATION ===");

        // STEP 1: DISPLAY DECLARATIONS
        System.out.println("\nAvailable Declarations:");

        for (int i = 0; i < declarationCount; i++) {

            System.out.println((i + 1) + ". "
                    + taxDeclarations[i].getDeclarationId()
                    + " | Status: "
                    + taxDeclarations[i].getStatus());
        }

        // STEP 2: SELECT DECLARATION
        System.out.print("\nSelect declaration number: ");

        TaxDeclaration selectedDeclaration;

        try {

            int choice = Integer.parseInt(sc.nextLine());

            if (choice < 1 || choice > declarationCount) {
                System.out.println("Invalid declaration selection.");
                return;
            }

            selectedDeclaration = taxDeclarations[choice - 1];

        } catch (NumberFormatException e) {

            System.out.println("Please enter a valid number.");
            return;
        }

        // STEP 3: CHECK IF ALREADY ASSESSED
        for (int i = 0; i < assessmentCount; i++) {

            if (taxAssessments[i].getDeclaration()
                    .getDeclarationId()
                    .equalsIgnoreCase(selectedDeclaration.getDeclarationId())) {

                System.out.println("This declaration has already been assessed.");
                return;
            }
        }

        // STEP 4: ENTER ASSESSMENT DETAILS
        System.out.print("Enter Assessment ID: ");
        String assessmentId = sc.nextLine();

        for (int i = 0; i < assessmentCount; i++) {

            if (taxAssessments[i].getAssessmentId()
                    .equalsIgnoreCase(assessmentId)) {

                System.out.println("Assessment ID already exists.");
                return;
            }
        }

        System.out.print("Enter Assessed Tax: ");
        String assessedInput = sc.nextLine();

        System.out.print("Enter Adjustment Amount: ");
        String adjustmentInput = sc.nextLine();

        try {

            BigDecimal assessedTax = new BigDecimal(assessedInput);
            BigDecimal adjustmentAmount = new BigDecimal(adjustmentInput);

            LocalDate assessmentDate = LocalDate.now();

            TaxAssessment assessment = new TaxAssessment(
                    assessmentId,
                    selectedDeclaration,
                    assessedTax,
                    adjustmentAmount,
                    assessmentDate,
                    "Draft"
            );


            assessment.validate();

            taxAssessments[assessmentCount] = assessment;
            assessmentCount++;

            System.out.println("\nAssessment created successfully!");
            System.out.println("Assessment ID: " + assessment.getAssessmentId());
            System.out.println("Assessed Tax: " + assessment.getAssessedTax());
            System.out.println("Adjustment: " + assessment.getAdjustmentAmount());
            System.out.println("Total Amount: " + assessment.getTotal());
            System.out.println("Status: " + assessment.getStatus());

        } catch (NumberFormatException e) {

            System.out.println("Invalid amount. Enter a valid number.");

        } catch (ValidationException e) {

            System.out.println("Validation Error: " + e.getMessage());
        }
    }



    public static void confirmAssessment() {

        if (assessmentCount == 0) {
            System.out.println("No assessments available.");
            return;
        }

        System.out.println("\n=== CONFIRM TAX ASSESSMENT ===");

        // Display assessments
        for (int i = 0; i < assessmentCount; i++) {

            System.out.println((i + 1) + ". "
                    + taxAssessments[i].getAssessmentId()
                    + " | Total: " + taxAssessments[i].getTotal()
                    + " | Status: " + taxAssessments[i].getStatus());
        }

        // Select assessment
        System.out.print("\nSelect assessment number: ");

        try {

            int choice = Integer.parseInt(sc.nextLine());

            if (choice < 1 || choice > assessmentCount) {
                System.out.println("Invalid selection.");
                return;
            }

            TaxAssessment selectedAssessment = taxAssessments[choice - 1];

            // Check current status
            if (!selectedAssessment.getStatus().equalsIgnoreCase("Draft")) {
                System.out.println("Only Draft assessments can be confirmed.");
                return;
            }

            // Confirm assessment
            selectedAssessment.setStatus("Confirmed");

            System.out.println("\nAssessment confirmed successfully!");
            System.out.println("Assessment ID: "
                    + selectedAssessment.getAssessmentId());
            System.out.println("New Status: "
                    + selectedAssessment.getStatus());

        } catch (NumberFormatException e) {

            System.out.println("Please enter a valid number.");
        }
    }


    public static void viewAllRecords() {

        System.out.println("\n========== ALL SYSTEM RECORDS ==========");


        System.out.println("\n--- Individual Taxpayers ---");
        if (individualCount == 0) {
            System.out.println("No individual taxpayers found.");
        } else {
            for (int i = 0; i < individualCount; i++) {
                individualTaxpayers[i].printDetails();
                System.out.println("------------------------");
            }
        }


        System.out.println("\n--- Corporate Taxpayers ---");
        if (corporateCount == 0) {
            System.out.println("No corporate taxpayers found.");
        } else {
            for (int i = 0; i < corporateCount; i++) {
                corporateTaxpayers[i].printDetails();
                System.out.println("------------------------");
            }
        }

        System.out.println("\n--- Revenue Officers ---");
        if (officerCount == 0) {
            System.out.println("No revenue officers found.");
        } else {
            for (int i = 0; i < officerCount; i++) {
                revenueOfficers[i].printDetails();
                System.out.println("------------------------");
            }
        }

        System.out.println("\n--- Tax Types ---");
        if (taxTypeCount == 0) {
            System.out.println("No tax types found.");
        } else {
            for (int i = 0; i < taxTypeCount; i++) {
                taxTypes[i].printDetails();
                System.out.println("------------------------");
            }
        }

        System.out.println("\n--- Tax Obligations ---");
        if (obligationCount == 0) {
            System.out.println("No tax obligations found.");
        } else {
            for (int i = 0; i < obligationCount; i++) {
                taxObligations[i].printDetails();
                System.out.println("------------------------");
            }
        }


        System.out.println("\n--- Tax Declarations ---");
        if (declarationCount == 0) {
            System.out.println("No tax declarations found.");
        } else {
            for (int i = 0; i < declarationCount; i++) {
                taxDeclarations[i].printDetails();
                System.out.println("------------------------");
            }
        }

        // Tax Assessments
        System.out.println("\n--- Tax Assessments ---");
        if (assessmentCount == 0) {
            System.out.println("No tax assessments found.");
        } else {
            for (int i = 0; i < assessmentCount; i++) {
                taxAssessments[i].printDetails();
                System.out.println("------------------------");
            }
        }

        System.out.println("\n========== END OF RECORDS ==========");
    }

    public static void viewDeclarationHistory() {

        System.out.println("\n========== DECLARATION HISTORY ==========");

        if (declarationCount == 0) {
            System.out.println("No declaration history found.");
            return;
        }

        for (int i = 0; i < declarationCount; i++) {

            System.out.println("\nDeclaration Number: " + (i + 1));

            taxDeclarations[i].printDetails();

            System.out.println("--------------------------------");
        }

        System.out.println("Total Declarations: " + declarationCount);
        System.out.println("========== END OF HISTORY ==========");
    }

    public static void viewAssessmentHistory() {

        if (assessmentCount == 0) {
            System.out.println("No assessment records found.");
            return;
        }

        System.out.println("\n===== VIEW ASSESSMENT HISTORY =====");

        System.out.println("1. Individual Taxpayer");
        System.out.println("2. Corporate Taxpayer");

        System.out.print("Choose taxpayer type: ");
        int type = sc.nextInt();

        RegisteredTaxpayer selectedTaxpayer = null;

        if (type == 1) {

            if (individualCount == 0) {
                System.out.println("No individual taxpayers found.");
                return;
            }

            for (int i = 0; i < individualCount; i++) {
                System.out.println((i + 1) + ". "
                        + individualTaxpayers[i].getDisplayName());
            }

            System.out.print("Select taxpayer: ");
            int choice = sc.nextInt();

            if (choice < 1 || choice > individualCount) {
                System.out.println("Invalid selection.");
                return;
            }

            selectedTaxpayer = individualTaxpayers[choice - 1];

        } else if (type == 2) {

            if (corporateCount == 0) {
                System.out.println("No corporate taxpayers found.");
                return;
            }

            for (int i = 0; i < corporateCount; i++) {
                System.out.println((i + 1) + ". "
                        + corporateTaxpayers[i].getDisplayName());
            }

            System.out.print("Select taxpayer: ");
            int choice = sc.nextInt();

            if (choice < 1 || choice > corporateCount) {
                System.out.println("Invalid selection.");
                return;
            }

            selectedTaxpayer = corporateTaxpayers[choice - 1];

        } else {
            System.out.println("Invalid taxpayer type.");
            return;
        }

        boolean found = false;

        System.out.println("\n===== ASSESSMENT HISTORY =====");
        System.out.println("Taxpayer: " + selectedTaxpayer.getDisplayName());

        for (int i = 0; i < assessmentCount; i++) {

            TaxAssessment assessment = taxAssessments[i];

            RegisteredTaxpayer taxpayer =
                    assessment.getDeclaration()
                            .getObligation()
                            .getTaxpayer();

            if (taxpayer.getId().equals(selectedTaxpayer.getId())) {

                assessment.printDetails();
                System.out.println("------------------------");

                found = true;
            }
        }

        if (!found) {
            System.out.println("No assessments found for this taxpayer.");
        }

        System.out.println("===== END OF ASSESSMENT HISTORY =====");
    }

    public static void recordTaxPayment() {

        if (assessmentCount == 0) {
            System.out.println("No assessments found.");
            return;
        }

        if (paymentCount == taxPayments.length) {
            System.out.println("Payment storage is full.");
            return;
        }

        System.out.println("\n===== RECORD TAX PAYMENT =====");

        boolean found = false;

        for (int i = 0; i < assessmentCount; i++) {
            if ("Confirmed".equalsIgnoreCase(taxAssessments[i].getStatus())) {
                System.out.println((i + 1) + ". Assessment ID: "
                        + taxAssessments[i].getAssessmentId()
                        + " | Total: " + taxAssessments[i].getTotal());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No confirmed assessments available.");
            return;
        }

        System.out.print("Select assessment number: ");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice < 1 || choice > assessmentCount) {
            System.out.println("Invalid selection.");
            return;
        }

        TaxAssessment selectedAssessment = taxAssessments[choice - 1];

        if (!"Confirmed".equalsIgnoreCase(selectedAssessment.getStatus())) {
            System.out.println("This assessment is not confirmed.");
            return;
        }

        System.out.print("Enter Payment ID: ");
        String paymentId = sc.nextLine();

        System.out.print("Enter Payment Reference: ");
        String reference = sc.nextLine();

        // Check duplicate payment reference
        for (int i = 0; i < paymentCount; i++) {
            if (taxPayments[i].getPaymentReference().equalsIgnoreCase(reference)) {
                System.out.println("Payment reference already exists.");
                return;
            }
        }

        System.out.print("Enter Payment Amount: ");
        BigDecimal amount = new BigDecimal(sc.nextLine());

        System.out.print("Enter Payment Method: ");
        String method = sc.nextLine();

        LocalDate paymentDate = LocalDate.now();

        try {

            TaxPayment payment = new TaxPayment(
                    paymentId,
                    selectedAssessment,
                    reference,
                    amount,
                    paymentDate,
                    method
            );

            payment.validate();

            taxPayments[paymentCount] = payment;
            paymentCount++;

            System.out.println("Payment recorded successfully!");
            payment.printDetails();

        } catch (ValidationException e) {
            System.out.println("Payment error: " + e.getMessage());
        }
    }

    public static void calculateAndRecordPenalty() {

        if (obligationCount == 0) {
            System.out.println("No tax obligations found.");
            return;
        }

        if (penaltyCount == penalties.length) {
            System.out.println("Penalty storage is full.");
            return;
        }

        System.out.println("\n===== CALCULATE / RECORD PENALTY =====");

        for (int i = 0; i < obligationCount; i++) {
            System.out.println((i + 1) + ". Obligation ID: "
                    + taxObligations[i].getId()
                    + " | Due Date: " + taxObligations[i].getDueDate());
        }

        System.out.print("Select obligation number: ");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice < 1 || choice > obligationCount) {
            System.out.println("Invalid selection.");
            return;
        }

        TaxObligation selectedObligation = taxObligations[choice - 1];

        // Check whether the obligation is overdue
        if (!LocalDate.now().isAfter(selectedObligation.getDueDate())) {
            System.out.println("This obligation is not overdue.");
            return;
        }

        System.out.print("Enter Penalty ID: ");
        String penaltyId = sc.nextLine();

        System.out.print("Enter Penalty Type: ");
        String penaltyType = sc.nextLine();

        // Check duplicate penalty for the same obligation and type
        for (int i = 0; i < penaltyCount; i++) {

            if (penalties[i].getObligation().getId()
                    .equals(selectedObligation.getId())
                    && penalties[i].getPenaltyType().equalsIgnoreCase(penaltyType)) {

                System.out.println("A penalty of this type already exists for this obligation.");
                return;
            }
        }

        System.out.print("Enter Base Amount: ");
        BigDecimal baseAmount = new BigDecimal(sc.nextLine());

        BigDecimal penaltyRate = new BigDecimal("5.00");

        try {

            Penalty penalty = new Penalty(
                    penaltyId,
                    selectedObligation,
                    penaltyType,
                    baseAmount,
                    penaltyRate,
                    BigDecimal.ZERO
            );

            penalty.validate();

            penalties[penaltyCount] = penalty;
            penaltyCount++;

            System.out.println("Penalty recorded successfully!");
            System.out.println("Penalty Rate: " + penaltyRate + "%");
            System.out.println("Calculated Penalty: " + penalty.getPenaltyAmount());

            penalty.printDetails();

        } catch (ValidationException e) {
            System.out.println("Penalty error: " + e.getMessage());
        }
    }

    public static void requestAndApproveRefund() {

        if (refundCount == taxRefunds.length) {
            System.out.println("Refund storage is full.");
            return;
        }

        if (assessmentCount == 0) {
            System.out.println("No assessments found.");
            return;
        }

        System.out.println("\n===== REQUEST / APPROVE REFUND =====");

        // Display confirmed assessments
        boolean found = false;

        for (int i = 0; i < assessmentCount; i++) {

            if ("Confirmed".equalsIgnoreCase(taxAssessments[i].getStatus())) {

                System.out.println((i + 1) + ". Assessment ID: "
                        + taxAssessments[i].getAssessmentId()
                        + " | Total: " + taxAssessments[i].getTotal());

                found = true;
            }
        }

        if (!found) {
            System.out.println("No confirmed assessments available.");
            return;
        }

        System.out.print("Select assessment number: ");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice < 1 || choice > assessmentCount) {
            System.out.println("Invalid selection.");
            return;
        }

        TaxAssessment selectedAssessment = taxAssessments[choice - 1];

        if (!"Confirmed".equalsIgnoreCase(selectedAssessment.getStatus())) {
            System.out.println("Selected assessment is not confirmed.");
            return;
        }

        RegisteredTaxpayer taxpayer = selectedAssessment.getDeclaration()
                .getObligation().getTaxpayer();

        System.out.print("Enter Refund ID: ");
        String refundId = sc.nextLine();

        // Check duplicate refund ID
        for (int i = 0; i < refundCount; i++) {
            if (taxRefunds[i].getRefundId().equalsIgnoreCase(refundId)) {
                System.out.println("Refund ID already exists.");
                return;
            }
        }

        System.out.print("Enter Requested Refund Amount: ");
        BigDecimal amount = new BigDecimal(sc.nextLine());

        try {

            TaxRefund refund = new TaxRefund(
                    refundId,
                    taxpayer,
                    selectedAssessment,
                    amount,
                    LocalDate.now(),
                    "Pending"
            );

            refund.validate();

            // Display active revenue officers
            if (officerCount == 0) {
                System.out.println("No revenue officers registered.");
                return;
            }

            System.out.println("\nAvailable Revenue Officers:");

            for (int i = 0; i < officerCount; i++) {
                if (revenueOfficers[i].isActive()) {
                    System.out.println((i + 1) + ". "
                            + revenueOfficers[i].getDisplayName()
                            + " | Approval Limit: "
                            + revenueOfficers[i].getApprovalLimit());
                }
            }

            System.out.print("Select officer number: ");
            int officerChoice = sc.nextInt();
            sc.nextLine();

            if (officerChoice < 1 || officerChoice > officerCount) {
                System.out.println("Invalid officer selection.");
                return;
            }

            RevenueOfficer officer = revenueOfficers[officerChoice - 1];

            if (!officer.isActive()) {
                System.out.println("This officer is not active.");
                return;
            }

            if (amount.compareTo(officer.getApprovalLimit()) > 0) {
                System.out.println("Officer does not have enough approval authority.");
                return;
            }

            // Save the refund request
            taxRefunds[refundCount] = refund;
            refundCount++;

            System.out.println("Refund request submitted successfully.");
            System.out.println("It is currently awaiting approval.");

        } catch (ValidationException e) {
            System.out.println("Refund error: " + e.getMessage());
        }
    }

    public static void requestTaxClearance() {

        if (clearanceCount == taxClearances.length) {
            System.out.println("Clearance storage is full.");
            return;
        }

        System.out.println("\n===== REQUEST / ISSUE TAX CLEARANCE =====");

        System.out.println("1. Individual Taxpayer");
        System.out.println("2. Corporate Taxpayer");

        System.out.print("Select taxpayer type: ");
        int type = sc.nextInt();
        sc.nextLine();

        RegisteredTaxpayer taxpayer = null;

        if (type == 1) {

            if (individualCount == 0) {
                System.out.println("No individual taxpayers found.");
                return;
            }

            for (int i = 0; i < individualCount; i++) {
                System.out.println((i + 1) + ". "
                        + individualTaxpayers[i].getDisplayName());
            }

            System.out.print("Select taxpayer: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice < 1 || choice > individualCount) {
                System.out.println("Invalid selection.");
                return;
            }

            taxpayer = individualTaxpayers[choice - 1];

        } else if (type == 2) {

            if (corporateCount == 0) {
                System.out.println("No corporate taxpayers found.");
                return;
            }

            for (int i = 0; i < corporateCount; i++) {
                System.out.println((i + 1) + ". "
                        + corporateTaxpayers[i].getDisplayName());
            }

            System.out.print("Select taxpayer: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice < 1 || choice > corporateCount) {
                System.out.println("Invalid selection.");
                return;
            }

            taxpayer = corporateTaxpayers[choice - 1];

        } else {
            System.out.println("Invalid taxpayer type.");
            return;
        }

        System.out.print("Enter Clearance ID: ");
        String clearanceId = sc.nextLine();

        // Check duplicate clearance ID
        for (int i = 0; i < clearanceCount; i++) {
            if (taxClearances[i].getClearanceId()
                    .equalsIgnoreCase(clearanceId)) {
                System.out.println("Clearance ID already exists.");
                return;
            }
        }

        System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
        LocalDate expiryDate;

        try {
            expiryDate = LocalDate.parse(sc.nextLine());
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format.");
            return;
        }

        LocalDate requestDate = LocalDate.now();

        try {

            TaxClearance clearance = new TaxClearance(
                    clearanceId,
                    taxpayer,
                    requestDate,
                    expiryDate,
                    "Pending",
                    null
            );

            clearance.validate();

            // Display active revenue officers
            if (officerCount == 0) {
                System.out.println("No revenue officers registered.");
                return;
            }

            System.out.println("\nAvailable Revenue Officers:");

            boolean officerFound = false;

            for (int i = 0; i < officerCount; i++) {
                if (revenueOfficers[i].isActive()) {
                    System.out.println((i + 1) + ". "
                            + revenueOfficers[i].getDisplayName());
                    officerFound = true;
                }
            }

            if (!officerFound) {
                System.out.println("No active officers available.");
                return;
            }

            System.out.print("Select approving officer: ");
            int officerChoice = sc.nextInt();
            sc.nextLine();

            if (officerChoice < 1 || officerChoice > officerCount) {
                System.out.println("Invalid officer selection.");
                return;
            }

            RevenueOfficer officer = revenueOfficers[officerChoice - 1];

            if (!officer.isActive()) {
                System.out.println("Selected officer is not active.");
                return;
            }

            clearance.setApprovedBy(officer);
            clearance.setStatus("Approved");

            clearance.validate();

            taxClearances[clearanceCount] = clearance;
            clearanceCount++;

            System.out.println("Tax clearance issued successfully!");
            clearance.printDetails();

        } catch (ValidationException e) {
            System.out.println("Clearance error: " + e.getMessage());
        }
    }

    public static void searchRecord() {

        System.out.println("\n===== SEARCH RECORD =====");

        System.out.print("Enter Record ID or Taxpayer TIN: ");
        String search = sc.nextLine().trim();

        boolean found = false;

        // Search Individual Taxpayers
        for (int i = 0; i < individualCount; i++) {
            if (individualTaxpayers[i].getId().equalsIgnoreCase(search)
                    || individualTaxpayers[i].getTin().equalsIgnoreCase(search)) {

                individualTaxpayers[i].printDetails();
                found = true;
            }
        }

        // Search Corporate Taxpayers
        for (int i = 0; i < corporateCount; i++) {
            if (corporateTaxpayers[i].getId().equalsIgnoreCase(search)
                    || corporateTaxpayers[i].getTin().equalsIgnoreCase(search)) {

                corporateTaxpayers[i].printDetails();
                found = true;
            }
        }

        // Search Revenue Officers
        for (int i = 0; i < officerCount; i++) {
            if (revenueOfficers[i].getId().equalsIgnoreCase(search)) {

                revenueOfficers[i].printDetails();
                found = true;
            }
        }

        // Search Tax Types
        for (int i = 0; i < taxTypeCount; i++) {
            if (taxTypes[i].getId().equalsIgnoreCase(search)) {

                taxTypes[i].printDetails();
                found = true;
            }
        }

        // Search Tax Obligations
        for (int i = 0; i < obligationCount; i++) {
            if (taxObligations[i].getId().equalsIgnoreCase(search)) {

                taxObligations[i].printDetails();
                found = true;
            }
        }

        // Search Tax Declarations
        for (int i = 0; i < declarationCount; i++) {
            if (taxDeclarations[i].getId().equalsIgnoreCase(search)) {

                taxDeclarations[i].printDetails();
                found = true;
            }
        }

        // Search Tax Assessments
        for (int i = 0; i < assessmentCount; i++) {
            if (taxAssessments[i].getId().equalsIgnoreCase(search)) {

                taxAssessments[i].printDetails();
                found = true;
            }
        }

        // Search Tax Payments
        for (int i = 0; i < paymentCount; i++) {
            if (taxPayments[i].getId().equalsIgnoreCase(search)) {

                taxPayments[i].printDetails();
                found = true;
            }
        }

        // Search Penalties
        for (int i = 0; i < penaltyCount; i++) {
            if (penalties[i].getId().equalsIgnoreCase(search)) {

                penalties[i].printDetails();
                found = true;
            }
        }

        // Search Refunds
        for (int i = 0; i < refundCount; i++) {
            if (taxRefunds[i].getId().equalsIgnoreCase(search)) {

                taxRefunds[i].printDetails();
                found = true;
            }
        }

        // Search Tax Clearances
        for (int i = 0; i < clearanceCount; i++) {
            if (taxClearances[i].getId().equalsIgnoreCase(search)) {

                taxClearances[i].printDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No record found with that ID or TIN.");
        }
    }

    static void updateEligibleRecord() {

        System.out.println("\n===== UPDATE TAXPAYER RECORD =====");

        System.out.println("1. Individual Taxpayer");
        System.out.println("2. Corporate Taxpayer");

        System.out.print("Choose taxpayer type: ");
        int type = Integer.parseInt(sc.nextLine());

        RegisteredTaxpayer taxpayer = null;

        if (type == 1) {

            if (individualCount == 0) {
                System.out.println("No individual taxpayers registered.");
                return;
            }

            System.out.println("\nIndividual Taxpayers:");

            for (int i = 0; i < individualCount; i++) {
                System.out.println((i + 1) + ". "
                        + individualTaxpayers[i].getDisplayName()
                        + " | TIN: " + individualTaxpayers[i].getTin());
            }

            System.out.print("Enter taxpayer number: ");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice < 1 || choice > individualCount) {
                System.out.println("Invalid taxpayer number.");
                return;
            }

            taxpayer = individualTaxpayers[choice - 1];

        } else if (type == 2) {

            if (corporateCount == 0) {
                System.out.println("No corporate taxpayers registered.");
                return;
            }

            System.out.println("\nCorporate Taxpayers:");

            for (int i = 0; i < corporateCount; i++) {
                System.out.println((i + 1) + ". "
                        + corporateTaxpayers[i].getDisplayName()
                        + " | TIN: " + corporateTaxpayers[i].getTin());
            }

            System.out.print("Enter taxpayer number: ");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice < 1 || choice > corporateCount) {
                System.out.println("Invalid taxpayer number.");
                return;
            }

            taxpayer = corporateTaxpayers[choice - 1];

        } else {
            System.out.println("Invalid taxpayer type.");
            return;
        }

        System.out.println("\nSelected Taxpayer:");
        taxpayer.printDetails();

        System.out.println("\nWhat do you want to update?");
        System.out.println("1. Taxpayer Status");
        System.out.println("2. District");
        System.out.println("3. Sector");
        System.out.println("4. Tax Office");

        System.out.print("Choose field: ");
        int field = Integer.parseInt(sc.nextLine());

        switch (field) {

            case 1:
                System.out.println("1. Active");
                System.out.println("2. Inactive");

                System.out.print("Choose new status: ");
                int statusChoice = Integer.parseInt(sc.nextLine());

                if (statusChoice == 1) {
                    taxpayer.setTaxpayerStatus("Active");
                } else if (statusChoice == 2) {
                    taxpayer.setTaxpayerStatus("Inactive");
                } else {
                    System.out.println("Invalid status.");
                    return;
                }

                break;

            case 2:
                System.out.print("Enter new district: ");
                String district = sc.nextLine().trim();

                if (district.isEmpty()) {
                    System.out.println("District cannot be empty.");
                    return;
                }

                taxpayer.setDistrict(district);
                break;

            case 3:
                System.out.print("Enter new sector: ");
                String sector = sc.nextLine().trim();

                if (sector.isEmpty()) {
                    System.out.println("Sector cannot be empty.");
                    return;
                }

                taxpayer.setSector(sector);
                break;

            case 4:
                System.out.print("Enter new tax office: ");
                String taxOffice = sc.nextLine().trim();

                if (taxOffice.isEmpty()) {
                    System.out.println("Tax office cannot be empty.");
                    return;
                }

                taxpayer.setTaxOffice(taxOffice);
                break;

            default:
                System.out.println("Invalid field choice.");
                return;
        }

        System.out.println("\nTaxpayer record updated successfully!");

        System.out.println("\nUpdated Record:");
        taxpayer.printDetails();
    }

    static void viewTaxpayerStatement() {

        System.out.println("\n===== TAXPAYER STATEMENT =====");

        System.out.println("1. Individual Taxpayer");
        System.out.println("2. Corporate Taxpayer");

        System.out.print("Choose taxpayer type: ");
        int type = Integer.parseInt(sc.nextLine());

        RegisteredTaxpayer taxpayer = null;

        if (type == 1) {

            if (individualCount == 0) {
                System.out.println("No individual taxpayers found.");
                return;
            }

            for (int i = 0; i < individualCount; i++) {
                System.out.println((i + 1) + ". "
                        + individualTaxpayers[i].getDisplayName()
                        + " | TIN: " + individualTaxpayers[i].getTin());
            }

            System.out.print("Select taxpayer: ");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice < 1 || choice > individualCount) {
                System.out.println("Invalid selection.");
                return;
            }

            taxpayer = individualTaxpayers[choice - 1];

        } else if (type == 2) {

            if (corporateCount == 0) {
                System.out.println("No corporate taxpayers found.");
                return;
            }

            for (int i = 0; i < corporateCount; i++) {
                System.out.println((i + 1) + ". "
                        + corporateTaxpayers[i].getDisplayName()
                        + " | TIN: " + corporateTaxpayers[i].getTin());
            }

            System.out.print("Select taxpayer: ");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice < 1 || choice > corporateCount) {
                System.out.println("Invalid selection.");
                return;
            }

            taxpayer = corporateTaxpayers[choice - 1];

        } else {
            System.out.println("Invalid taxpayer type.");
            return;
        }

        BigDecimal totalAssessment = BigDecimal.ZERO;
        BigDecimal totalPayments = BigDecimal.ZERO;
        BigDecimal totalPenalties = BigDecimal.ZERO;

        System.out.println("\n======================================");
        System.out.println("          TAXPAYER STATEMENT");
        System.out.println("======================================");

        System.out.println("Name: " + taxpayer.getDisplayName());
        System.out.println("TIN: " + taxpayer.getTin());
        System.out.println("Status: " + taxpayer.getTaxpayerStatus());
        System.out.println("District: " + taxpayer.getDistrict());

        // Display tax obligations
        System.out.println("\n----- TAX OBLIGATIONS -----");

        boolean hasObligation = false;

        for (int i = 0; i < obligationCount; i++) {

            if (taxObligations[i].getTaxpayer().getId()
                    .equalsIgnoreCase(taxpayer.getId())) {

                hasObligation = true;
                taxObligations[i].printDetails();
            }
        }

        if (!hasObligation) {
            System.out.println("No tax obligations found.");
        }

        // Display assessments
        System.out.println("\n----- CONFIRMED ASSESSMENTS -----");

        boolean hasAssessment = false;

        for (int i = 0; i < assessmentCount; i++) {

            TaxAssessment assessment = taxAssessments[i];

            if (assessment.getStatus().equalsIgnoreCase("Confirmed")
                    && assessment.getDeclaration().getObligation()
                    .getTaxpayer().getId().equalsIgnoreCase(taxpayer.getId())) {

                hasAssessment = true;

                assessment.printDetails();

                totalAssessment = totalAssessment.add(assessment.getTotal());
            }
        }

        if (!hasAssessment) {
            System.out.println("No confirmed assessments found.");
        }

        // Display payments
        System.out.println("\n----- TAX PAYMENTS -----");

        boolean hasPayment = false;

        for (int i = 0; i < paymentCount; i++) {

            TaxPayment payment = taxPayments[i];

            TaxAssessment assessment = payment.getAssessment();

            if (assessment.getStatus().equalsIgnoreCase("Confirmed")
                    && assessment.getDeclaration().getObligation()
                    .getTaxpayer().getId().equalsIgnoreCase(taxpayer.getId())) {

                hasPayment = true;

                payment.printDetails();

                totalPayments = totalPayments.add(payment.getAmount());
            }
        }

        if (!hasPayment) {
            System.out.println("No payments found.");
        }

        // Display penalties
        System.out.println("\n----- TAX PENALTIES -----");

        boolean hasPenalty = false;

        for (int i = 0; i < penaltyCount; i++) {

            Penalty penalty = penalties[i];

            if (penalty.getObligation().getTaxpayer().getId()
                    .equalsIgnoreCase(taxpayer.getId())) {

                hasPenalty = true;

                penalty.printDetails();

                totalPenalties = totalPenalties.add(penalty.getPenaltyAmount());
            }
        }

        if (!hasPenalty) {
            System.out.println("No penalties found.");
        }

        // Calculate outstanding balance
        BigDecimal outstandingBalance = totalAssessment
                .add(totalPenalties)
                .subtract(totalPayments);

        if (outstandingBalance.compareTo(BigDecimal.ZERO) < 0) {
            outstandingBalance = BigDecimal.ZERO;
        }

        // Display financial summary
        System.out.println("\n======================================");
        System.out.println("          FINANCIAL SUMMARY");
        System.out.println("======================================");

        System.out.println("Total Assessments: " + totalAssessment);
        System.out.println("Total Penalties: " + totalPenalties);
        System.out.println("Total Payments: " + totalPayments);

        System.out.println("--------------------------------------");
        System.out.println("Outstanding Balance: " + outstandingBalance);
        System.out.println("======================================");
    }


    public static void viewOutstandingBalances() {

        System.out.println("\n===== OUTSTANDING BALANCES =====");

        // Individual taxpayers
        System.out.println("\n--- Individual Taxpayers ---");

        if (individualCount == 0) {
            System.out.println("No individual taxpayers registered.");
        }

        for (int i = 0; i < individualCount; i++) {

            RegisteredTaxpayer taxpayer = individualTaxpayers[i];

            BigDecimal balance = calculateOutstandingBalance(taxpayer);

            System.out.println("\nTaxpayer ID: " + taxpayer.getId());
            System.out.println("TIN: " + taxpayer.getTin());
            System.out.println("Outstanding Balance: " + balance);
        }

        // Corporate taxpayers
        System.out.println("\n--- Corporate Taxpayers ---");

        if (corporateCount == 0) {
            System.out.println("No corporate taxpayers registered.");
        }

        for (int i = 0; i < corporateCount; i++) {

            RegisteredTaxpayer taxpayer = corporateTaxpayers[i];

            BigDecimal balance = calculateOutstandingBalance(taxpayer);

            System.out.println("\nTaxpayer ID: " + taxpayer.getId());
            System.out.println("TIN: " + taxpayer.getTin());
            System.out.println("Outstanding Balance: " + balance);
        }
    }



    public static BigDecimal calculateOutstandingBalance(
            RegisteredTaxpayer taxpayer) {

        BigDecimal totalAssessments = BigDecimal.ZERO;
        BigDecimal totalPayments = BigDecimal.ZERO;
        BigDecimal totalPenalties = BigDecimal.ZERO;


        for (int i = 0; i < assessmentCount; i++) {

            TaxAssessment assessment = taxAssessments[i];

            if (assessment.getStatus().equalsIgnoreCase("Confirmed")
                    && assessment.getDeclaration()
                    .getObligation().getTaxpayer().getId()
                    .equalsIgnoreCase(taxpayer.getId())) {

                totalAssessments = totalAssessments.add(
                        assessment.getTotal()
                );
            }
        }

        // Calculate payments made by the taxpayer
        for (int i = 0; i < paymentCount; i++) {

            TaxPayment payment = taxPayments[i];

            if (payment.getAssessment().getStatus()
                    .equalsIgnoreCase("Confirmed")
                    && payment.getAssessment().getDeclaration()
                    .getObligation().getTaxpayer().getId()
                    .equalsIgnoreCase(taxpayer.getId())) {

                totalPayments = totalPayments.add(payment.getAmount());
            }
        }

        // Calculate penalties
        for (int i = 0; i < penaltyCount; i++) {

            Penalty penalty = penalties[i];

            if (penalty.getObligation().getTaxpayer().getId()
                    .equalsIgnoreCase(taxpayer.getId())) {

                totalPenalties = totalPenalties.add(
                        penalty.getPenaltyAmount()
                );
            }
        }

        // Calculate final balance
        BigDecimal outstandingBalance = totalAssessments
                .add(totalPenalties)
                .subtract(totalPayments);

        return outstandingBalance;
    }

    public static void viewTaxReports() {

        System.out.println("\n========== TAX ADMINISTRATION REPORT ==========");

        int confirmedCount = 0;
        int pendingCount = 0;

        BigDecimal totalPaymentAmount = BigDecimal.ZERO;
        BigDecimal totalPenaltyAmount = BigDecimal.ZERO;
        BigDecimal totalAssessedTax = BigDecimal.ZERO;

        // Count confirmed and pending assessments
        for (int i = 0; i < assessmentCount; i++) {

            if (taxAssessments[i].getStatus()
                    .equalsIgnoreCase("Confirmed")) {

                confirmedCount++;

                totalAssessedTax = totalAssessedTax.add(
                        taxAssessments[i].getTotal()
                );

            } else {
                pendingCount++;
            }
        }

        // Calculate total payments
        for (int i = 0; i < paymentCount; i++) {

            totalPaymentAmount = totalPaymentAmount.add(
                    taxPayments[i].getAmount()
            );
        }

        // Calculate total penalties
        for (int i = 0; i < penaltyCount; i++) {

            totalPenaltyAmount = totalPenaltyAmount.add(
                    penalties[i].getPenaltyAmount()
            );
        }

        // Display registration report
        System.out.println("\n--- Registration Summary ---");

        System.out.println("Individual Taxpayers: " + individualCount);
        System.out.println("Corporate Taxpayers: " + corporateCount);
        System.out.println("Revenue Officers: " + officerCount);
        System.out.println("Tax Types: " + taxTypeCount);

        // Display tax activity report
        System.out.println("\n--- Tax Activity Summary ---");

        System.out.println("Tax Obligations: " + obligationCount);
        System.out.println("Tax Declarations: " + declarationCount);
        System.out.println("Total Assessments: " + assessmentCount);
        System.out.println("Confirmed Assessments: " + confirmedCount);
        System.out.println("Pending/Other Assessments: " + pendingCount);

        // Display financial report
        System.out.println("\n--- Financial Summary ---");

        System.out.println("Total Assessed Tax: " + totalAssessedTax);
        System.out.println("Total Payments: " + totalPaymentAmount);
        System.out.println("Total Penalties: " + totalPenaltyAmount);

        // Display refund and clearance report
        System.out.println("\n--- Refund and Clearance Summary ---");

        System.out.println("Total Refund Requests: " + refundCount);
        System.out.println("Total Tax Clearances: " + clearanceCount);

        System.out.println("\n===============================================");
    }


    public static void demonstratePolymorphism() {

        System.out.println("\n===== POLYMORPHISM DEMONSTRATION =====");


        TaxParty[] parties = new TaxParty[
                individualCount + corporateCount + officerCount
                ];

        int count = 0;

        // Add individual taxpayers
        for (int i = 0; i < individualCount; i++) {
            parties[count] = individualTaxpayers[i];
            count++;
        }

        // Add corporate taxpayers
        for (int i = 0; i < corporateCount; i++) {
            parties[count] = corporateTaxpayers[i];
            count++;
        }

        // Add revenue officers
        for (int i = 0; i < officerCount; i++) {
            parties[count] = revenueOfficers[i];
            count++;
        }

        // Display all parties using the parent class reference
        if (count == 0) {
            System.out.println("No records available.");
            return;
        }

        for (int i = 0; i < count; i++) {

            System.out.println("\n--- Record " + (i + 1) + " ---");

            parties[i].printDetails();
        }

        System.out.println("\nPolymorphism demonstrated successfully.");
    }
}
