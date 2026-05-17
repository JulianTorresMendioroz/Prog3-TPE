import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Servicios {
    private static final String SEPARADOR = ";";

    private List<Paquete> paquetes;
    private List<Camion> camiones;
    // Estructura auxiliar para optimizar el Servicio 1 a O(1)
    private Map<String, Paquete> mapaPaquetesPorCodigo;

    /**
     * Expresar la complejidad temporal del constructor.
     *
     * Complejidad Temporal del Constructor: O(N + M)
     * N es la cantidad de lineas en el archivo de camiones y M es la cantidad en el de paquetes (que no sabemos cuantos son)
     *
     * Leer cada linea toma tiempo constante O(1), ya que accede a cada linea al momento y trae el dato directamente
     */
    public Servicios(String pathCamiones, String pathPaquetes) {
        this.camiones = new ArrayList<>();
        this.paquetes = new ArrayList<>();
        this.mapaPaquetesPorCodigo = new HashMap<>();

        leerCamionesCSV(pathCamiones);
        leerPaquetesCSV(pathPaquetes);
    }

    private void leerCamionesCSV(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linea = br.readLine();
            if (linea == null) return;

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;

                String[] datos = linea.split(SEPARADOR);
                int id = Integer.parseInt(datos[0]);
                String patente = datos[1];
                int configuracion = Integer.parseInt(datos[2]);
                int capacidadMax = Integer.parseInt(datos[3]);

                camiones.add(new Camion(id, patente, configuracion, capacidadMax));
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de camiones: " + e.getMessage());
        }
    }

    private void leerPaquetesCSV(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linea = br.readLine();
            if (linea == null) return;

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;

                String[] datos = linea.split(SEPARADOR);
                int id = Integer.parseInt(datos[0]);
                String codigo = datos[1];
                int peso = Integer.parseInt(datos[2]);
                boolean contieneAlimentos = datos[3].equals("1");
                int urgencia = Integer.parseInt(datos[4]);

                Paquete p = new Paquete(id, codigo, peso, contieneAlimentos, urgencia);
                paquetes.add(p);
                mapaPaquetesPorCodigo.put(codigo, p); //O(1)
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de paquetes: " + e.getMessage());
        }
    }

    /**
     * Expresar la complejidad temporal del servicio 1
     * Servicio 1: Busca un paquete por su codigo
     * Complejidad temporal: O(1)
     * Al usar HashMap accedemos directamente a la key del paquete, sin recorrer la lista entera que seria O(M)
     */
    public Paquete servicio1(String codigoPaquete) {
        return mapaPaquetesPorCodigo.get(codigoPaquete);
    }

    /**
     * Expresar la complejidad temporal del servicio 2
     * Servicio 2: Filtra paquetes que tengan alimentos
     * Complejidad Temporal: O(M)
     * Se recorre la lista entera ya que no sabemos cual tiene alimentos o no, se evalua la condicion y se devuelve la lista
     */
    public List<Paquete> servicio2(boolean contieneAlimentos) {
        List<Paquete> resultado = new ArrayList<>();
        for (Paquete p : paquetes) {
            if (p.isContieneAlimentos() == contieneAlimentos) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    /**
     * Expresar la complejidad temporal del servicio 2
     * Servicio 3: Filtra paquetes dentro de un rango de urgencia
     * Complejidad Temporal: O(M)
     * Se recorre la lista entera ya que no sabemos cual es el nivel de urgencia de cada paquete, se evalua el rango y se devuelve los que cumplen con la condicion
     */
    public List<Paquete> servicio3(int urgenciaMinima, int urgenciaMaxima) {
        List<Paquete> resultado = new ArrayList<>();
        for (Paquete p : paquetes) {
            if (p.getNivelUrgencia() >= urgenciaMinima && p.getNivelUrgencia()  <= urgenciaMaxima) {
                resultado.add(p);
            }
        }
        return resultado;
    }
}