# Projet

# Côté front-end :
## CCO2 client

Front-end single-page application for the CCO2 project

## Prerequisites

- Install npm: `sudo apt install npm` 

- _(optional)_ Install yarn: `npm install -g yarn`

## Project setup
`yarn install`
or `npm install`

### Compiles and hot-reloads for development
`yarn serve` or `npm run serve`

### Compiles and minifies for production
`yarn build` or `npm run build`

### Run your unit tests
`yarn test:unit` or `npm run test:unit`

### Lints and fixes files
`yarn lint` or `npm run lint`

# Côté back-end :

## Base de données:

Données de consommation tirées de https://www.miningbenchmark.net/

Données des emissions tirées de https://www.statista.com/statistics/1190067/carbon-intensity-outlook-of-france/

En cas de probleme avec la BD, supprimer le WAR manuellement de tomcat

## API
```
All methods are POST, all require x-access-token except login and register
```
```
/register            cree un nouvel utilisateur
params:
-username
-password
```
```
/login               renvoie un token d'acces
params:
-username
-password
```
```
/test                affiche tous les mineurs
```
```
/home                affiche les fermes de l'utilisateur
```
```
/farm/add            ajoute une ferme
params:
-name         Nom de la nouvelle ferme
```
```
/farm/remove         supprime une ferme
params:
-id           ID de la ferme
```
```
/farm/show/<farmId>  affiche les mineurs dans la ferme
```
```
/farm/<farmId>/add   ajoute un mineur dans une ferme
params:
-miner        ID du mineur
```
```
/farm/<farmId>/remove   supprime un mineur d'une ferme
params:
-miner        ID du mineur
```
```
/miner/search        recherche les mineurs par nom
params:
-search       Nom partiel du mineur
```


# Contributeurs :

Melvyn Bertolone--Lopez-Serrano (p1804487 / Wilalde / odshell)

Célian Louis-Itty

Naguib Mohamed Mahamoud

Hichem Deghri (hidjgr)

Cécile Zagala

