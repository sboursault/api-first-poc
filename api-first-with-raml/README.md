intersting



compliqué d'obtenir les pojo à l'annotation près



sudo npm install -g api-console-cli

 ->  works with remote files too
NODE_OPTIONS=--max_old_space_size=2048
api-console build -t "RAML 1.0" -a helloworld.raml
api-console serve build/ --open



NODE_OPTIONS=--max_old_space_size=2048 api-console build -t "RAML 1.0" -a src/main/resources/raml/api.raml -o src/main/resources/static/api-console --verbose


# raml
https://raml.org/developers/raml-100-tutorial


# hateoas
link names
https://stackoverflow.com/a/13686175


# bilan

- possible de concevoir sur un exemple, qui sera inclue dans la doc
- pas obligatoire de documenter toutes les structures (usage interne +)
- pas mal la visu des erreurs avec un exemple


? génération de code auto ?
test de contrat ?
oauth ?

api first marche bien quand on fait des choses simples

# conversion raml 2 open-api-3 (OAS30)

https://swagger.io/blog/news/mulesoft-joins-the-openapi-initiative/
https://blogs.mulesoft.com/dev/api-dev/open-api-raml-better-together/

https://www.npmjs.com/package/api-spec-converter
https://github.com/aml-org/amf
https://github.com/mulesoft/amf-examples # vers OAS2 uniquement !!?


api-spec-converter --from=raml --to=openapi_3 --syntax=yaml ../raml-demo/src/main/resources/raml/api.raml > swagger.json
//  --order=alpha 

https://www.npmjs.com/package/oas-raml-converter

vi /usr/lib/node_modules/oas-raml-converter/lib/bin/converter.js
supprimer --harmony

oas-raml-converter --from RAML --to OAS30 ../raml-demo/src/main/resources/raml/api.raml >  ../raml-demo/src/main/resources/static/oas3/api.json



