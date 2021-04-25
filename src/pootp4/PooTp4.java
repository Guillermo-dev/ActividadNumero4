package pootp4;

import pootp4.ejercicio2.SinTrabajoEnColaException;
import pootp4.ejercicio4.Persona;
import pootp4.ejercicio2.NoListaException;
import pootp4.ejercicio2.MiTrabajo1;
import pootp4.ejercicio3.FullDataBagException;
import pootp4.ejercicio3.EmptyDataBagException;
import pootp4.ejercicio3.DataBag;
import pootp4.ejercicio2.ColaDeTrabajo;
import pootp4.ejercicio5.Circulo;
import pootp4.ejercicio1.Dividir;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PooTp4 {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner in = new Scanner(System.in);
        
//      Ejercicio 1

        System.out.println("Ejercicio 1\n");
        int a;
        int b;
        System.out.println("Ingrese el numero entero A");
        a = in.nextInt();
        System.out.println("Ingrese el numero entero B");
        b = in.nextInt();

        Dividir dividir = new Dividir();

        System.out.println("El resultado es: " + dividir.dividir(a, b));

//        b) El programa no andaria, ya que no existe la division por cero "0"
//        d) La excepcion mas adecuada seria usar "ArithmeticException"


//      Ejercicio 2
        System.out.println("Ejercicio 2\n");
        ColaDeTrabajo colaDeTrabajo = new ColaDeTrabajo("Trabajos por hacer");
        MiTrabajo1 trabajo = new MiTrabajo1("Programar", "qwerty");
        colaDeTrabajo.encolar(trabajo);

//         Simula el estado de la cola (0 = disponible, 1 = no disponible)
//         colaDeTrabajo.setEstado(random.nextInt(2) == 1);
        colaDeTrabajo.setEstado(true);
        try {
            System.out.println("Siguiente trabajo: " + colaDeTrabajo.sacar().getNombre());
        } catch (NoListaException e) {
            System.out.println(e.getMessage());
        } catch (SinTrabajoEnColaException e) {
            System.out.println(e.getMessage());
        }
//         b) Las excepciones se lanzan con los throws en la declaracion del metodo
//         c) Se capturan con un try y catch por cada una de las excepciones 
//         cuando se llama al metodo "peligroso"


//         Ejercicio 3
        System.out.println("Ejercicio 3\n");
        DataBag dataBag = new DataBag(1);

        try {
            System.out.println("Se agrego correctamente");
            dataBag.add("hola");
        } catch (FullDataBagException e) {
            System.out.println(e.getMessage());
        }

        try {
            dataBag.remove();
        } catch (EmptyDataBagException e) {
            System.out.println(e.getMessage());
        }

        
//         Ejercicio 4
        System.out.println("Ejercicio 4\n");
        List<String> myList = Arrays.asList("a1", "b1", "c2", "c1");
        myList.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
//        a) Retorna: C1, C2 (Los caracteres que empiezan con el caracter 'c', pasados a mayusculas y
//        de forma ordenada)
//        b) Los Streams son un tipo de dato que permite tratar a las colecciones con
//        otros tipos de metodos como pueden ser el .filter, .map
//        Un Stream es una interfaz que nos permite procesar datos de forma
//        mas eficientes, sin preocuparnos en el "como" sino en el "que". No
//        se usan para modificar datos.
//        c) Otro ejemplo
        Persona p1 = new Persona(50321365, "Roberto");
        Persona p2 = new Persona(50941934, "Agustin");
        Persona p3 = new Persona(30295073, "Jhony");

        ArrayList<Persona> Empleados = new ArrayList();
        Empleados.add(p1);
        Empleados.add(p2);
        Empleados.add(p3);

        Empleados.stream()
                .filter(s -> s.getDni() > 40000000)
                .forEach((p) -> {
                    System.out.println("Nombre: " + p.getNombre());
                    System.out.println("DNI: " + p.getDni());
                });
//        Muestro todas las personas que tengan un dni mayor a 40.000.000


//         Ejercicio 5
        System.out.println("Ejercicio 5\n");
//         No, no se puede establecer un valor de PI, porque es constante
        Circulo circulo = new Circulo();
        circulo.setRadio(20);
        System.out.println("Area: " + circulo.calcularArea()
                + "\nLongitud: " + circulo.calcularLongitud());
    }
}
