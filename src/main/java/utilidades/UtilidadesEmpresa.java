package utilidades;

import modelo.*;

import java.util.*;
import java.util.stream.Collectors;

public class UtilidadesEmpresa {
    public List<Empleado> getEmpleadosPorContrato(Empresa empresa, TipoContrato tipoContrato){
        List<Empleado> empleadosTipoContrato= new ArrayList<>();

        for (Empleado empleados:empresa.getEmpleados()){
            if (tipoContrato.equals(empleados.getContrato().getTipoContrato())){
                empleadosTipoContrato.add(empleados);


            }

        }
        return empleadosTipoContrato;
    }
    public List<Empleado> getMileuristasOrdenadosPorSalario(Empresa empresa){
        List<Empleado> empleadosmasoigual1000= new ArrayList<>();
        for(Empleado empleado:empresa.getEmpleados()){
            if (empleado.getContrato().getSalarioBase()>=1000){
                empleadosmasoigual1000.add(empleado);
            }
        };
        return empleadosmasoigual1000;
    }
    public double fondoSalarialEmpresa(Empresa empresa) {
        Double sumasalario= 0.0;
        for(Empleado empleado:empresa.getEmpleados()){
            sumasalario+=empleado.getContrato().getSalarioBase();

        };
        return sumasalario;
    }
    public Empleado getMejorPagado(List<Empresa> empresas){
        List<Empleado> todosempleados= new ArrayList<>();
        for(Empresa empresaa:empresas){
            todosempleados.addAll(empresaa.getEmpleados());
        };

        Empleado mejorPagado = todosempleados
                .stream()
                .max(Comparator.comparing(e-> e.getContrato().getSalarioBase()))
                .orElse(null);

        return  mejorPagado;
    }

    public Map<TipoContrato, List<Empleado>> getEmpleadosPorTipoContrato(Empresa empresas){
        Map<TipoContrato, List<Empleado>> mimapa= new HashMap<>();
        mimapa.put(TipoContrato.PRACTICAS, new ArrayList<>());
        mimapa.put(TipoContrato.TEMPORAL, new ArrayList<>());
        mimapa.put(TipoContrato.OBRAYSERVICIO, new ArrayList<>());
        mimapa.put(TipoContrato.INDEFINIDO, new ArrayList<>());



        for (Empleado emple:empresas.getEmpleados()){
            if (emple.getContrato().getTipoContrato().equals(TipoContrato.PRACTICAS)){
                mimapa.get(TipoContrato.PRACTICAS).add(emple);

            };
            if (emple.getContrato().getTipoContrato().equals(TipoContrato.TEMPORAL)){
                mimapa.get(TipoContrato.TEMPORAL).add(emple);

            };
            if (emple.getContrato().getTipoContrato().equals(TipoContrato.OBRAYSERVICIO)){
                mimapa.get(TipoContrato.OBRAYSERVICIO).add(emple);

            };
            if (emple.getContrato().getTipoContrato().equals(TipoContrato.INDEFINIDO)){
                mimapa.get(TipoContrato.INDEFINIDO).add(emple);
            };
        }
        return mimapa;
    }

    public Map<Empresa, Map<TipoContrato, List<Empleado>>>getEmpleadosPorTipoContrato(List<Empresa> empresas){
        Map<Empresa, Map<TipoContrato, List<Empleado>>> mimapaa = new HashMap<>();

        for (Empresa miempresa:empresas){
            mimapaa.put(miempresa,getEmpleadosPorTipoContrato(miempresa));
        }
        return mimapaa;
    }

    public Map<Empresa, Map<TipoContrato, List<Empleado>>>getEmpleadosPorTipoContrato2(List<Empresa> empresas){
        Map<Empresa, Map<TipoContrato, List<Empleado>>> mimapita= new HashMap<>();
        List<TipoContrato> todosempleados= new ArrayList<>();
        todosempleados.add(TipoContrato.INDEFINIDO);
        todosempleados.add(TipoContrato.TEMPORAL);
        todosempleados.add(TipoContrato.OBRAYSERVICIO);
        todosempleados.add(TipoContrato.PRACTICAS);


        for (Empresa miempresa:empresas){
            Map<TipoContrato, List<Empleado>> mi2mapita= new HashMap<>();
            mimapita.put(miempresa, mi2mapita);
            for (Empleado emple:miempresa.getEmpleados()){
                if (emple.getContrato().getTipoContrato().equals(TipoContrato.PRACTICAS)){
                    mi2mapita.get(TipoContrato.PRACTICAS).add(emple);

                };
                if (emple.getContrato().getTipoContrato().equals(TipoContrato.TEMPORAL)){
                    mi2mapita.get(TipoContrato.TEMPORAL).add(emple);

                };
                if (emple.getContrato().getTipoContrato().equals(TipoContrato.OBRAYSERVICIO)){
                    mi2mapita.get(TipoContrato.OBRAYSERVICIO).add(emple);

                };
                if (emple.getContrato().getTipoContrato().equals(TipoContrato.INDEFINIDO)){
                    mi2mapita.get(TipoContrato.INDEFINIDO).add(emple);
                };
            }
        }
        return mimapita;
    }

    //V4
    //Ejercicio 2 A
    public List<Empleado> getEmpleadosPymePracticas(List<Empresa> empresas){
        List<Empleado> empleadosfiltrados= new ArrayList<>();

        for (Empresa miempresa:empresas){
            if (miempresa.getTipoEmpresa().equals(TipoEmpresa.PYME)){
                for(Empleado miempleado:miempresa.getEmpleados()){
                    if (miempleado.getContrato().getTipoContrato().equals(TipoContrato.PRACTICAS)){
                        empleadosfiltrados.add(miempleado);
                    }
                }
            }
        }
        return empleadosfiltrados;
    }
    //Ejercicio 2 B
    public Map<Empresa,Empleado> getLosMejorPagadosPorEmpresa(List<Empresa> empresas){
        Map<Empresa, Empleado> empleadosqmascobran= new HashMap<>();
        for (Empresa miempresa:empresas){
            Empleado empleadomejorpagado= null;
            for(Empleado miempleado:miempresa.getEmpleados()){
                if (empleadomejorpagado==null){
                    empleadomejorpagado=miempleado;
                }
                if(empleadomejorpagado.getContrato().getSalarioBase()<miempleado.getContrato().getSalarioBase()){
                    empleadomejorpagado=miempleado;
                };
            }
            empleadosqmascobran.put(miempresa,empleadomejorpagado);
        }
        return empleadosqmascobran;
    }

    //Ejercicio 3
    public Double gastoTotalCliente(List<Factura> facturas, Cliente cliente){
        Double total= 0.0;
        for (Factura mifactura:facturas){
            if (mifactura.getCliente().equals(cliente)){
                total+=mifactura.getTotalAPagar();
            }
        }
        return total;
    }


}
