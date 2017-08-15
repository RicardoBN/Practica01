
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import com.csvreader.CsvReader;


public class Lectura_csv {
 
    public static void main(String[] args) {
     
        try {
         
        CsvReader mi_csv = new CsvReader("./P1.csv"); //Cambien a la ruta de su archivo
        mi_csv.readHeaders(); // Leemos las Cabeceras, las cuales nos dan informacion de cada campo
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
         
        while (mi_csv.readRecord())
        {
            String nombre = mi_csv.get(0);
            String tel = mi_csv.get(1);
            String direccion = mi_csv.get(2);
            String correo = mi_csv.get(3);
            String m2 = mi_csv.get(4);
            String val_prop = mi_csv.get(5);
            String val_venta = mi_csv.get(6);
            
            System.out.println("Registro leido");
            System.out.println("Nombre: "+nombre);
            System.out.println("Telefono: "+tel); 
            System.out.println("Direccion: "+direccion);             
            System.out.println("Correo: "+correo);     
            System.out.println("Metros Cuadrados: "+m2+" m^2"); 
            System.out.println("Valor de la Propiedad: $"+val_prop); 
            System.out.println("Valor para Venta: $"+val_venta);
            System.out.println("/***********************************/\n");
            Cliente cliente = new Cliente (nombre,tel,direccion,correo,Integer.parseInt(m2),Double.parseDouble(val_prop),Double.parseDouble(val_venta));
            clientes.add(cliente);
            System.out.println(cliente.toString());

        }
        Consulta consulta = new Consulta(clientes);
        consulta.info_1(200,10000,20000);
        consulta.info_2();
        consulta.info_34();
        consulta.info_5();        

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
