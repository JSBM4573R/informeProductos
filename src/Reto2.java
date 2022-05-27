
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Esta clase representa a cada uno de los productos que se venden en la tienda
 *
 * @author Juancho
 */
class Producto {

    /**
     * codigo del producto
     */
    private int codigo;

    /**
     * Nombre del producto
     */
    private String nombre;

    /**
     * Precio del producto
     */
    private double precio;

    /**
     * Cantidad del producto en el inventario
     */
    private int inventario;

    /**
     * Constructor que recibe todos los atributos requeridos por el producto. Se
     * utilizará cuando esta clase se use en los retos de MasterTech 2 y 3 (mas
     * no en el reto de la iterfaz)
     *
     * @param codigo codigo del producto
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     * @param inventario Cantidad del producto en el inventario
     */
    public Producto(int codigo, String nombre, double precio, int inventario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;
    }

    /**
     * Retorna el código del producto
     *
     * @return codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Asigna el código del producto
     *
     * @param codigo Valor del código del producto
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna el nombre del producto
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Actualiza el nombre del producto
     *
     * @param nombre Nombre del producto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna el precio del producto
     *
     * @return precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Actualiza el precio del producto
     *
     * @param precio Precio del producto
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Retorna la cantidad del producto en el inventario
     *
     * @return
     */
    public int getInventario() {
        return inventario;
    }

    /**
     * Actualiza la cantidad del producto en el inventario
     *
     * @param inventario cantidad de producto en inventario
     */
    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

    /**
     * Retorna el estado del objeto
     *
     * @return Cadena de caracteresc con los datos del objeto
     */
    @Override
    public String toString() {
        return "Código:" + codigo + "\nNombre:" + this.nombre + "\nPrecio:" + this.precio + "\nInventario:" + this.inventario;
    }
}

/**
 * Esta clase representa a una base de datos de productos, que cuenta con una
 * colección de tipo HashMap administrable con métodos que permiten
 * agregar,borrar y actualizar.
 *
 * @author Juancho
 */
class BasedeDatosProducto {

    /**
     * Atributo para administrar colecciónd e tipo HashMap
     */
    private Map<Integer, Producto> listaProductos;

    /**
     * Constructor de la clase: Se encarga de inicializar la colección y agregar
     * productos existentes
     */
    public BasedeDatosProducto() {
        listaProductos = new HashMap<Integer, Producto>();

        listaProductos.put(1, new Producto(1, "Manzanas", 9000.0, 75));
        listaProductos.put(2, new Producto(2, "Limones", 2300.0, 15));
        listaProductos.put(3, new Producto(3, "Peras", 2700.0, 33));
        listaProductos.put(4, new Producto(4, "Arandanos", 9300.0, 5));
        listaProductos.put(5, new Producto(5, "Tomates", 2100.0, 42));
        listaProductos.put(6, new Producto(6, "Fresas", 4100.0, 3));
        listaProductos.put(7, new Producto(7, "Helado", 4500.0, 41));
        listaProductos.put(8, new Producto(8, "Galletas", 500.0, 8));
        listaProductos.put(9, new Producto(9, "Chocolates", 3500.0, 80));
        listaProductos.put(10, new Producto(10, "Jamon", 19000.0, 99));
    }

    /**
     * Permite obtener la colección de productos
     *
     * @return listaProductos colección de productos
     */
    public Map<Integer, Producto> getListaProductos() {
        return listaProductos;
    }

    /**
     * Agrega un producto a la coleccion de base de datos
     *
     * @param agregar
     */
    public void agregar(Producto producto) {
        listaProductos.put(producto.getCodigo(), producto);
    }

    /**
     * Borra un producto de la coleccion de base de datos
     *
     * @param borrar remueve un producto de la coleccion
     */
    public void borrar(Producto producto) {
        listaProductos.remove(producto.getCodigo());
    }

    /**
     * Actualiza un registro de la coleccion
     *
     * @param actualizar actualiza un producto de la coleccion
     */
    public void actualizar(Producto producto) {
        listaProductos.replace(producto.getCodigo(), producto);
    }

    /**
     * Este metodo va a retornar el nombre del producto con el precio mayor
     *
     * @return nombre del producto con el mayor valor en la base de datos
     */
    public String productoMayor() {
        String nombre = listaProductos.values().iterator().next().getNombre();
        double precio = listaProductos.values().iterator().next().getPrecio();
        for (Producto producto : listaProductos.values()) {
            if (producto.getPrecio() > precio) {
                nombre = producto.getNombre();
                precio = producto.getPrecio();
            }
        }
        return nombre;
    }

    /**
     * Este metodo va a retornar el nombre del producto con el precio menor
     *
     * @return nombre del producto con el menor valor en la base de datos
     */
    public String productoMenor() {
        String nombre = listaProductos.values().iterator().next().getNombre();
        double precio = listaProductos.values().iterator().next().getPrecio();
        for (Producto producto : listaProductos.values()) {
            if (producto.getPrecio() < precio) {
                nombre = producto.getNombre();
                precio = producto.getPrecio();
            }
        }
        return nombre;
    }

    /**
     * Este metodo retorna el promedio de los precios de todos los productos
     *
     * @return promedio con un decimal
     */
    public String promedioPrecios() {
        double acumulador = 0;
        for (Producto producto : listaProductos.values()) {
            acumulador += producto.getPrecio();
        }
        double promedio = acumulador / (listaProductos.size());
        return String.format("%.1f", promedio);
    }

    /**
     * Retornara la suma total de todos los precio de la coleccion
     *
     * @return totalInventario con un decimal
     */
    public String valorInventario() {
        double totalInventario = 0;
        for (Producto producto : listaProductos.values()) {
            totalInventario += producto.getPrecio() * producto.getInventario();
        }
        return String.format("%.1f", totalInventario);
    }

    /**
     * retorna si el producto existe en la coleccion
     *
     * @param codigo
     * @return bandera
     */
    public boolean validarExistencia(Producto producto) {
        boolean bandera = false;
        bandera = listaProductos.containsKey(producto.getCodigo());
        return bandera;
    }

    /**
     * Genera un informe con el nombre del producto con el precio mayor, seguido
     * del nombre con el producto del precio menor, seguido del promedio y el
     * total del inventario. Todo en un input de una sola linea.
     *
     * @param informe
     */
    public void informe() {
        System.out.println(productoMayor() + " " + productoMenor() + " " + promedioPrecios() + " " + valorInventario());
    }
}

/**
 * Esta clase va a contener el metodo read() y el ejecutable del Reto2
 *
 * @author Juancho
 */
public class Reto2 {

    /**
     * Este debe ser el único objeto de tipo Scanner en el código
     */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Este método es usado para solicitar datos al usuario
     *
     * @return Lectura de la siguiente linea del teclado
     */
    public static String read() {
        return scanner.nextLine();
    }

    /**
     * Este metodo es el que va a contener el ejecutable del RetoDos
     *
     * @param args
     */
    public static void main(String[] args) {

        String inputUno = read();

        BasedeDatosProducto baseDatos = new BasedeDatosProducto();

        String inputDos[] = read().split(" ");

        Producto producto = new Producto(
                Integer.parseInt(inputDos[0]),
                inputDos[1],
                Float.parseFloat(inputDos[2]),
                Integer.parseInt(inputDos[3]));

        if ("AGREGAR".equalsIgnoreCase(inputUno) && !baseDatos.validarExistencia(producto)) {
            baseDatos.agregar(producto);
            baseDatos.informe();
        } else if ("BORRAR".equalsIgnoreCase(inputUno) && baseDatos.validarExistencia(producto)) {
            baseDatos.borrar(producto);
            baseDatos.informe();
        } else if ("ACTUALIZAR".equalsIgnoreCase(inputUno) && baseDatos.validarExistencia(producto)) {
            baseDatos.actualizar(producto);
            baseDatos.informe();
        } else {
            System.out.println("ERROR");
        }
    }
}
//        if (inputUno.equals("AGREGAR")) { //LiteralsFirstInComparisons
//            if (!baseDatos.validarExistencia(producto)) {
//                baseDatos.agregar(producto);
//                baseDatos.informe();
//            }else{
//                System.out.println("ERROR");
//            }
//        } else if (inputUno.equals("BORRAR") && baseDatos.validarExistencia(producto)) { //LiteralsFirstInComparisons 
//            baseDatos.borrar(producto);
//            baseDatos.informe();
//        } else if (inputUno.equals("ACTUALIZAR") && baseDatos.validarExistencia(producto)) { //LiteralsFirstInComparisons 
//            baseDatos.actualizar(producto);
//            baseDatos.informe();
//        } else {
//            System.out.println("ERROR");
//        }
