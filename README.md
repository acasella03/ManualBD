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
2. Crear un proyecto nuevo en Netbeans y en el apartado de librerías añadir dicho ejecutable.
![Ejecutable](https://github.com/acasella03/ManualBD/blob/master/imagenes/1.png)
3. En la opción Window de Netbeans, seleccionar Services.
![Window](https://github.com/acasella03/ManualBD/blob/master/imagenes/2.png)
4. En la carpeta del proyecto crear una nueva carpeta donde se creará un fichero (.db) para guardar los datos de la base de datos.
![Carpeta](https://github.com/acasella03/ManualBD/blob/master/imagenes/3.png)
![Fichero](https://github.com/acasella03/ManualBD/blob/master/imagenes/4.png)
5. Dentro de Services, hacer clic con el botón derecho sobre la opción Databases y seleccionar New Connection…
![Services](https://github.com/acasella03/ManualBD/blob/master/imagenes/5.png)
6. En el desplegable de Driver seleccionar New Driver porque SQlite no es una opción por defecto.
![Driver](https://github.com/acasella03/ManualBD/blob/master/imagenes/6.png)
7. Se abre una ventana New JDBC Driver, seleccionar el botón Add…, buscar el ejecutable (.jar) de SQlite, seleccionarlo y abrirlo.
![JDBC](https://github.com/acasella03/ManualBD/blob/master/imagenes/7.png)
8. Volviendo a la ventana New Connection Wizard, seleccionar Next >
![NewConnection](https://github.com/acasella03/ManualBD/blob/master/imagenes/8.png)
9. Ahora hay que asociar el fichero (.db) a la base de datos colocando la ruta completa en la opción JDBC URL. No se necesita usuario y password.
   Seleccionar el botón Test Connection para probar que el fichero es correcto y luego seleccionar el botón Finish.
![Ficherodb](https://github.com/acasella03/ManualBD/blob/master/imagenes/9.png)
10. Ya está asociada la base de datos con el proyecto.
![BDConectada](https://github.com/acasella03/ManualBD/blob/master/imagenes/10.png)
11. A continuación se creará la tabla que va a recibir todos los datos necesarios, hacer clic con el botón derecho sobre la base de datos y seleccionar  Execute Command…
![CreacionTabla](https://github.com/acasella03/ManualBD/blob/master/imagenes/11.png)
12. Crear la tabla con comando SQL y recordar colocar una primary key.
![Comando](https://github.com/acasella03/ManualBD/blob/master/imagenes/12.png)
13. Luego seleccionar Run SQL para guardar la tabla.
14. Una vez guardada, se visualizará así:
![Tabla](https://github.com/acasella03/ManualBD/blob/master/imagenes/13.png)

### MVC (Modelo-Vista-Controlador)
![Diagrama](https://github.com/acasella03/ManualBD/blob/master/imagenes/DiagramaFuncionamientoMVC.jpg)
