### Ecommerce
> La practica consiste en hacer un funcionamiento de una tienda con distintos metodos de pago:
- Bizum
- Tarjeta
- Paypal

## Estructuras del proyecto

# AppEcommerce
````
package org.example.Ecommerce;

/**
 * Clase principal que inicia la aplicación de Ecommerce.
 */
public class AppEccomerce {

    /**
     * Método principal que inicia el proceso de pago.
     */
    public static void main(String[] args) {
        Tienda.iniciarPago();
    }
}
````
# Bizum
````
package org.example.Ecommerce;

import java.util.Random;
import java.util.Scanner;

/**
 * Pagar con bizum
 */
public class Bizum extends MetodoPago {

    static Random random = new Random();
    static Scanner entrada = new Scanner(System.in);

    private String telefono;
    private int pin;

    /**
     * Constructor que genera un PIN y valida el pago.
     * @param telefono número de teléfono asociado
     */
    public Bizum(String telefono) {
        this.telefono = telefono;
        this.pin = generarPin();
        validarBizum(entrada.nextInt());
    }

    /**
     * Genera un PIN aleatorio de 6 cifras.
     * @return PIN generado
     */
    public static int generarPin() {
        int pin = random.nextInt(100000, 999999);
        System.out.println(pin);
        return pin;
    }

    /**
     * Valida el número de teléfono y el PIN introducido.
     * @param pin PIN introducido por el usuario
     */
    public void validarBizum(int pin) {
        System.out.println("Validando bizum:");
        if (telefono.matches("[0-9]{9}") && this.pin == pin) {
            System.out.println("Pin correcto");
        } else {
            System.out.println("Error");

        }
    }

    @Override
    void procesarPago(double importe) {
        System.out.println("Procesando pago de " + importe + "€ con Bizum.");
    }

    @Override
    public String toString() {
        return "Bizum{" +
                "telefono='" + telefono + '\'' +
                ", pin=" + pin +
                '}';
    }
}

````
# MetodoPago
````
package org.example.Ecommerce;

/**
 * Clase abstracta que define el comportamiento común
 * de todos los métodos de pago.
 */
abstract class MetodoPago {

    /**
     * Procesa un pago con el importe indicado.
     * @param importe cantidad a pagar
     */
    abstract void procesarPago(double importe);
}

````

# PayPal
````
package org.example.Ecommerce;

import java.util.Scanner;

/**
 * Pagar con Paypal.
 */
public class PayPal extends MetodoPago {

    static Scanner entrada = new Scanner(System.in);

    final double saldoPre = 23;
    private String cuenta;
    private double saldo;

    /**
     * Constructor que permite indicar cuenta y saldo.
     * @param cuenta correo asociado a la cuenta
     * @param saldo saldo disponible
     */
    public PayPal(String cuenta, double saldo) {
        this.saldo = saldo;
        this.cuenta = cuenta;
    }

    /**
     * Constructor que asigna un saldo predeterminado.
     * @param cuenta correo asociado a la cuenta
     */
    public PayPal(String cuenta) {
        this.cuenta = cuenta;
        this.saldo = saldoPre;
    }

    /**
     * Valida el formato del correo y el saldo disponible.
     * @param cuenta correo electrónico
     * @param importe importe a pagar
     * @return true si la validación es correcta
     */
    private boolean validarPayPal(String cuenta, double importe) {
        System.out.println("Validando cuenta:");
        if (cuenta.matches(".*@*.com") && importe <= saldo) {
            return true;
        }
        System.out.println("Datos incorrectos o saldo insuficiente.");
        return false;
    }

    @Override
    void procesarPago(double importe) {
        System.out.println("Procesando pago de " + importe + "€ con PayPal");
        if (validarPayPal(this.cuenta, importe)) {
            System.out.println("Pago aceptado.");
        }
    }

    @Override
    public String toString() {
        return "PayPal: cuenta: " + cuenta + ", saldo: " + saldo;
    }
}

````

# TarjetaCredito
````
package org.example.Ecommerce;

/**
 * Pagar con tarjeta de credito
 */
public class TarjetaCredito extends MetodoPago {

    private String nro_tarjeta;
    private String tipo;

    /**
     * Constructor que crea una tarjeta y valida sus datos.
     * @param nro_tarjeta número de tarjeta (16 dígitos)
     * @param tipo tipo de tarjeta (VISA, MASTERCARD o MAESTRO)
     */
    public TarjetaCredito(String nro_tarjeta, String tipo) {
        this.nro_tarjeta = nro_tarjeta;
        this.tipo = tipo;
        validarTarjeta(nro_tarjeta, tipo);
    }

    /**
     * Validar el número y tipo de tarjeta.
     * @param nro_tarjeta número de tarjeta
     * @param tipo tipo de tarjeta
     */
    private void validarTarjeta(String nro_tarjeta, String tipo) {
        System.out.println("Validando tarjeta:");
        if (nro_tarjeta.matches("\\d{16}") &&
                (tipo.equalsIgnoreCase("VISA") ||
                        tipo.equalsIgnoreCase("MASTERCARD") ||
                        tipo.equalsIgnoreCase("MAESTRO"))) {
            return;
        }
        System.out.println("Los datos de tu tarjeta no son correctos.");

    }

    @Override
    void procesarPago(double importe) {
        System.out.println("Procesando pago de " + importe + "€ con tarjeta de crédito " + tipo);
    }

    @Override
    public String toString() {
        return "TarjetaCredito{" +
                "nro_tarjeta='" + nro_tarjeta + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
````

# Tienda
````
package org.example.Ecommerce;

import java.util.Scanner;

/**
 * Clase que gestiona el proceso de pago en la tienda.
 */
public class Tienda {

    static Scanner entrada = new Scanner(System.in);

    /**
     * Ejecuta el pago usando el método seleccionado.
     * @param metodo método de pago
     * @param importe importe a pagar
     */
    static void realizarPago(MetodoPago metodo, double importe) {
        metodo.procesarPago(importe);
    }

    /**
     * Inicia el proceso de selección del método de pago.
     */
    static void iniciarPago() {
        System.out.println("¿Qué método de pago quieres usar? [Bizum, PayPal, Tarjeta]:");
        volver:
        while (true) {
            String metodo = entrada.nextLine().toLowerCase();
            switch (metodo) {
                case "tarjeta":
                    procesoTarjeta();
                    break volver;
                case "paypal":
                    procesoPayPal();
                    break volver;
                case "bizum":
                    procesoBizum();
                    break volver;
                default:
                    System.out.println("Introduce de nuevo el tipo de pago:");
            }
        }
    }

    /**
     * Gestiona el proceso de pago con tarjeta.
     */
    private static void procesoTarjeta() {
        System.out.println("Introduce los datos de tu tarjeta:");
        System.out.println("Número (16 dígitos):");
        String nro_tarjeta = entrada.next();
        System.out.println("tipo (VISA , MASTERCARD o MAESTRO):");
        String tipo = entrada.next().toUpperCase();
        MetodoPago tarjeta = new TarjetaCredito(nro_tarjeta, tipo);
        System.out.println("Introduce el importe a pagar:");
        realizarPago(tarjeta, entrada.nextDouble());
    }

    /**
     * Gestiona el proceso de pago con Bizum.
     */
    private static void procesoBizum() {
        System.out.println("Introduzca su número de teléfono:");
        String telefono = entrada.next();
        System.out.println("Introduzca el pin:");
        MetodoPago bizum = new Bizum(telefono);
        System.out.println("Introduce el importe a pagar:");
        realizarPago(bizum, entrada.nextDouble());
    }

    /**
     * Gestiona el proceso de pago con PayPal.
     */
    private static void procesoPayPal() {
        System.out.println("Introduzca el mail asociado a la cuenta:");
        String cuenta = entrada.next();
        MetodoPago paypal = new PayPal(cuenta);
        System.out.println("Introduzca el importe a pagar:");
        realizarPago(paypal, entrada.nextDouble());
    }
}

````

#PUML
![Foto](src/main/java/org/example/Eccomerce/Ecommerce.puml)



