

/**
 * @author Rodrigo Samayoa
 * @since 05 abril 2018
 * Clase Pacientes
 */

 public class Pacientes implements Comparable<Pacientes>
{
	public String nombre;
	public String sintoma;
	public String codigo;
	
	public Pacientes() 
	{
		
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
		// TODO Auto-generated method stub
		if(this.codigo.compareTo(o.getCodigo()) > 0)
		{
			return 1;
		}
		if(this.codigo.compareTo(o.getCodigo()) < 0)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
	
	public String toString()
	{
		return nombre + ", " + sintoma + ", " + codigo;
	}
	 
}