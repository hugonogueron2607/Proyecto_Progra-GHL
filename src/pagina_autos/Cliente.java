/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagina_autos;

import java.util.ArrayList;

/**
 *
 * @author Steins Gate
 */
public class Cliente {
    private String Nombre;
    private long Numero;
    private String Usuario;
    private String Correo;
    @SuppressWarnings("FieldMayBeFinal")
    private ArrayList <Auto> Disposicion;

    public Cliente(String c, String n, String d, long nu) {
        this.Nombre=n;
        this.Correo=c;
        this.Usuario=d;
        this.Numero=nu;
        this.Disposicion = new ArrayList <Auto>( );
    }
    Cliente(){
    }
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getUsuario() {
        return Usuario;
    }
    
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }
    
    public long getNumero() {
        return Numero;
    }

    public void setNumero(long Numero) {
        this.Numero = Numero;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
    
    public void agregarAuto(Auto R){
        Disposicion.add(R);
    }
    
    public void verAutos(){
        byte i;
        for(i=0;i<Disposicion.size();i++){
            Auto L=Disposicion.get(i);
            System.out.println("Auto "+(i+1)+":");
            visualizarAuto(L);
            System.out.println(" ");
        }
    }
    
    public boolean estaVacio(){
        return Disposicion.isEmpty();
    }
    
    public void modificarAuto(int i,Auto A){
        //COCO: tengo 2 autos por loque size es de 2, lo maximo que puedo recibir es un 1
        if((i>=Disposicion.size())||(i<0)){
            System.out.println("Mal indice, auto no reemplazado");
        }else{
            Disposicion.set(i, A);
        }
    }
    
    public void cancelarAuto(int i){
        if((i>=Disposicion.size())||(i<0)){
            System.out.println("Mal indice, no es posible cancelar auto");
        }else{
            Disposicion.remove(i);
        }
    }
    
    public void visualizarAuto(Auto P){
        String []Rines;//=new String[3];//Modelo,Acabado,Color
        String []ColorExt;//=new String[2];//Color 2, Color 1 (Externos)
        String []Interior;//=new String[3];//Material,Personalizado y Color (Interno)
        boolean []Esteticas;//Interiores{Blanco(False) o Amarillo(true)}, Exteriores{Blanco(False) o Amarillo(true)}
        boolean []TipAc;//=new boolean[6];//
        String Defensa;//3 Tipos de defensa
        Rines=P.getRines();
        ColorExt=P.getColorExt();
        Interior=P.getInterior();
        Esteticas=P.getEsteticas();
        TipAc=P.getTipAc();
        Defensa=P.getDefensa();
        System.out.println("Modelo: "+P.getModelo());
        System.out.println("Colores: ");
        System.out.println("    1.-"+ColorExt[0]);
        System.out.println("    2.-"+ColorExt[1]);
        System.out.println("Interiores de "+Interior[2]+" de color "+Interior[0]+" de tipo "+Interior[1]);
        System.out.println("Rines tipo "+Rines[2]+" acabado "+Rines[1]+" de color "+Rines[0]);
        System.out.println("Defensa tipo"+Defensa);
        System.out.println("Esteticas Interiores: ");if(Esteticas[1])System.out.println("Amarillas");else System.out.println("Blancas");
        System.out.println("Esteticas Exteriores: ");if(Esteticas[0])System.out.println("Amarillas");else System.out.println("Blancas");
        System.out.println("Transmision: ");if(TipAc[0])System.out.println("Automatica");else System.out.println("Manual");
        System.out.println("Equipo de sonido: ");if(TipAc[1])System.out.println("Incluido");else System.out.println("No incluido");
        System.out.println("Camara retrovisor: ");if(TipAc[2])System.out.println("Incluida");else System.out.println("No incluida");
        System.out.println("Aleron: ");if(TipAc[3])System.out.println("Incluido");else System.out.println("No incluido");
        System.out.println("Quemacocos: ");if(TipAc[4])System.out.println("Incluido");else System.out.println("No incluido");
        System.out.println("Faros: ");if(TipAc[5])System.out.println("LED");else System.out.println("Neon"); 
    }
}
