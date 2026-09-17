// ==================================================
//  ATRAPA EL CIRCULO - Tabla de puntajes con ROBLE
//  Algoritmia y Programacion II - Monitoria
// ==================================================
//  Pestanas del sketch:
//    TablaPuntajes -> pantallas y juego (aqui se trabaja)
//    ROBLE         -> conexion con Roble (solo se usa)
//
//  Pantallas:
//    0 = iniciar sesion
//    1 = jugando
//    2 = mejores puntajes
// ==================================================

// ---------- Datos del proyecto en Roble ----------
// Se copian de la consola: roble.uninorte.edu.co
String URL_ROBLE = "https://roble-api.uninorte.edu.co";
String CONTRATO  = "tu_contrato_aqui";

// ---------- Pantalla actual ----------
int pantalla = 0;

// ---------- Inicio de sesion ----------
String correo  = "";
String clave   = "";
int campo      = 0;     // 0 = escribiendo correo, 1 = escribiendo clave
String mensaje = "";
String jugador = "";    // lo que va antes del @ en el correo

// ---------- Juego ----------
int puntos = 0;
float circuloX = 0;
float circuloY = 0;
float TAM = 50;
int inicio = 0;         // momento (en ms) en que empezo la partida
int DURACION = 15;      // segundos que dura cada partida

// ---------- Tabla de puntajes (vectores paralelos) ----------
// nombres[i] y marcas[i] son del mismo jugador
String[] nombres = new String[200];
int[] marcas = new int[200];
int n = 0;              // cuantos puntajes hay cargados


void setup() {
  size(600, 500);
  textAlign(CENTER, CENTER);
  rectMode(CENTER);
  strokeWeight(2);
}

void draw() {
  background(30);

  if (pantalla == 0) {
    dibujarLogin();
  } else if (pantalla == 1) {
    dibujarJuego();
  } else {
    dibujarTabla();
  }
}


// ==================================================
//  PANTALLA 0: INICIAR SESION
// ==================================================

void dibujarLogin() {
  fill(255);
  textSize(32);
  text("ATRAPA EL CIRCULO", width/2, 80);

  textSize(16);
  text("Correo", width/2, 170);
  dibujarCaja(205, correo, campo == 0);

  // La clave se muestra con asteriscos
  String oculta = "";
  for (int i = 0; i < clave.length(); i++) {
    oculta = oculta + "*";
  }
  text("Clave", width/2, 260);
  dibujarCaja(295, oculta, campo == 1);

  fill(160);
  text("TAB o clic para cambiar de campo  -  ENTER para entrar", width/2, 360);

  fill(255, 200, 0);
  text(mensaje, width/2, 410);
}

void dibujarCaja(float y, String contenido, boolean activa) {
  if (activa) {
    stroke(0, 200, 255);
  } else {
    stroke(90);
  }
  fill(50);
  rect(width/2, y, 350, 40);
  noStroke();
  fill(255);
  text(contenido, width/2, y);
}

void teclaLogin() {
  if (key == TAB) {
    campo = 1 - campo;                     // alterna entre 0 y 1
  } else if (key == ENTER || key == RETURN) {
    entrar();
  } else if (key == BACKSPACE) {
    borrarLetra();
  } else if (key != CODED && key >= ' ' && key != DELETE) {
    if (campo == 0) {
      correo = correo + key;
    } else {
      clave = clave + key;
    }
  }
}

void borrarLetra() {
  if (campo == 0 && correo.length() > 0) {
    correo = correo.substring(0, correo.length() - 1);
  }
  if (campo == 1 && clave.length() > 0) {
    clave = clave.substring(0, clave.length() - 1);
  }
}

void entrar() {
  int arroba = correo.indexOf("@");

  if (arroba == -1) {
    mensaje = "El correo debe tener @";
  } else if (iniciarSesion(correo, clave)) {
    jugador = correo.substring(0, arroba);
    clave = "";
    mensaje = "";
    empezarJuego();
  } else {
    mensaje = "Correo o clave incorrectos";
  }
}


// ==================================================
//  PANTALLA 1: JUEGO
// ==================================================

void empezarJuego() {
  puntos = 0;
  moverCirculo();
  inicio = millis();
  pantalla = 1;
}

void moverCirculo() {
  circuloX = random(TAM, width - TAM);
  circuloY = random(TAM + 40, height - TAM);
}

void dibujarJuego() {
  int restante = DURACION - (millis() - inicio) / 1000;

  fill(255);
  textSize(18);
  text(jugador + "   Puntos: " + puntos + "   Tiempo: " + restante, width/2, 20);

  fill(255, 80, 80);
  ellipse(circuloX, circuloY, TAM, TAM);

  if (restante <= 0) {
    terminarJuego();
  }
}

void clicJuego() {
  // Si el clic cayo dentro del circulo, suma y lo mueve
  if (dist(mouseX, mouseY, circuloX, circuloY) < TAM / 2) {
    puntos = puntos + 1;
    moverCirculo();
  }
}

void terminarJuego() {
  guardarPuntaje(jugador, puntos);
  cargarPuntajes();
  ordenarPuntajes();
  pantalla = 2;
}


// ==================================================
//  PANTALLA 2: MEJORES PUNTAJES
// ==================================================

// Burbuja descendente sobre vectores paralelos:
// cuando se intercambia una marca, se intercambia tambien su nombre
void ordenarPuntajes() {
  for (int i = 0; i < n - 1; i++) {
    for (int j = 0; j < n - 1 - i; j++) {
      if (marcas[j] < marcas[j + 1]) {
        int aux = marcas[j];
        marcas[j] = marcas[j + 1];
        marcas[j + 1] = aux;

        String auxNombre = nombres[j];
        nombres[j] = nombres[j + 1];
        nombres[j + 1] = auxNombre;
      }
    }
  }
}

void dibujarTabla() {
  fill(255);
  textSize(30);
  text("MEJORES PUNTAJES", width/2, 60);

  textSize(18);
  fill(0, 200, 255);
  text("Tu puntaje: " + puntos, width/2, 110);

  // Solo los 5 primeros (o menos, si no hay tantos)
  for (int i = 0; i < n && i < 5; i++) {
    float y = 170 + i * 45;
    if (nombres[i].equals(jugador)) {
      fill(255, 200, 0);                   // resalta al jugador actual
    } else {
      fill(255);
    }
    text((i + 1) + ".   " + nombres[i] + "   " + marcas[i], width/2, y);
  }

  if (n == 0) {
    fill(160);
    text("No se pudieron cargar los puntajes", width/2, 200);
  }

  fill(160);
  text("ESPACIO para jugar otra vez", width/2, 450);
}


// ==================================================
//  TECLADO Y MOUSE
// ==================================================

void keyPressed() {
  if (pantalla == 0) {
    teclaLogin();
  } else if (pantalla == 2 && key == ' ') {
    empezarJuego();
  }
}

void mousePressed() {
  if (pantalla == 0) {
    // Clic en la mitad de arriba = correo, abajo = clave
    if (mouseY < 250) {
      campo = 0;
    } else {
      campo = 1;
    }
  } else if (pantalla == 1) {
    clicJuego();
  }
}
