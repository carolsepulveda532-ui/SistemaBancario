public class TestBanco {

    public static void main(String[] args) {

        System.out.println("=== PASO 1: CREACION DE CUENTAS ===");

        CuentaAhorro cuentaAna = new CuentaAhorro("AH001", "Ana Perez", 50000, "2024-01-15");
        CuentaCorriente cuentaLuis = new CuentaCorriente("CC001", "Luis Gomez", 20000);
        CuentaEmpresarial cuentaTech = new CuentaEmpresarial("EM001", "Tech Solutions", 200000, "Tech Solutions", "123456789-0");
        CuentaAhorro cuentaMaria = new CuentaAhorro("AH002", "Maria Lopez", 15000, "2024-02-01");

        System.out.println("Cuentas creadas.\n");

        System.out.println("=== PASO 2: INFORMACION INICIAL ===");
        cuentaAna.mostrarInfo();
        System.out.println();
        cuentaLuis.mostrarInfo();
        System.out.println();
        cuentaTech.mostrarInfo();
        System.out.println();
        cuentaMaria.mostrarInfo();
        System.out.println();

        System.out.println("=== PASO 3: OPERACIONES ===");

        System.out.println("Ana Perez deposita $10,000");
        cuentaAna.depositar(10000);

        System.out.println("Luis Gomez retira $25,000");
        cuentaLuis.retirar(25000);

        System.out.println("Tech Solutions retira $10,000");
        cuentaTech.retirar(10000);

        System.out.println("Maria Lopez intenta retirar $20,000");
        cuentaMaria.retirar(20000);

        System.out.println("=== PASO 4: APLICAR INTERESES ===");
        cuentaAna.aplicarInteres();
        cuentaLuis.aplicarInteres();
        cuentaTech.aplicarInteres();
        cuentaMaria.aplicarInteres();

        System.out.println("=== PASO 5: ESTADO FINAL ===");
        cuentaAna.mostrarInfo();
        System.out.println();
        cuentaLuis.mostrarInfo();
        System.out.println();
        cuentaTech.mostrarInfo();
        System.out.println();
        cuentaMaria.mostrarInfo();
        System.out.println();

        System.out.println("=== PASO 6: RESUMEN ===");

        int totalCuentas = 4;
        double saldoTotal = cuentaAna.getSaldo() + cuentaLuis.getSaldo() + cuentaTech.getSaldo() + cuentaMaria.getSaldo();
        double promedio = saldoTotal / totalCuentas;

        System.out.println("Total de cuentas: " + totalCuentas);
        System.out.println("Saldo total: $" + saldoTotal);
        System.out.println("Promedio de saldo: $" + promedio);

        CuentaBancaria cuentaMayorSaldo = cuentaAna;

        if (cuentaLuis.getSaldo() > cuentaMayorSaldo.getSaldo()) {
            cuentaMayorSaldo = cuentaLuis;
        }
        if (cuentaTech.getSaldo() > cuentaMayorSaldo.getSaldo()) {
            cuentaMayorSaldo = cuentaTech;
        }
        if (cuentaMaria.getSaldo() > cuentaMayorSaldo.getSaldo()) {
            cuentaMayorSaldo = cuentaMaria;
        }

        System.out.println("Cuenta con mayor saldo: " + cuentaMayorSaldo.getNumeroCuenta()
                + " - " + cuentaMayorSaldo.getTitular() + " - $" + cuentaMayorSaldo.getSaldo());
    }
}