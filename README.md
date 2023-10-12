# Readme: API de Consulta de Precios para Comercio Electrónico

## Tabla de Contenidos

- [Descripción](#descripción)
- [Requisitos](#requisitos)
- [Configuración](#configuración)
- [Uso](#uso)
- [Ejemplos de Peticiones](#ejemplos-de-peticiones)
- [Recursos](#recursos)


## Descripción

En la base de datos de comercio electrónico de la compañía, se encuentra la tabla PRICES con los siguientes campos relevantes:

| BRAND_ID |   START_DATE   |               END_DATE | PRICE_LIST |           PRODUCT_ID | PRIORITY | PRICE |  CURR |
|:---------|:--------------:|-----------------------:|-----------:|---------------------:|---------:|--------:|-------:|
| 1        | 12-31-23.59.59 |    2020-12-31-23.59.59 |          1 |                35455 |        0 | 35.50 |EUR |
| 1        | 06-14-18.30.00 |    2020-06-14-18.30.00 |          2 |                35455 |        1 | 25.45 |EUR |
| 1        | 06-15-11.00.00 |    2020-06-15-11.00.00 |          3 |                35455 |        1 | 30.50 |EUR |
| 1        | 12-31-23.59.59 |    2020-12-31-23.59.59 |          4 |                35455 |        1 | 38.95 |EUR |

- `BRAND_ID`: Identificador de la cadena de tiendas.
- `START_DATE` y `END_DATE`: Rango de fechas en el que aplica el precio tarifa indicado.
- `PRICE_LIST`: Identificador de la tarifa de precios aplicable.
- `PRODUCT_ID`: Identificador del producto.
- `PRIORITY`: Desambiguador de aplicación de precios. Se aplica la tarifa con la mayor prioridad si dos coinciden en un rango de fechas.
- `PRICE`: Precio final de venta.
- `CURR`: ISO de la moneda.


Se pide:

Construir una aplicación/servicio en SpringBoot que provea una end point rest de consulta  tal que:

Acepte como parámetros de entrada: fecha de aplicación, identificador de producto, identificador de cadena.
Devuelva como datos de salida: identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicación y precio final a aplicar.

Se debe utilizar una base de datos en memoria (tipo h2) e inicializar con los datos del ejemplo, (se pueden cambiar el nombre de los campos y añadir otros nuevos si se quiere, elegir el tipo de dato que se considere adecuado para los mismos).

Desarrollar unos test al endpoint rest que validen las siguientes peticiones al servicio con los datos del ejemplo:
## Requisitos

Para ejecutar se requiere usar Java que tiene por defecto IntelliJ en la versión:

- Java 17
- Maven 

## Configuración

1. Clona este repositorio en tu máquina local:

   ```
   git clone https://github.com/JBEortiz/test-technical-inditex.git
   ```

2. En el directorio raíz del proyecto, puedes compilar la aplicación y ejecutar los tests con el siguiente comando:

   ```
   mvn clean install
   ```


Puerto donde se ejecuta la aplicación: `http://localhost:8080`.

## Uso

La API REST proporciona un único endpoint:

- `GET /inditex/technical-test/prices`: Permite consultar los precios de productos. Los parámetros de entrada son la fecha de aplicación, el identificador de producto y el identificador de cadena. La respuesta incluye toda la información sobre la tarifa a aplicar, la fecha actual y el precio final a aplicar.



### Request:

```json

{
  "currentDate": "2020-06-14T23:59:59",
  "productId": 35455,
  "brandId": 1
}

```

### Response:

```json

{
  "currentDate": "2020-06-14T23:59:59",
  "brandId": 1,
  "brandName": "ZARA",
  "priceList": 1,
  "productId": 35455,
  "price": 35.5,
  "curr": "EUR"
}

```


## Ejemplos de Peticiones

Los casos de prueba para el método GET al endpoint `/inditex/technical-test/prices` para consultar los precios de los productos son los siguientes:


1. Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
2. Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
3. Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
4. Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
5. Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)

## Recursos

Lombok : [https://projectlombok.org/](https://projectlombok.org/)
                     
Mapstruct : [https://mapstruct.org/](https://mapstruct.org/)
                     
Spring Init : [https://start.spring.io/](https://start.spring.io/)




