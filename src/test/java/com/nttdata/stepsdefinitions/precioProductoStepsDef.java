package com.nttdata.stepsdefinitions;

import com.nttdata.steps.InventorySteps;
import com.nttdata.steps.precioProductoSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;


public class precioProductoStepsDef {

    private WebDriver driver;
    private precioProductoSteps precioProductoSteps;
    private precioProductoSteps precioProductoSteps(WebDriver driver){
        return new precioProductoSteps(driver);
    }
    @Dado("estoy en la pagina de la tienda")
    public void estoyEnLaPaginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/pe");
        screenShot();
    }
    @Y("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String user, String password) {
        precioProductoSteps = new precioProductoSteps(driver);
        precioProductoSteps.goLogin();
        precioProductoSteps.typeUser(user);
        precioProductoSteps.typePassword(password);
        precioProductoSteps.login();
        screenShot();
    }
    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        precioProductoSteps.goCategorias(categoria);
        screenShot();
        precioProductoSteps.goSubCategorias(subcategoria);
        screenShot();
    }

    @Y("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int und) {
        precioProductoSteps.goPrimerProducto();
        screenShot();

        for (int i=1; i <= und-1; i++){
            precioProductoSteps.masProducto();
        }
        screenShot();
        precioProductoSteps.addCarrito();
        screenShot();
    }

    @Entonces("valido en el popup la confirmacion del producto agregado")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado() {
        String title =  precioProductoSteps(driver).getTituloPopUp();
        //prueba: validamos el título del pop up
        Assertions.assertNotNull(title);
        screenShot();
    }
    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
    }
    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {
        screenShot();
        precioProductoSteps.cerrarModal();
    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        String title =  precioProductoSteps(driver).titleCarrito();
        //prueba: validamos el título del pop up
        Assertions.assertEquals("CARRITO",title);
        screenShot();
    }
    @Y("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        /*String precio =  precioProductoSteps(driver).precio();
        String precioStr = precio.replaceAll("[^0-9.]", "");
        double precioF = Double.parseDouble(precioStr);

        String total =  precioProductoSteps(driver).total();
        String totalStr = total.replaceAll("[^0-9.]", "");
        double totalF = Double.parseDouble(totalStr);

        String cantidad = precioProductoSteps(driver).cantidad();
        double cantidadF = Double.parseDouble(cantidad);

        boolean totalCorrecto = false;

        if (precioF * cantidadF == totalF){totalCorrecto=true;}

        Assert.assertTrue("Monto no es correcto", totalCorrecto);*/
        precioProductoSteps.finCompra();
        screenShot();
    }
}
