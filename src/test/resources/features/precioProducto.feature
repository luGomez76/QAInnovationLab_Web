#language: es
@testfeature
Característica: Product - Store
  Yo, como usuario
  Quiero, tener una opcion para poder inciar sesion
  Para elegir items y añadirlos a mi carrito de compras

  @testPrecioProducto
  Escenario: Validacion del precio de un producto
    Dado estoy en la pagina de la tienda
    Y me logueo con mi usuario "gomezlu76@gmail.com" y clave "techGIRL2024!"
    Cuando navego a la categoria "Clothes" y subcategoria "Men"
    Y agrego 2 unidades del primer producto al carrito
    Entonces valido en el popup la confirmacion del producto agregado
    Y valido en el popup que el monto total sea calculado correctamente
    Cuando finalizo la compra
    Entonces valido el titulo de la pagina del carrito
    Y vuelvo a validar el calculo de precios en el carrito