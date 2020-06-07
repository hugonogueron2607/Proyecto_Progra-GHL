/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagina_autos;

/**
 *
 * @author Steins Gate
 */
public class Compra {
    private int Precio;

    Compra() {
        this.Precio=0;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  
    
    public int verTotal(Auto f){
        Cotizacion L;//Necesito los metodos necesarios para ver los precios
        L=new Cotizacion();
        int Total=0;
        byte[] temp;
        byte[] temp1;
        byte[] temp2;
        temp=new byte[2];
        temp1=new byte[3];
        temp2=new byte[6];
        temp=f.getColorExtN();
        temp1=f.getInteriorN();
        temp2=f.getTipAcN();
        //L.getPrecioModelos(f.getModeloN());
        Total+=L.getPrecioModelos(f.getModeloN());//Precio por Modelo
        if(temp[1]==5){
            Total+=L.getPrecioColor1(temp[0]);//Precio por color
        }else{
            Total+=L.getPrecioColor2(temp[0], temp[1]);//Precio por color
        }
        Total+=L.getPrecioDefensas(f.getDefensaN());//Precio por defensas
        Total+=L.getPrecioInteriores(temp1[2], temp1[1], temp[0]);//Precio de interiores
        temp1=f.getRinesN();
        Total+=L.getPrecioRines(temp1[2], temp1[1], temp1[0]);//Precio por rines
        temp=f.getEsteticasN();
        Total+=L.getPrecioEsteticas(temp[1], temp[0]);//Precio por esteticas
        Total+=L.getPrecioTransmision(temp[0]);
        Total+=L.getPrecioSonido(temp2[1]);
        Total+=L.getPrecioCamara(temp2[2]);
        Total+=L.getPrecioAleron(temp2[3]);
        Total+=L.getPrecioConvertible(temp2[4]);
        Total+=L.getPrecioFaros(temp2[5]);//Precio por faros
        
        //Precio por luces
        this.Precio=Total;
        return Total;
    }
}
