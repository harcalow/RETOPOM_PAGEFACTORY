package com.orangehrmlive.opensourcedemo.page.admin.job.workshifts;

import com.orangehrmlive.opensourcedemo.page.common.CommonActionsOnPages;
import com.orangehrmlive.opensourcedemo.model.admin.job.workshifts.WorkshiftsModel;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.cucumber.messages.internal.com.google.common.base.StandardSystemProperty.USER_DIR;

public class Workshifts extends CommonActionsOnPages {

    private WorkshiftsModel workshiftsModel;
    private static final String PAGE_BASE_PATCH = USER_DIR.value() + "\\src\\main\\resources\\";
    private static final String SELECT_PICTURE_PATCH_DELETE = PAGE_BASE_PATCH + "page.admin.job.workshifts\\EliminarTurno.PNG";
    private static final String SELECT_PICTURE_PATCH_OK = PAGE_BASE_PATCH + "page.admin.job.workshifts\\OK.PNG";
    private static final Logger LOGGER = Logger.getLogger(Workshifts.class);
    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo.";
    //For input test cases.
    @FindBy(id = "txtUsername")
    @CacheLookup
    private WebElement username;

    @FindBy(id = "txtPassword")
    @CacheLookup
    private WebElement password;

    @FindBy(id = "btnLogin")
    @CacheLookup
    private WebElement submit;

    @FindBy(xpath = "//*[@id=\"menu_admin_viewAdminModule\"]/b")
    @CacheLookup
    private WebElement adminHome;

    @FindBy(id = "menu_admin_Job")
    @CacheLookup
    private WebElement menuAdminJob;

    @FindBy(id = "menu_admin_workShift")
    @CacheLookup
    private WebElement menuAdminWorkShift;

    @FindBy(id = "btnAdd")
    @CacheLookup
    private WebElement addWorkShifts ;

    @FindBy(id = "workShift_name")
    private WebElement nameWorkShift ;

    @FindBy(xpath = "//*[@id=\"workShift_availableEmp\"]/option[1]")
    @CacheLookup
    private WebElement  workerOne;

    @FindBy(xpath = "//*[@id=\"workShift_assignedEmp\"]/option[1]")
    @CacheLookup
    private WebElement  workerOneAssigned;


    @FindBy(id = "btnAssignEmployee")
    @CacheLookup
    private WebElement btnAssignEmployee ;

    @FindBy(id = "btnSave")
    @CacheLookup
    private WebElement btnSave ;

    @FindBy(id = "workShiftHeading")
    @CacheLookup
    private WebElement workShiftHeading ;

    @FindBy(id = "btnDelete")
    @CacheLookup
    private WebElement btnDelete ;


    public Workshifts(WebDriver driver, WorkshiftsModel workshiftsModel) {
        super(driver);
        pageFactoryInitElement(driver, this);
    }
    public Workshifts(WebDriver driver, WorkshiftsModel workshiftsModel, int secondsForExplicitWait) {
        super(driver, secondsForExplicitWait);
        this.workshiftsModel = workshiftsModel;
        pageFactoryInitElement(driver, this);

    }

    public void fillLoginPanel() throws IOException {
        clear(username);
        typeInto(username, workshiftsModel.getUsername());

        clear(password);
        typeInto(password, workshiftsModel.getPassword());

        clickOn(submit);

    }
    public void pathAdminJobWorkshift(){
        clickOn(adminHome);
        clickOn(menuAdminJob);
        clickOn(menuAdminWorkShift);
    }

    public void addWorkShifts(){
        clickOn(addWorkShifts);
        clear(nameWorkShift);
        typeInto(nameWorkShift, workshiftsModel.getNameworkshift());
        clickOn(By.xpath("//*[@id=\"workShift_workHours_from\"]/option[. = '" + workshiftsModel.getHourFrom() + "']"));
        clickOn(By.xpath("//*[@id=\"workShift_workHours_to\"]/option[. = '" + workshiftsModel.getHourTo() + "']"));
        clickOn(workerOne);
        clickOn(btnAssignEmployee);
        clickOn(btnSave);
    }

    public boolean valideWorkShifts(){
    return isDisplayed(nameWorkShift);
    }

    public void DELETEWorkShifts(){
        clickOn(SELECT_PICTURE_PATCH_DELETE);
        clickOn(btnDelete);
        clickOn(SELECT_PICTURE_PATCH_OK);
    }


}
