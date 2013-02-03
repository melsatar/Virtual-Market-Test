package com.virtual.market.test;

import android.test.ActivityInstrumentationTestCase2;

import com.jayway.android.robotium.solo.Solo;
import com.virtual.market.UserFirstActivity;


public class TestMain extends ActivityInstrumentationTestCase2<UserFirstActivity>{

	private Solo solo;

	public TestMain() {
		super(UserFirstActivity.class);

	}
	
	@Override
	public void setUp() throws Exception {
		//setUp() is run before a test case is started. 
		//This is where the solo object is created.
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	@Override
	public void tearDown() throws Exception {
		//tearDown() is run after a test case has finished. 
		//finishOpenedActivities() will finish all the activities that have been opened during the test execution.
		solo.finishOpenedActivities();
	}

	public void testSignUp() throws Exception {

		solo.clickOnButton("Register");
		solo.assertCurrentActivity("Expected Log in activity", "User_Signup");
		solo.enterText(0, "melsatar2013");
		solo.enterText(1, "melsatar@ymail.com");
		solo.enterText(2, "123");
		solo.enterText(3, "100200300400");
		solo.getCurrentSpinners();
		solo.sleep(1500);
		solo.pressSpinnerItem(0, 0);
		solo.sleep(1000);
		solo.goBack();
		solo.sleep(1500);
		solo.pressSpinnerItem(1, 0);
		solo.sleep(1000);
		solo.goBack();
		solo.enterText(4, "111 Building, 66 Flat");
		solo.clickOnButton("Register");
		solo.waitForActivity("SMSValidate");
		solo.assertCurrentActivity("Expected SMA vaildate activity", "SMSValidate");
		solo.enterText(0, "1111");
		solo.clickOnButton("Validate");
	}
	public void testSignIn() throws Exception {

		solo.clickOnButton("Log In");
		solo.assertCurrentActivity("Expected Log in activity", "User_Login");
		solo.enterText(0, "melsatar");
		solo.enterText(1, "123");
		solo.clickOnButton("Log In");
		solo.waitForActivity("User_MainActivity");
		solo.assertCurrentActivity("Expected User Manin activity", "User_MainActivity"); 
	}
	
	
	public void testViewCart() throws Exception {
		solo.clickOnButton("View myCart");
		solo.assertCurrentActivity("Expected Shopping cart activity", "Shopping_cart");
		solo.waitForActivity("Shopping_cart");
		solo.clickOnButton("checkout");		 
	}

}
