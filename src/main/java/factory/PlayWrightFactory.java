package factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlayWrightFactory {
	
	Playwright plawright;
	Browser browser;
	BrowserContext browsercontext;
	Page page;
	
	public Page initilaizeBrowser(String browserName) {
		
		System.out.println("browser name is:"+ browserName);
		
		plawright = Playwright.create();
		
		switch (browserName.toLowerCase()) {
		case "chromium":
			browser = plawright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "firefox":
			browser = plawright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "webkit":
			browser = plawright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "chrome":
			browser = plawright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
			break;
		case "msedge":
			browser = plawright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
			break;

		default:
			System.out.println("Please pass the correct browser name: ....");
			break;
		}
		
		browsercontext = browser.newContext();
		page = browsercontext.newPage();
		page.navigate("https://naveenautomationlabs.com/opencart/");
		
		return page;
		
	}
}
