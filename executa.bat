@echo off

if exist bin (
	echo  *** Executando projeto ***
	java -cp lib/ojdbc6.jar;bin Principal
)