package com.orangehrmlive.opensourcedemo.stepdefinition.administrativemodule.job.workshifts;
import com.orangehrmlive.opensourcedemo.stepdefinition.setup.WebUI;
import com.orangehrmlive.opensourcedemo.model.admin.job.workshifts.WorkshiftsModel;
import com.orangehrmlive.opensourcedemo.page.admin.job.workshifts.Workshifts;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;


public class WorkshiftsCucumberStepDefinitions extends WebUI {
    private static final Logger LOGGER = Logger.getLogger(WorkshiftsCucumberStepDefinitions.class);
    private Workshifts workshifts;
    private WorkshiftsModel workshiftsModel;
    private int TEN_SECONDS=10;
    private static final String ASSERTION_EXCEPTION_MESSAGE = "Los valores suministrados no son los esperados.";

    @Given("El empleado ingresa a la página principal donde se le solicita usuario y contraseña este los ingresa luego de esto ira a admin luego job y work shift")
    public void elEmpleadoIngresaALaPáginaPrincipalDondeSeLeSolicitaUsuarioYContraseñaEsteLosIngresaLuegoDeEstoIraAAdminLuegoJobYWorkShift() {
        try {
            generalSetUp();
            dataConfiguration();
            workshifts = new Workshifts(driver, workshiftsModel,TEN_SECONDS);
            workshifts.fillLoginPanel();
            workshifts.pathAdminJobWorkshift();
        }catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }
    @When("El empleado seleccionara add e ingresara nombre del turno en el campo correspondiente posteriormente a esto escogerá hora de inicio y final para finalizar escoge el o los empleados que se asignaran con la operación de selecciona el empleado y se le da en add luego de esto se confirma los datos con save.")
    public void elEmpleadoSeleccionaraAddEIngresaraNombreDelTurnoEnElCampoCorrespondientePosteriormenteAEstoEscogeráHoraDeInicioYFinalParaFinalizarEscogeElOLosEmpleadosQueSeAsignaranConLaOperaciónDeSeleccionaElEmpleadoYSeLeDaEnAddLuegoDeEstoSeConfirmaLosDatosConSave() {
         try{
             workshifts.addWorkShifts();
         }catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }
    @Then("En la tabla work shifs aparecerá el turno creado.")
    public void enLaTablaWorkShifsApareceráElTurnoCreado() {
        if (workshifts.valideWorkShifts()==false){
            workshifts.DELETEWorkShifts();
            quitDriver();
        }else{
            Assertions.fail(ASSERTION_EXCEPTION_MESSAGE);
            quitDriver();
        }
    }

    private void dataConfiguration(){
        workshiftsModel = new WorkshiftsModel();
        workshiftsModel.setUsername("Admin");
        workshiftsModel.setPassword("admin123");
        workshiftsModel.setNameworkshift("Turno uno");
        workshiftsModel.setHourFrom("01:15");
        workshiftsModel.setHourTo("18:15");
    }

}
