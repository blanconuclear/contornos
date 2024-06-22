package selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FormTest {

    static ChromeDriver driver;

    // TODO 0: Método que se debe ejecutar siempre antes de cualquier otro método
    @BeforeAll
    public static void setUp() {

        // TODO: 1. Inicializar objeto driver para que abra una ventana en Chrome
        ChromeDriver driver = new ChromeDriver();
        driver.

        // TODO: 2. Abrir página. Poner la ruta absoluta del fichero index_completo.html
        driver.get(
                "file:///home/sanclemente.local/daw1fpdcd2/Descargas/CD_Selenium_Recuperacion_2Ev/src/test/java/selenium/index_completo.html");

    }

    /**
     * En este test comprobaremos si se procesa el formulario enviando el nombre y
     * la password únicamente.
     */
    @Test
    public void testNombrePass() {

        // TODO 3: Recupera los elementos nombre y apellidos. Completar con el nombre
        // Julia Seaone Pérez.
        WebElement nombre = driver.findElement(By.id("nombre"));
        WebElement apellidos = driver.findElement(By.id("apellido"));

        nombre.sendKeys("Julia");
        apellidos.sendKeys("Seaone Pérez");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // TODO 4: Enviar formulario

        WebElement bnt = driver.findElement(By.id("enviar"));
        bnt.click();

        // TODO 5: Comprobar con Junit que el formulario se ha enviado correctamente

        WebElement h1 = driver.findElement(By.tagName("h1"));
        assertEquals("Te has inscrito correctamente!", h1.getText());
    }

    @Test
    public void testRadio() {

        // TODO: 6. Chequea el sexo femenino
        WebElement sexo = driver.findElement(By.tagName("f"));
        sexo.click();
        // TODO 7: Esperamos 2 segundos para poder visualizar las acciones ejecutadas
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // TODO 8: Recupera el textarea y completa con la frase "Examen recuperación
        // segunda evaluación"

        // TODO 9: Enviar formulario
        WebElement bnt = driver.findElement(By.id("enviar"));
        bnt.click();
    }

    @Test
    public void testCheckbox() {

        // TODO 9: Acepta los términos y condiciones
        WebElement check = driver.findElement(By.className("checkbox"));
        check.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // TODO 10: Comprueba con Junit que los dos están seleccionados

        WebElement bnt = driver.findElement(By.id("enviar"));
        bnt.click();

    }

    @Test
    public void testSelect() throws InterruptedException {

        // TODO 11: Selecciona la opción Perro
        Select multi = new Select(driver.findElement(By.tagName("Mascota:")));
        multi.selectByIndex(0);
        // TODO 12: Esperamos 2 segundos para poder visualizar las acciones ejecutadas
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // TODO 15: Este método se debe ejecutar siempre al final de realizar todas las
    // pruebas
    @AfterAll
    public static void setDown() {
        // TODO 16: Cerrar el driver
        driver.quit();
    }

}
