@echo off

if not exist bin (
	echo  *** Criando Diretorio bin ***
	mkdir bin
)

echo  *** Compilando projeto ***
javac -cp lib/ojdbc6.jar -sourcepath src -d bin src/*.java