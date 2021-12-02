/*
    Name : Tanishq Mor
    Student ID : 1216879638
    Class : CSE 360
    Instructor : Balasooriya
    Project : HW # 3
 */
package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class Controller {
    @FXML
    private TextField addr, checkingAccount, customerID, firstName, lastName, phoneNumber, savingAccount;
    @FXML
    private Text firstError, lastError, customerError, phoneError, addrError, savingError, checkingError, successText, duplication;
    private int saveButtonPressed = 0;
    private Vector<Integer> vector = new Vector<>();

    // Method to write the inputs into a file
    public void writeToFile(String str, int num) {
        try {
            FileWriter myWriter = new FileWriter("Application_" + num + ".txt");
            myWriter.write(str);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // Method to handle when the save button is clicked
    public void saveButton() {
        String firstN = "", lastN = "", cusID = "", phNumber = "", address = "", saveAcc = "", checkAcc = "";
        boolean isfilled = true;

        // Check if the there is anything in the First Name field
        if (!firstName.getText().matches("[a-zA-Z]+")) {
            firstError.setVisible(true);
        } else if (firstName.getText().isEmpty()) {
            firstError.setVisible(true);
            isfilled = false;
        } else {
            firstError.setVisible(false);
            firstN = firstName.getText();
        }
        // Check if the there is anything in the Last Name field
        if (!lastName.getText().matches("[a-zA-Z]+")) {
            lastError.setVisible(true);
        } else if (lastName.getText().isEmpty()) {
            lastError.setVisible(true);
            isfilled = false;
        } else {
            lastError.setVisible(false);
            lastN = firstName.getText();
        }
        // Check if the there is anything in the Customer ID field
        // and also if there is int in the field and not char also checks if they are 4 digits
        if (!customerID.getText().matches("\\d+") || customerID.getText().length() > 4 || customerID.getText().length() < 4) {
            customerError.setVisible(true);
            duplication.setVisible(false);

            isfilled = false;
        } else if (customerID.getText().isEmpty()) {
            customerError.setVisible(true);
            duplication.setVisible(false);
            isfilled = false;
        } else if (vector.contains(Integer.parseInt(customerID.getText()))) {
            duplication.setVisible(true);
            customerError.setVisible(false);

            isfilled = false;
        } else {
            customerError.setVisible(false);
            duplication.setVisible(false);
            cusID = customerID.getText();
            int i = Integer.parseInt(cusID);
            vector.add(i);
        }

        // Check if the there is anything in the Phone Number field and also check if it is a number
        if (!phoneNumber.getText().matches("\\d+")) {
            phoneError.setVisible(true);
            isfilled = false;
        } else if (phoneNumber.getText().isEmpty()) {
            phoneError.setVisible(true);
            isfilled = false;
        } else {
            phoneError.setVisible(false);
            phNumber = phoneNumber.getText();
        }
        // Check if the there is anything in the Address field
        if (addr.getText().isEmpty()) {
            addrError.setVisible(true);
            isfilled = false;
        } else {
            addrError.setVisible(false);
            address = addr.getText();
        }
        // Check if the there is anything in the Saving Account field and also check if it is a number
        if (!savingAccount.getText().matches("\\d+")) {
            savingError.setVisible(true);
            isfilled = false;
        } else if (savingAccount.getText().isEmpty()) {
            savingError.setVisible(true);
            isfilled = false;
        } else {
            savingError.setVisible(false);
            saveAcc = savingAccount.getText();
        }
        // Check if the there is anything in the Checking Account field and also check if it is a number
        if (!checkingAccount.getText().matches("\\d+")) {
            checkingError.setVisible(true);
            isfilled = false;
        } else if (checkingAccount.getText().isEmpty()) {
            checkingError.setVisible(true);
            isfilled = false;
        } else {
            checkingError.setVisible(false);
            checkAcc = checkingAccount.getText();
        }
        // Check if any fields are not empty if it is not empty then write to a file else display errors
        if (isfilled) {
            String result = "First name: " + firstN + "\n" +
                    "Last Name: " + lastN + "\n" +
                    "Customer ID: " + cusID + "\n" +
                    "Phone Number: " + phNumber + "\n" +
                    "Address: " + address + "\n" +
                    "Saving Account Number: " + saveAcc + "\n" +
                    "Checking Account Number: " + checkAcc;
            saveButtonPressed++;
            writeToFile(result, saveButtonPressed);
            successText.setVisible(true);
            firstName.clear();
            lastName.clear();
            customerID.clear();
            phoneNumber.clear();
            addr.clear();
            savingAccount.clear();
            checkingAccount.clear();
        } else {
            successText.setVisible(false);
        }

    }

    // Method for the Cancel Button
    public void cancelButton() {
        firstName.clear();
        lastName.clear();
        customerID.clear();
        phoneNumber.clear();
        addr.clear();
        savingAccount.clear();
        checkingAccount.clear();
        clearText();
    }

    // Method to clear all the Error statements
    private void clearText() {
        firstError.setVisible(false);
        lastError.setVisible(false);
        customerError.setVisible(false);
        phoneError.setVisible(false);
        addrError.setVisible(false);
        savingError.setVisible(false);
        checkingError.setVisible(false);
        successText.setVisible(false);
        duplication.setVisible(false);
    }

}
