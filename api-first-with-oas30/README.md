


## about api and|or tehcnical doc

https://idratherbewriting.com/learnapidoc/pubapis_swagger.html

An good example based on **https://stoplight.io**, integrating swagger ui within the doc (have a look at the getting started)
https://developers.themoviedb.org/3/account/get-account-details

https://idratherbewriting.com/learnapidoc/pubapis_swagger_intro.html (some links about api documentation)


## open api 3 spec

https://idratherbewriting.com/learnapidoc/pubapis_openapi_tutorial_overview


possibilié de faire des includes pour simplifier/éviter duplication ?
online editor, pas idéal si plusieur fichiers... plugin intellij ?
swagger editor online ne fonctionne qu'avec un seul fichier ...

comportement du plugin swagger intellij en cas d'erreur ???!!!

## swagger editor

git clone https://github.com/swagger-api/swagger-editor.git
cd swagger-editor
npm install
npm run build
npm start

##swagger editor alternatives

++ https://www.apicur.io/
++ https://mermade.github.io/openapi-gui/#
+some visualstudio plugins: https://apis.guru/awesome-openapi3/category.html

eclipse plugin: https://github.com/RepreZen/KaiZen-OpenAPI-Editor (validation, content assist)
eclipse plugin: https://www.reprezen.com/swagger-tools (payant, live swagger-ui)

https://github.com/apinf/openapi-designer

# swagger-ui

dernière release de springfox-swagger-ui de juin 2018 :(
-> pas mal d'évolutions manquent

intégration swagger-ui avec le reste de la doc:
https://idratherbewriting.com/learnapidoc/pubapis_combine_swagger_and_guide.html

## swagger ui alternatives

https://tech.trustpilot.com/an-evaluation-of-auto-generated-rest-api-documentation-uis-53031753a789

https://github.com/Redocly/redoc 
-> ne permet pas de tester l'api

https://mrin9.github.io/RapiDoc/
https://github.com/mrin9/RapiDoc
-> les exemples ne sont pas proposés à la saisie

https://github.com/mrin9/OpenAPI-Viewer
https://mrin9.github.io/OpenAPI-Viewer/#/load/https%3A%2F%2Fapi.apis.guru%2Fv2%2Fspecs%2Fbitbucket.org%2F2.0%2Fswagger.json

https://swaggerui.herokuapp.com/
https://github.com/jensoleg/swagger-ui
-> not maintained, must not comply with OAS30

https://github.com/twskj/pretty-swag
-> no support for OAS30

https://github.com/xiaoymin/swagger-bootstrap-ui
https://doc.xiaominfo.com/en/i18n.html
-> prometteur mais logique pas comprise

https://github.com/Orange-OpenSource/angular-swagger-ui
-> pas mieux que swagger ui officiel

https://github.com/koumoul-dev/openapi-viewer
-> supporte uniquement spec json

https://www.quora.com/What-are-some-alternatives-to-Swagger-for-documenting-REST-APIs


## other oas30 tools:
https://apis.guru/awesome-openapi3/category.html

## bilan

maintenance de la spec plutôt fun pour des petits services.
Pour des services plus conséquent, c'est beaucoup moins sympa -> privilégier code first ?
