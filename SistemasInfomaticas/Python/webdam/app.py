from flask import Flask, redirect, render_template, request, make_response

app = Flask(__name__)

@app.route('/')
def home():
    return render_template('index.html')

@app.route('/saludo/<nombre>')
def saludo(nombre):
    return f"<h1>Hola, {nombre}!</h1>"

@app.route('/form_login')  # Define la ruta para manejar solicitudes GET en '/form_login'
def login():
    # Renderiza la plantilla HTML llamada 'login_template.html' cuando se accede a la ruta '/form_login'
    return render_template('login_template.html')  # Devuelve la plantilla de login para que se muestre en el navegador

@app.route('/sign_in', methods=['POST'])  # Define la ruta para el método POST en /sign_in
def sign_in():
    # Obtener los datos del formulario (login y contraseña)
    login = request.form['login']  # Obtiene el valor del campo 'login' (correo o usuario)
    passwd = request.form['passwd']  # Obtiene el valor del campo 'passwd' (contraseña)
    
    # Imprimir el usuario y la contraseña en la consola (para propósitos de depuración)
    print(f'Usuario: {login}')  # Muestra el login (usuario o correo)
    print(f'Contraseña: {passwd}')  # Muestra la contraseña
    
    # Crear una respuesta de redirección a la página '/login_ok'
    response = make_response(redirect('/login_ok'))  # Redirige a la página '/login_ok'
    
    # Establecer una cookie con el token JWT (ejemplo en este caso)
    response.set_cookie('token', 'esto es un token de ejemplo')  # Se establece una cookie llamada 'token'
    
    # Establecer una cookie con el nombre de usuario (ejemplo en este caso)
    response.set_cookie('userlogin', 'el usuario')  # Se establece una cookie llamada 'userlogin'
    
    # Devolver la respuesta con las cookies configuradas
    return response  # Retorna la respuesta con las cookies y la redirección

@app.route('/login_ok')  # Define la ruta para manejar solicitudes GET en '/login_ok'
def login_ok():
    # Renderiza la plantilla HTML llamada 'login_ok_template.html' cuando se accede a la ruta '/login_ok'
    return render_template('login_ok_template.html')  # Devuelve la plantilla de login_ok para que se muestre al usuario

@app.route('/registro')  # Ruta para la página de registro (puedes crear esta página después)
def registro():
    return "<h1>Página de registro - Próximamente</h1>"
if __name__ == '__main__':
    app.run(host='0.0.0.0', port=80)
    