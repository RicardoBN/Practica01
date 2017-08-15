import java.util.ArrayList;
public class Consulta{
	ArrayList<Cliente> clientes;

	public Consulta (ArrayList<Cliente> clientes){
		this.clientes = clientes;
	}
	//Método que responde a la primera pregunta; puedes cambiar los rangos buscados 
	//No devuelve nada ya que no hay ninguna propiedad que cumpla el rango...
	public void info_1 (int m2,double menos,double mas){
        ArrayList<Cliente> clientesFiltrados = new ArrayList<Cliente>();
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).m2 <m2 && (clientes.get(i).val_prop > menos && clientes.get(i).val_prop < mas)){
                clientesFiltrados.add(clientes.get(i));
            }
        }
        System.out.println("Estos son los clientes con una propiedad con el rango de precio buscado");
        for (int i = 0; i < clientesFiltrados.size(); i++){
            System.out.println(clientesFiltrados.get(i).nombre+ " con una propiedad de: "+clientesFiltrados.get(i).m2+ "m^2 y un valor de propiedad de: "+ clientesFiltrados.get(i).val_prop);
        }
        System.out.println(" ");
    }
    //Método auxiliar para buscar repeticiones dentro de la lista
     public boolean repetido (ArrayList<Cliente> clientes, Cliente buscado){
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).nombre == buscado.nombre){
                return true;
            }            
        }
        return false;
    }
    //Método que responde a la segunda pregunta;
    //No hay personas con más de una propiedad
    public void info_2(){
        ArrayList<Cliente> clientesFiltrados = new ArrayList<Cliente>();
        ArrayList<Cliente> clientesFiltrados2 = new ArrayList<Cliente>();        
        for (int i = 0; i < clientes.size(); i++) {
            if(repetido(clientesFiltrados,clientes.get(i))){
                clientesFiltrados2.add(clientes.get(i));
            
            }else{
                clientesFiltrados.add(clientes.get(i));
            }
        }
        System.out.println("Estos son los clientes con mas de una propiedad");
        for (int i = 0; i < clientesFiltrados2.size(); i++){
            System.out.println(clientesFiltrados2.get(i).nombre);            
        }
        System.out.println(" ");
    }
    //Método que responde a la tercera y cuarta pregunta;
    //Se aprovecha que los clientes se ordenan dependiendo del valor de venta de sus casas
    public void info_34(){        
        Cliente[] pobres = clientes.toArray(new Cliente[clientes.size()]);
        
        Cliente temp= new Cliente();
        for(int i=0; i<pobres.length; i++) {
            for(int j = 1; j<pobres.length-1;j++){
                if(pobres[j-1].val_venta > pobres[j].val_venta) {
                    temp = pobres[j-1];
                    pobres[j-1] = pobres[j];
                    pobres[j] = temp;
                }
            }
        }
        System.out.println("Estos son las 10 propiedades mas baratas");
        for(int i=0; i<10;i++){
            System.out.println("Propiedad de "+pobres[i].nombre +" Valor: "+pobres[i].val_venta);
        }
        System.out.println("");
        System.out.println("Estos son las propiedades mas caras");
        int x = 0;
        for(int i=pobres.length-1;x < 5;x++){
            System.out.println("Propiedad de "+pobres[i].nombre +" Valor: "+pobres[i].val_venta);
            i--;
        }
        System.out.println(" ");
    }
    //Método que responde a la quinta pregunta;    
    public void info_5 (){
        Cliente[] ganancia = clientes.toArray(new Cliente[clientes.size()]);
        Cliente temp= new Cliente();
        for(int i=0; i<ganancia.length; i++) {
            for(int j = 1; j<ganancia.length-1;j++){

                if(ganancia[j-1].val_venta-ganancia[j-1].val_prop > ganancia[j].val_venta-ganancia[j].val_prop) {
                    temp = ganancia[j-1];
                    ganancia[j-1] = ganancia[j];
                    ganancia[j] = temp;
                }
            }
        }
        System.out.println("Estas son las propiedades con mayor margen de ganancia");
        for(int i=0; i<5;i++){
            double ganan = ganancia[i].val_venta-ganancia[i].val_prop;
            System.out.println("Casa de "+ganancia[i].nombre +" con una ganancia de : "+ ganan);
        }
    }
}