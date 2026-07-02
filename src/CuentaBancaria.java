public abstract class CuentaBancaria {

    private String numeroCuenta;
    private String titular;
    private double saldo;
    private double tasaInteres;

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial, double tasaInteres) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo.");
        }
        if (tasaInteres < 0) {
            throw new IllegalArgumentException("La tasa de interes no puede ser negativa.");
        }

        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
        this.tasaInteres = tasaInteres;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    protected void setSaldo(double nuevoSaldo) {
        this.saldo = nuevoSaldo;
    }

    public void depositar(double monto) {
        if (monto <= 0) {
            System.out.println("Error: el monto a depositar debe ser positivo.");
            return;
        }
        saldo = saldo + monto;
        System.out.println("Deposito exitoso de $" + monto + ". Nuevo saldo: $" + saldo);
    }

    public abstract void retirar(double monto);

    public void aplicarInteres() {
        double interes = saldo * (tasaInteres / 100);
        saldo = saldo + interes;
        System.out.println("Interes generado en cuenta " + numeroCuenta + ": $" + interes + ". Nuevo saldo: $" + saldo);
    }

    public void mostrarInfo() {
        System.out.println("Numero de cuenta: " + numeroCuenta);
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: $" + saldo);
        System.out.println("Tasa de interes: " + tasaInteres + "%");
    }
}
