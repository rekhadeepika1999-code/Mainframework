package com.comcast.crm.CreateOrgTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClassUtility.BaseClass;
import Com.comcast.crm.ObjectRepository.OrganizationPage;
import Com.comcast.crm.genericUtility.ExcelUlility;
import Com.comcast.crm.webdriverUtility.JavaUlility;
import ListenerImplementationutility.ListernImplementionclass;

@Listeners(ListernImplementionclass.class)


public class CreateOrganizationWithPhoneNumberTest extends BaseClass {

    @Test
    public void verifyOrganizationWithPhoneNumber() throws IOException {

        JavaUlility jvu = new JavaUlility();
        ExcelUlility eu = new ExcelUlility();

        String orgName = eu.getDataFromExcelFile("org", 7, 2)
                + jvu.getRandomNumber();

        String phoneNumber = eu.getDataFromExcelFile("org", 7, 3);

        OrganizationPage op = new OrganizationPage(driver);

        op.clickOrganization();

        op.clickCreateOrganization();

        op.enterOrganizationName(orgName);

        op.enterPhoneNumber(phoneNumber);

        op.clickSave();

        String actualNumber = op.getPhoneNumber();

        Assert.assertEquals(actualNumber, phoneNumber,
                "Phone number verification failed");

        System.out.println("Phone Number Verification: PASS");
    }
}