package utilidades;

import modelo.Almacen;
import modelo.Producto;
import modelo.TipoProducto;

import java.util.ArrayList;
import java.util.List;

public class UtilidadesProducto {
    public List<Producto> getPorTipo(List<Producto> productos, TipoProducto tipo){
        List<Producto> listaProductos= new ArrayList<>();

        for (Producto product:productos){
            if (product.getTipoProducto().equals(tipo)){
                listaProductos.add(product);
            }
        }
        return listaProductos;
    }
    public List<Producto> getPorAlmacen(List<Producto> productos, Almacen almacen){
        List<Producto> listaProductosAlmacen= new ArrayList<>();
        for ( Producto product:productos){
            if (product.getAlmacen().equals(almacen)){
                listaProductosAlmacen.add(product);

            }
        }
        return listaProductosAlmacen;

    }
}

