package main;

import java.util.Calendar;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TimeZone;


/**
 * Temporary main class (indicated in build.gradle) in v 0.01, reads data
 */
public class CrystalEye {
    public static void main(String[] args) {
        CustomerManager customerManager = new CustomerManager(); //Need to retrive data from the past, also need to store customerManager every round
        Scanner reader = new Scanner(System.in);
        Customer newCustomer;

        String name = reader.nextLine();
        String ic = reader.nextLine();
            int age = Integer.parseInt(reader.nextLine());
            String tempGender = reader.nextLine();
            Gender gender; //Should probably do a click in the interface
            if (tempGender.equals("F")) {
                gender = Gender.FEMALE;
            } else if (tempGender.equals("M")) {
                gender = Gender.MALE;
            } else if (tempGender.equals("O")) {
                gender = Gender.OTHER;
            } else {
            throw new NoSuchElementException("Gender can only be F or M or O");
        }
        Phone phone = new Phone(reader.nextLine());
        String occupation = reader.nextLine();
        String address = reader.nextLine();
        newCustomer = new Customer(name, ic, age, gender, phone, occupation, address);
        Customer customerToBeAssignedTask = newCustomer;
        Boolean flag = true;
        for(Customer customer : customerManager.getCustomerList()) {
            if (customer.isSameCustomer(newCustomer)) {
                flag = false;
                customerToBeAssignedTask = customer;
                break;
            }
        }
        if (flag == true) {
            customerManager.addCustomer(newCustomer);
        }

        String prevRight= reader.nextLine();
        String prevLeft = reader.nextLine();
        String prevOcht = reader.nextLine();
        String prevPupillaryDistance = reader.nextLine();
        String prevLens = reader.nextLine();
        String prevAddRight = reader.nextLine();
        String prevAddLeft = reader.nextLine();
        String prevUnaided = reader.nextLine();
        String prevBinocular = reader.nextLine();
        String prevRightVA = reader.nextLine();
        String prevLeftVA = reader.nextLine();
        String prevUnaidedRightVA = reader.nextLine();
        String prevUnaidedLeftVA = reader.nextLine();
        String prevBinocularVA = reader.nextLine();
        PrevRX prevRX = new PrevRX(prevRight, prevLeft, prevOcht, prevPupillaryDistance, prevLens, prevAddRight,
                prevAddLeft, prevUnaided, prevBinocular, prevRightVA, prevLeftVA, prevUnaidedRightVA, prevUnaidedLeftVA,
                prevBinocularVA);
        String subRight= reader.nextLine();
        String subLeft = reader.nextLine();
        String subPupillaryDistance = reader.nextLine();
        String subAddRight = reader.nextLine();
        String subAddLeft = reader.nextLine();
        String subBinocular = reader.nextLine();
        String subRightVA = reader.nextLine();
        String subLeftVA = reader.nextLine();
        String subBinocularVA = reader.nextLine();
        SubRX subRX = new SubRX(subRight, subLeft, subPupillaryDistance, subAddRight, subAddLeft, subBinocular,
                subRightVA, subLeftVA, subBinocularVA);
        String finalRight= reader.nextLine();
        String finalLeft = reader.nextLine();
        String finalOcht = reader.nextLine();
        String finalPupillaryDistance = reader.nextLine();
        String finalLens = reader.nextLine();
        String finalAddRight = reader.nextLine();
        String finalAddLeft = reader.nextLine();
        String finalRightVA = reader.nextLine();
        String finalLeftVA = reader.nextLine();
        String finalFrame = reader.nextLine();
        String finalRetinoscopy = reader.nextLine();
        String finalKeratometry = reader.nextLine();
        String finalHistory = reader.nextLine();
        FinalRX finalRX = new FinalRX(finalRight, finalLeft, finalOcht, finalPupillaryDistance, finalLens,
                finalAddRight, finalAddLeft, finalRightVA, finalLeftVA, finalFrame, finalRetinoscopy, finalKeratometry,
                finalHistory);
        String productRight = reader.nextLine();
        String productLeft = reader.nextLine();
        String productOcht = reader.nextLine();
        String productPupillaryDistance = reader.nextLine();
        String productAddRight = reader.nextLine();
        String productAddLeft = reader.nextLine();
        ProductRX productRX = new ProductRX(productRight, productLeft, productOcht, productPupillaryDistance,
                productAddRight, productAddLeft);
        double price = Double.parseDouble(reader.nextLine());
        String tempStatus = reader.nextLine();
        Status status;
        if (tempStatus.equals("D")) {
            status = Status.DONE;
        } else if (tempStatus.equals("P")) {
            status = Status.PENDING;
        } else if (tempStatus.equals("R")) {
            status = Status.READYFORCOLLECTION;
        } else {
            throw new NoSuchElementException("Status can only be D or P or R");
        }
        DataFields dataFields = new DataFields(prevRX, subRX, finalRX, productRX);
        int transactionID = 0;
        Transaction newTransaction = new Transaction(transactionID, Calendar.getInstance(TimeZone.getDefault()),
                dataFields, price, status);
        customerToBeAssignedTask.addTransaction(newTransaction);
        customerManager.printCustomerList();
    }
}
