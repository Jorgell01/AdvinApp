# AdvinApp
AdvinApp es una aplicación de juego interactiva desarrollada en JavaFX donde los usuarios intentan adivinar un número aleatorio del 1 al 100. La aplicación proporciona retroalimentación inmediata sobre si el número introducido es mayor o menor que el número a adivinar, y lleva un conteo de los intentos realizados por el jugador.

**Características**
Juego de adivinanza: El jugador debe adivinar un número generado aleatoriamente entre 1 y 100.
Retroalimentación en tiempo real: La aplicación informa al jugador si el número ingresado es menor o mayor que el número objetivo.
Contador de intentos: Se registra el número de intentos realizados por el jugador y se muestra al ganar.
Manejo de errores: Se incluye validación para asegurar que solo se acepten entradas numéricas.
**Requisitos**
Java 8 o superior
JavaFX: La aplicación está construida utilizando JavaFX, por lo que debe estar correctamente configurado en el entorno de desarrollo.
Estructura del proyecto
**El proyecto incluye la siguiente estructura principal:**

Main Class: AdvinApp.java
Contiene la lógica del juego, incluyendo la generación de números aleatorios y la verificación de las entradas del jugador.
Presenta una interfaz gráfica para interactuar con el usuario.
Instalación y uso
Clona o descarga el repositorio en tu máquina local.
Asegúrate de tener configurado JavaFX en tu entorno de desarrollo.
Ejecuta la aplicación desde tu IDE o mediante la línea de comandos.
Introduce un número en el campo de texto y presiona el botón "Comprobar" para verificar si has adivinado el número correcto.
Recibirás retroalimentación sobre tu intento y podrás seguir adivinando hasta que aciertes.
Validación de entrada
La aplicación valida la entrada del usuario para asegurarse de que solo se introduzcan números. Si se introduce un valor no válido, se mostrará un mensaje de error.

Mensajes de alerta
Ganador: Al adivinar el número correcto, la aplicación muestra un mensaje de victoria que incluye el número de intentos utilizados.
Fallos: Si el número ingresado no es el correcto, se proporciona retroalimentación indicando si el número a adivinar es mayor o menor.
Error: Ocurre cuando se introduce texto o algo que difiera de un número (dejar el campo vacío tambien genera esta alerta).
