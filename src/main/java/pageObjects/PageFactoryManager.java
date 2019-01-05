package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {

	
	public static DeleteAccountPageObject openDeleteAccountPage(WebDriver driver) {
		return new DeleteAccountPageObject(driver);
	}
	
	public static EditCustomerPageObject openEditCustomerPage(WebDriver driver) {
		return new EditCustomerPageObject(driver);
	}
	
	public static HomePageObject openHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static LoginPageObject openLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static NewCustomerPageObject openNewCustomerPage(WebDriver driver) {
		return new NewCustomerPageObject(driver);
	}
	
	public static RegisterPageObject openRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static WithdrawPageObject openWithDrawPage(WebDriver driver) {
		return new WithdrawPageObject(driver);
	}
	
	public static NewAccountPageObject openNewAccountPage(WebDriver driver) {
		return new NewAccountPageObject(driver);
	}

	public static DepositPageObject openDepositPage(WebDriver driver) {
		return new DepositPageObject(driver);
	}
	

	public static FundTransferPageObject openNewFundTransferPage(WebDriver driver) {
		return new FundTransferPageObject(driver);
	}

	public static BalanceEnquiryPageObject openBalanceEnquiryPage(WebDriver driver) {
		return new BalanceEnquiryPageObject(driver);
	}
	
	public static DeleteCustomerPageObject openDeleteCustomerPage(WebDriver driver) {
		return new DeleteCustomerPageObject(driver);
	}

	public static EditAccountPageObject openEditAccountPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new EditAccountPageObject(driver);
	}

	public static ChangePasswordPageObject openChangePasswordPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new ChangePasswordPageObject(driver);
	}

	public static MiniStatementPageObject openMiniStatementPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new MiniStatementPageObject(driver);
	}

	public static CustomisedStatementPageObject openCustomisedStatementPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new CustomisedStatementPageObject(driver);
	}
	
	public static AbstractPageObject openAbstractPage(WebDriver driver) {
		return new AbstractPageObject(driver);
	}

}
