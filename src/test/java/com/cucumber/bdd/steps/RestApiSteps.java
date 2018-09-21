package com.cucumber.bdd.steps;

import org.openqa.selenium.chrome.ChromeDriver;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RestApiSteps {
	
	WebDriver driver;
	OkHttpClient client = new OkHttpClient();
	String Url_initial = "https://api.github.com/search/repositories?q=";
	int code ;
	
	
	@Given("^Seaching the github api no (\\d+)$")
	public void seaching_the(int countNo) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("\n");
		System.out.println("---------------------------------------------------------");
		System.out.println("Git hub API search count"+ countNo);
		System.out.println("---------------------------------------------------------");
//Comment 2
	}
	
	
	@When("^API with (.*)$")
	public void api_with_keyword(String Keyword) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String final_Url = Url_initial+Keyword;
		System.out.println(final_Url);
		Request request = new Request.Builder().url(final_Url).get()
				.addHeader("cache-control", "no-cache").build();
				//.addHeader("postman-token", "6c2bf264-4a24-09bc-a6e5-baf3d7d00fb0").build();

		Response response = client.newCall(request).execute();
		code = response.code();
	}

	@Then("^the response code should be (\\d+)$")
	public void the_response_code_should_be(int codeValue) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("---------------------------------------------------------");
		if (codeValue==200) {
			System.out.println("API response Success with code :" + codeValue);
		} else {
			System.out.println("API response failure with code :" + codeValue);
		}
		System.out.println("---------------------------------------------------------");
	}

	


}
