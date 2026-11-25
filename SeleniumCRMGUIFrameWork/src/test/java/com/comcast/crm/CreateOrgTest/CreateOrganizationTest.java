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

public class CreateOrganizationTest extends BaseClass {

    @Test
    public void verifyCreateOrganization() throws IOException {

        JavaUlility jvu = new JavaUlility();
        ExcelUlility eu = new ExcelUlility();

        String orgName = eu.getDataFromExcelFile("org", 1, 2)
                + jvu.getRandomNumber();

        OrganizationPage op = new OrganizationPage(driver);

        op.clickOrganization();
        op.clickCreateOrganization();
        op.enterOrganizationName(orgName);
        op.clickSave();

        String actualHeader = op.getHeaderText();

        Assert.assertTrue(actualHeader.contains(orgName),
                "Organization header verification failed");

        System.out.println("Organization Header Verification: PASS");

        String actualOrgName = op.getOrganizationDetails();

        Assert.assertEquals(actualOrgName, orgName,
                "Organization details verification failed");

        System.out.println("Organization Details Verification: PASS");
    }
}