/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package banco;

import java.util.Scanner;

/**
 *
 * @author eduardsuarez
 */
public class Main {
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scanner = new Scanner(System.in);

        BDCuentas misCuentas = new BDCuentas();
        System.err.println("ingrese nùmero de cuenta y el monto");
        String valoresOperacion = scanner.nextLine();
        System.err.println("ingrese la operación a realizar");
        String operacion = scanner.nextLine();
        String[] entradas = valoresOperacion.split(" ");
        boolean opExitosa = false;
//        System.out.println("evaluando arternativas");
        switch (operacion) {
            case "consignar":
                opExitosa = misCuentas.ingresarDinero(entradas[0], Double.parseDouble(entradas[1]));
                if (opExitosa == true) {
                    Cuenta miCuenta = misCuentas.cuentas.get(entradas[0]);
                    System.out.println("el nuevo saldo de la cuenta " + entradas[0]
                            + " es :" + miCuenta.getSaldo());
                } else {
                    System.out.println("ERROR");
                }
                break;
            case "retirar":
                opExitosa = misCuentas.retirarDinero(entradas[0], Double.parseDouble(entradas[1]));
                if (opExitosa == true) {
                    Cuenta miCuenta = misCuentas.cuentas.get(entradas[0]);
                    System.out.println("el nuevo saldo de la cuenta " + entradas[0]
                            + " es :" + miCuenta.getSaldo());
                } else {
                    System.out.println("ERROR");
                }

                break;
            case "transferir":
                opExitosa = misCuentas.transferirDinero(entradas[0], Double.parseDouble(entradas[1]), entradas[2]);
                if (opExitosa == true) {
                    Cuenta miCuenta = misCuentas.cuentas.get(entradas[0]);
                    System.out.println("el nuevo saldo de la cuenta origen " + entradas[0]
                            + " es :" + miCuenta.getSaldo());
                    miCuenta = misCuentas.cuentas.get(entradas[2]);
                    System.out.println("el nuevo saldo de la cuenta destino " + entradas[2]
                            + " es :" + miCuenta.getSaldo());
                } else {
                    System.out.println("ERROR");
                }
                break;
            case "imprimir":
                opExitosa = misCuentas.consultarCuenta(entradas[0]);
                if (opExitosa == true) {
                    Cuenta miCuenta = misCuentas.cuentas.get(entradas[0]);
                    System.out.println(miCuenta.toString());
//12
//imprimir
//grp13ejercicioseman02.Cuenta@4554617c
                } else {
                    System.out.println("ERROR");
                }
                break;
            default:
                System.out.println("ERROR");
                break;
        }
    }

}

