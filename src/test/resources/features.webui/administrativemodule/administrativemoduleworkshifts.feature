Feature: Yo como usuario ingreso a la página y cuando ingrese deseo ir a admin,job y work shift donde  se creará un turno y al mismo se le asignaran empleados.
  Scenario: Crear un turno de empleados y añadir empleados al turno.
    Given El empleado ingresa a la página principal donde se le solicita usuario y contraseña este los ingresa luego de esto ira a admin luego job y work shift
    When El empleado seleccionara add e ingresara nombre del turno en el campo correspondiente posteriormente a esto escogerá hora de inicio y final para finalizar escoge el o los empleados que se asignaran con la operación de selecciona el empleado y se le da en add luego de esto se confirma los datos con save.
    Then En la tabla work shifs aparecerá el turno creado.
