package entidad;

public class registro_empleados {
    
    int id_empleado;
    String nombre_empleado;
    String puesto_empleado;
    String fecha_ingreso;

    public registro_empleados() {
    }

    public registro_empleados(int id_empleado, String nombre_empleado, String puesto_empleado, String fecha_ingreso) {
        this.id_empleado = id_empleado;
        this.nombre_empleado = nombre_empleado;
        this.puesto_empleado = puesto_empleado;
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getPuesto_empleado() {
        return puesto_empleado;
    }

    public void setPuesto_empleado(String puesto_empleado) {
        this.puesto_empleado = puesto_empleado;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    @Override
    public String toString() {
        return "registro_empleados{" + "id_empleado=" + id_empleado + ", nombre_empleado=" + nombre_empleado + ", puesto_empleado=" + puesto_empleado + ", fecha_ingreso=" + fecha_ingreso + '}';
    }
    
    
     
    
    
}
