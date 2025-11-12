package medibuddy;

public class Familiar extends Usuario {
    public String relacion;
    public AdultoMayor adultoMayorAsociado;

    public Familiar(int idUsuario, String nomUsuario, String tipoUsuario, String telefono, String relacion, AdultoMayor adultoMayorAsociado) {
        super(idUsuario, nomUsuario, tipoUsuario, telefono);
        this.relacion = relacion;
        this.adultoMayorAsociado = adultoMayorAsociado;
    }

    public void asociar_adulto_mayor(AdultoMayor adulto) {
        this.adultoMayorAsociado = adulto;
    }
    
    @Override
    public String obtener_datos() {
        return nomUsuario + " - Relación: " + relacion + " con " + adultoMayorAsociado.getNomUsuario();
    }
}

