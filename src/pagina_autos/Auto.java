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
public class Auto {
    //Guardado de informacion de auto en cadenas
    private String Modelo;
    private String []Rines;//=new String[3];//Modelo,Acabado,Color
    private String []ColorExt;//=new String[2];//Color 2, Color 1 (Externos)
    private String []Interior;//=new String[3];//Material,Personalizado y Color (Interno)
    private boolean []Esteticas;//Interiores{Blanco(False) o Amarillo(true)}, Exteriores{Blanco(False) o Amarillo(true)}
    private boolean []TipAc;//=new boolean[6];//
    //Guardado de informacion de auto en bytes para apuntadores
    private byte ModeloN;
    private byte []RinesN;//Modelo,Acabado,Color
    private byte []ColorExtN;//Color 2, Color 1 (Externos)
    private byte []InteriorN;//Material,Personalizado y Color (Interno)
    private byte []EsteticasN;//{Interiores(False) o Exteriores(true)},{Blanco(False) o Amarillo(true)}
    private byte []TipAcN;//
    /*
        Ver si en cotización se puede hacer una matriz de 5*2 para tener todas estas variables
        TipAc[0] Transmision -> Manual(false),Automatica(true)
        TipAc[1] EQsonido ->            Sin(False), Con(true)
        TipAc[2] CamaraRestrovisor ->   Sin(False), Con(true)
        TipAc[3] Alerón ->              Sin(False), Con(true)
        TipAc[4] Convertible ->          Sin(False), Con(true)
        TipAc[5] Faros  ->              Neon(False), LED(true)
    */
    private String Defensa;//3 Tipos de defensa
    private byte DefensaN;

    public Auto(){
        this.Rines=new String[3];
        this.ColorExt=new String[2];//Color 2, Color 1 (Externos)
        this.Interior=new String[3];//Material,Personalizado y Color (Interno)
        this.Esteticas=new boolean[2];//{Interiores(False) o Exteriores(true)},{Blanco(False) o Amarillo(true)}
        this.TipAc=new boolean[6];//
        
        this.RinesN=new byte[3];//Modelo,Acabado,Color
        this.ColorExtN=new byte[2];//Color 2, Color 1 (Externos)
        this.InteriorN=new byte[3];//Material,Personalizado y Color (Interno)
        this.EsteticasN=new byte[2];//{Interiores(False) o Exteriores(true)},{Blanco(False) o Amarillo(true)}
        this.TipAcN=new byte[6];
    }
    
    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
        switch(Modelo){
            case "GN00":
                this.ModeloN=0;
            break;
            case "GN01":
                this.ModeloN=1;
            break;
            case "GN02":
                this.ModeloN=2;
            break;
            case "GN03":
                this.ModeloN=3;
            break;
            case "GN04":
                this.ModeloN=4;
            break;
            case "GN05":
                this.ModeloN=5;
            break;
            default:
                System.out.println("Modelo de auto no valido");
                this.ModeloN=0;
            break;
        }
    }

    public String[] getRines() {
        return Rines;
    }

    public void setRines(String[] Rines) {
        this.Rines = Rines;
        byte i;
        for(i=0;i<3;i++){
            switch(Rines[i]){
                //Rines[2] Personalizados
                case "PersonX1":
                    this.RinesN[2]=0;
                break;
                case "PersonX2":
                    this.RinesN[2]=1;
                break;
                case "PersonX3":
                    this.RinesN[2]=2;
                break;
                case "PersonX4":
                    this.RinesN[2]=3;
                break;
                //Rines[1] Acabados
                case "Cromo":
                    this.RinesN[1]=0;
                break;
                case "Mate":
                    this.RinesN[1]=1;
                break;
                case "Metalico":
                    this.RinesN[1]=2;
                break;
                //Rines[0] Colores
                case "Negro":
                    this.RinesN[0]=0;
                break;
                case "Blanco":
                    this.RinesN[0]=1;
                break;
                case "Dorado":
                    this.RinesN[0]=2;
                break;
                case "Plateado":
                    this.RinesN[0]=3;
                break;
                default:
                    System.out.println("Dato Invalido");
                    this.RinesN[0]=0;
                    this.RinesN[1]=0;
                    this.RinesN[2]=0;
                break;
            }
        }
        
    }

    public String[] getColorExt() {
        return ColorExt;
    }

    public void setColorExt(String[] ColorExt) {//
        this.ColorExt = ColorExt;
        int i;
        for(i=0;i<2;i++){
            switch(ColorExt[i]){
                case "Negro":
                    this.ColorExtN[i]=0;
                break;
                case "Rojo":
                    this.ColorExtN[i]=1;
                break;
                case "Blanco":
                    this.ColorExtN[i]=2;
                break;
                case "Azul":
                    this.ColorExtN[i]=3;
                break;
                case "Gris":
                    this.ColorExtN[i]=4;
                break;
                default:
                    if(i==0) {System.out.println("Color no valido");
                    this.ColorExtN[0]=0;
                    }else {//System.out.println("Selecciono un solo color");
                    this.ColorExtN[1]=5;}
                break;
            }
        }
    }

    public String[] getInterior() {
        return Interior;
    }

    public void setInterior(String[] Interior) {//
        this.Interior = Interior;
        byte i;
        for(i=0;i<3;i++){
            switch(Interior[i]){
                //Interior[2] Material
                case "Piel":
                    this.InteriorN[2]=0;
                break;
                case "Piel Sintetica"://Pielsintetica
                    this.InteriorN[2]=1;
                break;
                case "Tela":
                    this.InteriorN[2]=2;
                break;
                //Interior[1] Personalizado
                case "PersonInt1":
                    this.InteriorN[1]=0;
                break;
                case "PersonInt2":
                    this.InteriorN[1]=1;
                break;
                case "PersonInt3":
                    this.InteriorN[1]=2;
                break;
                //Interior[0] Colores
                case "Negro":
                    this.InteriorN[0]=0;
                break;
                case "Beige":
                    this.InteriorN[0]=1;
                break;
                case "Cafe":
                    this.InteriorN[0]=2;
                break;
                default:
                    System.out.println("Dato Invalido");
                    this.RinesN[i]=0;
                break;
            }
        }
    }

    public boolean[] getEsteticas() {
        return Esteticas;
    }

    public void setEsteticas(boolean[] Esteticas) {//Falta ete
        this.Esteticas = Esteticas;
        if(Esteticas[1]) this.EsteticasN[1]=1;
        else this.EsteticasN[1]=0;
        if(Esteticas[0]) this.EsteticasN[0]=1;
        else this.EsteticasN[0]=0;
        
    }

    public boolean[] getTipAc() {
        return TipAc;
    }

    public void setTipAc(boolean[] TipAc) {//
        this.TipAc = TipAc;
        byte i;
        for(i=0;i<6;i++){
            if(TipAc[i]) this.TipAcN[i]=1;
            else this.TipAcN[i]=0;
        }
    }

    public String getDefensa() {
        return Defensa;
    }

    public void setDefensa(String Defensa) {//Este es el más papa
        this.Defensa = Defensa;
        if(Defensa=="PersonDef1") this.DefensaN=0;
        else if(Defensa=="PersonDef2") this.DefensaN=1;
        else if(Defensa=="PersonDef3") this.DefensaN=2;
        else this.DefensaN=0;
    }

    public byte getModeloN() {
        return ModeloN;
    }

    public byte[] getRinesN() {
        return RinesN;
    }

    public byte[] getColorExtN() {
        return ColorExtN;
    }

    public byte[] getInteriorN() {
        return InteriorN;
    }

    public byte[] getEsteticasN() {
        return EsteticasN;
    }

    public byte[] getTipAcN() {
        return TipAcN;
    }

    public byte getDefensaN() {
        return DefensaN;
    }
  
}
