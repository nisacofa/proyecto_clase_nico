package utilidades;

import modelo.Factura;
import modelo.LineaFactura;

import java.time.LocalDate;

public class UtilidadesFactura {
    public Boolean esFacturaVencida(Factura factura){
        if (factura.getFechaVencimiento().isEqual(LocalDate.now())|| factura.getFechaVencimiento().isAfter(LocalDate.now())){
            return true;


        }else return false;
    }
    public Double calcularBaseFutura(Factura factura){
        double suma= 0;
        for(LineaFactura linea:factura.getLineaFactura()){
            double total= linea.getProducto().getPrecio() * linea.getCantidad();
            suma+=total;

        };
        return suma;


    }
    public double calcularTotalAPagar(Factura factura){
        double total= (factura.getImporteBase()-factura.getDescuento())*factura.getIva();
        return total;

    };
}
