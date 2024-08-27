package com.nttdata.steps;

import com.nttdata.page.InventoryPage;
import com.nttdata.page.LoginPage;
import com.nttdata.page.precioProductoPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class precioProductoSteps {

    private WebDriver driver;

    //constructor
    public precioProductoSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Redireccionamiento al login
     */
    public void goLogin() {this.driver.findElement(precioProductoPage.goLoginButton).click();}

    /**
     * Escribir el usuario
     * @param user el usuario
     */
    public void typeUser(String user){
        WebElement userInputElement = driver.findElement(precioProductoPage.userInput);
        userInputElement.sendKeys(user);
        //espera implicita, simplemente espera 444 segundos
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        //espera explicita, espera 40 segundos hasta encontrar el boton de login
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(precioProductoPage.loginButton));
    }

    /**
     * Escribir el password
     * @param password el password del usuario
     */
    public void typePassword(String password){
        this.driver.findElement(precioProductoPage.passInput).sendKeys(password);
    }

    /**
     * Hacer click en el botón login
     */
    public void login(){
        this.driver.findElement(precioProductoPage.loginButton).click();
    }



    public void goCategorias(String categoria) {
            this.driver.findElement(precioProductoPage.categoriaClothes).click();
    }

    public void goSubCategorias(String subcategoria) {
            this.driver.findElement(precioProductoPage.subCategoriaMen).click();
    }

    public void goPrimerProducto() {
        this.driver.findElement(precioProductoPage.primerProducto).click();
    }
    public void masProducto() {
        this.driver.findElement(precioProductoPage.masProducto).click();
    }

    public void addCarrito() {
        this.driver.findElement(precioProductoPage.addCarrito).click();
    }
    public String getTituloPopUp(){
        return this.driver.findElement(precioProductoPage.tituloPopUp).getText();
        //return this.driver.findElement(InventoryPage.productsTitle).getText();
    }
    public void finCompra() {
        this.driver.findElement(precioProductoPage.finCompra).click();
    }
    public void cerrarModal() {
        this.driver.findElement(precioProductoPage.cerrarModal).click();
    }
    public String titleCarrito(){
        return this.driver.findElement(precioProductoPage.titleCarrito).getText();
    }
    public String precio(){
        return this.driver.findElement(precioProductoPage.precio).getText();
    }
    public String cantidad(){
        return this.driver.findElement(precioProductoPage.precio).getAttribute("value");
    }
    public String total(){
        return this.driver.findElement(precioProductoPage.precio).getText();
    }

}
