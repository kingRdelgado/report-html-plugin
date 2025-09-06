package co.unicauca.microkernel.plugins.html;

import co.unicauca.microkernel.common.entities.Project;
import co.unicauca.microkernel.common.interfaces.IReportPlugin;

import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Plugin para generar reportes en formato HTML
 */
public class HtmlReportPlugin implements IReportPlugin {

    @Override
    public String generateReport(List<Project> data) {
        StringBuilder html = new StringBuilder();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        html.append("<!DOCTYPE html>\n");
        html.append("<html lang=\"es\">\n");
        html.append("<head>\n");
        html.append("   <title>Reporte de Proyectos de Grado</title>\n");
        html.append("</head>\n");
        html.append("<body>\n");
        html.append("    <h1>Reporte de Proyectos de Grado</h1>\n");
        html.append("    <table border=\"1\">\n");
        html.append("        <thead>\n");
        html.append("            <tr>\n");
        html.append("                <th>ID</th>\n");
        html.append("                <th>Nombre del Proyecto</th>\n");
        html.append("                <th>Fecha aprobación formato A</th>\n");
        html.append("                <th>Estudiante(s)</th>\n");
        html.append("                <th>Profesor</th>\n");
        html.append("                <th>Tipo</th>\n");
        html.append("                <th>Programa</th>\n");
        html.append("            </tr>\n");
        html.append("        </thead>\n");
        html.append("        <tbody>\n");

        for (Project p : data) {
            html.append("            <tr>\n");
            html.append("                <td>").append(p.getID()).append("</td>\n");
            html.append("                <td>").append(p.getNomProyecto()).append("</td>\n");
            html.append("                <td>").append(p.getFechaAprobacion().format(formatter)).append("</td>\n");
            html.append("                <td>").append(String.join(", ", p.getEstudiante())).append("</td>\n");
            html.append("                <td>").append(p.getProfesor()).append("</td>\n");
            html.append("                <td>").append(p.getTipo()).append("</td>\n");
            html.append("                <td>").append(p.getPrograma()).append("</td>\n");
            html.append("            </tr>\n");
        }

        html.append("        </tbody>\n");
        html.append("    </table>\n");
        html.append("</body>\n");
        html.append("</html>\n");

        return html.toString();
    }
}

