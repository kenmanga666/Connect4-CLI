# Nom du binaire à produire
BINARY_NAME=Puissance4

# Liste explicite des fichiers source
SOURCES :=  src/Puissance4.java \
            src/Grid.java \
            src/Color.java \
            src/winCondition.java \
            src/Clear.java

# Assurez-vous que le shell et l'encodage sont définis pour UTF-8
SHELL := /bin/bash
export LC_ALL=C.UTF-8

# Commande par défaut
default: run

# Commande de build
build:
	@echo -e "Construction du projet..."
	javac -d build -cp . $(SOURCES)

# Commande pour nettoyer le projet (supprimer le binaire)
clean:
	@echo -e "Nettoyage..."
	rm -rf build
	rm -f $(BINARY_NAME)

# Commande pour exécuter le programme
run: build
	@echo -e "Execution du programme..."
	java -cp build src/$(BINARY_NAME)

# Option 'phony' pour indiquer que 'clean', 'run', et 'build' ne sont pas des fichiers
.PHONY: build clean run
