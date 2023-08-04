# JetpackComposeCatalogo
Box<br>
-Son los mas sencillos, como frameLayouts<br>
-Se pueden anidar<br>
-Si no se le indica altura o anchura solo cogera lo que necesite, wrap_content<br>
-contentAligment -> permite alinear solo el contenido<br>
-fillMaxSize -> ocupa todo el ancho y alto<br>
-width y height -> ocupa el ancho y/o alto indicado<br>
-background -> pinta el color indicado<br>

Text<br>
-verticalScroll -> si el texto no cabe para que haga scroll, lleva rememberScrollState()

Column<br>
-Como un linearLayout en posicion vertical<br>
-El tamaño de columna es el tamaño de sus hijos<br>
-weight -> peso que se coge para pintar en pantalla<br>
-verticalArrangement -> podemos definir como comportarse los hijos en su separacion<br>

Row<br>
-Como un linearLayout en posicion horizontal<br>
-Tiene los mismo atributos q Column

Spacer<br>
-Se suele usar a modo de layout al no tener margenes en compose

ConstraintLayout<br>
-createRefs -> crea los id para poder referenciar los elementos composables<br>
-constrainAs & linkTo -> engancha los constraints, admiten margenes<br>
-createGuideline -> crea una linea invisible para poder engancharme<br>
-createBarrier -> crea una barrera referenciando elementos<br>
-createChain -> union de elementos<br>


Estados<br>
-mutableStateOf -> asi se declaran variables en compose<br>
-remember -> debido al recomposicion de vistas es necesario para no perder valores de las variables<br>
-.value -> para acceder al valor de la variable para leer o escribirla.<br>
-Ejemplo -> val counter = remember { mutableStateOf(0) } // counter.value += 1 // aunque no nos guarda si se rota pantalla por el ciclo de vida<br>
-rememberSaveable -> mantiene el estado aunque la vista se destruya.
-by -> para evitar usar .value //var counter by rememberSaveable { mutableStateOf(0) } // counter += 1

Text, TextField y OutlinedTextField<br>

State Hoisting<br>
-Elevar el estado al principal común más bajo entre todos lo elementos componibles.

