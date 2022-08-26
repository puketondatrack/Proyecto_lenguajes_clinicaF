
package entidad;

public class registro_citas {
    int id_cita;
    String nombre_paciente;
    String motivo_cita;
    String fecha_cita;
    String hora_cita;

    public registro_citas() {
    }

    public registro_citas(int id_cita, String nombre_paciente, String motivo_cita, String fecha_cita, String hora_cita) {
        this.id_cita = id_cita;
        this.nombre_paciente = nombre_paciente;
        this.motivo_cita = motivo_cita;
        this.fecha_cita = fecha_cita;
        this.hora_cita = hora_cita;
    }

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public String getNombre_paciente() {
        return nombre_paciente;
    }

    public void setNombre_paciente(String nombre_paciente) {
        this.nombre_paciente = nombre_paciente;
    }

    public String getMotivo_cita() {
        return motivo_cita;
    }

    public void setMotivo_cita(String motivo_cita) {
        this.motivo_cita = motivo_cita;
    }

    public String getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(String fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public String getHora_cita() {
        return hora_cita;
    }

    public void setHora_cita(String hora_cita) {
        this.hora_cita = hora_cita;
    }

    @Override
    public String toString() {
        return "registro_citas{" + "id_cita=" + id_cita + ", nombre_paciente=" + nombre_paciente + ", motivo_cita=" + motivo_cita + ", fecha_cita=" + fecha_cita + ", hora_cita=" + hora_cita + '}';
    }

    
}


