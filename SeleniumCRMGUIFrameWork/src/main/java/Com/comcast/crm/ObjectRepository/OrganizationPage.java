package Com.comcast.crm.ObjectRepository;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganizationPage {

    WebDriver driver;

    public OrganizationPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Organization Link
    @FindBy(linkText = "Organizations")
    private WebElement organizationLink;

    // Create Organization Button
    @FindBy(xpath = "//img[@title='Create Organization...']")
    private WebElement createOrganizationBtn;

    // Organization Name
    @FindBy(name = "accountname")
    private WebElement organizationNameEdt;

    // Industry Dropdown
    @FindBy(name = "industry")
    private WebElement industryDropdown;

    // Type Dropdown
    @FindBy(name = "accounttype")
    private WebElement typeDropdown;

    // Save Button
    @FindBy(name = "button")
    private WebElement saveBtn;

    // Header Text
    @FindBy(className = "dvHeaderText")
    private WebElement headerText;

    // Organization Details
    @FindBy(id = "dtlview_Organization Name")
    private WebElement organizationDetails;

    // Industry Details
    @FindBy(id = "mouseArea_Industry")
    private WebElement industryText;

    // Type Details
    @FindBy(id = "mouseArea_Type")
    private WebElement typeText;

 // Phone Number Text Field
    @FindBy(id = "phone")
    private WebElement phoneNumberEdt;

    // Phone Number Details
    @FindBy(id = "dtlview_Phone")
    private WebElement phoneNumberText;
    
    // Click Organizations
    public void clickOrganization() {
        organizationLink.click();
    }

    // Click Create Organization
    public void clickCreateOrganization() {
        createOrganizationBtn.click();
    }

    // Enter Organization Name
    public void enterOrganizationName(String orgName) {
        organizationNameEdt.sendKeys(orgName);
    }

    // Select Industry
    public void selectIndustry(String industry) {
        Select sel = new Select(industryDropdown);
        sel.selectByVisibleText(industry);
    }

    // Select Type
    public void selectType(String type) {
        Select sel = new Select(typeDropdown);
        sel.selectByContainsVisibleText(type);
    }

    // Click Save
    public void clickSave() {
        saveBtn.click();
    }

    // Get Header Text
    public String getHeaderText() {
        return headerText.getText();
    }

    // Get Organization Name
    public String getOrganizationDetails() {
        return organizationDetails.getText();
    }

    // Get Industry
    public String getIndustry() {
        return industryText.getText();
    }

    // Get Type
    public String getType() {
        return typeText.getText();
    }
 // Enter Phone Number
    public void enterPhoneNumber(String number) {
        phoneNumberEdt.sendKeys(number);
    }

    // Get Phone Number
    public String getPhoneNumber() {
        return phoneNumberText.getText();
    }
}