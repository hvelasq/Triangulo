/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogot� - Colombia)
 * Departamento Tecnolog�as de la Informaci�n
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Unidad de Estudio: Desarrollo de Software
 * Ejercicio: Triangulo
 * Fecha: Agosto 2022
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Presentado por Arturo Velasquez
 * Febrero 14 2023
 */
package universidadean.desarrollosw.triangulo.mundo;
import static java.lang.Math.acos;
/**
 * Clase que representa un tri�ngulo.
 */
public class Triangulo {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    double sum,s,l1,hight,x1,x2,x3,y1,y2,y3,d,e,l,f,angulo1,angulo2,anguloOpuesto,a,a2,b,b2,c,c2,z,zz,zzz;
    /**
     * Primer punto del tri�ngulo.
     */
    private Punto punto1;
    /**
     * Segundo punto del tri�ngulo.
     */
    private Punto punto2;
    /**
     * Tercer punto del tri�ngulo.
     */
    private Punto punto3;
    /**
     * Color de las l�neas.
     */
    private Color colorLineas;
    /**
     * Color del relleno.
     */
    private Color colorRelleno;
    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------
    /**
     * Inicializa el tri�ngulo
     */
    public Triangulo() {
        // Inicializa los puntos
        punto1 = new Punto(200, 50);
        punto2 = new Punto(300, 200);
        punto3 = new Punto(100, 200);
        // Inicializa los colores
        colorRelleno = new Color(60, 168, 56);
        colorLineas = new Color(0, 83, 24);
    }
    /**
     * Retorna el punto 1 del tri�ngulo.
     */
    public Punto darPunto1() {
        return punto1;
    }
    /**
     * Retorna el punto 2 del tri�ngulo.
     */
    public Punto darPunto2() {
        return punto2;
    }
    /**
     * Retorna el punto 3 del tri�ngulo.
     */
    public Punto darPunto3() {
        return punto3;
    }
    /**
     * Retorna el color de las l�neas del tri�ngulo.
     */
    public Color darColorLineas() {
        return colorLineas;
    }
    /**
     * Retorna el color del relleno del tri�ngulo.
     */
    public Color darColorRelleno() {
        return colorRelleno;
    }
    /**
     * Retorna el per�metro del tri�ngulo.
     */
    public double darPerimetro() {
        //TODO: Retorna la suma de todos los lados
        sum = calcularLado1() + calcularLado2()+ calcularLado3();
        return sum;
    }
    /**
     * Retorna el �rea del tri�ngulo, calculada utilizando la formula de Her�n. <br>
     */
    public double darArea() {
        // TODO: Obtener y retornar el area del tri�ngulo
        s = (calcularLado1()+calcularLado2()+calcularLado3())/2;
        return Math.sqrt(s*(s-calcularLado1())*(s-calcularLado2())*(s-calcularLado3()));
    }
    /**
     * Calcula la altura del tri�ngulo, teniendo en cuenta como base la l�nea entre el punto 1 y 2. <br>
     * Tenga en cuenta que �rea = (Base * Altura) / 2.
     */
    public double darAltura() {
        // TODO: Obtener y retornar la altura del tri�ngulo
        l1 = calcularLado1();
        hight = (2 * darArea()) / calcularLado1();
        return hight;
    }
    /**
     * Calcula la distancia entre el punto 1 y 2.
     */
    private double calcularLado1() {
        x1 = punto1.darX();
        y1 = punto1.darY();
        x2 = punto2.darX();
        y2 = punto2.darY();
        // calcula la distancia
        d = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
            //apra multiplicar al cuadrado se puede usar POU
        return d;
    }
    /**
     * Calcula la distancia entre el punto 2 y 3.
     */
    private double calcularLado2() {
        x2 = punto2.darX();
        y2 = punto2.darY();
        x3 = punto3.darX();
        y3 = punto3.darY();
        e = Math.sqrt(Math.pow(x3-x2, 2) + Math.pow(y3-y2, 2));
        return e;
    }
    /**
     * Calcula la distancia entre el punto 3 y 1.
     */
    private double calcularLado3() {
        x3 = punto3.darX();
        y3 = punto3.darY();
        x1 = punto1.darX();
        y1 = punto1.darY();
        f = Math.sqrt(Math.pow(x1-x3, 2) + Math.pow(y1-y3, 2));
        return f;
    }
    /**
     * Calcula el �ngulo opuesto entre un v�rtice de referencia y los otros dos v�rtices de un tri�ngulo.
     */
    public double calcularAnguloOpuesto(double pX1, double pY1, double pX2, double pY2, double pX3, double pY3) {
        // �ngulo 1
        angulo1 = Math.atan2(pY2 - pY1, pX2 - pX1);
        // �ngulo 2
        angulo2 = Math.atan2(pY3 - pY1, pX3 - pX1);
        // Garantiza que la diferencias de �ngulos sea la m�s peque�a.
        if (Math.abs(angulo1 - angulo2) > Math.PI) {
            angulo1 = angulo1 < 0 ? angulo1 + 2.d * Math.PI : angulo1;
            angulo2 = angulo2 < 0 ? angulo2 + 2.d * Math.PI : angulo2;
        }
        // Calcula el �ngulo opuesto
        anguloOpuesto = (angulo1 + angulo2) / 2.d + Math.PI;
        anguloOpuesto = anguloOpuesto % (2.d * Math.PI);
        return anguloOpuesto;
    }
    /**
     * Cambia el valor de la coordenada X y Y del punto 1.
     */
    public void cambiarPunto1(double pX, double pY) {
        punto1.cambiarX(pX);
        punto1.cambiarY(pY);
    }
    /**
     * Cambia el valor de la coordenada X y Y del punto 2.
     */
    public void cambiarPunto2(double pX, double pY) {
        punto2.cambiarX(pX);
        punto2.cambiarY(pY);
    }
    /**
     * Cambia el valor de la coordenada X y Y del punto 3.
     */
    public void cambiarPunto3(double pX, double pY) {
        punto3.cambiarX(pX);
        punto3.cambiarY(pY);
    }
    /**
     * Cambia el color de relleno del tri�ngulo.
     */
    public void cambiarColorRelleno(int pRojo, int pVerde, int pAzul) {
        colorRelleno.cambiarRojo(pRojo);
        colorRelleno.cambiarVerde(pVerde);
        colorRelleno.cambiarAzul(pAzul);
    }
    /**
     * Cambia el color de la l�neas del tri�ngulo.
     */
    public void cambiarColorLineas(int pRojo, int pVerde, int pAzul) {
        // TODO: Realice el cambio de los colores
    }
    /**
     * Obtener el tipo de tri�ngulo. Este puede ser:
     * - equilatero: los tres lados iguales
     * - isosceles: solo dos lados iguales
     * - escaleno: todos los lados diferentes.
     */
    public String tipo() {
        // TODO: Obtener y retornar el tipo del triangulo
        if (calcularLado1() == calcularLado2() || calcularLado2() == calcularLado3() || calcularLado1() == calcularLado3()) {
            return "isosceles";
        } else if (calcularLado1() == calcularLado2() && calcularLado2() == calcularLado3()) {
            return "equilatero";
        } else {
            return "escaleno";
        }
    }
    /**
     * Obtener el �ngulo (en radianes) entre el lado 1 y el lado 2.
     * Use la ley del coseno para tal fin
     */
    public double angulo1() {
        // TODO: Obtener y retornar el �ngulo entre los lado 1 y lado 2
        //ley de coceno
        // this no es necesario se refiere al objeto, ya que esta en la misma clase
        a2 = Math.pow(a = calcularLado1(),2);//this
        b2 = Math.pow(b = calcularLado2(),2);//this
        c2 = Math.pow(c = calcularLado3(),2);
        // (a*a+b*b-c)/(2*a*b)  :ley de presendencia
        return z = acos((a2+b2-c2)/(2 *a*b)) * (180 / Math.PI);//Math.acos()
    }
    /**
     * Obtener el �ngulo (en radianes) entre el lado 2 y el lado 3.
     * Use la ley del coseno para tal fin
     */
    public double angulo2() {
        // TODO: Obtener y retornar el �ngulo entre los lado 2 y lado 3
        c2 = Math.pow(a = calcularLado1(),2);
        a2 = Math.pow(b = calcularLado2(),2);//this
        b2 = Math.pow(this.c = calcularLado3(),2);//this
        return zz = acos((a2+b2-c2)/(2 *a*b)) * (180 / Math.PI);
    }
    /**
     * Obtener el �ngulo (en radianes) entre el lado 1 y el lado 3.
     * Use la ley del coseno para tal fin
     */
    public double angulo3() {
        // TODO: Obtener y retornar el �ngulo entre los lado 1 y lado 3
        b2 = Math.pow(a = calcularLado1(),2);//this
        c2 = Math.pow(b = calcularLado2(),2);
        a2 = Math.pow(this.c = calcularLado3(),2);//this
        return zzz = acos((a2+b2-c2)/(2 *a*b)) * (180 / Math.PI);
    }
}