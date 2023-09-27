
package entidad;

import java.util.ArrayList;

public class CuentaBancaria {
    private String titular;
    private String numeroCuenta;
    private double saldo;
    private ArrayList<String> historialTransacciones;

    public CuentaBancaria(String titular, String numeroCuenta, double saldoInicial) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
        this.historialTransacciones = new ArrayList<>();
    }

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            historialTransacciones.add("Depósito de " + cantidad + " realizado.");
        }
    }

    public void retirar(double cantidad) {
        if (cantidad > 0) {
            if (saldo >= cantidad) {
                saldo -= cantidad;
                historialTransacciones.add("Retiro de " + cantidad + " realizado.");
            } else {
                historialTransacciones.add("Saldo insuficiente para realizar el retiro de " + cantidad + ".");
            }
        }
    }

    public void transferir(CuentaBancaria cuentaDestino, double cantidad) {
        if (cantidad > 0 && saldo >= cantidad) {
            saldo -= cantidad;
            cuentaDestino.depositar(cantidad);
            historialTransacciones.add("Transferencia de " + cantidad + " a la cuenta " + cuentaDestino.getNumeroCuenta() + " realizada.");
        }
    }

    public void consultarHistorialTransacciones() {
        System.out.println("Historial de transacciones de la cuenta " + numeroCuenta + ":");
        for (String transaccion : historialTransacciones) {
            System.out.println(transaccion);
        }
    }

    public String getTitular() {
        return titular;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }