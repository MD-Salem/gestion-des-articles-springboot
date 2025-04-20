# Système de Gestion des Articles

Une application Spring Boot pour la gestion des articles avec authentification JWT.

## Instructions d'Installation et d'Exécution

### Prérequis
- Java 17 ou supérieur
- Maven 3.6+
- MySQL 8.0+
- Git

### Configuration Backend

1. **Cloner le Répertoire**
   ```bash
   git clone https://github.com/MD-Salem/gestion-des-articles-springboot.git
   cd articles
   ```

2. **Configuration de la Base de Données**
   - Créer une base de données MySQL nommée `articles_db`
   - Mettre à jour `src/main/resources/application.properties` avec vos identifiants de base de données

3. **Compiler et Exécuter**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
   L'API backend sera disponible sur `http://localhost:8080`

### Configuration Frontend

1. **Cloner le Répertoire Frontend**
   ```bash
   git clone https://github.com/medsaddemhamdi/articles-frontend.git
   cd articles-frontend
   ```

2. Suivez les instructions d'installation dans le README du répertoire frontend

## Documentation de l'API

Une fois l'application lancée, vous pouvez accéder à la documentation de l'API sur :
- Interface Swagger : `http://localhost:8080/swagger-ui.html`
- Documentation API : `http://localhost:8080/v3/api-docs`

## Fonctionnalités

- Gestion des articles (opérations CRUD)
- Gestion des auteurs
- Authentification utilisateur avec JWT
- Contrôle d'accès basé sur les rôles
- Points de terminaison API RESTful
- Documentation Swagger