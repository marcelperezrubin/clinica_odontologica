<%@page import="com.marcelperezrubin.clinicaodontologica.logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="components/header.jsp"%>
<%@ include file="components/bodyprimeraparte.jsp"%>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">Ver Usuarios</h1>
<p class="mb-4">A Continuación podrá visualizar la lista completa de usuarios</p>

<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Usuarios</h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre de Usuario</th>
                        <th>Rol</th>
                        <th style="width: 210px">Accion</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>Id</th>
                        <th>Nombre de Usuario</th>
                        <th>Rol</th>
                        <th style="width: 210px">Accion</th>
                    </tr>
                </tfoot>

                <%
                    List<Usuario> listaUsuarios = (List<Usuario>) request.getSession().getAttribute("listaUsuarios");
                %>

                <tbody>
                    <% for (Usuario usu: listaUsuarios) { %>
                    <tr>
                        <td id="id_usu"><%=usu.getId_usuario() %></td>
                        <td><%=usu.getNombreUsuario() %></td>
                        <td><%=usu.getRol() %></td>
                        <td style="display: flex; width: 230px;">
                            <form name="eliminar" action="SvElimUsuarios" method="POST"> <!-- Esto es para enviar el codigo al servlet-->
                                <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color: red; margin-right: 5px;">
                                    <i class="fas fa-trash-alt"></i> Eliminar
                                </button>
                                <input type="hidden" name="id" value="<%=usu.getId_usuario() %>">
                            </form>
                            
                                <form name="editar" action="SvEditUsuarios" method="GET">
                                    <!-- Campo oculto que pasa el ID del usuario seleccionado al servlet para la edición -->
                                    <input type="hidden" name="id" value="<%=usu.getId_usuario()%>"> <!-- Añadir el parámetro id -->

                                    <!-- Botón para enviar el formulario y solicitar la edición del usuario -->
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left: 5px;">
                                        <i class="fas fa-pencil-alt"></i> Editar
                                    </button>
                                </form>

                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>
</div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<%@ include file="components/bodyfinal.jsp"%>
