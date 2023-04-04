package pac1;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class Test_masters {
	public static WebDriver driver;
	JavaScriptExecutor js = (JavaScriptExecutor) driver;
	
	public static void Baseclass() {
		System.setProperty("webdriver.chrome.driver", "../xpath/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://testingmasters.weebly.com/webtables.html");
	}

	public static void Teardown() {
		driver.close();
	}

	public static void PrintEmployeeID(String Designation) {

		try {
			List<WebElement> id1 = driver.findElements(By.xpath(
					"//table[@id='VisitingTable']/tbody/tr/td[text()='Analyst']/preceding-sibling::td[3]"));
			System.out.println("-->Print the employee ID's of the candiates whose designation is Analyst");
			System.out.println(id1.size());
			for (WebElement webelement : id1) {
				if (webelement.isEnabled()) {
					System.out.println(webelement.getText());
					System.out.println("EmployeeID Printed ");

				} else {
					System.out.println("EmployeeID not Printed ");
				}
			}
		} catch (Exception e) {
			System.out.println();
		}
	}

	public static void PrinttTheMailIds() {
		try {
			List<WebElement> id2 = driver
					.findElements(By.xpath("//table/tbody/tr/td[7][.<='5']/preceding-sibling::td[3]"));
			System.out.println(
					"-->  Print the Mail Id's of the candidates who have applied for less than or equal to 5 days");
			System.out.println(id2.size());
			for (WebElement webelement : id2) {
				if (webelement.isEnabled()) {
					System.out.println(webelement.getText());
					System.out.println("MailId Printed ");

				} else {
					System.out.println("MailId not Printed ");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void CheckboxesManager(String Designation, String data) {

		try {
			List<WebElement> id3 = driver.findElements(By.xpath(
					"//table/tbody/tr/td[text()='" + Designation + "']/preceding-sibling::td[4]"));
			System.out.println("-->Click on the checkboxes of the records whose Designation is " + data);
			System.out.println(id3.size());
			for (WebElement webelement : id3) {
				if (webelement.isEnabled()) {
					webelement.click();
					System.out.println("Checkbox Clicked");
					if (webelement.isEnabled()) {
						Thread.sleep(1500);
						webelement.click();
						System.out.println("Checkbox Cleared");
					} else {
						System.out.println("Checkbox not Cleared");
					}
				} else {
					System.out.println("Checkbox not Clicked");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Checkboxs8days() {
		try {
			List<WebElement> id4 = driver
					.findElements(By.xpath("//table/tbody/tr/td[7][.>'8']/preceding-sibling::td[6]"));
			System.out.println("-->Click on the checkboxes of the records whose applied days are more than 8 days");
			System.out.println(id4.size());
			for (WebElement webelement : id4) {
				if (webelement.isEnabled()) {
					webelement.click();
					System.out.println("Checkbox Clicked");
					if (webelement.isEnabled()) {
						Thread.sleep(1500);
						webelement.click();
						System.out.println("Checkbox Cleared");
					} else {
						System.out.println("Checkbox not Cleared");
					}
				} else {
					System.out.println("Checkbox not Clicked");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void RejectAnalystLeave(String Designation) {
		try {
			List<WebElement> id5 = driver.findElements(By.xpath("//table/tbody/tr/td[text()='"
					+ Designation + "']/following-sibling::td[3]/select"));
			System.out.println("-->Reject the leaves applied by " + Designation);
			System.out.println(id5.size());
			for (int i = 0; i < id5.size(); i++) {
				WebElement element = id5.get(i);
				Select st = new Select(element);
				String status = st.getFirstSelectedOption().getText();
				System.out.println(status);
				if (status.equals("Pending")) {
					Thread.sleep(1500);
					st.selectByVisibleText("Rejected");

				} else {
					System.out.println("Leave Rejected");
					System.out.println(status);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void PrintEmpIDApproved(String Status, String data) {
		try {
			List<WebElement> id6 = driver.findElements(
					By.xpath("//table/tbody/tr/td[8]/select/option[@selected='selected' and text()='"
							+ Status + "']/ancestor::td/preceding-sibling::td[6]"));
			System.out.println("-->Print the employee Id's of the " + Status + " candidates");
			System.out.println(id6.size());
			for (WebElement webelement : id6) {
				if (webelement.isEnabled()) {
					System.out.println(webelement.getText());
					System.out.println(data + " EmpID is Printed");
				} else {
					System.out.println(data + " EmpID is not Printed");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void CheckboxVinodAnalyst(String Designation, String UserName) {
		try {
			List<WebElement> id7 = driver.findElements(By.xpath("//table/tbody/tr/td[text()='"
					+ Designation + "']/preceding-sibling::td[2][text()='" + UserName + "']/preceding-sibling::td[2]"));

			System.out.println("-->Click on the checkboxes of the records whose username is " + UserName
					+ " and Designation is " + Designation + "");
			System.out.println(id7.size());

			for (WebElement webelement : id7) {
				if (webelement.isEnabled()) {
					webelement.click();
					System.out.println("Checkbox Clicked");
					if (webelement.isEnabled()) {
						Thread.sleep(1500);
						webelement.click();
						System.out.println("Checkbox Cleared");
					} else {
						System.out.println("Checkbox not Cleared");
					}
				} else {
					System.out.println("Checkbox not Clicked");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void First5records(int dada) {
		try {
			List<WebElement> id8 = driver.findElements(By.xpath(
					"(//table/tbody/tr/td[7])[position()<" + dada + "]/preceding-sibling::td[6]"));
			System.out.println("-->Click on checkboxes of first five records");
			System.out.println(id8.size());

			for (WebElement webelement : id8) {
				if (webelement.isEnabled()) {
					webelement.click();
					System.out.println("Checkbox Clicked");
					if (webelement.isEnabled()) {
						Thread.sleep(1500);
						webelement.click();
						System.out.println("Checkbox Cleared");
					} else {
						System.out.println("Checkbox not Cleared");
					}
				} else {
					System.out.println("Checkbox not Clicked");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Last4records(int dada) {
		try {
			List<WebElement> id9 = driver
					.findElements(By.xpath("(//table/tbody/tr/td[1])[position()>" + dada + "]"));
			System.out.println("-->Clik on checkboxes of last 4 records");
			System.out.println(id9.size());
			for (WebElement webelement : id9) {
				if (webelement.isEnabled()) {
					webelement.click();
					System.out.println("Checkbox Clicked");
					if (webelement.isEnabled()) {
						Thread.sleep(1500);
						webelement.click();
						System.out.println("Checkbox Cleared");
					} else {
						System.out.println("Checkbox not Cleared");
					}
				} else {
					System.out.println("Checkbox not Clicked");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void CheckboxesDemo(String StartsWith) {
		try {
			List<WebElement> id10 = driver
					.findElements(By.xpath("//table/tbody/tr/td[4][contains(text(),'" + StartsWith
							+ "')]/preceding-sibling::td[3]"));
			System.out.println("-->Click on checkboxes whose email id starts with '" + StartsWith + "'");
			System.out.println(id10.size());
			for (WebElement webelement : id10) {
				if (webelement.isEnabled()) {
					webelement.click();
					System.out.println("Checkbox Clicked");
					if (webelement.isEnabled()) {
						Thread.sleep(1500);
						webelement.click();
						System.out.println("Checkbox Cleared");
					} else {
						System.out.println("Checkbox not Cleared");
					}
				} else {
					System.out.println("Checkbox not Clicked");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Baseclass();
		PrintEmployeeID("Analyst");
		Thread.sleep(3000);
		PrinttTheMailIds();
		Thread.sleep(3000);
		CheckboxesManager("Manager", "Manager");
		Thread.sleep(3000);
		Checkboxs8days();
		Thread.sleep(3000);
		RejectAnalystLeave("Analyst");
		Thread.sleep(3000);
		PrintEmpIDApproved("Accepted", "Analyst");
		Thread.sleep(3000);
		CheckboxVinodAnalyst("Analyst", "Vinod");
		Thread.sleep(3000);
		First5records(6);
		Thread.sleep(3000);
		Last4records(8);
		Thread.sleep(3000);
		CheckboxesDemo("demo");
		Thread.sleep(3000);
		Teardown();
	}
}
