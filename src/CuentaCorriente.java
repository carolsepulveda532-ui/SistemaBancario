public class CuentaCorriente extends CuentaBancaria {

    double limiteSobregiro;
    double porcentajeComisionSobregiro;

    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial,
                           double limiteSobregiro, double porcentajeComisionSobregiro) {
        super(numeroCuenta, titular, saldoInicial, 0.0);
        this.limiteSobregiro = limiteSobregiro;
        this.porcentajeComisionSobregiro = porcentajeComisionSobregiro;
    }

    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial) {
        this(numeroCuenta, titular, saldoInicial, 50000, 5.0);
    }

    @Override
    public void retirar(double monto) {
        if (monto <= 0) {
            System.out.println("Error: el monto a retirar debe ser positivo.");
            return;
        }
        if (monto > getSaldo() + limiteSobregiro) {
            System.out.println("Error: el retiro supera el limite de sobregiro en la cuenta " + getNumeroCuenta());
            return;
        }

        double nuevoSaldo = getSaldo() - monto;
        setSaldo(nuevoSaldo);
        System.out.println("Retiro exitoso de $" + monto);

        if (nuevoSaldo < 0) {
            double montoSobregirado = -nuevoSaldo;
            double comision = montoSobregirado * (porcentajeComisionSobregiro / 100);
            setSaldo(getSaldo() - comision);
            System.out.println("Comision por sobregiro: $" + comision);
        }

        System.out.println("Nuevo saldo: $" + getSaldo());
    }

    @Override
    public void mostrarInfo() {
        System.out.println("--- Cuenta Corriente ---");
        super.mostrarInfo();
        System.out.println("Limite de sobregiro: $" + limiteSobregiro);
    }
}
