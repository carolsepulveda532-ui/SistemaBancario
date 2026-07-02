public class CuentaEmpresarial extends CuentaBancaria {

    String nombreEmpresa;
    String rut;
    double comisionRetiro;

    public CuentaEmpresarial(String numeroCuenta, String titular, double saldoInicial,
                             String nombreEmpresa, String rut) {
        super(numeroCuenta, titular, saldoInicial, 1.5);

        if (saldoInicial < 100000) {
            throw new IllegalArgumentException("El saldo minimo para abrir una Cuenta Empresarial es $100,000.");
        }

        this.nombreEmpresa = nombreEmpresa;
        this.rut = rut;
        this.comisionRetiro = 2000;
    }

    @Override
    public void retirar(double monto) {
        if (monto <= 0) {
            System.out.println("Error: el monto a retirar debe ser positivo.");
            return;
        }
        if (monto + comisionRetiro > getSaldo()) {
            System.out.println("Error: saldo insuficiente en la cuenta " + getNumeroCuenta() + " para cubrir el retiro mas la comision.");
            return;
        }

        setSaldo(getSaldo() - monto);
        setSaldo(getSaldo() - comisionRetiro);

        System.out.println("Retiro exitoso de $" + monto);
        System.out.println("Comision por retiro: $" + comisionRetiro);
        System.out.println("Nuevo saldo: $" + getSaldo());
    }

    @Override
    public void mostrarInfo() {
        System.out.println("--- Cuenta Empresarial ---");
        super.mostrarInfo();
        System.out.println("Nombre de la empresa: " + nombreEmpresa);
        System.out.println("RUT: " + rut);
    }
}
