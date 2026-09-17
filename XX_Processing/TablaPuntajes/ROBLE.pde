// ==================================================
//  ROBLE - conexion con la base de datos
// ==================================================
//  Esta pestana NO hace falta modificarla.
//  Desde la otra pestana solo se llaman estas 3:
//
//    iniciarSesion(correo, clave)   -> true si entro
//    guardarPuntaje(nombre, valor)  -> guarda una fila
//    cargarPuntajes()               -> llena nombres[], marcas[] y n
//
//  En la consola de Roble debe existir la tabla:
//    puntajes  con columnas  nombre (texto)  y  puntaje (entero)
// ==================================================

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStream;
import java.io.InputStream;

String token = "";          // llave que entrega Roble al iniciar sesion
int codigoRespuesta = 0;    // 200-299 = todo bien


boolean iniciarSesion(String email, String password) {
  JSONObject datos = new JSONObject();
  datos.setString("email", email);
  datos.setString("password", password);

  String respuesta = enviar("POST", URL_ROBLE + "/auth/" + CONTRATO + "/login", datos.toString());

  if (salioBien()) {
    token = parseJSONObject(respuesta).getString("accessToken");
    return true;
  }
  return false;
}


void guardarPuntaje(String nombre, int valor) {
  JSONObject fila = new JSONObject();
  fila.setString("nombre", nombre);
  fila.setInt("puntaje", valor);

  JSONObject datos = new JSONObject();
  datos.setString("tableName", "puntajes");
  datos.setJSONObject("record", fila);

  enviar("POST", URL_ROBLE + "/database/" + CONTRATO + "/insert-one", datos.toString());
}


void cargarPuntajes() {
  n = 0;
  String respuesta = enviar("GET", URL_ROBLE + "/database/" + CONTRATO + "/read?tableName=puntajes", null);

  if (salioBien()) {
    JSONArray filas;
    if (respuesta.trim().startsWith("[")) {
      filas = parseJSONArray(respuesta);
    } else {
      filas = parseJSONObject(respuesta).getJSONArray("data");
    }

    for (int i = 0; i < filas.size() && n < nombres.length; i++) {
      JSONObject fila = filas.getJSONObject(i);
      nombres[n] = fila.getString("nombre", "?");
      marcas[n] = fila.getInt("puntaje", 0);
      n = n + 1;
    }
  }
}


// ---------- Uso interno ----------

boolean salioBien() {
  return codigoRespuesta >= 200 && codigoRespuesta < 300;
}

// Hace la peticion HTTP y devuelve el texto que responde Roble
String enviar(String metodo, String direccion, String cuerpo) {
  codigoRespuesta = 0;
  try {
    HttpURLConnection con = (HttpURLConnection) new URL(direccion).openConnection();
    con.setRequestMethod(metodo);
    con.setConnectTimeout(10000);
    con.setReadTimeout(10000);
    con.setRequestProperty("Content-Type", "application/json");
    if (token.length() > 0) {
      con.setRequestProperty("Authorization", "Bearer " + token);
    }

    if (cuerpo != null) {
      con.setDoOutput(true);
      OutputStream salida = con.getOutputStream();
      salida.write(cuerpo.getBytes("UTF-8"));
      salida.close();
    }

    codigoRespuesta = con.getResponseCode();

    InputStream entrada;
    if (codigoRespuesta < 400) {
      entrada = con.getInputStream();
    } else {
      entrada = con.getErrorStream();
    }
    if (entrada == null) {
      return "";
    }

    String texto = join(loadStrings(entrada), "\n");
    if (!salioBien()) {
      println("Roble respondio " + codigoRespuesta + ": " + texto);
    }
    return texto;
  } catch (Exception e) {
    println("Error de conexion: " + e.getMessage());
    return "";
  }
}
