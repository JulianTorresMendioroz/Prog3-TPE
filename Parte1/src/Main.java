import java.util.List;

public class Main {
    public static void main(String[] args) {
        String archivoCamiones = "Camiones.csv";
        String archivoPaquetes = "Paquetes.csv";

        //Iniciamos servicios
        Servicios servicios = new Servicios(archivoCamiones, archivoPaquetes);

        //S1
        System.out.println("Servicio 1:");
        String codigoABuscar = "P003";
        Paquete paqueteEncontrado = servicios.servicio1(codigoABuscar);
        if (paqueteEncontrado != null) {
            System.out.println("Codigo : " + paqueteEncontrado.getCodigoIdentificador()  + " Alimentos : " + paqueteEncontrado.isContieneAlimentos()  + " Urgencia: " + paqueteEncontrado.getNivelUrgencia());
        } else {
            System.out.println("Paquete no encontrado: " + codigoABuscar);
        }
        System.out.println();

        //S2 contiene
        System.out.println("Servicio 2:");
        List<Paquete> conAlimentos = servicios.servicio2(true);
        for (Paquete p : conAlimentos) {
            System.out.println("Paquete : " + p.getCodigoIdentificador() + " contiene alimentos");
        }

        //S2 no contiene
        System.out.println("Servicio 2 (no contiene):");
        List<Paquete> sinAlimentos = servicios.servicio2(false);
        for (Paquete p : sinAlimentos) {
            System.out.println("Paquete : " + p.getCodigoIdentificador() + " no contiene alimentos");
        }
        System.out.println();

        //S3
        System.out.println("Servicio 3 rango 10 y 90:");
        int minUrgencia = 10;
        int maxUrgencia = 90;
        List<Paquete> paquetesPorUrgencia = servicios.servicio3(minUrgencia, maxUrgencia);

        if (paquetesPorUrgencia.isEmpty()) {
            System.out.println("No hay paquetes en ese rango");
        } else {
            for (Paquete p : paquetesPorUrgencia) {
                System.out.println("Paquete: " + p.getCodigoIdentificador() + " Urgencia: " + p.getNivelUrgencia());
            }
        }
    }
}