/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import java.util.HashMap;

/**
 *
 * @author eduardsuarez
 */
public class BDCuentas {

    HashMap<String, Cuenta> cuentas = new HashMap<String, Cuenta>();

    public BDCuentas() {
        cargarCuentas();
    }

    public void cargarCuentas() {

        cuentas.put("12", new Cuenta("Juan P.", "12", 0.08, 5000.0));
        cuentas.put("13", new Cuenta("Juanita P.", "13", 0.08, 25000.0));
        cuentas.put("14", new Cuenta("Paola C.", "14", 0.08, 290000.0));
        cuentas.put("15", new Cuenta("Juanita P.", "15", 0.08, 215000.0));
        cuentas.put("16", new Cuenta("Paola C.", "16", 0.08, 2900100.0));
        cuentas.put("17", new Cuenta("Juanita P.", "17", 0.08, 251000.0));
        cuentas.put("18", new Cuenta("Paola C.", "18", 0.08, 2902000.0));
        cuentas.put("19", new Cuenta("Juanita P.", "19", 0.08, 251000.0));
        cuentas.put("11", new Cuenta("Paola C.", "11", 0.08, 29000110.0));
    }

    public boolean ingresarDinero(String numeroCuenta, double monto) {
        Cuenta miCuenta = cuentas.get(numeroCuenta);
        if (miCuenta == null || monto < 0) {
            return false;
        } else {
            double valorSaldo = miCuenta.getSaldo();
            miCuenta.setSaldo(valorSaldo + monto);
            cuentas.put(numeroCuenta, miCuenta);
            return true;
        }
    }

    public boolean retirarDinero(String numeroCuenta, double monto) {
        Cuenta miCuenta = cuentas.get(numeroCuenta);
        if (miCuenta == null || monto < 0) {
            return false;
        } else {
            double valorSaldo = miCuenta.getSaldo();
            if ((valorSaldo - monto) < 0) {
                return false;
            } else {
                miCuenta.setSaldo(valorSaldo - monto);
                cuentas.put(numeroCuenta, miCuenta);
                return true;
            }
        }
    }

    public boolean transferirDinero(String cuentaOrigen, double monto, String cuentaDestino) {
        Cuenta miCuentaOrigen = cuentas.get(cuentaOrigen);
        Cuenta miCuentaDestino = cuentas.get(cuentaDestino);

        if (miCuentaOrigen == null
                || miCuentaDestino == null
                || monto < 0
                || miCuentaOrigen.equals(miCuentaDestino)
                || miCuentaOrigen.getNumeroCuenta().equals(miCuentaDestino.getNumeroCuenta())
                || monto > miCuentaOrigen.getSaldo()) {
            return false;
        } else {
            double saldoOrigen = miCuentaOrigen.getSaldo();
            double saldoDestino = miCuentaDestino.getSaldo();
            miCuentaOrigen.setSaldo(saldoOrigen - monto);
            miCuentaDestino.setSaldo(saldoDestino + monto);
            cuentas.put(cuentaOrigen, miCuentaOrigen);
            cuentas.put(cuentaDestino, miCuentaDestino);
            return true;
        }

    }

    public boolean consultarCuenta(String numeroCuenta) {
        Cuenta miCuenta = cuentas.get(numeroCuenta);
        if (miCuenta == null) {
            return false;
        } else {
            return true;
        }
    }

}
