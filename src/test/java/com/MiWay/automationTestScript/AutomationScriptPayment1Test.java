package com.MiWay.automationTestScript;

import org.MiWay.LifeInsurenceObjectRepositery.AddPaymentPage;
import org.MiWay.LifeInsurenceObjectRepositery.PaymentInformationPage;
import org.MiWay.LifeInsurenceObjectRepositery.TabNames;
import org.MiWay.LifeInsurenceObjectRepositery.TextFieldNames;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.MiWay.Genericutility.BaseClass;

public class AutomationScriptPayment1Test extends BaseClass{
@Test
public void paymen1() {
	String s1 = comman.getTextOfTheElement();
	String s2 = s1.replaceAll("[^0-9]", "");
	int n1 = Integer.parseInt(s2);
	System.out.println(n1);
	//asd
	//lkjhgf
	comman.clickOnrequriedTab(TabNames.PAYMENTS);
	PaymentInformationPage paymentPage = new PaymentInformationPage(driver);
	paymentPage.clickOnAddPaymentButton();

	AddPaymentPage addPayment = new AddPaymentPage(driver);
	addPayment.setDataForRequiredTextField(TextFieldNames.CLIENT_ID, "10001");
	addPayment.setDataForRequiredTextField(TextFieldNames.MONTH, "september");
	addPayment.setDataForRequiredTextField(TextFieldNames.AMOUNT, "10000");
	addPayment.setDataForRequiredTextField(TextFieldNames.DUE, "100");
	addPayment.setDataForRequiredTextField(TextFieldNames.FINE, "10");

	addPayment.clickOnSubmitButton();
	comman.homePage();

	String s3 = comman.getTextOfTheElement();
	String s4 = s3.replaceAll("[^0-9]", "");
	int n2 = Integer.parseInt(s4);
	System.out.println(n2);

	Assert.assertTrue(n2 == n1 + 1);
	Reporter.log("passed: payment record increased successfully",true);
	
}
}

