
public class Cliente{
	public String nombre;
	public String tel;
	public String dir;
	public String correo;
	public int m2;
	public double val_prop;
	public double val_venta;
	public int props;
	public Cliente(){

	}
	public Cliente (String nombre,String tel,String dir, String correo, int m2, double val_prop, double val_venta){
		this.nombre = nombre;
		this.tel = tel;
		this.dir = dir;
		this.correo = correo;
		this.m2 = m2;
		this.val_prop = val_prop;
		this.val_venta = val_venta;
	}
	public String toString(){
		return "";
	}
}