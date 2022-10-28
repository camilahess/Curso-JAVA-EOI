package poo1;

import java.util.Objects;

//1- CREAR LOS ATRIBUTOS
//2 - Crear los constructores ( vacío, todos los parámetros )
//2b (opcional) - Crear más constructores y el de copia
//3 - Crear Getters and Setters
//4 - Crear toString
//5 - Crear  hashCode and Equals
//6 (opcional) - Métodos adicionales

public class Coche {

    // Atributos - lo mejor es que sean privados para que no se pueda acceder desde
    // fuera fácilmente
    private String matricula;
    private String modelo;
    private String marca;
    private int anyo;
    private int kms;

    
    //Generamos constructor vacío
    public Coche() {
        //En los constructores vacíos para un int devuelve un 0 y para un String devuelve un NULL.
        
    }

    // generamos constructor con todos los parámetros
    //Si queremos construir un coche, agregarlo, deberemos pasarle todos los datos
    //No podremos pasarle solo uno o dos datos
    public Coche(String matricula, String modelo, String marca, int anyo, int kms) {
        super();
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
        this.anyo = anyo;
        this.kms = kms;
    }

      //Creamos más constructores con otras combinaciones
    //Para poder dar de alta un coche si no tenemos todos los datos
    public Coche(String matricula, String modelo, String marca) {
        super();
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
    }
    
    
    //Constructor de copia ( copiamos un coche a partir de otro)
    public Coche(Coche c) {
        super();
        this.matricula = c.matricula;
        this.modelo = c.modelo;
        this.marca =c.marca;
        this.anyo = c.anyo;
        this.kms = c.kms;
        
    }
    
    
    //GENERAMOS GETTERS Y SETTERS PUBLICOS 
    //Podemos modificar los getters y setters y hacer un método con excepciones 
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        if (matricula.length() > 7 )
            this.matricula = matricula.substring(0, 7);
        else {
        this.matricula = matricula;
        }
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    } 

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public int getKms() {
        return kms;
    }

    public void setKms(int kms) {
        //evitamos que me pasen un numero negativo
        
        this.kms = Math.abs(kms); // lo pasa a negativo
        /*if (kms < 0)
            this.kms = -kms;
        else
            this.kms = kms;*/
    }

    
    //FORMATO DE IMPRESIÓN A UN COCHE
    //CREAMOS EL FORMATO DE SALIDA 
    @Override
    public String toString() {
        String resultado = "Matricula: " + matricula + "\n"
                + "Marca: " + marca + "\n"
                + "Modelo: " + modelo + "\n"
                + "Año: " + anyo;
        return resultado;
        
        //TODO ESO DE ARRIBA ES LO MISMO QUE ESTO :
        // String resultado = "Matricula: " + matricula + "\n" + "Marca: " + marca + "\n" + "Modelo: " + modelo + "\n" + "Año: " + anyo;
    }

    

    //
    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    //Si un coche tiene la misma matricula que otro, es el mismo coche. 
    //COMPARACION DE OBJETOS!
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coche other = (Coche) obj;
        return Objects.equals(matricula, other.matricula);
    }
    
    //Métodos adicionales
    /**
     * Método que dado un coche te dice si es nuevo o viejo basandose en el año 2000
     * @return Cadena "Nuevo" si es mayor o igual  al 2000 y "Viejo" si es menor al año 2000
     */
    public String estado () {
        if(this.anyo>=2000) {
            return "Nuevo";
        }else if(this.anyo>0 && this.anyo<2000){
            return "Viejo";
        } else {
            return "Este coche no tiene especificado el año";
        }
    }
    
    /**
     * Método que me devuelve true si el coche ya ha hecho el rodado, false en contrario
     * Considero el coche rodado si tiene más de 10.000 kms
     * @return True si está rodado, false lo contrario.
     */
    public boolean rodado() {
        if(this.kms>10000) {
            return true; 
        } else {
            return false;
        }
        
    }
    }
    

