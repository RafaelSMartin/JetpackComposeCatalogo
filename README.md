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