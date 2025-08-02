# Challenge-Conversor-de-Monedas
App final de Conversor de Monedas

Aplicación de consola desarrollada en Java que permite convertir entre distintas monedas en tiempo real usando la API [ExchangeRate-API](https://www.exchangerate-api.com/).

---

## 📌 Características

- Consulta actualizada de tasas de cambio.
- Conversión entre:
  - Peso chileno (CLP)
  - Peso argentino (ARS)
  - Real brasileño (BRL)
  - Dólar estadounidense (USD)
- Opción de conversión personalizada entre cualquier par de monedas.
- Historial de conversiones dentro de la sesión.
- Posee validación de datos para el no ingreso de Letras o números negativos

---

## 🛠️ Tecnologías usadas

- Java 17+
- Maven
- [Gson](https://github.com/google/gson) (para manipulación de JSON)
- API: [https://v6.exchangerate-api.com](https://v6.exchangerate-api.com)

---

## 🚀 Cómo ejecutar

1. **Clona el repositorio:**

```bash
git clone https://github.com/tu-usuario/conversor-moneda.git
cd conversor-moneda
```

2. **Importa el proyecto en IntelliJ IDEA como proyecto Maven.**

3. **Agrega tu API KEY** en la clase `ApiConversor.java` (ya viene con una clave de prueba):

```java
private static final String API_KEY = "TU_API_KEY_AQUI";
```

4. **Ejecuta la clase `ConversorApp.java`.**

---

## 🎮 Ejemplo de uso

```
🌎 Bienvenido al Conversor de Monedas
1) CLP → USD
2) USD → CLP
...
8) Conversión personalizada
9) Salir

Ingrese su opción: 1
Ingrese el monto a convertir: 10000

💰 Resultado: 10000.00 CLP = 11.20 USD
```


Puede incluirse nuevas monedas indicando su denominación y su nombre

---

## 🧠 Autor

Desarrollado por **Rodrigo Zúñiga** como parte del programa **Oracle Next Education (ONE) - Alura LATAM**.

---

## 📄 Licencia

Este proyecto se distribuye bajo la licencia MIT. Puedes usarlo, modificarlo y compartirlo libremente.



## 📄 Versiones

Primera Versión 15 de Julio de 2025
