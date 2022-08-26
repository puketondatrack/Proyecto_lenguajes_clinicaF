
package entidad;

public class registro_recetas {
    
    int id_receta;
    String codigo_receta;
    String nombre_paciente_e;
    String fechade_entrega;

    public registro_recetas() {
    }

    public registro_recetas(int id_receta, String codigo_receta, String nombre_paciente_e, String fechade_entrega) {
        this.id_receta = id_receta;
        this.codigo_receta = codigo_receta;
        this.nombre_paciente_e = nombre_paciente_e;
        this.fechade_entrega = fechade_entrega;
    }

    public int getId_receta() {
        return id_receta;
    }

    public void setId_receta(int id_receta) {
        this.id_receta = id_receta;
    }

    public String getCodigo_receta() {
        return codigo_receta;
    }

    public void setCodigo_receta(String codigo_receta) {
        this.codigo_receta = codigo_receta;
    }

    public String getNombre_paciente_e() {
        return nombre_paciente_e;
    }

    public void setNombre_paciente_e(String nombre_paciente_e) {
        this.nombre_paciente_e = nombre_paciente_e;
    }

    public String getFechade_entrega() {
        return fechade_entrega;
    }

    public void setFechade_entrega(String fechade_entrega) {
        this.fechade_entrega = fechade_entrega;
    }

    @Override
    public String toString() {
        return "registro_recetas{" + "id_receta=" + id_receta + ", codigo_receta=" + codigo_receta + ", nombre_paciente_e=" + nombre_paciente_e + ", fechade_entrega=" + fechade_entrega + '}';
    }
     
    
}
