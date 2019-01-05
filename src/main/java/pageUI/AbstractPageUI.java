package pageUI;

public class AbstractPageUI {

	public static final String DYNAMIC_PAGE_LINK = "//a[text()='%s']";
    
	public static final String DYNAMIC_INPUT = "//input[@name='%s']";
	
	public static final String DYNAMIC_AREA = "//textarea[@name='%s']";
	
	public static final String DYNAMIC_BUTTON = "//input[@value='%s']";
	
	public static final String DYNAMIC_RADIO_BUTTON = "//input[@value='%s']";


	public static final String DYNAMIC_DROPDOWN = "//select[@name='%s']";
	
    public static final String DYNAMIC_FOLLOWING_TD ="//td[text()='%s']/following-sibling::td";

	public static final String DYNAMIC_TITLE = "//table[@id='%s']/tbody//p[@class='heading3']";

	public static final String DYNAMIC_MESSAGE="//p[@class='heading3' and text()='%s']";

	public static final String DYNAMIC_MESSAGE_TEXT = "//marquee[text()=\"%s\"]";

	public static final String DYNAMIC_LOCATOR = "//%s[@name='%s']";
	
	public static final String DYNAMIC_ELEMENT_WITH_TEXT = "//%s[text()='%s']";

	public static final String DYNAMIC_TABLE_ELEMENT = "//table[@id='%s']/tbody/%s";
	
    public static final String DYNAMIC_FOLLOWING_LOCATOR="//%s/following-sibling::%s";


}
