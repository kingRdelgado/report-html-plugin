package co.unicauca.microkernel.plugins.html;

import co.unicauca.microkernel.common.entities.Project;
import co.unicauca.microkernel.common.interfaces.IReportPlugin;

import java.util.List;

/**
 * Plugin que genera un reporte en formato HTML para los proyectos de grado.
 */
public class HtmlReportPlugin implements IReportPlugin {

    @Override
    public String generateReport(List<Project> data) {
        StringBuilder html = new StringBuilder();

        html.append("<html><head><title>Reporte de Proyectos</title></head><body>");
        html.append("<h1>Listado de Proyectos de Grado</h1>");
        html.append("<table border='1'>");
        html.append("<tr>")
            .append("<th>ID</th>")
            .append("<th>Nombre Proyecto</th>")
            .append("<th>Fecha Aprobación</th>")
            .append("<th>Estudiantes</th>")
            .append("<th>Profesor</th>")
            .append("<th>Tipo</th>")
            .append("<th>Programa</th>")
            .append("</tr>");

        for (Project p : data) {
            html.append("<tr>")
                .append("<td>").append(p.getID()).append("</td>")
                .append("<td>").append(p.getNomProyecto()).append("</td>")
                .append("<td>").append(p.getFechaAprobacion()).append("</td>")
                .append("<td>").append(String.join(", ", p.getEstudiante())).append("</td>")
                .append("<td>").append(p.getProfesor()).append("</td>")
                .append("<td>").append(p.getTipo()).append("</td>")
                .append("<td>").append(p.getPrograma()).append("</td>")
                .append("</tr>");
        }

        html.append("</table>");
        html.append("</body></html>");

        return html.toString();
    }
}

