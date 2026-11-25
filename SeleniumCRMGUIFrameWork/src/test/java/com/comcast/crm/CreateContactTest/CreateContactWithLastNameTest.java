package com.comcast.crm.CreateContactTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClassUtility.BaseClass;
import Com.comcast.crm.ObjectRepository.ContactPage;
import Com.comcast.crm.genericUtility.ExcelUlility;
import ListenerImplementationutility.ListernImplementionclass;



@Listeners(ListernImplementionclass.class)

public class CreateContactWithLastNameTest extends BaseClass {

    @Test
    public void verifyContactWithLastName() throws IOException {

        ExcelUlility eu = new ExcelUlility();

        String lastName = eu.getDataFromExcelFile("constact", 1, 3);

        ContactPage cp = new ContactPage(driver);

        cp.clickContacts();

        cp.clickCreateContact();

        cp.enterLastName(lastName);

        cp.clickSave();

        String actualHeader = cp.getHeaderText();

        Assert.assertTrue(actualHeader.contains(lastName),
                "Contact creation failed - Last Name not found in header");

        System.out.println("Contact Header Verification: PASS");
    }
}