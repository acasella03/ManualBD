# JAVA + SQLITE + MVC
#### Manual de conexión de la base de datos con JAVA usando el patrón MVC

### SQlite:
![imagenSQlite](https://github.com/acasella03/ManualBD/blob/master/imagenes/imagenSQlite.jpg)

Es una herramienta de software libre, que permite almacenar información en dispositivos de una forma sencilla, eficaz, potente, rápida y en equipos con pocas capacidades de hardware, como puede ser un PDA o un móvil.

### Características de SQlite:
* La base de datos completa se encuentra en un solo archivo.
* Puede funcionar enteramente en memoria, lo que la hace muy rápida.
* Es totalmente autocontenida (sin dependencias externas).
* Cuenta con librerías de acceso para muchos lenguajes de programación.
* Soporta texto en formato UTF-8 y UTF-16, así como datos numéricos de 64 bits.
* Soporta funciones SQL definidas por el usuario.
* El código fuente es de dominio público y se encuentra muy bien documentado.

### Conexión a SQLITE desde Netbeans (JAVA)
1. Descargar el ejecutable (.jar) desde http://www.sqlite.org/
2. Crear un proyecto nuevo en Netbeans y en el apartado de librerías añadir dicho ejecutable.<br>
![Ejecutable](https://github.com/acasella03/ManualBD/blob/master/imagenes/1.png)<br>
3. En la opción **Window** de Netbeans, seleccionar **Services**.<br>
![Window](https://github.com/acasella03/ManualBD/blob/master/imagenes/2.png)<br>
4. En la carpeta del proyecto crear una nueva carpeta donde se creará un fichero (.db) para guardar los datos de la base de datos.<br>
![Carpeta](https://github.com/acasella03/ManualBD/blob/master/imagenes/3.png)
![Fichero](https://github.com/acasella03/ManualBD/blob/master/imagenes/4.png)<br>
5. Dentro de **Services**, hacer clic con el botón derecho sobre la opción **Databases** y seleccionar **New Connection…**<br>
![Services](https://github.com/acasella03/ManualBD/blob/master/imagenes/5.png)<br>
6. En el desplegable de **Driver** seleccionar **New Driver** porque SQlite no es una opción por defecto.<br>
![Driver](https://github.com/acasella03/ManualBD/blob/master/imagenes/6.png)<br>
7. Se abre una ventana ***New JDBC Driver***, seleccionar el botón **Add…**, buscar el ejecutable (.jar) de SQlite, seleccionarlo y abrirlo.<br>
![JDBC](https://github.com/acasella03/ManualBD/blob/master/imagenes/7.png)<br>
8. Volviendo a la ventana ***New Connection Wizard***, seleccionar **Next >** <br>
![NewConnection](https://github.com/acasella03/ManualBD/blob/master/imagenes/8.png)<br>
9. Ahora hay que asociar el fichero (.db) a la base de datos colocando la ruta completa en la opción JDBC URL. No se necesita usuario y password.
   Seleccionar el botón **Test Connection** para probar que el fichero es correcto y luego seleccionar el botón **Finish**.<br>
![Ficherodb](https://github.com/acasella03/ManualBD/blob/master/imagenes/9.png)<br>
10. Ya está asociada la base de datos con el proyecto.<br>
![BDConectada](https://github.com/acasella03/ManualBD/blob/master/imagenes/10.png)<br>
11. A continuación se creará la tabla que va a recibir todos los datos necesarios, hacer clic con el botón derecho sobre la base de datos y seleccionar  **Execute Command…**<br>
![CreacionTabla](https://github.com/acasella03/ManualBD/blob/master/imagenes/11.png)<br>
12. Crear la tabla con comando SQL y recordar colocar una primary key.<br>
![Comando](https://github.com/acasella03/ManualBD/blob/master/imagenes/12.png)<br>
13. Luego seleccionar **Run SQL** para guardar la tabla.
14. Una vez guardada, se visualizará así:<br>
![Tabla](https://github.com/acasella03/ManualBD/blob/master/imagenes/13.png)

### MVC (Modelo-Vista-Controlador)
Es un ***patrón de diseño*** de software comúnmente utilizado para implementar interfaces de usuario, datos y lógica de control.

Las **tres partes** del patrón se pueden describir de la siguiente manera:
1. **Modelo:** Maneja datos y lógica.
2. **Vista:** Se encarga del diseño y presentación.
3. **Controlador:** Enruta comando a los modelos y vistas.

![Diagrama](https://github.com/acasella03/ManualBD/blob/master/imagenes/DiagramaFuncionamientoMVC.jpg)

### Clase [Alumno](https://github.com/acasella03/ManualBD/blob/master/src/manualbd/Modelo/Alumno.java).java
### Clase [Conector](https://github.com/acasella03/ManualBD/blob/master/src/manualbd/Modelo/Conector.java).java
### Clase [CtrlAlumno](https://github.com/acasella03/ManualBD/blob/master/src/manualbd/Controlador/CtrlAlumno.java).java
### Ventana (Interfaz Gráfica para el usuario)
![UI](https://github.com/acasella03/ManualBD/blob/master/imagenes/26.png)