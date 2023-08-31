import java.util.Scanner;
import java.util.concurrent.TimeUnit;

//
public class AutoDealer {
  // JAVA SLOW PRINT ATTRIBUTION. CREATED BY plscodeinjava.
  // https://replit.com/talk/learn/Slow-Print-tutorial-for-JAVA/51697
  public static void slowPrint(String output) {
    for (int i = 0; i < output.length(); i++) {
      char c = output.charAt(i);
      System.out.print(c);
      try {
        TimeUnit.MILLISECONDS.sleep(15);
      } catch (Exception e) {
      }
    }
  }

  public static void main(String[] args) {
    System.out.println("");
    slowPrint("Welcome to AutoDealer!\n");
    System.out.println("----------------------");
    System.out.println("");

    // MODEL SECTION
    slowPrint("Make your model selection:\n");
    slowPrint("1 - Toyota\n");
    slowPrint("2 - Honda\n");
    slowPrint("3 - Ford\n");
    slowPrint("4 - Chevy\n");
    Scanner carScanner = new Scanner(System.in);
    slowPrint("Selection: ");
    int modelSelection = carScanner.nextInt();
    int modelCost;
    switch (modelSelection) {
      case 1:
        modelCost = 23000;
        break;
      case 2:
        modelCost = 25000;
        break;
      case 3:
        modelCost = 22000;
        break;
      case 4:
        modelCost = 23500;
        break;
      default:
        modelCost = 19999;
        break;
    }

    // INTERIOR SECTION
    System.out.println("");
    slowPrint("Make your Interior Selection:\n");
    slowPrint("1 - Cloth\n");
    slowPrint("2 - Leather\n");
    slowPrint("3 - Premium Leather\n");
    Scanner interiorScanner = new Scanner(System.in);
    slowPrint("Selection: ");
    int interiorSelection = interiorScanner.nextInt();
    int interiorCost;
    switch (interiorSelection) {
      case 1:
        interiorCost = 1200;
        break;
      case 2:
        interiorCost = 1500;
        break;
      case 3:
        interiorCost = 1900;
        break;
      default:
        interiorCost = 1000;
        break;
    }

    // COLOR SECTION
    System.out.println("");
    slowPrint("Make your Color Selection:\n");
    slowPrint("1 - Purple\n");
    slowPrint("2 - Gold\n");
    slowPrint("3 - Blended\n");
    Scanner colorScanner = new Scanner(System.in);
    slowPrint("Selection: ");
    int colorSelection = colorScanner.nextInt();
    int colorCost;
    switch (colorSelection) {
      case 1:
        colorCost = 800;
        break;
      case 2:
        colorCost = 900;
        break;
      case 3:
        colorCost = 1100;
        break;
      default:
        colorCost = 500;
        break;
    }

    // PURCHASE MONTH SECTION
    System.out.println("");
    Scanner purchaseMonthScanner = new Scanner(System.in);
    slowPrint("Month of Automobile Purchase: (Jan -> 1, Dec -> 12) ");
    int purchaseMonth = purchaseMonthScanner.nextInt();

    // DOWN PAYMENT SECTION
    System.out.println("");
    Scanner downPaymentScanner = new Scanner(System.in);
    slowPrint("How much will the down payment be?: $");
    int downPayment = downPaymentScanner.nextInt();

    // CLOSE SCANNERS
    carScanner.close();
    interiorScanner.close();
    colorScanner.close();
    purchaseMonthScanner.close();
    downPaymentScanner.close();

    // CALCULATIONS
    // 1. IF CUSTOMER DOWNPAYMENT IS BETWEEN $5000 & $10000, 25% DISCOUNT ON COST OF
    // PAINT COLOR
    if (downPayment >= 5000 && downPayment <= 10000) {
      colorCost = (int) (colorCost * 0.75);
    }

    // 2. IF CUSTOMER DOWNPAYMENT IS BIGGER THAN $10,000, 35% DISCOUNT Of COST OF
    // INTERIOR TRIM AND CUSTOMER PAYS NO SALES TAX
    double salesTax = .0975;
    if (downPayment > 10000) {
      interiorCost = (int) (interiorCost * 0.65);
      salesTax = 0;
    }

    // 3. If VEHICLE IS PURCHASED IN EITHER MAY (5th month) OR NOVEMBER (11th
    // month), ENTIRE SALE GETS A 10% DISCOUNT.
    double subTotal = modelCost + colorCost + interiorCost;
    double mayAndNovSubTotal = 0;
    if (purchaseMonth == 5 || purchaseMonth == 11) {
      mayAndNovSubTotal = subTotal * 0.9;
    }

    // TOTAL CALCULATIONS
    double taxAmount = subTotal * salesTax;
    double total;
    if (purchaseMonth == 5 || purchaseMonth == 11) {
      total = mayAndNovSubTotal + taxAmount;
    } else {
      total = subTotal + taxAmount;
    }
    double finalTotal = total - downPayment;

    // PRINT RECEIPT SECTION
    System.out.println("");
    slowPrint("PRINTING RECEIPT.........................\n");
    slowPrint("Base Model Cost: $" + modelCost + "\n");
    slowPrint("Paint Color Cost: $" + colorCost + "\n");
    // INTERIOR COST
    if (downPayment > 10000) {
      slowPrint("Interior Cost: $" + interiorCost + " (With 35% Discount!)\n");
    } else {
      slowPrint("Interior Cost: $" + interiorCost + "\n");
    }
    System.out.println("-----------------------");

    // SUBTOTAL
    if (purchaseMonth == 5 || purchaseMonth == 11) {
      slowPrint("Subtotal: $" + subTotal + "\n");
      slowPrint("With May/Nov Discount: $" + mayAndNovSubTotal + "\n");
    } else {
      slowPrint("Subtotal: $" + subTotal + "\n");
    }
    System.out.println("-----------------------");

    // TAX
    if (taxAmount == 0) {
      slowPrint("No Tax! - Large Down Payment!\n");
    } else {
      slowPrint("Tax Amount: $" + taxAmount + "\n");
    }
    System.out.println("-----------------------");

    // Total
    slowPrint("Total: $" + total + "\n");
    System.out.println("-----------------------");

    // DOWNPAYMENT
    slowPrint("Subtract Down Payment: -$" + downPayment + "\n");
    System.out.println("-----------------------");

    // FINAL COST
    slowPrint("Final Total: $" + finalTotal + "\n");
    System.out.println("-----------------------");
    System.out.println("");

    // Attribution
    slowPrint("RECEIPT PRINTED! THANK YOU AND PLEASE COME AGAIN!\n");
    slowPrint("CODED BY JORDAN KLEINBAUM\n");
    slowPrint("LinkedIn: ");
    System.out.println("https://www.linkedin.com/in/jordan-kleinbaum-259633204/");
    slowPrint("GitHub: ");
    System.out.println("https://github.com/JordanKleinbaum");
    slowPrint("FrontEnd Mentor: ");
    System.out.println("https://www.frontendmentor.io/profile/JordanKleinbaum");
    System.out.println("");
  }
}
