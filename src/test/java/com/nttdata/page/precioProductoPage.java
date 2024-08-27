package com.nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class precioProductoPage {

    //Localizadores de elementos
    public static By userInput = By.id("field-email");
    public static By passInput = By.id("field-password");
    public static By loginButton = By.id("submit-login");
    public static By goLoginButton = By.xpath("//div[@class='user-info']//a[@href]");
    public static By categoriaClothes = By.xpath("//div[@id='_desktop_top_menu']//a[@href]");
    public static By subCategoriaMen = By.xpath("//ul[@class='category-sub-menu']//li//a[text()='Men']");
    public static By primerProducto = By.className("thumbnail-top");
    public static By masProducto = By.cssSelector("span.input-group-btn-vertical button.btn-touchspin.bootstrap-touchspin-up");
    public static By addCarrito = By.cssSelector("div.add button.add-to-cart");
    public static By tituloPopUp = By.className("cart-products-count");
    public static By cerrarModal = By.cssSelector("div.cart-content-btn a.btn.btn-primary");
    public static By finCompra = By.cssSelector("a.btn.btn-primary");
    public static By titleCarrito = By.cssSelector("div.card-block h1.h1");
    public static By precio = By.cssSelector("span.precio");
    public static By cantidad = By.xpath("//input[@name='product-quantity-spin']");
    public static By total = By.cssSelector("span.value");


}
