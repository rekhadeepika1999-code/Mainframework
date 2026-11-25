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


public class CreateOrganizationWithIndustryAndTypeTest extends BaseClass {

    @Test
    public void verifyOrganizationWithIndustryAndType() throws IOException {

        JavaUlility jvu = new JavaUlility();
        ExcelUlility eu = new ExcelUlility();

        String orgName = eu.getDataFromExcelFile("org", 4, 2)
                + jvu.getRandomNumber();

        String industry = eu.getDataFromExcelFile("org", 4, 3);

        String type = eu.getDataFromExcelFile("org", 4, 4);

        OrganizationPage op = new OrganizationPage(driver);

        op.clickOrganization();

        op.clickCreateOrganization();

        op.enterOrganizationName(orgName);

        op.selectIndustry(industry);

        op.selectType(type);
        op.clickSave();

        String actualIndustry = op.getIndustry();

        Assert.assertEquals(actualIndustry, industry,
                "Industry verification failed");

        System.out.println("Industry Verification: PASS");

        String actualType = op.getType();

        Assert.assertEquals(actualType, type,
                "Organization Type verification failed");

        System.out.println("Organization Type Verification: PASS");
    }
}