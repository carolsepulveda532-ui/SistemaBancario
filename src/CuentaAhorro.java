public class CuentaAhorro extends CuentaBancaria {

    String fechaApertura;

    public CuentaAhorro(String numeroCuenta, String titular, double saldoInicial, String fechaApertura) {
        super(numeroCuenta, titular, saldoInicial, 2.5);

        if (saldoInicial < 10000) {
            throw new IllegalArgumentException("El saldo minimo para abrir una Cuenta de Ahorro es $10,000.");
        }

        this.fechaApertura = fechaApertura;
    }

    @Override
    public void retirar(double monto) {
        if (monto <= 0) {
            System.out.println("Error: el monto a retirar debe ser positivo.");
            return;
        }
        if (monto > getSaldo()) {
            System.out.println("Error: saldo insuficiente en la cuenta " + getNumeroCuenta());
            return;
        }
        setSaldo(getSaldo() - monto);
        System.out.println("Retiro exitoso de $" + monto + ". Nuevo saldo: $" + getSaldo());
    }

    @Override
    public void mostrarInfo() {
        System.out.println("--- Cuenta de Ahorro ---");
        super.mostrarInfo();
        System.out.println("Fecha de apertura: " + fechaApertura);
    }
}