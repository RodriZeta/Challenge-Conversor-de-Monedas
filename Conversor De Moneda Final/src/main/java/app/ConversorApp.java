package app;

import java.util.*;

public class ConversorApp {
    private static final List<String> historial = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n🌎 Bienvenido al Conversor de Monedas Alura");
            System.out.println("Seleccione una opción de conversión:");
            System.out.println("1) Peso chileno (CLP) → Dólar estadounidense (USD)");
            System.out.println("2) Dólar estadounidense (USD) → Peso chileno (CLP)");
            System.out.println("3) Peso argentino (ARS) → Dólar estadounidense (USD)");
            System.out.println("4) Dólar estadounidense (USD) → Peso argentino (ARS)");
            System.out.println("5) Real brasileño (BRL) → Dólar estadounidense (USD)");
            System.out.println("6) Dólar estadounidense (USD) → Real brasileño (BRL)");
            System.out.println("7) Ver historial de conversiones");
            System.out.println("8) Agregar una nueva conversión personalizada");
            System.out.println("9) Salir");

            System.out.print("\nIngrese su opción (1-9): ");
            int opcion;
            if (!scanner.hasNextInt()) {
                System.out.println("❌ Entrada inválida. Debe ser un número entre 1 y 9.");
                scanner.next();
                continue;
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            String origen = "", destino = "";

            switch (opcion) {
                case 1: origen = "CLP"; destino = "USD"; break;
                case 2: origen = "USD"; destino = "CLP"; break;
                case 3: origen = "ARS"; destino = "USD"; break;
                case 4: origen = "USD"; destino = "ARS"; break;
                case 5: origen = "BRL"; destino = "USD"; break;
                case 6: origen = "USD"; destino = "BRL"; break;
                case 7:
                    mostrarHistorial();
                    continue;
                case 8:
                    System.out.print("Ingrese el código de la moneda de origen (ej: USD): ");
                    origen = scanner.nextLine().trim().toUpperCase();
                    System.out.print("Ingrese el código de la moneda de destino (ej: CLP): ");
                    destino = scanner.nextLine().trim().toUpperCase();
                    break;
                case 9:
                    continuar = false;
                    System.out.println("👋 Muchas Gracias por usar el conversor de Monedas. ¡Hasta pronto!");
                    continue;
                default:
                    System.out.println("❌ Opción fuera de rango.");
                    continue;
            }

            System.out.print("Ingrese el monto a convertir: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("❌ Monto inválido. Debe ser un número.");
                scanner.next();
                continue;
            }

            double monto = scanner.nextDouble();
            if (monto <= 0) {
                System.out.println("❌ El monto debe ser mayor que cero.");
                continue;
            }

            try {
                double tasa = ApiConversor.obtenerTasa(origen, destino);
                double resultado = monto * tasa;

                String resultadoTexto = String.format("%.2f %s = %.2f %s", monto, origen, resultado, destino);
                historial.add(resultadoTexto);

                System.out.printf("\n💰 Resultado: %s\n", resultadoTexto);

            } catch (Exception e) {
                System.out.println("⚠️ Error durante la conversión: " + e.getMessage());
            }

            System.out.print("\n¿Desea realizar otra conversión? (s/n): ");
            String respuesta = scanner.next().toLowerCase();
            continuar = respuesta.equals("s");
        }

        scanner.close();
    }

    private static void mostrarHistorial() {
        System.out.println("\n📜 Historial de conversiones:");
        if (historial.isEmpty()) {
            System.out.println("(No hay conversiones registradas)");
        } else {
            for (int i = 0; i < historial.size(); i++) {
                System.out.println((i + 1) + ". " + historial.get(i));
            }
        }
    }
}
