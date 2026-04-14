#!/bash/bin

clear

echo "EXAMEN SISTEMAS: APARTADO 2"

read -p "Introduzca un nombre de directorio: " directorio

if [[ -d $directorio ]] then
	echo "El nombre del directorio ya existe."
	read -p "Pulsa C para volver a intentarlo, B para borrar, R para renombrar, S para salir " opcion
	if [[ $opcion == "B" || $opcion == "b" ]] then
		 rm -rf $directorio/
		 echo "El directorio $directorio fue borrado. Pulse una tecla para sair"
		 exit 1
	elif [[ $opcion == "r" || $opcion == "R" ]] then
		clear
		read -p "Como deseas nombrar el directorio?" nuevoNombre
		if [[ -d $nuevoNombre ]] then
			echo "El directorio $nuevoNombre ya existe. Pulse una tecla para salir"
			exit 0
		else
			mv $directorio $nuevoNombre
			echo "El directorio $nuevoNombre fue renombrado con exito"
			exit 1
		fi
	elif [[ $opcion == "s" || $opcion == "S" ]] then
		read -p "Realmente deseas salir? [s/n]" salir
		if [[ $salir == "s" || $salir == "S" ]] then
				clear
				echo "Gracias por usar nuestra aplicacion"
				exit 0
		else
			bash ./apartado2.sh
		fi
	elif [[ $opcion == "c" || $opcion == "C" ]] then
		bash ./apartado2.sh
	else
		echo "Opcion no valida"
		exit 0
	fi
else
	mkdir ./$directorio/
	echo "Directorio $directorio credo con exito!"
fi
