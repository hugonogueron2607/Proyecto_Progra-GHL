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
public class Cotizacion {
    int []Modelo=new int[6];
    int [][][]Rines=new int[4][3][4];
    int []ColorExt=new int[5];
    int [][][]Interior=new int[3][3][3];
    int []Defensas=new int[3];
    //int []FarosNiebla=new int[2];
    int []Faros=new int[2];
    int []Camara=new int[2];
    int []Convertible=new int[2];
    int []Transmision=new int[2];
    int []Aleron=new int[2];
    int []Sonido=new int[2];
    int [][]Esteticas=new int[2][2];

    public int getPrecioModelos(byte i) {
        return this.Modelo[i];
    }

    public int getPrecioRines(byte i,byte j,byte k) {
        return this.Rines[i][j][k];
    }

    public int getPrecioColor1(byte i) {
        return this.ColorExt[i];
    }
    public int getPrecioColor2(byte i,byte j) {
        return this.ColorExt[i]+(this.ColorExt[j]/10);
    }

    public int getPrecioInteriores(byte i, byte j, byte k) {
        return this.Interior[i][j][k];
    }

    public int getPrecioDefensas(int i) {
        return this.Defensas[i];
    }

    //public int getPrecioFarosNiebla(int i) {
    //    return this.FarosNiebla[i];
    //}

    public int getPrecioFaros(int i) {
        return this.Faros[i];
    }

    public int getPrecioEsteticas(int i,int j) {
        return this.Esteticas[i][j];
    }
    
    public int getPrecioCamara(int i){
        return this.Camara[i];
    }
    
    public int getPrecioAleron(int i){
        return this.Aleron[i];
    }
    
    public int getPrecioTransmision(int i){
         return this.Transmision[i];
    }
    
    public int getPrecioSonido(int i){
         return this.Sonido[i];
    }
    
    public int getPrecioConvertible(int i){
         return this.Convertible[i];
    }
    
Cotizacion(){
   //----------------------------------------------------------------
    Modelo[0]=68950;
    Modelo[1]=70124;
    Modelo[2]=75389;
    Modelo[3]=78620;
    Modelo[4]=81000;
    Modelo[5]=85300;
    Modelo[6]=100000;
  //----------------------------------------------------------------
    Rines[0][0][0]=15739;
    Rines[0][0][1]=15748;
    Rines[0][0][2]=15757;
    Rines[0][0][3]=15765;
    Rines[0][1][0]=15759;
    Rines[0][1][1]=15768;
    Rines[0][1][2]=15777;
    Rines[0][1][3]=15785;
    Rines[0][2][0]=15729;
    Rines[0][2][1]=15738;
    Rines[0][2][2]=15747;
    Rines[0][2][3]=15755;
    
    Rines[1][0][0]=18659;
    Rines[1][0][1]=18668;
    Rines[1][0][2]=18677;
    Rines[1][0][3]=18685;
    Rines[1][1][0]=18679;
    Rines[1][1][1]=18688;
    Rines[1][1][2]=18697;
    Rines[1][1][3]=18705;
    Rines[1][2][0]=18649;
    Rines[1][2][1]=18658;
    Rines[1][2][2]=18667;
    Rines[1][2][3]=18675;
    
    Rines[2][0][0]=21784;
    Rines[2][0][1]=21793;
    Rines[2][0][2]=21802;
    Rines[2][0][3]=21810;
    Rines[2][1][0]=21804;
    Rines[2][1][1]=21813;
    Rines[2][1][2]=21822;
    Rines[2][1][3]=21830;
    Rines[2][2][0]=21774;
    Rines[2][2][1]=21783;
    Rines[2][2][2]=21792;
    Rines[2][2][3]=21800;
    
    Rines[3][0][0]=24656;
    Rines[3][0][1]=24665;
    Rines[3][0][2]=24674;
    Rines[3][0][3]=24682;
    Rines[3][1][0]=24676;
    Rines[3][1][1]=24685;
    Rines[3][1][2]=24694;
    Rines[3][1][3]=24702;
    Rines[3][2][0]=24646;
    Rines[3][2][1]=24655;
    Rines[3][2][2]=24664;
    Rines[3][2][3]=24672;
  //-------------------------------------------------------------
    ColorExt[0]=50000; //Negro
    ColorExt[1]=50223; 
    ColorExt[2]=50365;
    ColorExt[3]=50432;
    ColorExt[4]=50569;
  //-------------------------------------------------------------
    Interior[0][0][0]=65326;
    Interior[0][0][1]=65342;
    Interior[0][0][2]=65360;
    Interior[0][1][0]=65531;
    Interior[0][1][1]=65547;
    Interior[0][1][2]=65565;
    Interior[0][2][0]=65746;
    Interior[0][2][1]=65762;
    Interior[0][2][2]=65780;
    
    Interior[1][0][0]=72637;
    Interior[1][0][1]=72653;
    Interior[1][0][2]=72671;
    Interior[1][1][0]=72842;
    Interior[1][1][1]=72858;
    Interior[1][1][2]=72876;
    Interior[1][2][0]=73057;
    Interior[1][2][1]=73073;
    Interior[1][2][2]=73091;
    
    Interior[2][0][0]=93654;
    Interior[2][0][1]=93670;
    Interior[2][0][2]=93688;
    Interior[2][1][0]=93859;
    Interior[2][1][1]=93875;
    Interior[2][1][2]=93893;
    Interior[2][2][0]=94074;
    Interior[2][2][1]=94090;
    Interior[2][2][2]=94108;
  //-------------------------------------------------------------
    Defensas[0]=26347;
    Defensas[1]=30280;
    Defensas[2]=41562;
  //-------------------------------------------------------------
    Transmision[0]=0;
    Transmision[1]=20000; 
    
    Sonido[0]=0;
    Sonido[1]=7489;
    
    Camara[0]=0;
    Camara[1]=2000;
    
    Aleron[0]=0;
    Aleron[1]=1500;
    
    Convertible[0]=0;
    Convertible[1]=9500;
   
    Faros[0]=1200;
    Faros[1]=3000;
    
    //FarosNiebla[0]=2551;
    //FarosNiebla[1]=3120;
   
    
  //-----------------------------------------------------------
    Esteticas[0][0]=1430;
    Esteticas[0][1]=1521;
    Esteticas[1][0]=1640;
    Esteticas[1][1]=1720;
} 
}

