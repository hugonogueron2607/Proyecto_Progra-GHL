/*
 * Version bonita y ordenada de proyecto
 * 
 * 
 */
package pagina_autos;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gilberto Vazquez
 * Luis Escarcega
 * Hugo Nogueron
 */
public class Pagina_autos {
    
    /**
     * Version 0.1
     */
    public static ArrayList<Cliente> BaseDat;
    
    public static void main(String[] args) {
        BaseDat=new ArrayList();//Inicializacion de ArrayList
        inicio();
    }
    
    private static void inicio() {//Menu de seleccion para entrar como Administrador o cliente
        int r;
        Scanner Teclado;
        Teclado=new Scanner(System.in);
        System.out.println("Bienvenido al Centro de Ventas Automovilisticas AutoMod");
        System.out.println("Cómo desea desea ingresar al sistema?");
        System.out.println("1. ADMINISTRADOR");
        System.out.println("2. CLIENTE");
        r=Teclado.nextInt();
            switch(r){
                case 1: 
                    inicioAdmi();
                break;        
                case 2: 
                    inicioCliente();
                break;    
                case 0x0:
                    inicio();
                break;    
            }
    }    
    
    public static void inicioAdmi(){ 
        //Modo Administrador: Tiene la capacidad de ver todos los usuarios registrados en el sistema
        //modificarlos, darlos de baja y ademas de ver todos los autos ordenados hasta ahora con
        //la opcion "seguimiento de pedido"
        int contra;
        Scanner Teclado2=new Scanner(System.in);
        System.out.println(" Administrador");
        System.out.println("Ingrese la contraseña del administrador");
        contra=Teclado2.nextInt();
            if(contra==123){//Contraseña necesaria para entrar a las funciones del administrador
                System.out.println("Bienvenido a la funcion de Administrador");
                System.out.println("¿Qué desea hacer?"); 
                System.out.println("1. Seguimiento de pedido");                                
                System.out.println("2. Visualizar cliente");
                System.out.println("3. Dar de baja cliente");
                System.out.println("4. Modificar cliente");
                System.out.println("0. Salir");
                int funcion1;
                funcion1=Teclado2.nextInt();
                    switch(funcion1){
                        case 1: 
                            System.out.println("Seguimiento de Pedido");
                            verTodosLosAutos();
                            inicioAdmi();    
                        break;    
                        case 2: 
                            System.out.println("Visualizar Clientes");
                            verClientes();
                            inicioAdmi();
                        break;  
                        case 3: 
                            System.out.println("Dar de baja Cliente");
                            darDeBajaCliente();                              
                            inicioAdmi();
                        break;
                        case 4: 
                            System.out.println("Modificar Cliente");
                            System.out.println("Si desea modificar un cliente, toda su informacion");
                            System.out.println("incuyendo los autos solicitados sera perdida");
                            System.out.println("Si aun asi esta seguro de querer modificarlo");
                            System.out.println("inserte 0, si no presione cualquier otro numero: ");
                            contra=Teclado2.nextInt();
                                if(contra==0) modificarCliente();  
                            inicioAdmi();
                        break;
                        case 0:
                            inicio();
                        break;
                        default:
                        break;
                    }
            }else{
                System.out.println("Contraseña invalida");
                System.out.println("Reingrese la contraseña");//Se solicita reingreso de contrasenia hasta ser la acertada *a discutir para no estar siempre ahi*
                inicioAdmi();
            }
    }
    
    public static void inicioCliente(){
        //Modo Cliente: Para que un cliente pueda acceder a sus privilegios primero debe de ser
        //un cliente registrado
        int funcion;
        Scanner Teclado3;
        Teclado3=new Scanner(System.in);
        System.out.println(" Cliente");
        System.out.println("¿Qué desea hacer?"); 
        System.out.println("1. Iniciar Sesion");
        System.out.println("2. Darse de alta");
        System.out.println("0. Salir");    
        funcion=Teclado3.nextInt();
            switch(funcion){
                case 1:
                    iniSes();
                    inicioCliente();
                break;    
                case 2:
                    Cliente R;
                    R=agregarClientes();
                    BaseDat.add(R);//Con esto se agrega un cliente
                    //iniSes();
                    inicioCliente();
                break;       
                case 0:
                    inicio();
                break;  
                default:
                    inicioCliente();
                break;
            }
    }
    
    public static void iniSes(){
        //Para ingresar sesion se solicita el nombre del usuario, cuando se
        //encuentra el nombre, se trabaja sobre ese cliente todas sus operaciones,
        //de haber mas de un cliente con el mismo nombre, se trabaja con el primero
        //que se registro
        String nombreu;
        int i,j,m;
        Scanner teclado=new Scanner(System.in);
        System.out.println("Ingrese su nombre de usuario: ");
        nombreu=teclado.nextLine();
        j=buscarCliente(nombreu);
        if(j==-1){
            System.out.println("Usuario incorrecto o contraseña inválida");
        }else{
            Cliente C;
            C=BaseDat.get(j);
            System.out.println("Bienvenido, que desea hacer?");
            verMenuCliente(C);
          }
        }
        
        public static void verMenuCliente(Cliente C){
            int m,i;
            Scanner teclado=new Scanner(System.in);
            System.out.println("1.-Agregar un vehículo");
            System.out.println("2.-Ver mis pedidos");
            System.out.println("3.-Modificar vehiculo");
            System.out.println("4.-Dar de baja vehiculo");
            System.out.println("Presione cualquier otro numero para salir");
            m=teclado.nextInt();
                switch(m){
                    case 1:
                        Auto A;
                        A=CrearAuto();
                        C.agregarAuto(A);
                        System.out.println("¿Desea proceder al pago de su(s) vehículo(s)?");
                        System.out.println("Si(1) No(0)");
                        i=teclado.nextInt();
                        if(i==1) PagodeAuto(A);
                        System.out.println("¿Desea hacer otra operación?");
                        System.out.println("Si(1) No(0)");
                        i=teclado.nextInt();
                        if(i==1) verMenuCliente(C);
                    break;
                    case 2:
                        C.verAutos();
                        System.out.println("¿Desea proceder al pago de su(s) vehículo(s)?");
                        System.out.println("Si(1) No(0)");
                        i=teclado.nextInt();
                        // if(i==1) PagodeAuto(A);
                        //System.out.println("¿Desea hacer otra operación?");
                        //System.out.println("Si(1) No(0)");
                        //i=teclado.nextInt();
                        //if(i==1) verMenuCliente(C);
                    break;
                    case 3:
                        modificarAuto(C);
                        System.out.println("¿Desea proceder al pago de su(s) vehículo(s)?");
                        System.out.println("Si(1) No(0)");
                        i=teclado.nextInt();
                        //if(i==1) PagodeAuto(A);
                        System.out.println("¿Desea hacer otra operación?");
                        System.out.println("Si(1) No(0)");
                    break;
                    case 4:
                        darDeBajaAuto(C);
                        System.out.println("¿Desea hacer otra operación?");
                        System.out.println("Si(1) No(0)");
                        i=teclado.nextInt();
                        if(i==1) verMenuCliente(C);
                    break;
                    default:
                    break;
                }
        } 
    
    
    public static void modificarAuto(Cliente C){
        //Esta funcion crea un auto y lo remplaza con el que se encuentre
        //en la posicion indicada
        int p;
        Scanner teclado=new Scanner(System.in);
        if(C.estaVacio()){
            System.out.println("Usted no tiene autos que modificar");
        }else{
            C.verAutos();
            System.out.println("Seleccione el auto que desea remplazar: ");
            p=teclado.nextInt();
            System.out.println("Cree su nuevo auto: ");
            Auto Remplazo;
            Remplazo=CrearAuto();
            C.modificarAuto(p-1, Remplazo);
        }
    }
    
    public static void modificarCliente(){
        //Crea un cliente y lo remplaza con el cliente que
        //coincida con el nombre ingresado, de no haber coincidencias
        //se indicara y no habra remplazo
        Cliente C;
        String Busca;
        int b;
        Scanner teclado=new Scanner(System.in);
        if(BaseDat.isEmpty()){
            System.out.println("Usted no tiene clientes para modificar");
        }else{
            System.out.println("Ingrese el nombre del cliente que desea reemplazar");
            Busca=teclado.next();
            b=buscarCliente(Busca);
                if(b==-1){
                    System.out.println("El nombre que usted busca no existe");
                }else{
                    System.out.println("Cree al nuevo cliente para modificar el anterior: ");
                    C=agregarClientes();
                    BaseDat.set(b, C);
                }
        }
    }
    
    public static void darDeBajaAuto(Cliente C){
        //Da de baja el auto senialado con un indice
        int p;
        Scanner teclado=new Scanner(System.in);
        if(C.estaVacio()){
            System.out.println("Usted no tiene autos que dar de baja");
        }else{
            System.out.println("Lista de sus autos: ");
            C.verAutos();
            System.out.println("Que auto desea eliminar?");
            p=teclado.nextByte();
            C.cancelarAuto(p-1);
        }
    }
    
    public static void darDeBajaCliente(){
        //Da de baja el cliente con el nombre indicado
        int i;
        String baja;
        Scanner Teclado2=new Scanner(System.in);
        if(BaseDat.isEmpty()){
            System.out.println("No hay clientes para eliminar");
        }else{
            System.out.println("Ingrese el nombre de quien desea dar de baja");
            baja=Teclado2.next();
            i=buscarCliente(baja);
                if((i>=BaseDat.size())||(i<0)){
                    System.out.println("No se ha encontrado a tal cliente");
                }else{
                    BaseDat.remove(i);
                }
        }
    }
    
    public static void verClientes(){
        //Muestra una lista enumerada de todos los clientes registrados
        System.out.println("Nombre:         número:     Correo:");
            for(byte i=0;i<BaseDat.size();i++){
                Cliente P;
                P=BaseDat.get(i);
                System.out.println((i+1)+".-"+P.getNombre()+"\t"+P.getNumero()+"\t"+P.getCorreo());
            }
    }    
    
    public static Cliente agregarClientes(){
        //Crea un cliente otorgandole sus atributos principales
        Cliente Nuevo;
        Nuevo=new Cliente();
        String n,c,d;
        long nu;
        Scanner Tecladon;
        Tecladon=new Scanner(System.in);
        System.out.println("Ingrese su nombre:");                                                                        
        n=Tecladon.next();
        Nuevo.setNombre(n);
        System.out.println("Ingrese su número de celular:");
        Scanner Tecladonu;
        Tecladonu=new Scanner(System.in);
        nu=Tecladonu.nextLong();
        Nuevo.setNumero(nu);
        System.out.println("Ingrese su nombre de usuario");
        d=Tecladon.next();
        Nuevo.setUsuario(d);
        System.out.println("Ingrese su correo:");
        Scanner Tecladoc;
        Tecladoc=new Scanner(System.in);
        c=Tecladoc.next();
        Nuevo.setCorreo(c);
        System.out.println(n+ " ");
        System.out.println(c+" ");
        System.out.println(nu+" ");
        Cliente R;
        R=new Cliente(c,n,d,nu);
        return R;
        //BaseDat.add(R);   
    }    
    
    private static int buscarCliente(String Usuario){
        //Regresa el indice del cliente buscado, de no haber un cliente
        //que coincida en la busqueda, el metodo regresara un -1
        //indicando que no se encuentra el cliente
        int j=-1;
        long cont;
        Scanner Teclado=new Scanner(System.in);
        Cliente R;
        for(int i=0;i<BaseDat.size();i++){
            R=BaseDat.get(i);
            if(R.getUsuario().equals(Usuario)){
                j=i;
               // System.out.println("Ingrese su contraseña: ");
               // cont=Teclado.nextLong();
               // if((R.getNumero()-cont)==0) j=i; 
                break;//
            } 
        }  
        return j;
    }
    
    public static Auto CrearAuto(){
        //Crea un auto con sus principales atributos
        Scanner teclado=new Scanner(System.in);
        Auto A;
        A=new Auto();
        byte g,h;                                                 //Pues a ver, me toco lo hardcore xd
        String []Rines=new String[3];                   //=new String[3];//Modelo,Acabado,Color
        String []ColorExt=new String[2];               //=new String[2];//Color 2, Color 1 (Externos)
        String []Interior=new String[3];                //=new String[3];//Material,Personalizado y Color (Interno)
        boolean []Esteticas=new boolean[2];        //Interiores{Blanco(False) o Amarillo(true)}, Exteriores{Blanco(False) o Amarillo(true)}
        boolean []TipAc=new boolean[6];            //=new boolean[6];//
        System.out.println("Seleccione el modelo del auto: ");
        System.out.println("1.-GN00");
        System.out.println("2.-GN01");
        System.out.println("3.-GN02");
        System.out.println("4.-GN03");
        System.out.println("5.-GN04");
        System.out.println("6.-GN05");
        g=teclado.nextByte();
            switch(g-1){
                case 0: A.setModelo("GN00"); break;
                case 1: A.setModelo("GN01"); break;
                case 2: A.setModelo("GN02"); break;
                case 3: A.setModelo("GN03"); break;
                case 4: A.setModelo("GN04"); break;
                case 5: A.setModelo("GN05"); break;
                default: System.out.println("Opcion invalida, se le asignara GN00");A.setModelo("GN00");System.out.println("");break;
            }
        System.out.println("Ingrese 1 para un color, ingrese 2 para 2 colores");
        h=teclado.nextByte();
            for(int n=0;n<h;n++){
                if(n>1)break;
                System.out.println("Seleccione el color"+(n+1));
                System.out.println("1.-Negro");
                System.out.println("2.-Blanco");
                System.out.println("3.-Rojo");
                System.out.println("4.-Azul");
                System.out.println("5.-Gris");
                g=teclado.nextByte();
                    switch(g-1){
                        case 0: ColorExt[n]="Negro";break;
                        case 1: ColorExt[n]="Blanco"; break;
                        case 2: ColorExt[n]="Rojo"; break;
                        case 3: ColorExt[n]="Azul"; break;
                        case 4: ColorExt[n]="Gris"; break;
                        default: System.out.println("Opcion invalida, se le asignara Negro");System.out.println("");break;
                     }
                if(h==1) ColorExt[1]="Selecciono solo un color";
            }
            A.setColorExt(ColorExt);
            System.out.println("");System.out.println("INTERIORES: ");
            System.out.println("Seleccione el material: ");
            System.out.println("1.-Piel");
            System.out.println("2.-Piel Sintetica");
            System.out.println("3.-Tela");
            g=teclado.nextByte();
                switch(g-1){
                    case 0: Interior[2]="Piel";break;
                    case 1: Interior[2]="Piel Sintetica";break;
                    case 2: Interior[2]="Tela";break;
                    default:System.out.println("Opcion no valida, se le asignara de piel");Interior[2]="Piel";break;
                }
            System.out.println("Seleccione el personalizado: ");
            System.out.println("1.- Personalizado 1");
            System.out.println("2.- Personalizado 2");
            System.out.println("3.- Personalizado 3");
            g=teclado.nextByte();
                switch(g-1){
                    case 0: Interior[1]="PersonInt1";break;
                    case 1: Interior[1]="PersonInt2";break;
                    case 2: Interior[1]="PersonInt3";break;
                    default:System.out.println("Opcion no valida, se le asignara PersonInt1");Interior[1]="PersonInt1";break; 
                }
            System.out.println("Seleccione el color de los interiores: ");
            System.out.println("1.- Negro");
            System.out.println("2.- Beige");
            System.out.println("3.- Cafe");
            g=teclado.nextByte();
                switch(g-1){
                    case 0: Interior[0]="Negro";break;
                    case 1: Interior[0]="Beige";break;
                    case 2: Interior[0]="Cafe";break;
                    default:System.out.println("Opcion no valida, se le asignara negro");Interior[0]="Negro";break; 
                }
            A.setInterior(Interior);
            System.out.println("");System.out.println("RINES");
            System.out.println("Seleccione el tipo de personalizado: ");
            System.out.println("1.-Personalizado X1");
            System.out.println("2.-Personalizado X2");
            System.out.println("3.-Personalizado X3");
            System.out.println("4.-Personalizado X4");
            g=teclado.nextByte();
                switch(g-1){
                    case 0: Rines[2]="PersonX1";break;
                    case 1: Rines[2]="PersonX2";break;
                    case 2: Rines[2]="PersonX3";break;
                    case 3: Rines[2]="PersonX4";break;
                    default:System.out.println("Opcion no valida, se le asignara X1");Rines[2]="PersonX1";break;
                }
            System.out.println("Seleccione el acabado: ");
            System.out.println("1.-Cromo");
            System.out.println("2.-Mate");
            System.out.println("3.-Metalico");
            g=teclado.nextByte();
                switch(g-1){
                    case 0: Rines[1]="Cromo";break;
                    case 1: Rines[1]="Mate";break;
                    case 2: Rines[1]="Metalico";break;
                    default:System.out.println("Opcion no valida, se le asignara Cromo");Rines[1]="Cromo";break;
                }
            System.out.println("Seleccione el color ");
            System.out.println("1.-Negro");
            System.out.println("2.-Blanco");
            System.out.println("3.-Dorado");
            System.out.println("4.-Plateado");
            g=teclado.nextByte();
                switch(g-1){
                    case 0: Rines[0]="Negro";break;
                    case 1: Rines[0]="Blanco";break;
                    case 2: Rines[0]="Dorado";break;
                    case 3: Rines[0]="Plateado";break;
                    default:System.out.println("Opcion no valida, se le asignara Negro");Rines[0]="Negro";break;
                }
            A.setRines(Rines);
            System.out.println("");System.out.println("Seleccione el tipo de defensa:");
            System.out.println("1.-Personalizada 1");
            System.out.println("2.-Personalizada 2");
            System.out.println("3.-Personalizada 3");
            g=teclado.nextByte();
                switch(g-1){
                    case 0: A.setDefensa("PersonDef1");break;
                    case 1: A.setDefensa("PersonDef2");break;
                    case 2: A.setDefensa("PersonDef3");break;
                    default:System.out.println("Opcion no valida, se le asignara Personalizado 1");A.setDefensa("PersonDef1");break;
                }
            System.out.println("");System.out.println("ESTETICAS");
            System.out.println("Las Esteticas interiores las desea blancas(0) o amarillas(1)?");
            g=teclado.nextByte();
                if(g==1)Esteticas[1]=true;
                else Esteticas[1]=false;
            System.out.println("Las Esteticas exteriores las desea blancas(0) o amarillas(1)?");
            g=teclado.nextByte();
                if(g==1)Esteticas[0]=true;
                else Esteticas[0]=false;
            A.setEsteticas(Esteticas);
            System.out.println("");System.out.println("ACCESORIOS Y TRANSMISION");
            System.out.println("Desea transmision manual(0) o automatica(1)?");
            g=teclado.nextByte();
                if(g==1)TipAc[0]=true;
                else TipAc[0]=false;
            System.out.println("Desea sin(0) o con(1) equipo de sonido?");
            g=teclado.nextByte();
                if(g==1)TipAc[1]=true;
                else TipAc[1]=false;
            System.out.println("Desea sin(0) o con(1) camara retrovisora?");
            g=teclado.nextByte();
                if(g==1)TipAc[2]=true;
                else TipAc[2]=false;
            System.out.println("Desea sin(0) o con(1) aleron?");
            g=teclado.nextByte();
                if(g==1)TipAc[3]=true;
                else TipAc[3]=false;
            System.out.println("Desea que sea convertible Si(1), No(0)?");
            g=teclado.nextByte();
                if(g==1)TipAc[4]=true;
                else TipAc[4]=false;
            System.out.println("Faros tipo NEON(0) o LED(1)?");
            g=teclado.nextByte();
                if(g==1)TipAc[5]=true;
                else TipAc[5]=false;
            A.setTipAc(TipAc);                                        
        return A;
        }

    public static void verTodosLosAutos(){
        //Hace un listado de todos los clientes por Nombre y
        //muestra los autos que ellos han solicitado
        System.out.println("Listado de autos por cliente: ");
            for(byte i=0;i<BaseDat.size();i++){
                Cliente P;
                P=BaseDat.get(i);
                System.out.println(P.getNombre()+": ");
                P.verAutos();
                System.out.println(" ");
            }
    }
    
    public static void PagodeAuto(Auto A){
        System.out.println("Total: " );
        Compra C;
        C=new Compra();
        System.out.println(C.verTotal(A));
        
    }
    
    
}

