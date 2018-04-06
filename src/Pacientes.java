

/**
 * @author Rodrigo Samayoa
 * @author Marcos Gutierrez
 * @since 05 abril 2018
 * Clase Pacientes
 */

 public class Pacientes implements Comparable<Pacientes>
{
	public String nombre;
	public String sintoma;
	public String codigo;
	
	public Pacientes(String nombre, String sintoma,String codigo) 
	{
		this.nombre = nombre;
		this.sintoma = sintoma;
		this.codigo = codigo;
	}
	
	public void setNombre()
	{
		nombre = this.nombre;
	}
	
	public void setSintoma()
	{
		sintoma = this.sintoma;
	}
	
	public void setCodigo()
	{
		codigo = this.codigo;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public String getSintoma()
	{
		return sintoma;
	}
	
	public String getCodigo()
	{
		return codigo;
	}
	 
	@Override
	public int compareTo(Pacientes o) 
	{
		if(this.codigo.charAt(0) > o.getCodigo().charAt(0))
		{
			return 1;
		}
		if(this.codigo.charAt(0) < o.getCodigo().charAt(0))
		{
			return -1;
		}
		return 0;
	}
	
	public String toString()
	{
		return nombre + ", " + sintoma + ", " + codigo;
	}
	 
}