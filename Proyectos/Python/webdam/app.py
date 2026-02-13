from flask import Flask

app = Flask(__name__)

@app.route('/')
def home():
    return "<h1>Hello World!</h1>"

@app.route('/saludo/<nombre>')
def saludo(nombre):
    return f"<h1>Hola, {nombre}!</h1>"

if __name__ == '__main__':
    app.run(debug=True)
    