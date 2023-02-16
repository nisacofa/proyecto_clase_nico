package utilidades;

import modelo.Cliente;

public class UtilidadesCliente {
    public boolean esDniValido(Cliente cliente) {
        String dni = cliente.getDni();
        return cliente.getDni().length()==9 && dni.matches("[0-9]{8}[A-Z]{1}");


    }
}
