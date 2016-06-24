package com.maf.batterytest;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class BatteryTest extends UiAutomatorTestCase {
	public void test() throws UiObjectNotFoundException {
		// Default parameters
		String toNumber = "0457760939"; 
		String text = "Test message";
		
		String toParam = getParams().getString("to");
		String textParam = getParams().getString("text");
		if (toParam != null) {
			toNumber = toParam.trim();
		}
		if (textParam != null) {
			text = textParam.trim();
		}
		findAndRunApp();
	    	sendMessage(toNumber, text);
	    	exitToMainWindow();
	}
	// Here will be called for all other functions
	private void findAndRunApp() throws UiObjectNotFoundException {
		// Go to main screen
		getUiDevice().pressHome();
		sleep(100);
		getUiDevice().pressHome();
		// Find menu button
		//UiObject allAppsButton = new UiObject(new UiSelector()
		//.description("App drawer"));
		// Click on menu button and wait new window
		//allAppsButton.clickAndWaitForNewWindow();
		// Find App tab
		//UiObject appsTab = new UiObject(new UiSelector()
		//.text("Apps"));
		// Click on app tab
		//appsTab.click();
		// Find scroll object (menu scroll)
		//UiScrollable appViews = new UiScrollable(new UiSelector()
		//.scrollable(true));
		// Set the swiping mode to horizontal (the default is vertical)
		//appViews.setAsHorizontalList();
		// Find Messaging application
		UiObject messagingApp = new UiObject(new UiSelector()
				.className("com.sec.android.app.launcher.views.HomeItemView").text("Messages"));
		// Open Messaging application
		messagingApp.clickAndWaitForNewWindow();
	}
	
	private void sendMessage(String toNumber, String text) throws UiObjectNotFoundException {
		// Find and click New message button
		UiObject newMessageButton = new UiObject(new UiSelector()
		.className("android.widget.ImageButton").description("Compose new message"));
		newMessageButton.clickAndWaitForNewWindow();
		
		// Find to box and enter the number into it
		UiObject toBox = new UiObject(new UiSelector()
		.className("android.widget.EditText").text("Enter recipients"));
		toBox.setText(toNumber);
		// Find text box and enter the message into it
		UiObject textBox = new UiObject(new UiSelector()
		.className("android.widget.EditText").text("Enter message"));
		textBox.setText(text);
		
		// Find send button and send message
		UiObject sendButton = new UiObject(new UiSelector()
		.className("android.widget.Button").text("Send"));
		sendButton.click();
	}
	
	private void exitToMainWindow() {
			getUiDevice().pressBack();
			getUiDevice().pressBack();
			getUiDevice().pressHome();
	}
}
