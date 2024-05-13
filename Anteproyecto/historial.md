# Diario proyecto final

### Día 1 (11/03/2024)

Empezar la creación del modelo de datos de la aplicación, y del diseño de esta en Figma.

### Día 2 (12/03/2024)

Seguir trabajando en el modelo de datos y el diseño de todas las pantallas de la aplicación en Figma.

### Día 3 (13/03/2024)

Termine el modelo de datos, el excel con los ejemplos y el proyecto de Figma, por último lo entregue todo en GitHub, en el archivo “Anteproyecto”, junto a las capturas del trabajo.

### Día 4 (16/03/2024)

Búsqueda de información sobre la API TMDB y obtención de la clave necesaria para esta.

### Día 5 (18/03/2024)

Empeze a programar la navegación entre pantallas, termite las pantallas de login y registro, ademas tambien hice la TopBar, a parte Realize un taller de Git y GitHub, utilizamos el repositorio de GitHub "little lemon menu" para ello.

### Día 6 (19/03/2024)

Empecé a trabajar con el menú desplegable, el cual estuvo dándome problemas y no he terminado de solucionar. Tambien cambie el color primario de la aplicacion ha negro y el color de los iconos a blanco.

### Día 7 (20/03/2024)

- Comencé moviendo el nav host a una función aparte
- Tuve problemas con la variable showTopBar
- Creación de la pantalla de perfil, la pantalla de listas, un archivo para el menú desplegable.
- Edite el AndroidManifest.xml añadiendo el "uses-permission"

### Día 8 (24/03/2024)

Busque información sobre unos problemas que tenia con el nav host y el menu desplegable, posteriormente termine:
- Cree paquete componentes y añadi la clase InfoMenuDesplegable, que es donde se guarda la informacion del menu desplegable, MenuLateral y TopBarCinemalist
- Cree la función contenido a la cual movi el scafold que estba en la función MyApp
- Refactorize el archivo MyApp para facilitarme la modularidad del topbar y el menú

### Día 9 (30/03/2024)

- Cree carpeta "views" donde meti todas las pantallas
- Refactorize un poco todos los archivos que tenia

### Día 10 (01/04/2024)

Hoy he terminado de implementar la API con retrofit, ademas de añadir nombres de peliculas a la pantalla principal
- Cree clase PeliculasResponse
- Cree CardPelicula
- CreeWebServise
- Cree RetrofitClient

### Día 11 (02/04/2024)

Hoy por fin termine de conectar la Api y conseguí que se viesen los posters de las películas, a parte también hice:
- Añadir Upcoming y top_rated a las consultas de la Api
- Apartados cartelera, populares, por salir y top puntuación en la pantalla principal
- Cree pantalla ficha y todo la que lleva dentro

### Despues de la presentación y antes del 17 de mayo

Durante este periodo de tiempo he intentado mejorara las portadas de las peliculas, y la pantlla principal, 
también he trabajado en el viewModel y en la pantalla "ficha", no he podido lograr grandes cambios ya que sigo trabado
y sin poder avanzar debido a los mismos problemas que antes de la presentación. La aplicación funciona correctamente 
teniendo en cuenta el contenido dado en clase antes de empezar con el proyecto, el cual esta todo aplicado en la aplicación.